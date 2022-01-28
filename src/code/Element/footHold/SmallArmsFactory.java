package code.Element.footHold;

import code.Element.troop.*;
import code.Obj.TroopObject;
import code.util.Tip;
import code.util.values;
import utils.MyPoint;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.net.UnknownHostException;


/**
 * @author  wangxiaoyang
 */
public class SmallArmsFactory extends ArmsFactory{




    {this.iron=20;}//工业值生产效率

    public SmallArmsFactory(MyPoint point, int temp) {
        super(point, temp);

        this.image= values.SmallArmsFactory;
    }
    @Override
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();
       if(frame.getNowCamp() == camp){
           int choice=0;
           if(key == KeyEvent.VK_1) {
               choice = ARMORED;
           }else if(key ==  KeyEvent.VK_2) {
               choice = LIGHT_TANK;
           } else if(key ==  KeyEvent.VK_3) {
               choice = LIGHT_ARTILLERY;
           }
           produceTroop(choice);
           if(server!=null){
               try {
                   server.send("hold"+"_"+myPoint.x+"_"+myPoint.y+"_"+choice);
               } catch (UnknownHostException ex) {
                   ex.printStackTrace();
               }
           }
           if(client!=null){
               try {
                   client.send("hold"+"_"+myPoint.x+"_"+myPoint.y+"_"+choice);
               } catch (UnknownHostException ex) {
                   ex.printStackTrace();
               }
           }
       }
        if(key == KeyEvent.VK_Q){
            JOptionPane.showMessageDialog(frame,"小型兵工厂，，可以招生产甲车，轻坦克，轻火炮\n按1生产装甲车，按2生产轻坦克，按3生产轻火炮\n装甲车花费：130金币，60工业值；轻坦克花费：180金币，90工业值，轻火炮花费：160金币，50工业值\n每回合产值：20工业值",null,1,new ImageIcon(image));
        }
    }


    @Override
    public void produceTroop(int choice) {
        boolean empty = true;
        for(TroopObject t:this.frame.getTroopsObjects()) {
            if(t.canClick(myPoint)) {
                empty = false;
            }
        }
        if(empty) {
            if(choice == ARMORED) {
                Armored newAR = new Armored(this.frame,this.myPoint,this.camp);
                MyPoint price = newAR.getPrice();
                if(this.frame.getNowResource().x>=price.x&&this.frame.getNowResource().y>=price.y) {
                    this.frame.getTroopsObjects().add(newAR);
                    this.frame.getNowResource().setX(this.frame.getNowResource().x - price.x);
                    this.frame.getNowResource().setY(this.frame.getNowResource().y - price.y);
                }else{
                    frame.getAddList().add(new Tip(frame,"资源不足，无法生产装甲车",myPoint));
                }
            }else if(choice == LIGHT_TANK) {
                LightTank newAR = new LightTank(this.frame,this.myPoint,this.camp);
                MyPoint price = newAR.getPrice();
                if(this.frame.getNowResource().x>=price.x&&this.frame.getNowResource().y>=price.y) {
                    this.frame.getTroopsObjects().add(newAR);
                    this.frame.getNowResource().setX(this.frame.getNowResource().x - price.x);
                    this.frame.getNowResource().setY(this.frame.getNowResource().y - price.y);
                }else{
                    frame.getAddList().add(new Tip(frame,"资源不足，无法生产轻坦克",myPoint));
                }
            }else if(choice == LIGHT_ARTILLERY) {
                LightArtillery newAR = new LightArtillery(this.frame,this.myPoint,this.camp);
                MyPoint price = newAR.getPrice();
                if(this.frame.getNowResource().x>=price.x&&this.frame.getNowResource().y>=price.y) {
                    this.frame.getTroopsObjects().add(newAR);
                    this.frame.getNowResource().setX(this.frame.getNowResource().x - price.x);
                    this.frame.getNowResource().setY(this.frame.getNowResource().y - price.y);
                }else{
                    frame.getAddList().add(new Tip(frame,"资源不足，无法生产轻火炮",myPoint));
                }
            }
        }else{
            frame.getAddList().add(new Tip(frame,"兵工厂内已经有作战单位，无法继续生产单位",myPoint));
        }

    }

}
