package code.altas;

import java.awt.*;

import code.Element.cartoon.BigBurst;
import code.Element.footHold.*;
import code.Element.troop.*;
import code.Obj.GameObject;
import code.util.values;
import utils.MyPoint;

/**
 * @author 王晓阳
 * 七七事变
 */
public class Atlas_A_77ShiBian extends Atlas{

    private Atlas_A_77ShiBian(Image image, int xForBg, int yForBg, int width, int height) {
        this.image = image;
        this.xForBg = xForBg;
        this.yForBg = yForBg;
        this.width = width;
        this.height = height;
        loadData();

    }

    public static Atlas_A_77ShiBian instance() {
        return new Atlas_A_77ShiBian(values.atlas_QiQiShiBian, -150, -1590, 3000, 3000);
    }
    @Override
    protected void loadData() {
        temps = new int[] {GameObject.KMT,GameObject.JAPAN};
        footHoldList.add(new LargeCity(new MyPoint(972,2150), GameObject.JAPAN));//北平
        footHoldList.add(new LargeCity(new MyPoint(1989,1753), GameObject.JAPAN));//沈阳

        footHoldList.add(new SmallCity(new MyPoint(2457,2162), GameObject.JAPAN));//平壤
        footHoldList.add(new SmallCity(new MyPoint(2669,2377), GameObject.JAPAN));//首尔

        footHoldList.add(new MiddleCity(new MyPoint(2314,1053), GameObject.JAPAN));//哈尔滨
        footHoldList.add(new MiddleCity(new MyPoint(2189,1387), GameObject.JAPAN));//长春
        footHoldList.add(new MiddleCity(new MyPoint(1098,2252), GameObject.JAPAN));//天津
        footHoldList.add(new MiddleCity(new MyPoint(1863,2498), GameObject.JAPAN));//山东半岛

        footHoldList.add(new LargeArmsFactory(new MyPoint(1972,1847), GameObject.JAPAN));
        footHoldList.add(new MiddleArmsFactory(new MyPoint(1944,1908), GameObject.JAPAN));
        footHoldList.add(new LargeArmsFactory(new MyPoint(1936,1999), GameObject.JAPAN));
        footHoldList.add(new MiddleArmsFactory(new MyPoint(2070,1684), GameObject.JAPAN));


        footHoldList.add(new LargeCity(new MyPoint(706,2470), GameObject.KMT));//石家庄
        footHoldList.add(new LargeCity(new MyPoint(1111,2672), GameObject.KMT));//济南
        footHoldList.add(new LargeCity(new MyPoint(401,2224), GameObject.KMT));

        footHoldList.add(new MiddleCity(new MyPoint(407,2486), GameObject.KMT));//太原
        footHoldList.add(new MiddleCity(new MyPoint(936,2522), GameObject.KMT));

        footHoldList.add(new SmallCity(new MyPoint(553,2398), GameObject.KMT));//
        footHoldList.add(new SmallCity(new MyPoint(1049,2748), GameObject.KMT));

        footHoldList.add(new LargeArmsFactory(new MyPoint(404,2363), GameObject.KMT));
        footHoldList.add(new MiddleArmsFactory(new MyPoint(266,2362), GameObject.KMT));


        troopList.add(new MiddleTank(new MyPoint(888,2178), GameObject.JAPAN));
        troopList.add(new HeavyTank(new MyPoint(943,2254), GameObject.JAPAN));
        troopList.add(new HeavyTank(new MyPoint(1008,2320), GameObject.JAPAN));
        troopList.add(new MiddleTank(new MyPoint(1128,2375), GameObject.JAPAN));

        troopList.add(new NormalInfantry(new MyPoint(1031,2083), GameObject.JAPAN));
        troopList.add(new NormalInfantry(new MyPoint(1094,2121), GameObject.JAPAN));
        troopList.add(new NormalInfantry(new MyPoint(1165,2181), GameObject.JAPAN));
        troopList.add(new NormalInfantry(new MyPoint(1230,2159), GameObject.JAPAN));
        troopList.add(new NormalInfantry(new MyPoint(1188,2078), GameObject.JAPAN));
        troopList.add(new NormalInfantry(new MyPoint(1102,2020), GameObject.JAPAN));

        troopList.add(new MobileInfantry(new MyPoint(1720,2460), GameObject.JAPAN));
        troopList.add(new MobileInfantry(new MyPoint(1761,2510), GameObject.JAPAN));
        troopList.add(new MobileInfantry(new MyPoint(1767,2568), GameObject.JAPAN));
        troopList.add(new MobileInfantry(new MyPoint(1944,2502), GameObject.JAPAN));
        troopList.add(new MobileInfantry(new MyPoint(1894,1696), GameObject.JAPAN));
        troopList.add(new MobileInfantry(new MyPoint(1900,1811), GameObject.JAPAN));
        troopList.add(new MobileInfantry(new MyPoint(2077,1886), GameObject.JAPAN));
        troopList.add(new MobileInfantry(new MyPoint(2131,1312), GameObject.JAPAN));
        troopList.add(new MobileInfantry(new MyPoint(2086,1418), GameObject.JAPAN));
        troopList.add(new MobileInfantry(new MyPoint(2264,1482), GameObject.JAPAN));
        troopList.add(new MobileInfantry(new MyPoint(2295,1352), GameObject.JAPAN));
        troopList.add(new MobileInfantry(new MyPoint(2436,2063), GameObject.JAPAN));
        troopList.add(new MobileInfantry(new MyPoint(2589,2175), GameObject.JAPAN));
        troopList.add(new MobileInfantry(new MyPoint(2701,2306), GameObject.JAPAN));
        troopList.add(new MobileInfantry(new MyPoint(2730,2460), GameObject.JAPAN));
        troopList.add(new MobileInfantry(new MyPoint(2827,2394), GameObject.JAPAN));


        troopList.add(new HeavyTank(new MyPoint(628,2417), GameObject.KMT));
        troopList.add(new HeavyTank(new MyPoint(709,2380), GameObject.KMT));
        troopList.add(new MiddleTank(new MyPoint(789,2411), GameObject.KMT));
        troopList.add(new MiddleTank(new MyPoint(782,2484), GameObject.KMT));
        troopList.add(new MiddleTank(new MyPoint(866,2508), GameObject.KMT));
        troopList.add(new HeavyTank(new MyPoint(996,2555), GameObject.KMT));
        troopList.add(new HeavyTank(new MyPoint(1110,2572), GameObject.KMT));

        troopList.add(new NormalInfantry(new MyPoint(662,2528), GameObject.KMT));
        troopList.add(new NormalInfantry(new MyPoint(711,2558), GameObject.KMT));
        troopList.add(new NormalInfantry(new MyPoint(773,2592), GameObject.KMT));
        troopList.add(new NormalInfantry(new MyPoint(840,2633), GameObject.KMT));
        troopList.add(new NormalInfantry(new MyPoint(900,2664), GameObject.KMT));
        troopList.add(new NormalInfantry(new MyPoint(1004,2656), GameObject.KMT));

        troopList.add(new MobileInfantry(new MyPoint(154,1972), GameObject.KMT));
        troopList.add(new MobileInfantry(new MyPoint(154,2023), GameObject.KMT));
        troopList.add(new MobileInfantry(new MyPoint(151,2072), GameObject.KMT));
        troopList.add(new MobileInfantry(new MyPoint(160,2119), GameObject.KMT));
        troopList.add(new MobileInfantry(new MyPoint(114,1957), GameObject.KMT));
        troopList.add(new MobileInfantry(new MyPoint(108,2000), GameObject.KMT));
        troopList.add(new MobileInfantry(new MyPoint(106,2043), GameObject.KMT));
        troopList.add(new MobileInfantry(new MyPoint(92,2107), GameObject.KMT));


        this.troopList.add(new BigBurst(new MyPoint(580,830)));//首颗炸弹是哑弹，确保第一个需要的炸弹是可以爆炸的



    }
}
