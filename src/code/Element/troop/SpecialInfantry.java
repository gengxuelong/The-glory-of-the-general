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

public class SpecialInfantry extends Infantry{

	public final static int STEP = 2;
    {
        MAX_BLOOD = 220;
        blood = MAX_BLOOD;
        price = new MyPoint(120,30);
        fireRange = 55;
        moveRange = 160;
        step = STEP;
    }

    public SpecialInfantry(  MyPoint point ,int camp){
        this.frame = frame;
        this.setCamp(camp);
        this.myPoint = point;
        image = getImage(camp);
    }

    public SpecialInfantry(Frame frame, MyPoint point, int camp){
        this.frame = frame;
        this.setCamp(camp);
        image = getImage(camp);
        this.myPoint = point;
    }

    private Image getImage(int camp){

        Image SI;
        switch (camp) {
            case JAPAN:
                SI = values.SIOfJapan;
                break;
            case KMT:
                SI = values.SIOfKMT;
                break;
            case CPC:
                SI = values.SIOfCPC;
                break;
            case DENMARK:
                SI = values.SIOfDenmark;
                break;
            case FRANCE:
                SI = values.SIOfFrance;
                break;
            case FINLAND:
                SI = values.SIOfFinland;
                break;
            case US:
                SI = values.SIOfUS;
                break;
            case USSR:
                SI = values.SIOfUSSR;
                break;
            case TURKEY:
                SI = values.SIOfTurkey;
                break;
            case SPAIN:
                SI = values.SIOfSpain;
                break;
            case UK:
                SI = values.SIOfUK;
                break;
            case POLAND:
                SI = values.SIOfPoland;
                break;
            case GERMAN:
                SI = values.SIOfGerman;
                break;

            default:
                return null;
        }
        return SI;
    }



    private SpecialInfantry mySelf = this;
    @Override
    public boolean attack(TroopObject troopObject) {
        super.fireMusic();
        if(this.canFire(troopObject)) {
        	int damage;
            Random r = new Random();
            if (troopObject instanceof Armored) {
                damage = 13;
                damage += r.nextInt(30);
                damage = (int)(damage * this.blood*1.0/this.MAX_BLOOD * Math.random() * values.probability());
            } else if(troopObject instanceof Tank){
                damage = 25;
                damage += r.nextInt(55);
                damage = (int)(damage * this.blood*1.0/this.MAX_BLOOD * Math.random() * values.probability());
            }else {
            	damage = 15;
                damage += r.nextInt(30);
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
                damage = 25;
                damage += r.nextInt(55);
                damage = (int)(damage * this.blood*1.0/this.MAX_BLOOD * Math.random() * values.probability());
            } else if(troopObject instanceof Armored){
                damage = 13;
                damage += r.nextInt(30);
                damage = (int)(damage * this.blood*1.0/this.MAX_BLOOD * Math.random() * values.probability());
            }else {
            	damage = 15;
                damage += r.nextInt(30);
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
            JOptionPane.showMessageDialog(frame,"特种步兵，擅长攻击坦克，按1在其左端建造一个防空炮，按2在其左端生产一个机枪堡垒\n防空炮花费120金币，30工业值；机枪堡垒话费100金币，30工业值",null,1,new ImageIcon(image));
        }
    }

    public void setSTEP(){
        step = STEP;
    }


}
