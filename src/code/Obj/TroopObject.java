package code.Obj;

import code.Element.troop.Armored;
import code.Element.troop.Fort;
import code.Element.troop.RocketGun;
import code.Element.troop.Tank;
import code.util.Tip;
import utils.*;

import java.awt.*;

/**
 * This class is a basic class.
 *
 * @author lijie
 * @version 1.0
 */
public abstract class TroopObject extends GameObject {


    protected int blood;
//    血量
    protected int fireRange;
//    攻击力
    protected int moveRange;
//    行动范围
    protected int step;
//    行动步数
    protected MyPoint price;
//    价格，x表示金币花费，y表示工业之花费
    protected int MAX_BLOOD;

    protected double doufire = 2.5;

    public  boolean attack(TroopObject troopObject){

        return false;
    }

    public  void reAttack(TroopObject troopObject){

    }

    public  void fireMusic(){
        if(camp == frame.getMyCamp())
            if(this instanceof RocketGun){
                MyPlayer.playMusic("./resource/sound/rocket.wav");
            }else if(this instanceof Armored || this instanceof Fort){
                MyPlayer.playMusic("./resource/sound/machine_gun.wav");
            }else{
                MyPlayer.playMusic("./resource/sound/fire.wav");
            }
    }


    public boolean canFire(GameObject troopObject) {//只要给元素一个角在攻击范围内就算其可以攻击
        if(((troopObject.getMyPoint().getX()-size/2-myPoint.getX())
                *(troopObject.getMyPoint().getX()-size/2-myPoint.getX())
                +(troopObject.getMyPoint().getY()-size/2-myPoint.getY())
                *(troopObject.getMyPoint().getY()-size/2- myPoint.getY()))
                <=(fireRange*fireRange)||
                ((troopObject.getMyPoint().getX()+size/2-myPoint.getX())
                        *(troopObject.getMyPoint().getX()+size/2-myPoint.getX())
                        +(troopObject.getMyPoint().getY()-size/2-myPoint.getY())
                        *(troopObject.getMyPoint().getY()-size/2- myPoint.getY()))
                        <=(fireRange*fireRange)||
                ((troopObject.getMyPoint().getX()-size/2-myPoint.getX())
                        *(troopObject.getMyPoint().getX()-size/2-myPoint.getX())
                        +(troopObject.getMyPoint().getY()+size/2-myPoint.getY())
                        *(troopObject.getMyPoint().getY()+size/2- myPoint.getY()))
                        <=(fireRange*fireRange)||
                ((troopObject.getMyPoint().getX()+size/2-myPoint.getX())
                        *(troopObject.getMyPoint().getX()+size/2-myPoint.getX())
                        +(troopObject.getMyPoint().getY()+size/2-myPoint.getY())
                        *(troopObject.getMyPoint().getY()+size/2- myPoint.getY()))
                        <=(fireRange*fireRange)) {
            return true;
        }
        return false;
    }

    public boolean canEntry(FootHoldObject footHoldObject) {//只要给元素一个角在移动范围内就算其可以进入据点
        if(((footHoldObject.getMyPoint().getX()-size/2-myPoint.getX())
                *(footHoldObject.getMyPoint().getX()-size/2-myPoint.getX())
                +(footHoldObject.getMyPoint().getY()-size/2-myPoint.getY())
                *(footHoldObject.getMyPoint().getY()-size/2- myPoint.getY()))
                <=(moveRange*moveRange)||
                ((footHoldObject.getMyPoint().getX()+size/2-myPoint.getX())
                        *(footHoldObject.getMyPoint().getX()+size/2-myPoint.getX())
                        +(footHoldObject.getMyPoint().getY()-size/2-myPoint.getY())
                        *(footHoldObject.getMyPoint().getY()-size/2- myPoint.getY()))
                        <=(moveRange*moveRange)||
                ((footHoldObject.getMyPoint().getX()-size/2-myPoint.getX())
                        *(footHoldObject.getMyPoint().getX()-size/2-myPoint.getX())
                        +(footHoldObject.getMyPoint().getY()+size/2-myPoint.getY())
                        *(footHoldObject.getMyPoint().getY()+size/2- myPoint.getY()))
                        <=(moveRange*moveRange)||
                ((footHoldObject.getMyPoint().getX()+size/2-myPoint.getX())
                        *(footHoldObject.getMyPoint().getX()+size/2-myPoint.getX())
                        +(footHoldObject.getMyPoint().getY()+size/2-myPoint.getY())
                        *(footHoldObject.getMyPoint().getY()+size/2- myPoint.getY()))
                        <=(moveRange*moveRange)) {
            return true;
        }
        return false;
    }

    public boolean canOccupy(FootHoldObject footHoldObject) {//只要给元素一个角在攻击范围内就算其可以被占领
        if(((footHoldObject.getMyPoint().getX()-size/2-myPoint.getX())
                *(footHoldObject.getMyPoint().getX()-size/2-myPoint.getX())
                +(footHoldObject.getMyPoint().getY()-size/2-myPoint.getY())
                *(footHoldObject.getMyPoint().getY()-size/2- myPoint.getY()))
                <=(fireRange*fireRange)||
                ((footHoldObject.getMyPoint().getX()+size/2-myPoint.getX())
                        *(footHoldObject.getMyPoint().getX()+size/2-myPoint.getX())
                        +(footHoldObject.getMyPoint().getY()-size/2-myPoint.getY())
                        *(footHoldObject.getMyPoint().getY()-size/2- myPoint.getY()))
                        <=(fireRange*fireRange)||
                ((footHoldObject.getMyPoint().getX()-size/2-myPoint.getX())
                        *(footHoldObject.getMyPoint().getX()-size/2-myPoint.getX())
                        +(footHoldObject.getMyPoint().getY()+size/2-myPoint.getY())
                        *(footHoldObject.getMyPoint().getY()+size/2- myPoint.getY()))
                        <=(fireRange*fireRange)||
                ((footHoldObject.getMyPoint().getX()+size/2-myPoint.getX())
                        *(footHoldObject.getMyPoint().getX()+size/2-myPoint.getX())
                        +(footHoldObject.getMyPoint().getY()+size/2-myPoint.getY())
                        *(footHoldObject.getMyPoint().getY()+size/2- myPoint.getY()))
                        <=(fireRange*fireRange)) {
            return true;
        }
        return false;
    }

    public boolean canReach(MyPoint point) {
        if(((point.getX() - myPoint.getX()) * (point.getX() - myPoint.getX())
                +(point.getY() - myPoint.getY()) * (point.getY()- myPoint.getY()))
                <=(moveRange * moveRange)) {
            return true;
        }
        return false;
    }

    public boolean move(MyPoint myPoint) {
        if(canReach(myPoint)){
            boolean flag = true;
            for(TroopObject o : frame.getTroopsObjects()){
                if(o!= this&&o.canClick(myPoint)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                if(camp==frame.getMyCamp()){
                    if(this instanceof Tank){
                        MyPlayer.playMusic("./resource/sound/tank.wav");
                    }else{
                        MyPlayer.playMusic("./resource/sound/leg.wav");
                    }
                }
                this.myPoint = myPoint;
                this.step--;
                return true;
            }else{
                frame.getAddList().add(new Tip(frame,"欲转移位置已有作战单位",this.myPoint));
                return false;
            }
        }else{
            frame.getAddList().add(new Tip(frame,"距离过远，无法到达",this.myPoint));
            return false;
        }

    }
    public boolean occupy(FootHoldObject o) {
        if(canOccupy(o)){
            this.myPoint = o.getMyPoint();
            o.changeCamps(this.getCamp());
            step--;
            if(this.camp == frame.getMyCamp())
                MyPlayer.playMusic("./resource/sound/occupy.wav");
            return true;
        }else{
            frame.getAddList().add(new Tip(frame,"只能占领在攻击范围内的据点",this.myPoint));
            return false;
        }
    }

    public void entry(FootHoldObject footHoldObject){
        if(canEntry(footHoldObject)&&footHoldObject.getCamp()== this.camp){
            this.myPoint = footHoldObject.getMyPoint();
            step--;
        }
    }

    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
        g.setFont(new Font("仿宋", Font.BOLD, 10));
        g.setColor(Color.BLUE);
        g.drawString(String.valueOf(step),myPoint.getX() + size*2 / 7,
                myPoint.getY()-size / 2 );
        g.setColor(Color.white);
        g.drawRect(myPoint.getX()-size/2,myPoint.getY()+size/2,size,size/10);
        g.setColor(Color.red);
        g.fillRect(myPoint.getX()-size/2,myPoint.getY()+size/2,(int)(size*(blood*1.0/MAX_BLOOD)),size/10);
        g.setFont(new Font("仿宋", Font.BOLD, 10));
        g.setColor(Color.red);
        g.drawString(String.valueOf(blood)+"/"+String.valueOf(this.MAX_BLOOD),myPoint.getX()-size/2,
                myPoint.getY()+size/2+size/3);
        if(isChoose){
            g.setColor(Color.GRAY);
            g.drawOval(myPoint.x-moveRange,myPoint.y-moveRange,2*moveRange,2*moveRange);
            g.setColor(Color.RED);
            g.drawOval(myPoint.x-fireRange,myPoint.y-fireRange,2*fireRange,2*fireRange);
        }
        if(blood <=0){
            this.frame.getRemoveList().add(this);
        }
    }


    public int getBlood() {
        return blood;
    }

    public void setBlood(int blood) {
        this.blood = blood;
    }

    public int getFireRange() {
        return fireRange;
    }

    public void setFireRange(int fireRange) {
        this.fireRange = fireRange;
    }

    public int getMoveRange() {
        return moveRange;
    }

    public void setMoveRange(int moveRange) {
        this.moveRange = moveRange;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public MyPoint getPrice() {
        return price;
    }

    public void setPrice(MyPoint price) {
        this.price = price;
    }

    public void setSTEP(){}

}
