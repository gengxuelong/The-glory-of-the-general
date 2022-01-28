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
 * 重型坦克
 *
 * @author 王晓阳
 * @version 1.1
 */

public class HeavyTank extends Tank{
    public final static int STEP = 3;

    {
        MAX_BLOOD = 420;
        this.blood=MAX_BLOOD;
        this.price=new MyPoint(280,150);
        this.fireRange=60;
        this.moveRange=125;
        this.step=STEP;
    }

    public HeavyTank( MyPoint point,int temp){
        this.frame = frame;
        this.setCamp(temp);
        this.myPoint = point;
        image = getImage(temp);
    }
    public HeavyTank(Frame frame, MyPoint point, int temp){
        this.frame = frame;
        this.setCamp(temp);
        image = getImage(temp);
        this.myPoint = point;
    }

    private Image getImage(int camp) {
        Image MI;
        switch (camp) {
            case JAPAN:
                MI = values.HeavyTankOfJapan;
                break;
            case KMT:
            case POLAND:
            case UK:
            case TURKEY:
            case USSR:
            case US:
            case FINLAND:
            case FRANCE:
                MI = values.HeavyTankOfKMT;
                break;
            case CPC:
                MI = values.HeavyTankOfCPC;
                break;
            case DENMARK:
                MI = values.HeavyTankOfUSSR;
                break;
            case SPAIN:
            case GERMAN:
                MI = values.HeavyTankOfGerman;
                break;

            default:
                return null;
        }
        return MI;
    }

    private final HeavyTank mySelf = this;
    @Override
    public boolean attack(TroopObject troopObject) {
        super.fireMusic();
        if(this.canFire(troopObject)) {
            Random r = new Random();
            int damage = 0;
            double pro = blood * 1.0 / MAX_BLOOD * Math.random() * values.probability();
            if (troopObject instanceof Armored) {
                damage = 45;
                damage += r.nextInt(80);
            } else {
                damage = 38;
                damage += r.nextInt(60);
            }
            damage *= doufire;
            damage = (int)(damage * pro);
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
           int damage = 0;
           double pro = blood * 1.0 / MAX_BLOOD * Math.random() * values.probability();
           if(troopObject instanceof Armored){
               damage = 45;
               damage += r.nextInt(80);
           }else{
               damage = 38;
               damage += r.nextInt(60);
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
            JOptionPane.showMessageDialog(frame,"重型坦克，攻击力很强，血量很多，但机动性不强",null,1,new ImageIcon(image));
        }
    }
    public void setSTEP(){
        step = STEP;
    }
}
