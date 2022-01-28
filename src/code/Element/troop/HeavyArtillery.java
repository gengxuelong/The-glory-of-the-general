package code.Element.troop;

import code.Element.cartoon.BigBurst;
import code.Obj.TroopObject;
import code.frame.Frame;
import code.util.Tip;
import code.util.values;
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
public class HeavyArtillery extends Artillery{
    //重火炮
    public final static int STEP = 2;

    {
         MAX_BLOOD= 200;
        this.blood=MAX_BLOOD;
        this.price=new MyPoint(180,70);
        this.fireRange=125;
        this.moveRange=115;
        this.step=STEP;
    }

    public HeavyArtillery( MyPoint point,int temp){

        this.setCamp(temp);
        this.myPoint = point;
        image = getImage(temp);
    }
    public HeavyArtillery(Frame frame, MyPoint point, int temp){
        this.frame = frame;
        this.setCamp(temp);
        image = getImage(temp);
        this.myPoint = point;
    }

    private Image getImage(int camp) {
        String path = "./resource/二战/";
        Image HeavyArtillery;
        switch (camp) {
            case JAPAN:
                HeavyArtillery = values.HeavyArtilleryOfJapan;
                break;
            case KMT:
                HeavyArtillery = values.HeavyArtilleryOfKMT;
                break;
            case CPC:
                HeavyArtillery = values.HeavyArtilleryOfCPC;
                break;
            case DENMARK:
                HeavyArtillery = values.HeavyArtilleryOfDenmark;
                break;
            case FRANCE:
                HeavyArtillery = values.HeavyArtilleryOfFrance;
                break;
            case FINLAND:
                HeavyArtillery = values.HeavyArtilleryOfFinland;
                break;
            case US:
                HeavyArtillery = values.HeavyArtilleryOfUS;
                break;
            case USSR:
                HeavyArtillery = values.HeavyArtilleryOfUSSR;
                break;
            case TURKEY:
                HeavyArtillery = values.HeavyArtilleryOfTurkey;
                break;
            case SPAIN:
                HeavyArtillery = values.HeavyArtilleryOfSpain;
                break;
            case UK:
                HeavyArtillery = values.HeavyArtilleryOfUK;
                break;
            case POLAND:
                HeavyArtillery = values.HeavyArtilleryOfPoland;
                break;
            case GERMAN:
                HeavyArtillery = values.HeavyArtilleryOfGerman;
                break;


            default:
                HeavyArtillery = Toolkit.getDefaultToolkit().createImage(path + "火炮_重/苏联.png");

        }
        return HeavyArtillery;
    }


    private HeavyArtillery mySelf = this;
    @Override
    public boolean attack(TroopObject troopObject) {
        super.fireMusic();
        if(this.canFire(troopObject)) {
            Random r = new Random();
            int damage = 0;
            double pro = Math.random()*values.probability()*(blood*1.0/MAX_BLOOD);
            if (troopObject instanceof Infantry) {
                 damage = 33;
                damage += r.nextInt(65);
            } else if (troopObject instanceof Tank) {
                 damage = 30;
                damage += r.nextInt(70);
            } else if (troopObject instanceof Artillery) {
                 damage = 35;
                damage += r.nextInt(70);
            } else {
                 damage = 33;
                damage += r.nextInt(65);
            }
            damage *= doufire;
            damage = (int)(damage *pro);
            frame.getTroopsObjects().add(new Tip(frame,"-"+damage,troopObject.getMyPoint()));
            this.frame.getAddList().add(new BigBurst(frame,troopObject.getMyPoint(),damage*1.0/100));
            troopObject.setBlood(troopObject.getBlood() - damage);
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
        } frame.getAddList().add(new Tip(frame,"敌人未在攻击范围内，无法攻击",myPoint));
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
               damage = 33;
               damage += r.nextInt(65);
           }else if(troopObject instanceof Tank){
               damage = 28;
               damage += r.nextInt(55);
           }else if(troopObject instanceof Artillery){
               damage = 35;
               damage += r.nextInt(70);
           }else {
               damage = 33;
               damage += r.nextInt(65);
           }
           damage *= doufire;
           damage =(int)( damage * pro * 0.7);//反击伤害削弱至0.7的水平
           frame.getTroopsObjects().add(new Tip(frame,"-"+damage,troopObject.getMyPoint()));
           this.frame.getAddList().add(new BigBurst(frame,troopObject.getMyPoint(),damage*1.0/100));
           troopObject.setBlood(troopObject.getBlood() - (damage));
       }else  frame.getAddList().add(new Tip(frame,"敌人未在攻击范围内，无法攻击",myPoint));
    }
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_Q){
            JOptionPane.showMessageDialog(frame,"重型火炮，攻击范围较大，攻击力高，但机动性较弱，血量交薄",null,1,new ImageIcon(image));
        }
    }
    public void setSTEP(){
        step = STEP;
    }
}
