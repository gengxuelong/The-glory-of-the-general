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
public class LightArtillery extends Artillery{
    //轻火炮
    public final static int STEP = 2;

    {
        MAX_BLOOD= 180;
        this.blood=MAX_BLOOD;
        this.price=new MyPoint(160,50);
        this.fireRange=100;
        this.moveRange=115;
        this.step=STEP;
    }

    public LightArtillery(MyPoint point , int temp){

        this.setCamp(temp);
        this.myPoint = point;
        image = getImage(temp);
    }

    public LightArtillery(Frame frame, MyPoint point, int temp){
        this.frame = frame;
        this.setCamp(temp);
        image=getImage(temp);
        this.myPoint = point;
    }
    private Image getImage(int camp) {
        String path = "./resource/二战/";
        Image TightArtillery;
        switch (camp) {
            case JAPAN:
                TightArtillery = values.TightArtilleryOfJapan;
                break;
            case KMT:
                TightArtillery = values.TightArtilleryOfKMT;
                break;
            case CPC:
                TightArtillery = values.TightArtilleryOfCPC;
                break;
            case DENMARK:
                TightArtillery = values.TightArtilleryOfDenmark;
                break;
            case FRANCE:
                TightArtillery = values.TightArtilleryOfFrance;
                break;
            case FINLAND:
                TightArtillery = values.TightArtilleryOfFinland;
                break;
            case US:
                TightArtillery = values.TightArtilleryOfUS;
                break;
            case USSR:
                TightArtillery = values.TightArtilleryOfUSSR;
                break;
            case TURKEY:
                TightArtillery = values.TightArtilleryOfTurkey;
                break;
            case SPAIN:
                TightArtillery = values.TightArtilleryOfSpain;
                break;
            case UK:
                TightArtillery = values.TightArtilleryOfUK;
                break;
            case POLAND:
                TightArtillery = values.TightArtilleryOfPoland;
                break;
            case GERMAN:
                TightArtillery = values.TightArtilleryOfGerman;
                break;

            default:
                TightArtillery = Toolkit.getDefaultToolkit().createImage(path + "轻坦克/通用.png");

        }
        return TightArtillery;
    }

    private LightArtillery mySelf = this;
    @Override
    public boolean attack(TroopObject troopObject) {
        super.fireMusic();
        if(this.canFire(troopObject)) {
            int damage = 0;
            double pro = Math.random()*values.probability()*(blood*1.0/MAX_BLOOD);
            Random r = new Random();
            if (troopObject instanceof Infantry) {
                 damage = 26;
                damage += r.nextInt(60);
            }else if(troopObject instanceof Tank){
                 damage = 28;
                damage += r.nextInt(55);
            }else if(troopObject instanceof Artillery){
                 damage = 32;
                damage += r.nextInt(60);
            }else {
                 damage = 30;
                damage += r.nextInt(55);
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
               damage = 26;
               damage += r.nextInt(60);
           }else if(troopObject instanceof Tank){
               damage = 28;
               damage += r.nextInt(55);
           }else if(troopObject instanceof Artillery){
               damage = 32;
               damage += r.nextInt(60);
           }else {
               damage = 30;
               damage += r.nextInt(55);
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
            JOptionPane.showMessageDialog(frame,"轻型火炮，攻击范围相对较小，攻击力适中，但机动性相对较强",null,1,new ImageIcon(image));
        }
    }
    public void setSTEP(){
        step = STEP;
    }
}
