package code.Obj;

import UDP.Client;
import UDP.Server;
import code.frame.Frame;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * @author wangxiaoyang
 * @version 1.0
 */
public abstract class FootHoldObject extends GameObject {


    protected Server server;
    protected Client client;
    {
        size = 60;
    }

    public void changeCamps(int camp){
        //更改据点所属阵营，当据点被占领时调用
        this.setCamp(camp);
    }


    public void setFrame(Frame frame) {
        this.frame = frame;
        server = frame.getServer();
        client = frame.getClient();
    }
    /*
    抽象据点类
    包括三种据点，机场、兵工厂、城市
    机场的唯一行为是消耗资源派遣飞机对敌方单位实施打击
    兵工厂有两种行为，1。消耗资源（工业值和金币）制造装甲部队 2.每回合自动产出一定的工业值
    城市有两种行为，1。消耗资源（工业值和金币）招募新兵 2.每回合自动产出一定的金币（城市大小不同，产出率不同）
     */

    public abstract void keyPressed(KeyEvent e);
    public void paintSelf(Graphics g){
        super.paintSelf(g);
        if(isChoose){
            g.setColor(Color.blue);
            g.drawRect(myPoint.x-size*5/9,myPoint.y-size*5/9,size*10/9,size*10/9);
        }
    }
    public abstract void produceTroop(int a);//产出部队
    public abstract void produceResource();//产出资源

}
