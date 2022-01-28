package code.Element.cartoon;

import code.Obj.TroopObject;
import code.frame.Frame;
import utils.MyPlayer;
import utils.MyPoint;

import java.awt.*;

/**
 * @author PYE
 * @Date 2021/12/18 21:02
 */
public class BigBurst extends TroopObject {

    {
        size = 90;
    }
    private static final Image[] images = new Image[15];
    private  int burstCount = 0;
    static {
        for(int i=0;i<15;i++){
            images[i] = Toolkit.getDefaultToolkit().createImage("./resource/二战/大炸弹/largeBurst"+i+".gif");
        }
    }

    public BigBurst(Frame frame,MyPoint point){
        this.myPoint = point;
        this.frame = frame;
    }
    public BigBurst(Frame frame, MyPoint point, double bili){
        this.myPoint = point;
        this.frame = frame;
        size = (int)(size *bili*2);
        MyPlayer.playMusic("./resource/sound/explode.wav");
    }

    public BigBurst(MyPoint point){
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

        if(burstCount<15){
            g.drawImage(images[this.burstCount++],myPoint.x-size/2,myPoint.y-size/2,size,size, null);
        }else{
            this.frame.getRemoveList().add(this);
        }
    }

}
