package code.Element.troop;

import code.Obj.TroopObject;
import code.frame.Frame;
import utils.MyPoint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 *
 * @author 王晓阳
 * @version 1.2
 */

/*
防空系统的思路变动：

1.原先我们给每一个TroopsObject都设置了planeDefence属性，现在这个属性没用了

2.我方阵营有唯一一个List，里面包含所有我方防空系统的信息

3.当 敌方 使用机场进行轰炸行为时，对于每一个即将遭受轰炸的我方目标 x ，x遍历一遍 我方 List，判定x和所有防空炮的距离，如果在防空炮范围内，就叠加一层减伤属性，
然后再计算轰炸伤害，然后进行血量扣除。
 */



public class AirDefenceSystem extends TroopObject {

    {
        size = 50;
        MAX_BLOOD = 280;
        this.fireRange=230;
        this.moveRange=0;
        this.blood=MAX_BLOOD;
        this.price = new MyPoint(120,30);
    }

    public AirDefenceSystem(Frame frame, MyPoint point , int temp){
        this.frame = frame;
        this.setCamp(temp);
         image = getImage(temp);
        this.myPoint = point;
    }


    public AirDefenceSystem( MyPoint point,int temp) {
        this.setCamp(temp);
        image = getImage(temp);
        this.myPoint = point;
    }

    private Image getImage(int camp) {
        String path = "./resource/二战/";
        Image img=Toolkit.getDefaultToolkit().createImage(path+"要塞/防空炮.png");
        return img;
    }


    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_Q){
            JOptionPane.showMessageDialog(frame,"防空炮，其无主动作战功能，用于提供一个防控区域\n在该区域的我方士兵在受到空袭时可以不通畅度的减伤",null,1,new ImageIcon(image));
        }
    }
    @Override
    public boolean attack(TroopObject troopsObject) {
        //不用写这个
        return false;
    }

    @Override
    public void reAttack(TroopObject troopsObject) {
        //不用写这个
    }
}
