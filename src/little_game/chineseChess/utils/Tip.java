package little_game.chineseChess.utils;

import little_game.chineseChess.obj.Qizi;
import little_game.chineseChess.page.GameFrame;
import utils.MyPoint;

import java.awt.*;

/**
 * @author KangZhaoXin
 * @Date 2021/12/23 1:09
 */
public class Tip extends Qizi {

    private final String string;

    public Tip(GameFrame frame,String string,MyPoint point){
        this.frame = frame;
        this.gridMyPoint = point;
        this.string = string;
        frame.repaint();
    }

    private int paintCount=0;
    public void paintSelf(Graphics g){
        g.setColor(Color.RED);
        g.setFont(new Font( null,Font.BOLD,40));
        g.drawString(string,gridMyPoint.x*50,gridMyPoint.y*50);
       paintCount++;
       if(paintCount>6){
           frame.getRemoveList().add(this);
       }

    }


    @Override
    public boolean isCanMove(MyPoint gridMyPoint) {
        return false;
    }
}
