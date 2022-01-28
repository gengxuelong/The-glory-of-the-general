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
 * @author
 * @version 1.1
 */
public class NormalInfantry extends Infantry {


    public final static int STEP = 2;
    {
        MAX_BLOOD = 200;
        blood = 200;
        price = new MyPoint(80,0);
        fireRange = 50;
        moveRange = 140;
        step = STEP;

    }

    public NormalInfantry( MyPoint point,int temp){
        this.frame = frame;
        this.setCamp(temp);
        this.myPoint = point;
        image = getImage(temp);
    }
    public NormalInfantry(Frame frame, MyPoint point, int temp){
        this.frame = frame;
        this.setCamp(temp);
        getImage(temp);
        this.myPoint = point;
        image = getImage(temp);
    }

    private Image getImage(int camp){
        Image NI;
        switch (camp) {
            case JAPAN:
                NI = values.NIOfJapan;
                break;
            case KMT:
                NI = values.NIOfKMT;
                break;
            case CPC:
                NI = values.NIOfCPC;
                break;
            case DENMARK:
                NI = values.NIOfDenmark;
                break;
            case FRANCE:
                NI = values.NIOfFrance;
                break;
            case FINLAND:
                NI = values.NIOfFinland;
                break;
            case US:
                NI = values.NIOfUS;
                break;
            case USSR:
                NI = values.NIOfUSSR;
                break;
            case TURKEY:
                NI = values.NIOfTurkey;
                break;
            case SPAIN:
                NI = values.NIOfSpain;
                break;
            case UK:
                NI = values.NIOfUK;
                break;
            case POLAND:
                NI = values.NIOfPoland;
                break;
            case GERMAN:
                NI = values.NIOfGerman;
                break;

            default:
                return null;
        }
        return NI;
    }



    private NormalInfantry mySelf = this;
    @Override
    public boolean attack(TroopObject troopObject) {
        super.fireMusic();
        if(this.canFire(troopObject)) {
        	int damage;
        	double pro = Math.random()*values.probability()*(blood*1.0/MAX_BLOOD);
            Random r = new Random();
            if (troopObject instanceof Tank) {
                damage = 12;
                damage += r.nextInt(40);
            } else if(troopObject instanceof Armored){
                damage = 15;
                damage += r.nextInt(30);
            }else {
            	damage = 20;
                damage += r.nextInt(45);
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
        }
        frame.getAddList().add(new Tip(frame,"敌人未在攻击范围内，无法攻击",myPoint));
        return false;
    }

    @Override
    public void reAttack(TroopObject troopObject) {
        super.fireMusic();
    	if(this.canFire(troopObject)) {
        	int damage;
            double pro = Math.random()*values.probability()*(blood*1.0/MAX_BLOOD);
            Random r = new Random();
            if (troopObject instanceof Tank) {
                damage = 12;
                damage += r.nextInt(40);
            } else if(troopObject instanceof Armored){
                damage = 15;
                damage += r.nextInt(30);
            }else {
            	damage = 20;
                damage += r.nextInt(45);
            }
            damage *= doufire;
            damage =(int)( damage * pro * 0.7);//反击伤害削弱至0.7的水平
            frame.getTroopsObjects().add(new Tip(frame,"-"+damage,troopObject.getMyPoint()));
            this.frame.getAddList().add(new BigBurst(frame,troopObject.getMyPoint(),damage*1.0/100));
            troopObject.setBlood(troopObject.getBlood() - (damage));
        }else{
            frame.getAddList().add(new Tip(frame,"敌人未在攻击范围内，无法攻击",myPoint));
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_Q){
            JOptionPane.showMessageDialog(frame,"普通步兵，适合守城，按1在其左端建造一个防空炮，按2在其左端生产一个机枪堡垒\n防空炮花费120金币，30工业值；机枪堡垒话费100金币，30工业值",null,1,new ImageIcon(image));
        }
    }
    public void setSTEP(){
        step = STEP;
    }

}
