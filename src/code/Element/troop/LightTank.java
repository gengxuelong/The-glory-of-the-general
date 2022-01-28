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
 * 轻型坦克
 *
 * @author 王晓阳
 * @version 1.1
 */
public class LightTank extends Tank{
    public final static int STEP = 3;
    {
        MAX_BLOOD= 350;
        this.blood=MAX_BLOOD;
        this.price=new MyPoint(180,90);
        this.fireRange=55;
        this.moveRange=150;
        this.step=STEP;
    }

    public LightTank(MyPoint point, int temp){
        this.frame = frame;
        this.setCamp(temp);
        this.myPoint = point;
        image = getImage(temp);
    }
    public LightTank(Frame frame, MyPoint point, int temp){
        this.frame = frame;
        this.setCamp(temp);
        image = getImage(temp);
        this.myPoint = point;
    }
    private Image getImage(int camp) {
        Image MI;
        switch (camp) {
            case JAPAN:
                MI = values.TightTankOfJapan;
                break;
            case KMT:
            case POLAND:
            case UK:
            case TURKEY:
            case USSR:
            case US:
            case FINLAND:
            case FRANCE:
                MI = values.TightTankOfKMT;
                break;
            case CPC:
                MI = values.TightTankOfCPC;
                break;
            case DENMARK:
                MI = values.TightTankOfUSSR;
                break;
            case SPAIN:
            case GERMAN:
                MI = values.TightTankOfGerman;
                break;

            default:
                return null;
        }
        return MI;
    }

    private final LightTank mySelf = this;
    @Override
    public boolean attack(TroopObject troopObject) {
        super.fireMusic();
        if(this.canFire(troopObject)) {
            Random r = new Random();
            int damage = 0;
            double pro = Math.random()*values.probability()*(blood*1.0/MAX_BLOOD);
            if (troopObject instanceof Armored) {
                damage = 35;
                damage += r.nextInt(60);
            } else {
                damage = 28;
                damage += r.nextInt(45);
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
            if(troopObject instanceof Armored){
                damage = 35;
                damage += r.nextInt(60);
            }else{
                damage = 28;
                damage += r.nextInt(45);
            }
            damage *= doufire;
            damage =(int)( damage * pro * 0.7);//反击伤害削弱至0.7的水平
            troopObject.setBlood(troopObject.getBlood() - damage);
            frame.getTroopsObjects().add(new Tip(frame,"-"+damage,troopObject.getMyPoint()));
            this.frame.getAddList().add(new BigBurst(frame,troopObject.getMyPoint(),damage*1.0/100));
            troopObject.setBlood(troopObject.getBlood() - (damage));
        }else
            frame.getAddList().add(new Tip(frame,"敌人未在攻击范围内，无法攻击",myPoint));
    }
    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_Q){
            JOptionPane.showMessageDialog(frame,"轻型坦克，总和性价比很高，机动性很高，同时攻击力不弱",null,1,new ImageIcon(image));
        }
    }
    public void setSTEP(){
        step = STEP;
    }
}
