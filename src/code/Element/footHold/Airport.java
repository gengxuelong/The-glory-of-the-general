package code.Element.footHold;

import code.Element.cartoon.Bomber;
import code.Element.cartoon.Fighter;
import code.Element.troop.*;
import code.Obj.FootHoldObject;
import code.Obj.TroopObject;
import code.util.Tip;
import code.util.values;
import utils.MyPoint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.net.UnknownHostException;
import java.util.Random;
/**
 * @athor wangxiaoyang
 */
public class Airport extends FootHoldObject {


    public final static int BOMBER = 0;
    public final static int FIGHTER = 1;
    private int fireRange;// （攻击范围）

    {
        fireRange = 300;
        size = 80;
    }

    public boolean canFire(TroopObject troopObject) {
        if (((troopObject.getMyPoint().getX() - size / 2 - myPoint.getX())
                * (troopObject.getMyPoint().getX() - size / 2 - myPoint.getX())
                + (troopObject.getMyPoint().getY() - size / 2 - myPoint.getY())
                * (troopObject.getMyPoint().getY() - size / 2 - myPoint.getY()))
                <= (fireRange * fireRange) ||
                ((troopObject.getMyPoint().getX() + size / 2 - myPoint.getX())
                        * (troopObject.getMyPoint().getX() + size / 2 - myPoint.getX())
                        + (troopObject.getMyPoint().getY() - size / 2 - myPoint.getY())
                        * (troopObject.getMyPoint().getY() - size / 2 - myPoint.getY()))
                        <= (fireRange * fireRange) ||
                ((troopObject.getMyPoint().getX() - size / 2 - myPoint.getX())
                        * (troopObject.getMyPoint().getX() - size / 2 - myPoint.getX())
                        + (troopObject.getMyPoint().getY() + size / 2 - myPoint.getY())
                        * (troopObject.getMyPoint().getY() + size / 2 - myPoint.getY()))
                        <= (fireRange * fireRange) ||
                ((troopObject.getMyPoint().getX() + size / 2 - myPoint.getX())
                        * (troopObject.getMyPoint().getX() + size / 2 - myPoint.getX())
                        + (troopObject.getMyPoint().getY() + size / 2 - myPoint.getY())
                        * (troopObject.getMyPoint().getY() + size / 2 - myPoint.getY()))
                        <= (fireRange * fireRange)) {
            return true;
        }
        return false;
    }

    public Airport(MyPoint point, int temp) {
        this.myPoint = point;
        this.setCamp(temp);
        this.image = values.Airport_1;
    }


    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(frame.getNowCamp() == camp)
        switch (key){
            case KeyEvent.VK_1:
                produceTroop(BOMBER);
                break;
            case KeyEvent.VK_2:
               produceTroop(FIGHTER);
               break;
        }
        if(key == KeyEvent.VK_Q){
            JOptionPane.showMessageDialog(frame,"作战机场，，用于对机场周围敌方单位派出飞机进行空袭\n每次空袭的目标为机场攻击范围内的所有敌方目标\n按1进行轰炸机轰炸，其攻击力更强，花费为：260金币，80工业值\n按2进行战斗机攻击，其攻击力相对较弱，花费为：220金币，50工业值，80工业值",null,1,new ImageIcon(image));
        }
    }








    private  double airDefence(TroopObject troopObject){
        double x=0.0;
        for (TroopObject t: troopObject.getFrame().getTroopsObjects()){
            if(t instanceof AirDefenceSystem){
                if((t.getMyPoint().getX()-troopObject.getMyPoint().getX())*(t.getMyPoint().getX()-troopObject.getMyPoint().getX())+
                        (t.getMyPoint().getX()-troopObject.getMyPoint().getX())*(t.getMyPoint().getX()-troopObject.getMyPoint().getX())
                        <=t.getFireRange()*t.getFireRange()){
                    x+=0.1;
                }
            }
        }
        if(x>1.0){
            x=1.0;
        }
        return x;
    }

    public void paintSelf(Graphics g){
        super.paintSelf(g);
        if(isChoose){
            g.setColor(Color.red);
            g.drawOval(myPoint.x-fireRange,myPoint.y-fireRange,2*fireRange,2*fireRange);
        }
    }

    private  void bomberAttack(TroopObject troopObject){
        double probability=values.probability();
        double defence=airDefence(troopObject);
        Random r = new Random();
        defence = 1- defence;
        int damage=0;
        if (troopObject instanceof Tank) {
            damage = 35;
            damage += r.nextInt(55);
            damage=(int)(probability*damage);
            damage=(int)((defence)*damage);
            troopObject.setBlood(troopObject.getBlood() - damage);
        } else if(troopObject instanceof Armored){
            damage = 40;
            damage += r.nextInt(60);
            damage=(int)(probability*damage);
            damage=(int)(defence*damage);
            troopObject.setBlood(troopObject.getBlood() - damage);
        }else if(troopObject instanceof Artillery){
            damage = 38;
            damage += r.nextInt(60);
            damage=(int)(probability*damage);
            damage=(int)(defence*damage);
            troopObject.setBlood(troopObject.getBlood() - damage);
        }else if(troopObject instanceof Infantry){
            damage = 25;
            damage += r.nextInt(50);
            damage=(int)(probability*damage);
            damage=(int)(defence*damage);
            troopObject.setBlood(troopObject.getBlood() - damage);
        }else{
            damage = 30;
            damage += r.nextInt(50);
            damage=(int)(probability*damage);
            damage=(int)(defence*damage);
            troopObject.setBlood(troopObject.getBlood() - damage);
        }
        this.frame.getAddList().add(new Tip(frame,"-"+damage,troopObject.getMyPoint()));
        if(server!=null){
            try {
                server.send("bomberAttack"+"_"+troopObject.getMyPoint().getX()+"_"+troopObject.getMyPoint().getY()+"_"+damage);
            } catch (UnknownHostException ex) {
                ex.printStackTrace();
            }
        }
        if(client!=null){
            try {
                client.send("bomberAttack"+"_"+troopObject.getMyPoint().getX()+"_"+troopObject.getMyPoint().getY()+"_"+damage);
            } catch (UnknownHostException ex) {
                ex.printStackTrace();
            }
        }

    }

    private void fighterAttack(TroopObject troopObject){
        double probability=values.probability();
        double defence=airDefence(troopObject);
        defence = 1- defence;
        Random r = new Random();
        int damage = 0;
        if (troopObject instanceof Tank) {
             damage = 12;
            damage += r.nextInt(25);
            damage=(int)(probability*damage);
            damage=(int)(defence*damage);
            troopObject.setBlood(troopObject.getBlood() - damage);
        }else if(troopObject instanceof Infantry){
             damage = 35;
            damage += r.nextInt(30);
            damage=(int)(probability*damage);
            damage=(int)(defence*damage);
            troopObject.setBlood(troopObject.getBlood() - damage);
        }else{
            damage = 25;
            damage += r.nextInt(30);
            damage=(int)(probability*damage);
            damage=(int)(defence*damage);
            troopObject.setBlood(troopObject.getBlood() - damage);
        }
        this.frame.getAddList().add(new Tip(frame,"-"+damage,troopObject.getMyPoint()));
        if(server!=null){
            try {
                server.send("fighterAttack"+"_"+troopObject.getMyPoint().getX()+"_"+troopObject.getMyPoint().getY()+"_"+damage);
            } catch (UnknownHostException ex) {
                ex.printStackTrace();
            }
        }
        if(client!=null){
            try {
                client.send("fighterAttack"+"_"+troopObject.getMyPoint().getX()+"_"+troopObject.getMyPoint().getY()+"_"+damage);
            } catch (UnknownHostException ex) {
                ex.printStackTrace();
            }
        }
    }





    @Override
    public void produceResource() {

    }
    @Override
    public void produceTroop(int choice) {
        switch(choice) {
            case BOMBER :
                Bomber b = new Bomber();
                if(this.frame.getNowResource().x > b.getPrice().x&&this.frame.getNowResource().y > b.getPrice().y){
                    boolean flag = false;
                    for(TroopObject o :frame.getTroopsObjects()){
                        if(this.getCamp()!=o.getCamp()&&this.canFire(o)){
                            flag = true;
                            this.frame.getTroopsObjects().add(new Bomber(frame,o.getMyPoint(),this.getCamp()));
                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        Thread.sleep(2000);
                                    } catch (InterruptedException interruptedException) {
                                        interruptedException.printStackTrace();
                                    }
                                    bomberAttack(o);

                                    if(server!=null){
                                        try {
                                            server.send("bomber"+"_"+getMyPoint().getX()+"_"
                                                    +getMyPoint().getY()+"_"+frame.getNowResource().getX()+"_"+frame.getNowResource().getY());
                                        } catch (UnknownHostException ex) {
                                            ex.printStackTrace();
                                        }
                                    }
                                    if(client!=null){
                                        try {
                                            client.send("bomber"+"_"+getMyPoint().getX()+"_"
                                                    +getMyPoint().getY()+"_"+frame.getNowResource().getX()+"_"+frame.getNowResource().getY());
                                        } catch (UnknownHostException ex) {
                                            ex.printStackTrace();
                                        }
                                    }
                                }
                            }).start();
                        }
                    }
                    if(!flag){
                        this.frame.getTroopsObjects().add(new Bomber(frame,new MyPoint(this.myPoint.x,this.myPoint.y-100),this.getCamp()));
                    }
                    //一旦开出飞机，就对整个航程范围的敌人进行攻击，即使周围无敌人，也要扣除相应费用
                    this.frame.getNowResource().setX(frame.getNowResource().x-b.getPrice().x);
                    this.frame.getNowResource().setY(frame.getNowResource().y-b.getPrice().y);
                }else{
                    frame.getAddList().add(new Tip(frame,"资源不足，无法派出轰炸机轰炸",myPoint));
                }
                break;
            case FIGHTER:
                Fighter f = new Fighter();
                if(this.frame.getNowResource().x > f.getPrice().x&&this.frame.getNowResource().y > f.getPrice().y){
                    boolean flag = false;
                    for(TroopObject o :frame.getTroopsObjects()){
                        if(this.getCamp()!=o.getCamp()&&this.canFire(o)){
                            flag = true;
                            this.frame.getTroopsObjects().add(new Fighter(frame,o.getMyPoint(),this.getCamp()));
                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        Thread.sleep(2000);
                                    } catch (InterruptedException interruptedException) {
                                        interruptedException.printStackTrace();
                                    }
                                    fighterAttack(o);
                                    if(server!=null){
                                        try {
                                            server.send("fighter"+"_"+getMyPoint().getX()+"_"
                                                    +getMyPoint().getY()+"_"+frame.getNowResource().getX()+"_"+frame.getNowResource().getY());
                                        } catch (UnknownHostException ex) {
                                            ex.printStackTrace();
                                        }
                                    }
                                    if(client!=null){
                                        try {
                                            client.send("fighter"+"_"+getMyPoint().getX()+"_"
                                                    +getMyPoint().getY()+"_"+frame.getNowResource().getX()+"_"+frame.getNowResource().getY());
                                        } catch (UnknownHostException ex) {
                                            ex.printStackTrace();
                                        }
                                    }

                                }
                            }).start();
                        }
                    }
                    if(!flag){
                        this.frame.getTroopsObjects().add(new Fighter(frame,new MyPoint(myPoint.x,myPoint.y-100),this.getCamp()));
                    }
                    //一旦开出飞机，就对整个航程范围的敌人进行攻击，即使周围无敌人，也要扣除相应费用
                    this.frame.getNowResource().setX(frame.getNowResource().x-f.getPrice().x);
                    this.frame.getNowResource().setY(frame.getNowResource().y-f.getPrice().y);
                }else{
                    frame.getAddList().add(new Tip(frame,"资源不足，无法派出战斗机空袭",myPoint));
                }
                break;

        }
    }
}
