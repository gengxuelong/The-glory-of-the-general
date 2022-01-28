package little_game.hitMouse.obj;

import little_game.hitMouse.page.MyFrame;
import little_game.hitMouse.utils.util;
import utils.MyPoint;

import java.awt.*;

/**
 * @author: 彭烨
 *
 */
public class Hammer extends Obj{
    {
        height = 60;
        width = 60;
        image = util.hammer;
    }
    private Image[] images = new Image[7];
    {
        images[0] = Toolkit.getDefaultToolkit().createImage(util.path+"锤子.png");
        images[1] = Toolkit.getDefaultToolkit().createImage(util.path+"锤子1.png");
        images[2] = Toolkit.getDefaultToolkit().createImage(util.path+"锤子2.png");
        images[3] = Toolkit.getDefaultToolkit().createImage(util.path+"锤子3.png");
        images[4] = Toolkit.getDefaultToolkit().createImage(util.path+"锤子2.png");
        images[5] = Toolkit.getDefaultToolkit().createImage(util.path+"锤子1.png");
        images[6] = Toolkit.getDefaultToolkit().createImage(util.path+"锤子.png");
    }
    public Hammer(MyFrame frame, MyPoint point){
        this.myFrame = frame;
        this.myPoint = point;
    }

    public void paintSelf(Graphics g){
        image = images[paintTime];
        super.paintSelf(g);
        if(paintTime>0){
            paintTime--;
        }
    }

    private  int paintTime = 0;
    public void paintContinue(){
        paintTime = 6;
        for(Obj o: myFrame.objList){
            if(this.getRec().intersects(o.getRec())){
                myFrame.removeList.add(o);
            }
        }
    }
}
