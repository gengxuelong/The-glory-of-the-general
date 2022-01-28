package code.Element.cartoon;

import code.Obj.TroopObject;
import code.frame.Frame;
import utils.MyPoint;

import java.awt.*;

/**
 * @author PYE
 * @Date 2021/12/18 20:09
 */
public class littleBurst extends TroopObject {

    {
        size = 60;
    }
    private static final Image[] images = new Image[10];
    private  int burstCount = 0;
    static {
        for(int i=0;i<10;i++){
            images[i] = Toolkit.getDefaultToolkit().createImage("./resource/二战/小炸弹/burst"+i+".gif");
        }
    }

    public littleBurst(Frame frame, MyPoint point){
        this.myPoint = point;
        this.frame = frame;
    }

    public littleBurst(MyPoint point){
        burstCount = 0;
        this.myPoint = point;

    }


    @Override
    public boolean attack(TroopObject troopObject) {

        return false;
    }

    @Override
    public void reAttack(TroopObject troopObject) {

    }

    public void paintSelf(Graphics g) {

        if(burstCount<10){
            g.drawImage(images[this.burstCount++],myPoint.x-size/2,myPoint.y-size/2,size,size, null);
        }else{
            this.frame.getRemoveList().add(this);
            System.out.println("小爆炸类消失");
        }
    }


}
