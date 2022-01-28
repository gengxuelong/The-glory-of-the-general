package code.altas;

import code.Element.cartoon.BigBurst;
import code.Element.footHold.LargeArmsFactory;
import code.Element.footHold.LargeCity;
import code.Element.troop.NormalInfantry;
import code.Obj.GameObject;
import code.util.values;
import utils.MyPoint;

import java.awt.*;

public class Atlas_E_SiDaLingGeLeZhanYi extends Atlas{
    private Atlas_E_SiDaLingGeLeZhanYi(Image image, int xForBg, int yForBg, int width, int height) {
        this.image = image;
        this.xForBg = xForBg;
        this.yForBg = yForBg;
        this.width = width;
        this.height = height;
        loadData();

    }

    public static Atlas_E_SiDaLingGeLeZhanYi instance () {
        return new Atlas_E_SiDaLingGeLeZhanYi(values.atlas_SiDaLingGeLeZhanYi, -150, -1590, 2800, 2400);
    }

    @Override
    protected void loadData() {
        temps = new int[] {GameObject.GERMAN,GameObject.USSR};

        footHoldList.add(new LargeCity(new MyPoint(1808,1416), GameObject.USSR));
        footHoldList.add(new LargeCity(new MyPoint(1750,237), GameObject.USSR));
        footHoldList.add(new LargeCity(new MyPoint(1981,723), GameObject.USSR));

        footHoldList.add(new LargeArmsFactory(new MyPoint(1630,288), GameObject.USSR));
        footHoldList.add(new LargeArmsFactory(new MyPoint(1860,153), GameObject.USSR));
        footHoldList.add(new LargeArmsFactory(new MyPoint(2043,653), GameObject.USSR));
        footHoldList.add(new LargeArmsFactory(new MyPoint(2057,786), GameObject.USSR));
        footHoldList.add(new LargeArmsFactory(new MyPoint(1732,1438), GameObject.USSR));
        footHoldList.add(new LargeArmsFactory(new MyPoint(1923,1400), GameObject.USSR));

        troopList.add(new NormalInfantry(new MyPoint(1449,208), GameObject.USSR));
        troopList.add(new NormalInfantry(new MyPoint(1502,350), GameObject.USSR));
        troopList.add(new NormalInfantry(new MyPoint(1606,112), GameObject.USSR));
        troopList.add(new NormalInfantry(new MyPoint(1734,445), GameObject.USSR));
        troopList.add(new NormalInfantry(new MyPoint(1952,387), GameObject.USSR));
        troopList.add(new NormalInfantry(new MyPoint(1784,616), GameObject.USSR));
        troopList.add(new NormalInfantry(new MyPoint(1784,752), GameObject.USSR));
        troopList.add(new NormalInfantry(new MyPoint(1863,823), GameObject.USSR));
        troopList.add(new NormalInfantry(new MyPoint(1946,875), GameObject.USSR));
        troopList.add(new NormalInfantry(new MyPoint(2106,874), GameObject.USSR));
        troopList.add(new NormalInfantry(new MyPoint(1883,1243), GameObject.USSR));
        troopList.add(new NormalInfantry(new MyPoint(1763,1242), GameObject.USSR));
        troopList.add(new NormalInfantry(new MyPoint(1625,1292), GameObject.USSR));
        troopList.add(new NormalInfantry(new MyPoint(1586,1406), GameObject.USSR));
        troopList.add(new NormalInfantry(new MyPoint(1591,1493), GameObject.USSR));






        footHoldList.add(new LargeCity(new MyPoint(222,299), GameObject.GERMAN));
        footHoldList.add(new LargeCity(new MyPoint(540,1050), GameObject.GERMAN));
        footHoldList.add(new LargeCity(new MyPoint(590,1658), GameObject.GERMAN));

        footHoldList.add(new LargeArmsFactory(new MyPoint(330,208), GameObject.GERMAN));
        footHoldList.add(new LargeArmsFactory(new MyPoint(346,292), GameObject.GERMAN));
        footHoldList.add(new LargeArmsFactory(new MyPoint(429,983), GameObject.GERMAN));
        footHoldList.add(new LargeArmsFactory(new MyPoint(410,1098), GameObject.GERMAN));
        footHoldList.add(new LargeArmsFactory(new MyPoint(463,1693), GameObject.GERMAN));
        footHoldList.add(new LargeArmsFactory(new MyPoint(650,1731), GameObject.GERMAN));

        troopList.add(new NormalInfantry(new MyPoint(486,1782), GameObject.GERMAN));
        troopList.add(new NormalInfantry(new MyPoint(565,1802), GameObject.GERMAN));
        troopList.add(new NormalInfantry(new MyPoint(658,1823), GameObject.GERMAN));
        troopList.add(new NormalInfantry(new MyPoint(505,1861), GameObject.GERMAN));
        troopList.add(new NormalInfantry(new MyPoint(332,1107), GameObject.GERMAN));
        troopList.add(new NormalInfantry(new MyPoint(346,1185), GameObject.GERMAN));
        troopList.add(new NormalInfantry(new MyPoint(547,1137), GameObject.GERMAN));
        troopList.add(new NormalInfantry(new MyPoint(598,1199), GameObject.GERMAN));
        troopList.add(new NormalInfantry(new MyPoint(530,912), GameObject.GERMAN));
        troopList.add(new NormalInfantry(new MyPoint(395,181), GameObject.GERMAN));
        troopList.add(new NormalInfantry(new MyPoint(431,313), GameObject.GERMAN));
        troopList.add(new NormalInfantry(new MyPoint(297,414), GameObject.GERMAN));



        this.troopList.add(new BigBurst(new MyPoint(580,830)));//首颗炸弹是哑弹，确保第一个需要的炸弹是可以爆炸的



    }
}
