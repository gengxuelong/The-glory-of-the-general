package code.altas;

import code.Element.cartoon.BigBurst;
import code.Element.cartoon.littleBurst;
import code.Element.footHold.Airport;
import code.Element.footHold.LargeCity;
import code.Element.footHold.MiddleArmsFactory;
import code.Element.footHold.MiddleCity;
import code.Element.troop.*;
import code.Obj.GameObject;
import code.util.values;
import utils.MyPoint;

import java.awt.*;

/**
 * @author wenrui
 * @Date 2021/12/23 21:48
 */
public class Atlas_A_TaiYuanHuiZhan extends Atlas {

    private Atlas_A_TaiYuanHuiZhan(Image image, int xForBg, int yForBg, int width, int height) {
        this.image = image;
        this.xForBg = xForBg;
        this.yForBg = yForBg;
        this.width = width;
        this.height = height;
        loadData();

    }

    public static Atlas_A_TaiYuanHuiZhan instance () {
        return new Atlas_A_TaiYuanHuiZhan(values.atlas_QiQiShiBian, -150, -1590, 3000, 3000);
    }

    @Override
    protected void loadData() {
        temps = new int[]{GameObject.KMT, GameObject.JAPAN};

        footHoldList.add(new LargeCity(new MyPoint(1515, 1009), GameObject.JAPAN));//武汉
        footHoldList.add(new MiddleCity(new MyPoint(1925, 1367), GameObject.JAPAN));//南昌
        footHoldList.add(new LargeCity(new MyPoint(1395, 2451), GameObject.JAPAN));//广州

        footHoldList.add(new MiddleCity(new MyPoint(1237, 1492), GameObject.KMT));//长沙
        footHoldList.add(new MiddleCity(new MyPoint(243, 2518), GameObject.KMT));//南宁

//步兵
        troopList.add(new NormalInfantry(new MyPoint(1329, 1103), GameObject.JAPAN));
        troopList.add(new NormalInfantry(new MyPoint(1473, 1285), GameObject.JAPAN));
        troopList.add(new NormalInfantry(new MyPoint(1580, 1488), GameObject.JAPAN));
        troopList.add(new NormalInfantry(new MyPoint(1887, 1716), GameObject.JAPAN));
        troopList.add(new NormalInfantry(new MyPoint(1193, 2513), GameObject.JAPAN));
        troopList.add(new NormalInfantry(new MyPoint(1327, 2304), GameObject.JAPAN));
        troopList.add(new SpecialInfantry(new MyPoint(1609, 1961), GameObject.JAPAN));
        troopList.add(new SpecialInfantry(new MyPoint(1805, 1652), GameObject.JAPAN));

        troopList.add(new NormalInfantry(new MyPoint(442, 2549), GameObject.KMT));
        troopList.add(new NormalInfantry(new MyPoint(351, 2274), GameObject.KMT));
        troopList.add(new NormalInfantry(new MyPoint(433, 2109), GameObject.KMT));
        troopList.add(new NormalInfantry(new MyPoint(539, 1709), GameObject.KMT));
        troopList.add(new NormalInfantry(new MyPoint(539, 1409), GameObject.KMT));
        troopList.add(new NormalInfantry(new MyPoint(785, 1401), GameObject.KMT));
        troopList.add(new NormalInfantry(new MyPoint(969, 1402), GameObject.KMT));
        troopList.add(new NormalInfantry(new MyPoint(1021, 1841), GameObject.KMT));


//坦克
        troopList.add(new LightTank(new MyPoint(1001, 2522), GameObject.JAPAN));
        troopList.add(new LightTank(new MyPoint(1109, 2271), GameObject.JAPAN));
        troopList.add(new MiddleTank(new MyPoint(1399, 2100), GameObject.JAPAN));
        troopList.add(new MiddleTank(new MyPoint(1457, 1588), GameObject.JAPAN));
        troopList.add(new HeavyTank(new MyPoint(1280, 930), GameObject.JAPAN));
        troopList.add(new HeavyTank(new MyPoint(1187, 1104), GameObject.JAPAN));


//大炮
        troopList.add(new LightArtillery(new MyPoint(474, 2199), GameObject.KMT));
        troopList.add(new LightArtillery(new MyPoint(597, 1653), GameObject.KMT));
        troopList.add(new LightArtillery(new MyPoint(983, 1503), GameObject.KMT));
        troopList.add(new HeavyArtillery(new MyPoint(566, 1578), GameObject.KMT));
        troopList.add(new HeavyArtillery(new MyPoint(755, 2349), GameObject.KMT));
        troopList.add(new HeavyArtillery(new MyPoint(509, 2617), GameObject.KMT));

        troopList.add(new LightArtillery(new MyPoint(1411, 1805), GameObject.JAPAN));
        troopList.add(new LightArtillery(new MyPoint(1388, 1497), GameObject.JAPAN));
        troopList.add(new LightArtillery(new MyPoint(1203, 2377), GameObject.JAPAN));
        troopList.add(new HeavyArtillery(new MyPoint(1326, 1788), GameObject.JAPAN));
        troopList.add(new HeavyArtillery(new MyPoint(1171, 840), GameObject.JAPAN));
        troopList.add(new HeavyArtillery(new MyPoint(1789, 1053), GameObject.JAPAN));


//火箭炮
        troopList.add(new RocketGun(new MyPoint(971, 1691), GameObject.KMT));
        troopList.add(new RocketGun(new MyPoint(937, 2075), GameObject.KMT));
        troopList.add(new RocketGun(new MyPoint(759, 2494), GameObject.KMT));
        troopList.add(new RocketGun(new MyPoint(585, 2555), GameObject.KMT));
        troopList.add(new RocketGun(new MyPoint(695, 1529), GameObject.KMT));

        troopList.add(new RocketGun(new MyPoint(1339, 1025), GameObject.JAPAN));
        troopList.add(new RocketGun(new MyPoint(1308, 661), GameObject.JAPAN));
        troopList.add(new RocketGun(new MyPoint(1467, 2279), GameObject.JAPAN));
        troopList.add(new RocketGun(new MyPoint(1097, 2628), GameObject.JAPAN));
        troopList.add(new RocketGun(new MyPoint(964, 2336), GameObject.JAPAN));


//装甲车
        troopList.add(new Armored(new MyPoint(127, 2387), GameObject.KMT));
        troopList.add(new Armored(new MyPoint(599, 2145), GameObject.KMT));
        troopList.add(new Armored(new MyPoint(426, 1567), GameObject.KMT));
        troopList.add(new Armored(new MyPoint(795, 2199), GameObject.KMT));
        troopList.add(new Armored(new MyPoint(391, 2629), GameObject.KMT));

        troopList.add(new Armored(new MyPoint(1635, 2517), GameObject.JAPAN));
        troopList.add(new Armored(new MyPoint(1321, 2579), GameObject.JAPAN));
        troopList.add(new Armored(new MyPoint(1724, 1967), GameObject.JAPAN));
        troopList.add(new Armored(new MyPoint(1953, 1529), GameObject.JAPAN));
        troopList.add(new Armored(new MyPoint(1663, 986), GameObject.JAPAN));

//兵工厂
        footHoldList.add(new MiddleArmsFactory(new MyPoint(101, 2525), GameObject.KMT));
        footHoldList.add(new MiddleArmsFactory(new MyPoint(1021, 1587), GameObject.KMT));
        footHoldList.add(new MiddleArmsFactory(new MyPoint(676, 2078), GameObject.KMT));

        footHoldList.add(new MiddleArmsFactory(new MyPoint(1629, 1114), GameObject.JAPAN));
        footHoldList.add(new MiddleArmsFactory(new MyPoint(1553, 2525), GameObject.JAPAN));
        footHoldList.add(new MiddleArmsFactory(new MyPoint(1693, 1915), GameObject.JAPAN));
        footHoldList.add(new MiddleArmsFactory(new MyPoint(1901, 1487), GameObject.JAPAN));

//机场
        footHoldList.add(new Airport(new MyPoint(1720, 2484), GameObject.JAPAN));
        footHoldList.add(new Airport(new MyPoint(1608, 1181), GameObject.JAPAN));


        this.troopList.add(new littleBurst(new MyPoint(580, 830)));//首颗炸弹是哑弹，确保第一个需要的炸弹是可以爆炸的

        this.troopList.add(new BigBurst(new MyPoint(580,830)));//首颗炸弹是哑弹，确保第一个需要的炸弹是可以爆炸的

    }
}