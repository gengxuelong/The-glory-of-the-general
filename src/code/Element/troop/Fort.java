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
 * 机枪堡垒
 *
 * @author 王晓阳
 * @version 1.2
 */

public class Fort extends TroopObject {
    public final static int STEP = 1;
    {
        size = 50;
        MAX_BLOOD = 300;
        this.blood=MAX_BLOOD;
        this.price=new MyPoint(100,30);
        this.fireRange=70;
        this.moveRange=0;
        this.step=STEP;

    }

    public Fort(Frame frame, MyPoint point , int temp){
        this.frame = frame;
        this.setCamp(temp);
        image = getImage(temp);
        this.myPoint = point;
    }

    public Fort(  MyPoint point ,int temp){
        this.setCamp(temp);
        this.myPoint = point;
        image = getImage(temp);
    }

    private Image getImage(int camp) {
        String path = "./resource/二战/";
        Image img=Toolkit.getDefaultToolkit().createImage(path+"要塞/机枪堡垒.png");
        return img;
    }

    private Fort mySelf = this;
    @Override
    public boolean attack(TroopObject troopObject) {
        super.fireMusic();
        if(this.canFire(troopObject)) {
            Random r = new Random();
            double pro = Math.random()* values.probability()*(blood*1.0/MAX_BLOOD);
            int damage = 0;
            if (troopObject instanceof Infantry) {
                 damage = 35;
                damage += r.nextInt(40);
                troopObject.setBlood(troopObject.getBlood() - damage);
            } else if (troopObject instanceof Tank) {
                 damage = 15;
                damage += r.nextInt(20);
                troopObject.setBlood(troopObject.getBlood() - damage);
            } else {
                 damage = 25;
                damage += r.nextInt(35);
                troopObject.setBlood(troopObject.getBlood() - damage);
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
                damage = 35;
                damage += r.nextInt(40);
                troopObject.setBlood(troopObject.getBlood() - (int)(damage*0.7));
            } else if(troopObject instanceof Tank){
                damage = 15;
                damage += r.nextInt(20);
                troopObject.setBlood(troopObject.getBlood() - (int)(damage*0.7));
            }else{
                damage = 25;
                damage += r.nextInt(35);
                troopObject.setBlood(troopObject.getBlood() - (int)(damage*0.7));
            }
            damage =(int)(damage * pro * 0.7);//反击伤害削弱至0.7的水平
            frame.getTroopsObjects().add(new Tip(frame,"-"+damage,troopObject.getMyPoint()));
            this.frame.getAddList().add(new BigBurst(frame,troopObject.getMyPoint(),damage*1.0/100));
            troopObject.setBlood(troopObject.getBlood() - (damage));
        }frame.getAddList().add(new Tip(frame,"敌人未在攻击范围内，无法攻击",myPoint));

    }
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_Q){
            JOptionPane.showMessageDialog(frame,"机枪堡垒，为固定作战单位，不可移动，其活力强大的机枪可以对步兵单位带来极大伤害",null,1,new ImageIcon(image));
        }
    }
    public void setSTEP(){
        step = STEP;
    }
}
