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

public class Atlas_E_BoLingZhanYi extends Atlas{
    private Atlas_E_BoLingZhanYi(Image image, int xForBg, int yForBg, int width, int height) {
        this.image = image;
        this.xForBg = xForBg;
        this.yForBg = yForBg;
        this.width = width;
        this.height = height;
        loadData();

    }

    public static Atlas_E_BoLingZhanYi instance () {
        return new Atlas_E_BoLingZhanYi(values.atlas_BoLinZhanYi, -150, -1590, 2800, 2400);
    }

    @Override
    protected void loadData() {
        temps = new int[] {GameObject.GERMAN,GameObject.USSR};

        footHoldList.add(new LargeCity(new MyPoint(1854,1552), GameObject.USSR));
        footHoldList.add(new LargeCity(new MyPoint(1618,1300), GameObject.USSR));
        footHoldList.add(new LargeCity(new MyPoint(1464,1823), GameObject.USSR));

        footHoldList.add(new LargeArmsFactory(new MyPoint(1663,1222), GameObject.USSR));
        footHoldList.add(new LargeArmsFactory(new MyPoint(1924,1591), GameObject.USSR));
        footHoldList.add(new LargeArmsFactory(new MyPoint(1535,1895), GameObject.USSR));
        footHoldList.add(new LargeArmsFactory(new MyPoint(1780,1513), GameObject.USSR));
        footHoldList.add(new LargeArmsFactory(new MyPoint(1416,1901), GameObject.USSR));
        footHoldList.add(new LargeArmsFactory(new MyPoint(1583,1374), GameObject.USSR));

        troopList.add(new NormalInfantry(new MyPoint(1504,1232), GameObject.USSR));
        troopList.add(new NormalInfantry(new MyPoint(1454,1341), GameObject.USSR));
        troopList.add(new NormalInfantry(new MyPoint(1464,1461), GameObject.USSR));
        troopList.add(new NormalInfantry(new MyPoint(1433,1588), GameObject.USSR));
        troopList.add(new NormalInfantry(new MyPoint(1367,1718), GameObject.USSR));
        troopList.add(new NormalInfantry(new MyPoint(1345,1810), GameObject.USSR));
        troopList.add(new NormalInfantry(new MyPoint(1324,1909), GameObject.USSR));
        troopList.add(new NormalInfantry(new MyPoint(1388,2022), GameObject.USSR));
        troopList.add(new NormalInfantry(new MyPoint(1625,1589), GameObject.USSR));
        troopList.add(new NormalInfantry(new MyPoint(1729,1657), GameObject.USSR));
        troopList.add(new NormalInfantry(new MyPoint(1614,1740), GameObject.USSR));
        troopList.add(new NormalInfantry(new MyPoint(1566,1664), GameObject.USSR));


        footHoldList.add(new LargeCity(new MyPoint(472,1436), GameObject.GERMAN));
        footHoldList.add(new LargeCity(new MyPoint(686,1119), GameObject.GERMAN));

        footHoldList.add(new LargeArmsFactory(new MyPoint(570,1280), GameObject.GERMAN));
        footHoldList.add(new LargeArmsFactory(new MyPoint(423,1218), GameObject.GERMAN));
        footHoldList.add(new LargeArmsFactory(new MyPoint(871,1174), GameObject.GERMAN));
        footHoldList.add(new LargeArmsFactory(new MyPoint(530,1605), GameObject.GERMAN));

        troopList.add(new NormalInfantry(new MyPoint(644,1662), GameObject.GERMAN));
        troopList.add(new NormalInfantry(new MyPoint(654,1570), GameObject.GERMAN));
        troopList.add(new NormalInfantry(new MyPoint(650,1459), GameObject.GERMAN));
        troopList.add(new NormalInfantry(new MyPoint(666,1339), GameObject.GERMAN));
        troopList.add(new NormalInfantry(new MyPoint(703,1222), GameObject.GERMAN));
        troopList.add(new NormalInfantry(new MyPoint(782,1098), GameObject.GERMAN));
        troopList.add(new NormalInfantry(new MyPoint(911,1094), GameObject.GERMAN));
        troopList.add(new NormalInfantry(new MyPoint(976,1210), GameObject.GERMAN));
        troopList.add(new NormalInfantry(new MyPoint(886,1297), GameObject.GERMAN));
        troopList.add(new NormalInfantry(new MyPoint(381,1325), GameObject.GERMAN));
        troopList.add(new NormalInfantry(new MyPoint(342,1165), GameObject.GERMAN));
        troopList.add(new NormalInfantry(new MyPoint(268,1347), GameObject.GERMAN));


        this.troopList.add(new littleBurst(new MyPoint(580,830)));//首颗炸弹是哑弹，确保第一个需要的炸弹是可以爆炸的
        this.troopList.add(new BigBurst(new MyPoint(580,830)));//首颗炸弹是哑弹，确保第一个需要的炸弹是可以爆炸的




    }
}
