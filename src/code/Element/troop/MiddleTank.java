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
 * 中型坦克
 *
 * @author 王晓阳
 * @version 1.1
 */

public class MiddleTank extends Tank{
    public final static int STEP = 3;

    {
        MAX_BLOOD = 380;
        this.blood=MAX_BLOOD;
        this.price=new MyPoint(220,110);
        this.fireRange=55;
        this.moveRange=140;
        this.step=STEP;
    }

    public MiddleTank ( MyPoint point,int temp){
        this.frame = frame;
        this.setCamp(temp);
        this.myPoint = point;
        image = getImage(temp);
    }
    public MiddleTank(Frame frame, MyPoint point, int temp){
        this.frame = frame;
        this.setCamp(temp);
        image = getImage(temp);
        this.myPoint = point;
    }

    private Image getImage(int camp) {
        Image MI = null;
        switch (camp) {
            case JAPAN:
                MI = values.MiddleTankOfJapan;
                break;
            case KMT:
            case UK:
            case POLAND:
            case TURKEY:
            case USSR:
            case US:
            case FINLAND:
            case FRANCE:
                MI = values.MiddleTankOfKMT;
                break;
            case CPC:
                MI = values.MiddleTankOfCPC;
                break;
            case DENMARK:
                MI = values.MiddleTankOfUSSR;
                break;
            case SPAIN:
            case GERMAN:
                MI = values.MiddleTankOfGerman;
                break;

            default:
                return null;
        }
        return MI;
    }

    private final MiddleTank mySelf = this;
    @Override
    public boolean attack(TroopObject troopObject) {
        super.fireMusic();
        if(this.canFire(troopObject)) {
            Random r = new Random();
            int damage = 0;
            double pro = Math.random()*values.probability()*(blood*1.0/MAX_BLOOD);
            if (troopObject instanceof Armored) {
                damage = 42;
                damage += r.nextInt(65);
            } else {
                damage = 32;
                damage += r.nextInt(50);
            }
            damage *= doufire;
            damage = (int) (damage * pro);
            troopObject.setBlood(troopObject.getBlood() - damage);
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
        }
        frame.getAddList().add(new Tip(frame,"敌人未在攻击范围内，无法攻击",myPoint));
        return false;
    }

    @Override
    public void reAttack(TroopObject troopObject) {
        super.fireMusic();
       if(canFire(troopObject)){
           Random r = new Random();
           int damage = 0;
           double pro = Math.random()*values.probability()*(blood*1.0/MAX_BLOOD);
           if(troopObject instanceof Armored){
               damage = 42;
               damage += r.nextInt(65);
           }else{
               damage = 32;
               damage += r.nextInt(50);
           }
           damage *= doufire;
           damage =(int)(damage * pro * 0.7);//反击伤害削弱至0.7的水平
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
            JOptionPane.showMessageDialog(frame,"中型坦克，攻击力强于轻型坦克，但机动性略逊",null,1,new ImageIcon(image));
        }
    }
    public void setSTEP(){
        step = STEP;
    }
}
