package code.Element.troop;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.Random;

import code.Element.cartoon.BigBurst;
import code.Obj.TroopObject;
import code.frame.Frame;
import code.util.Tip;
import code.util.values;
import utils.MyPoint;

import javax.swing.*;

public class MobileInfantry extends Infantry{
	
	public final static int STEP = 3;
    {
        MAX_BLOOD = 220;
        blood = MAX_BLOOD;
        price = new MyPoint(110,50);
        fireRange = 50;
        moveRange = 175;
        step = STEP;
    }

    public MobileInfantry( MyPoint point, int temp){
        this.setCamp(temp);
        this.myPoint = point;
        image = getImage(temp);
    }
    public MobileInfantry(Frame frame, MyPoint point, int temp){
        this.frame = frame;
        this.setCamp(temp);
        image = getImage(temp);
        this.myPoint = point;
    }

    private Image getImage(int camp){

        Image MI;
        switch (camp) {
            case JAPAN:
                MI = values.MIOfJapan;
                break;
            case KMT:
                MI = values.MIOfKMT;
                break;
            case CPC:
                MI = values.MIOfCPC;
                break;
            case DENMARK:
                MI = values.MIOfDenmark;
                break;
            case FRANCE:
                MI = values.MIOfFrance;
                break;
            case FINLAND:
                MI = values.MIOfFinland;
                break;
            case US:
                MI = values.MIOfUS;
                break;
            case USSR:
                MI = values.MIOfUSSR;
                break;
            case TURKEY:
                MI = values.MIOfTurkey;
                break;
            case SPAIN:
                MI = values.MIOfSpain;
                break;
            case UK:
                MI = values.MIOfUK;
                break;
            case POLAND:
                MI = values.MIOfPoland;
                break;
            case GERMAN:
                MI = values.MIOfGerman;
                break;

            default:
                return null;
        }
        return MI;
    }



    private final MobileInfantry mySelf = this;
    @Override
    public boolean attack(TroopObject troopObject) {
        super.fireMusic();
        if(this.canFire(troopObject)) {
        	int damage;
            Random r = new Random();
            if (troopObject instanceof Armored) {
                damage = 13;
                damage += r.nextInt(25);
                damage = (int)(damage * this.blood*1.0/this.MAX_BLOOD * Math.random() * values.probability());
            } else if(troopObject instanceof Tank){
                damage = 12;
                damage += r.nextInt(35);
                damage = (int)(damage * this.blood*1.0/this.MAX_BLOOD * Math.random() * values.probability());
            }else {
            	damage = 20;
                damage += r.nextInt(40);
                damage = (int)(damage * this.blood*1.0/this.MAX_BLOOD * Math.random() * values.probability());
            }
            damage *= doufire;
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
            Random r = new Random();
            if (troopObject instanceof Tank) {
                damage = 12;
                damage += r.nextInt(35);
                damage = (int)(damage * this.blood*1.0/this.MAX_BLOOD * Math.random() * values.probability());
            } else if(troopObject instanceof Armored){
                damage = 13;
                damage += r.nextInt(25);
                damage = (int)(damage * this.blood*1.0/this.MAX_BLOOD * Math.random() * values.probability());
            }else {
            	damage = 20;
                damage += r.nextInt(40);
                damage = (int)(damage * this.blood*1.0/this.MAX_BLOOD * Math.random() * values.probability());
            }
            damage *= doufire;
            damage =(int)( damage * 0.7);//反击伤害削弱至0.7的水平
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
            JOptionPane.showMessageDialog(frame,"机动，攻击力一般，但有极高的机动能力，适合远距离快速转移，按1在其左端建造一个防空炮，按2在其左端生产一个机枪堡垒\n防空炮花费120金币，30工业值；机枪堡垒话费100金币，30工业值",null,1,new ImageIcon(image));
        }
    }
    public void setSTEP(){
        step = STEP;
    }
}
