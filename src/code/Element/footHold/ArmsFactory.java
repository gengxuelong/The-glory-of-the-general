package code.Element.footHold;

import code.Obj.FootHoldObject;
import utils.MyPoint;


/**
 * @author  wangxiaoyang
 */
public abstract class ArmsFactory extends FootHoldObject {

    protected int iron;//工业值产出量

    public static final int LIGHT_TANK=1;
    public static final int MIDDLE_TANK=2;
    public static final int HEAVY_TANK=3;
    public static final int LIGHT_ARTILLERY=4;
    public static final int HEAVY_ARTILLERY=5;
    public static final int ROCKET_GUN=6;
    public static final int ARMORED=7;

    {
        size = 60;
    }
    ArmsFactory(MyPoint point, int temp){
        this.myPoint = point;
        this.setCamp(temp);
    }

    public void produceResource() {
        this.frame.getNowResource().setY(this.frame.getNowResource().y + this.iron);
    }


}
