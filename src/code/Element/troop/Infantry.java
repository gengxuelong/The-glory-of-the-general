package code.Element.troop;

import code.Obj.FootHoldObject;
import code.Obj.TroopObject;
import code.util.Tip;
import utils.MyPoint;

import java.awt.event.KeyEvent;

/**
 * 仅用来简化受击时的兵种判断，无其他作用
 * @author:彭烨
 * @Date: 2021/12/16 12:58
 */
public abstract class Infantry extends TroopObject {
    {
        this.size = 40;
    }

    public abstract void reAttack(TroopObject troopObject);

    public abstract boolean attack(TroopObject troopObject);

    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        switch(key){
            case KeyEvent.VK_1:
                MyPoint thePoint = new MyPoint(myPoint.x-size, myPoint.y);
                AirDefenceSystem airDefenceSystem = new AirDefenceSystem(frame,thePoint,this.getCamp());
                MyPoint thePrice = airDefenceSystem.getPrice();
                boolean flag = true;
                for(TroopObject o:frame.getTroopsObjects()){
                    if(o.canClick(thePoint)){//如果所建造的防空炮正中心在其他元素矩形范围内则认为元素重叠，无法创建
                        flag = false;
                    }
                }
                for(FootHoldObject o:frame.getFootHoldObjects()){
                    if(o.canClick(thePoint)){//如果所建造的防空炮正中心在其他元素矩形范围内则认为元素重叠，无法创建
                        flag = false;
                    }
                }
                if(this.getStep()>0&&flag&&frame.getNowResource().x>thePrice.x&&frame.getNowResource().y>thePrice.y){
                    frame.getAddList().add(airDefenceSystem);
                    frame.getNowResource().setX(frame.getNowResource().x-thePrice.x);
                    frame.getNowResource().setY(frame.getNowResource().y-thePrice.y);
                    this.setStep(this.getStep()-1);
                }else if(this.getStep()<=0){
                    frame.getAddList().add(new Tip(frame,"行动点数已用光",myPoint));
                }else if(flag&&frame.getNowResource().x>thePrice.x||frame.getNowResource().y>thePrice.y){
                    frame.getAddList().add(new Tip(frame,"抱歉，资源不足，无法建造防空炮",myPoint));
                }else if(flag){
                    frame.getAddList().add(new Tip(frame,"抱歉，建造位置已有单位，无法建造防空炮",myPoint));
                }
                break;
            case KeyEvent.VK_2:
                MyPoint thePoint2 = new MyPoint(myPoint.x-size, myPoint.y);
                Fort fort = new Fort(frame,thePoint2,this.getCamp());
                MyPoint thePrice2 = fort.getPrice();
                boolean flag2 = true;
                for(TroopObject o:frame.getTroopsObjects()){
                    if(o.canClick(thePoint2)){//如果所建造的堡垒正中心在其他元素矩形范围内则认为元素重叠，无法创建
                        flag2 = false;
                    }
                }
                for(FootHoldObject o:frame.getFootHoldObjects()){
                    if(o.canClick(thePoint2)){//如果所建造的堡垒正中心在其他元素矩形范围内则认为元素重叠，无法创建
                        flag2 = false;
                    }
                }
                if(this.getStep()>0&&flag2&&frame.getNowResource().x>thePrice2.x&&frame.getNowResource().y>thePrice2.y){
                    frame.getAddList().add(fort);
                    frame.getNowResource().setX(frame.getNowResource().x-thePrice2.x);
                    frame.getNowResource().setY(frame.getNowResource().y-thePrice2.y);
                    this.setStep(this.getStep()-1);
                }else if(this.getStep()<=0){
                    frame.getAddList().add(new Tip(frame,"行动点数已用光",myPoint));
                }else if(!flag2){
                    frame.getAddList().add(new Tip(frame,"抱歉，建造位置已有单位，无法建造机枪堡垒",myPoint));
                } else if(frame.getNowResource().x>thePrice2.x||frame.getNowResource().y>thePrice2.y){
                    frame.getAddList().add(new Tip(frame,"抱歉，资源不足，无法建造机枪堡垒",myPoint));
                }
                break;
        }

    }
}
