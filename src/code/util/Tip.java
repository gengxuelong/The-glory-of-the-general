package code.util;

import code.Obj.TroopObject;
import code.frame.Frame;
import utils.MyPoint;

import java.awt.*;

/**
 * @author kangzhaoxin
 * @Date 2021/12/19 1:17
 */
public class Tip extends TroopObject{

    public static  boolean alive = true;
    Tip mySelf = this;
    private String tip;
    public Tip(Frame frame, String tip, MyPoint point){
        this.tip = tip;
        this.frame = frame;
        this.myPoint = point;
    }

    private boolean isDraw;
    private int paintCount = 0;
    @Override
    public void paintSelf(Graphics g) {



        if(alive){
            g.setFont(new Font(null,Font.BOLD,20));
            g.setColor(Color.red);
            g.drawString(tip,myPoint.x,myPoint.y-40);
        }
        if(paintCount<20){
            paintCount ++;
        }else{
            frame.getRemoveList().add(mySelf);

        }



    }

    @Override
    public boolean attack(TroopObject troopObject) {

        return false;
    }

    @Override
    public void reAttack(TroopObject troopObject) {

    }
}
