package code.Element.cartoon;

import code.Obj.GameObject;
import code.Obj.TroopObject;
import code.frame.Frame;
import code.util.values;
import utils.MyPlayer;
import utils.MyPoint;

import java.awt.*;

/**
     * @author PYE
 * @Date 2021/12/18 21:03
 */
public class Bomber extends TroopObject {

    {
        price = new MyPoint(260,80);
    }

    private static final MyPoint[] points = new MyPoint[40];
    private int moveCount = 0;
    private final int size = 60;

    public  void loadPoint(){
        for(int i=0;i<40;i++){
            points[i] = new MyPoint(this.myPoint.x+240-12*i,this.myPoint.y-40);
        }
    }

    public Bomber(){}
    public Bomber(Frame frame, MyPoint point, int temp){
        this.myPoint = point;
        loadPoint();
        this.frame = frame;
        this.setCamp(temp);
        setImage(temp);
        if(camp == frame.getMyCamp())
        MyPlayer.playMusic("./resource/sound/scout.wav");
    }
    private void setImage(int temp){
        switch (temp){
            case GameObject.KMT:
            case GameObject.US:image = values.bomber_US;break;
            case GameObject.JAPAN:image = values.bomber_Japan;break;
            case GameObject.CPC:image = values.bomber_China;break;
            case GameObject.GERMAN:image = values.bomber_German;break;
            default : image = values.bomber_General;break;
        }
    }


    @Override
    public boolean attack(TroopObject troopObject) {

        return false;
    }

    @Override
    public void reAttack(TroopObject troopObject) {

    }

    public void paintSelf(Graphics g) {

        if(moveCount <40){
            g.drawImage(image,points[moveCount].x-size/2,points[moveCount].y-size/2,size,size, frame);
            moveCount++;
            if(moveCount==20){
                this.frame.getAddList().add(new BigBurst(frame,myPoint));
            }
        }else{
            this.frame.getRemoveList().add(this);
        }
    }

}
