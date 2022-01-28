package code.Element.troop;

import code.Element.cartoon.BigBurst;
import code.Obj.TroopObject;
import code.frame.Frame;
import code.util.Tip;
import code.util.values;
import utils.MyPlayer;
import utils.MyPoint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;

/**
 * This class is a basic class.
 *
 * @author lijie
 * @version 1.0
 */
public class RocketGun extends Artillery{

    //火箭炮
    public final static int STEP = 2;

    {
        MAX_BLOOD= 180;
        this.blood=MAX_BLOOD;
        this.price=new MyPoint(200,70);
        this.fireRange=125;
        this.moveRange=115;
        this.step=STEP;
    }

    public RocketGun( MyPoint point,int camp){
        this.setCamp(camp);
        this.myPoint = point;
        image = getImage(camp);
    }
    public RocketGun(Frame frame, MyPoint point, int camp){
        this.frame = frame;
        this.setCamp(camp);
        image=getImage(camp);
        this.myPoint = point;
    }
    private Image getImage(int camp) {
        String path = "./resource/二战/";
        Image RocketGun;
        switch (camp) {
            case JAPAN:
                RocketGun = values.RocketGunOfJapan;
                break;
            case KMT:
                RocketGun = values.RocketGunOfKMT;
                break;
            case CPC:
                RocketGun = values.RocketGunOfCPC;
                break;
            case DENMARK:
                RocketGun = values.RocketGunOfDenmark;
                break;
            case FRANCE:
                RocketGun = values.RocketGunOfFrance;
                break;
            case FINLAND:
                RocketGun = values.RocketGunOfFinland;
                break;
            case US:
                RocketGun = values.RocketGunOfUS;
                break;
            case USSR:
                RocketGun = values.RocketGunOfUSSR;
                break;
            case TURKEY:
                RocketGun = values.RocketGunOfTurkey;
                break;
            case SPAIN:
                RocketGun = values.RocketGunOfSpain;
                break;
            case UK:
                RocketGun = values.RocketGunOfUK;
                break;
            case POLAND:
                RocketGun = values.RocketGunOfPoland;
                break;
            case GERMAN:
                RocketGun = values.RocketGunOfGerman;
                break;


            default:
                RocketGun = Toolkit.getDefaultToolkit().createImage(path + "火箭炮/通用.png");

        }
        return RocketGun;
    }

    private RocketGun mySelf = this;
    @Override
    public boolean attack(TroopObject troopObject) {
        super.fireMusic();
        if(this.canFire(troopObject)) {
            Random r = new Random();
            int damage = 0;
            double pro = Math.random()*values.probability()*(blood*1.0/MAX_BLOOD);
            if (troopObject instanceof Infantry) {
                 damage = 45;
                damage += r.nextInt(80);
            } else if (troopObject instanceof Tank) {
                 damage = 35;
                damage += r.nextInt(70);
            } else if (troopObject instanceof Artillery) {
                 damage = 40;
                damage += r.nextInt(70);
            } else {
                 damage = 35;
                damage += r.nextInt(75);
            }
            damage *= doufire;
            damage = (int)(damage *pro);
            frame.getTroopsObjects().add(new Tip(frame,"-"+damage,troopObject.getMyPoint()));
            this.frame.getAddList().add(new BigBurst(frame,troopObject.getMyPoint(),damage*1.0/100));
            troopObject.setBlood(troopObject.getBlood() - damage);
            MyPlayer.playMusic("./resource/sound/rocket.wav");
            step--;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                        troopObject.reAttack(mySelf);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            return true;
        }
        frame.getAddList().add(new Tip(frame,"敌人未在攻击范围内，无法攻击",myPoint));
        return false;
    }

    @Override
    public void reAttack(TroopObject troopObject) {
        super.fireMusic();
        if(canFire(troopObject)){
            Random r = new Random();
            double pro = Math.random()*values.probability()*(blood*1.0/MAX_BLOOD);
            int damage = 0;
            if (troopObject instanceof Infantry) {
                damage = 45;
                damage += r.nextInt(80);
            }else if(troopObject instanceof Tank){
                damage = 35;
                damage += r.nextInt(70);
            }else if(troopObject instanceof Artillery){
                damage = 40;
                damage += r.nextInt(70);
            }else {
                damage = 35;
                damage += r.nextInt(75);
            }
            damage *= doufire;
            damage =(int)( damage * pro * 0.7);//反击伤害削弱至0.7的水平
            frame.getTroopsObjects().add(new Tip(frame,"-"+damage,troopObject.getMyPoint()));
            this.frame.getAddList().add(new BigBurst(frame,troopObject.getMyPoint(),damage*1.0/100));
            troopObject.setBlood(troopObject.getBlood() - (damage));
        }else
            frame.getAddList().add(new Tip(frame,"敌人未在攻击范围内，无法攻击",myPoint));
    }
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_Q){
            JOptionPane.showMessageDialog(frame,"火箭炮，攻击范围极大，攻击力很高，但机动性弱，血量薄",null,1,new ImageIcon(image));
        }
    }
    public void setSTEP(){
        step = STEP;
    }

}
