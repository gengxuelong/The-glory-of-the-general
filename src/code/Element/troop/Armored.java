package code.Element.troop;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;

import code.Element.cartoon.BigBurst;
import code.Obj.TroopObject;
import code.frame.Frame;
import code.util.Tip;
import code.util.values;
import utils.MyPoint;

import javax.swing.*;

public class Armored extends TroopObject {

    public final static int STEP = 3;

    {
        size = 60;
        MAX_BLOOD = 280;
        blood = MAX_BLOOD;
        price = new MyPoint(130,60);
        fireRange = 50;
        moveRange = 175;
        step = STEP;
    }

    public Armored( MyPoint point,int temp){
        this.frame = frame;
        this.setCamp(temp);
        this.myPoint = point;
        image = getImage(temp);
    }
    public Armored(Frame frame, MyPoint point , int temp){
        this.frame = frame;
        this.setCamp(temp);
        image = getImage(temp);
        this.myPoint = point;
    }


    private Image getImage(int camp){

        Image armored = null;
        switch (camp) {
            case JAPAN:
                armored = values.ARMOfJapan;
                break;
            case KMT:
                armored = values.ARMOfKMT;
                break;
            case CPC:
                armored = values.ARMOfCPC;
                break;
            case DENMARK:
                armored = values.ARMOfDenmark;
                break;
            case FRANCE:
                armored = values.ARMOfFrance;
                break;
            case FINLAND:
                armored = values.ARMOfFinland;
                break;
            case US:
                armored = values.ARMOfUS;
                break;
            case USSR:
                armored = values.ARMOfUSSR;
                break;
            case TURKEY:
                armored = values.ARMOfTurkey;
                break;
            case SPAIN:
                armored = values.ARMOfSpain;
                break;
            case UK:
                armored = values.ARMOfUK;
                break;
            case POLAND:
                armored = values.ARMOfPoland;
                break;
            case GERMAN:
                armored = values.ARMOfGerman;
                break;


            default:
                return null;
        }
        return armored;
    }



    private final Armored mySelf = this;
    @Override
    public boolean attack(TroopObject troopObject) {
        super.fireMusic();
        if(this.canFire(troopObject)) {
            double pro = Math.random()*values.probability()*(blood*1.0/MAX_BLOOD);
        	int damage = 0;
            Random r = new Random();
            if (troopObject instanceof Infantry) {
                damage = 35;
                damage += r.nextInt(55);
            } else if(troopObject instanceof Tank){
                damage = 18;
                damage += r.nextInt(30);
            }else {
            	damage = 22;
                damage += r.nextInt(35);
            }
            damage = (int) (damage * pro);
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
        }frame.getAddList().add(new Tip(frame,"敌人未在攻击范围内，无法攻击",myPoint));
        return false;
    }

    @Override
    public void reAttack(TroopObject troopObject) {
        super.fireMusic();
    	if(this.canFire(troopObject)) {
            double pro = Math.random()*values.probability()*(blood*1.0/MAX_BLOOD);
        	int damage = 0;
            Random r = new Random();
            if (troopObject instanceof Tank) {
                damage = 18;
                damage += r.nextInt(30);
            } else if(troopObject instanceof Infantry){
                damage = 35;
                damage += r.nextInt(55);
            }else {
            	damage = 22;
                damage += r.nextInt(35);
            }
            damage =(int)(damage * pro * 0.7);//反击伤害削弱至0.7的水平
            frame.getTroopsObjects().add(new Tip(frame,"-"+damage,troopObject.getMyPoint()));
            this.frame.getAddList().add(new BigBurst(frame,troopObject.getMyPoint(),damage*1.0/100));
            troopObject.setBlood(troopObject.getBlood() - (damage));
        }else frame.getAddList().add(new Tip(frame,"敌人未在攻击范围内，无法攻击",myPoint));
    }
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_Q){
            JOptionPane.showMessageDialog(frame,"装甲车，机动性极高，其机枪攻击会给步兵带来极大伤害",null,1,new ImageIcon(image));
        }
    }
    public void setSTEP(){
        step = STEP;
    }
}
