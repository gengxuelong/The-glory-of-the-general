package code.altas;

import code.Element.cartoon.BigBurst;
import code.Element.cartoon.littleBurst;
import code.Element.footHold.LargeArmsFactory;
import code.Element.footHold.LargeCity;
import code.Element.troop.NormalInfantry;
import code.Obj.GameObject;
import code.util.values;
import utils.MyPoint;

import java.awt.*;

public class Atlas_E_BoLanZhanYi extends Atlas{
    private Atlas_E_BoLanZhanYi(Image image, int xForBg, int yForBg, int width, int height) {
        this.image = image;
        this.xForBg = xForBg;
        this.yForBg = yForBg;
        this.width = width;
        this.height = height;
        loadData();

    }

    public static Atlas_E_BoLanZhanYi instance () {
        return new Atlas_E_BoLanZhanYi(values.atlas_BoLanZhanYi, -150, -1590, 2800, 2400);
    }

    @Override
    protected void loadData() {
        temps = new int[] {GameObject.GERMAN,GameObject.USSR};
        footHoldList.add(new LargeCity(new MyPoint(2036,1140), GameObject.USSR));
        footHoldList.add(new LargeCity(new MyPoint(2200,850), GameObject.USSR));
        footHoldList.add(new LargeCity(new MyPoint(2137,1582), GameObject.USSR));

        footHoldList.add(new LargeArmsFactory(new MyPoint(2187,1434), GameObject.USSR));
        footHoldList.add(new LargeArmsFactory(new MyPoint(1997,1015), GameObject.USSR));
        footHoldList.add(new LargeArmsFactory(new MyPoint(2250,615), GameObject.USSR));

        troopList.add(new NormalInfantry(new MyPoint(2119,868), GameObject.USSR));
        troopList.add(new NormalInfantry(new MyPoint(2102,945), GameObject.USSR));
        troopList.add(new NormalInfantry(new MyPoint(2066,802), GameObject.USSR));
        troopList.add(new NormalInfantry(new MyPoint(2009,886), GameObject.USSR));
        troopList.add(new NormalInfantry(new MyPoint(2140,1608), GameObject.USSR));
        troopList.add(new NormalInfantry(new MyPoint(2089,1374), GameObject.USSR));
        troopList.add(new NormalInfantry(new MyPoint(2026,1450), GameObject.USSR));
        troopList.add(new NormalInfantry(new MyPoint(2283,1424), GameObject.USSR));
        troopList.add(new NormalInfantry(new MyPoint(2277,1533), GameObject.USSR));

        footHoldList.add(new LargeCity(new MyPoint(784,744), GameObject.GERMAN));
        footHoldList.add(new LargeCity(new MyPoint(578,1070), GameObject.GERMAN));
        footHoldList.add(new LargeCity(new MyPoint(781,2054), GameObject.GERMAN));

        footHoldList.add(new LargeArmsFactory(new MyPoint(875,707), GameObject.GERMAN));
        footHoldList.add(new LargeArmsFactory(new MyPoint(617,1176), GameObject.GERMAN));
        footHoldList.add(new LargeArmsFactory(new MyPoint(1043,2083), GameObject.GERMAN));

        troopList.add(new NormalInfantry(new MyPoint(626,832), GameObject.GERMAN));
        troopList.add(new NormalInfantry(new MyPoint(583,882), GameObject.GERMAN));
        troopList.add(new NormalInfantry(new MyPoint(521,936), GameObject.GERMAN));
        troopList.add(new NormalInfantry(new MyPoint(606,1268), GameObject.GERMAN));
        troopList.add(new NormalInfantry(new MyPoint(620,1349), GameObject.GERMAN));
        troopList.add(new NormalInfantry(new MyPoint(643,1449), GameObject.GERMAN));
        troopList.add(new NormalInfantry(new MyPoint(650,1549), GameObject.GERMAN));
        troopList.add(new NormalInfantry(new MyPoint(846,2000), GameObject.GERMAN));
        troopList.add(new NormalInfantry(new MyPoint(957,2006), GameObject.GERMAN));
        troopList.add(new NormalInfantry(new MyPoint(874,2104), GameObject.GERMAN));
        troopList.add(new NormalInfantry(new MyPoint(940,2120), GameObject.GERMAN));

        this.troopList.add(new littleBurst(new MyPoint(580,830)));//首颗炸弹是哑弹，确保第一个需要的炸弹是可以爆炸的
        this.troopList.add(new BigBurst(new MyPoint(580,830)));//首颗炸弹是哑弹，确保第一个需要的炸弹是可以爆炸的



    }
}
