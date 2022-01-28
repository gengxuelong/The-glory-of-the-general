package code.altas;

import code.Element.cartoon.BigBurst;
import code.Element.cartoon.littleBurst;
import code.Element.footHold.Airport;
import code.Element.footHold.LargeCity;
import code.Element.footHold.MiddleCity;
import code.Element.footHold.SmallCity;
import code.Element.troop.*;
import code.Obj.GameObject;
import code.util.values;
import utils.MyPoint;

import java.awt.*;

/**
 * @author 康照鑫
 * 保卫云南
 */
public class Atlas_A_BaoWeiYunNan extends Atlas{

    private Atlas_A_BaoWeiYunNan(Image image, int xForBg, int yForBg, int width, int height) {
        this.image = image;
        this.xForBg = xForBg;
        this.yForBg = yForBg;
        this.width = width;
        this.height = height;
        loadData();

    }



    public static Atlas_A_BaoWeiYunNan instance () {
        return new Atlas_A_BaoWeiYunNan(values.atlas_BaoWeiYunNan, -150, -1590, 3000, 3000);
    }

    public void loadData(){

        temps = new int[] {GameObject.KMT,GameObject.JAPAN};
        footHoldList.add(new LargeCity(new MyPoint(658,952), GameObject.JAPAN));//达卡
        footHoldList.add(new LargeCity(new MyPoint(1328,2388), GameObject.JAPAN));//内比都
        footHoldList.add(new LargeCity(new MyPoint(2694,2277), GameObject.JAPAN));//河内

        footHoldList.add(new LargeCity(new MyPoint(2850,562), GameObject.KMT));//贵阳
        footHoldList.add(new LargeCity(new MyPoint(2325,1072), GameObject.KMT));//昆明


        footHoldList.add(new SmallCity(new MyPoint(2325,1072), GameObject.KMT));
        footHoldList.add(new SmallCity(new MyPoint(2909,1301), GameObject.KMT));
        footHoldList.add(new MiddleCity(new MyPoint(2431,1444), GameObject.KMT));

        footHoldList.add(new SmallCity(new MyPoint(2046,1774), GameObject.JAPAN));
        footHoldList.add(new SmallCity(new MyPoint(2621,2634), GameObject.JAPAN));
        footHoldList.add(new SmallCity(new MyPoint(2185,2885), GameObject.JAPAN));
        footHoldList.add(new MiddleCity(new MyPoint(1714,2705), GameObject.JAPAN));
        footHoldList.add(new SmallCity(new MyPoint(1215,1724), GameObject.JAPAN));
        footHoldList.add(new MiddleCity(new MyPoint(919,938), GameObject.JAPAN));


        troopList.add(new NormalInfantry(new MyPoint(656,954), GameObject.JAPAN));
        troopList.add(new NormalInfantry(new MyPoint(1326,2390), GameObject.JAPAN));
        troopList.add(new NormalInfantry(new MyPoint(2692,2279), GameObject.JAPAN));
        troopList.add(new NormalInfantry(new MyPoint(1265,1950), GameObject.JAPAN));
        troopList.add(new NormalInfantry(new MyPoint(1844,2547), GameObject.JAPAN));
        troopList.add(new NormalInfantry(new MyPoint(2578,1855), GameObject.JAPAN));

        troopList.add(new NormalInfantry(new MyPoint(2852,564), GameObject.KMT));
        troopList.add(new NormalInfantry(new MyPoint(2327,1074), GameObject.KMT));
        troopList.add(new NormalInfantry(new MyPoint(2327,1074), GameObject.KMT));
        troopList.add(new NormalInfantry(new MyPoint(1999,342), GameObject.KMT));
        troopList.add(new NormalInfantry(new MyPoint(2019,731), GameObject.KMT));
        troopList.add(new NormalInfantry(new MyPoint(2246,803), GameObject.KMT));
        troopList.add(new NormalInfantry(new MyPoint(2704,1632), GameObject.KMT));
        troopList.add(new NormalInfantry(new MyPoint(2803,1287), GameObject.KMT));
        troopList.add(new NormalInfantry(new MyPoint(1874,1550), GameObject.KMT));
        troopList.add(new NormalInfantry(new MyPoint(2831,1508), GameObject.KMT));
        troopList.add(new NormalInfantry(new MyPoint(2503,1413), GameObject.KMT));
        troopList.add(new NormalInfantry(new MyPoint(2026,1346), GameObject.KMT));
        troopList.add(new NormalInfantry(new MyPoint(1985,1927), GameObject.KMT));
        troopList.add(new NormalInfantry(new MyPoint(2292,1645), GameObject.KMT));


        troopList.add(new MiddleTank(new MyPoint(2170,1080),GameObject.KMT));
        troopList.add(new MiddleTank(new MyPoint(2812,887),GameObject.KMT));
        troopList.add(new MiddleTank(new MyPoint(2828,1858),GameObject.KMT));
        troopList.add(new MiddleTank(new MyPoint(2542,1314),GameObject.KMT));

        troopList.add(new MiddleTank(new MyPoint(2703,2179),GameObject.JAPAN));
        troopList.add(new MiddleTank(new MyPoint(1018,776),GameObject.JAPAN));
        troopList.add(new MiddleTank(new MyPoint(1486,1327),GameObject.JAPAN));
        troopList.add(new MiddleTank(new MyPoint(1378,2160),GameObject.JAPAN));
        troopList.add(new MiddleTank(new MyPoint(2010,2251),GameObject.JAPAN));
        troopList.add(new MiddleTank(new MyPoint(2442,2144),GameObject.JAPAN));
        troopList.add(new MiddleTank(new MyPoint(2728,1996),GameObject.JAPAN));


        troopList.add(new HeavyArtillery(new MyPoint(2369,1002),GameObject.KMT));
        troopList.add(new HeavyArtillery(new MyPoint(2795,1035),GameObject.KMT));

        troopList.add(new HeavyArtillery(new MyPoint(2754,2154),GameObject.JAPAN));
        troopList.add(new HeavyArtillery(new MyPoint(2568,1945),GameObject.JAPAN));
        troopList.add(new HeavyArtillery(new MyPoint(2262,2240),GameObject.JAPAN));
        troopList.add(new HeavyArtillery(new MyPoint(1507,1888),GameObject.JAPAN));
        troopList.add(new HeavyArtillery(new MyPoint(790,799),GameObject.JAPAN));


        troopList.add(new Armored(new MyPoint(2381,851),GameObject.KMT));
        troopList.add(new Armored(new MyPoint(2318,1441),GameObject.KMT));

        troopList.add(new Armored(new MyPoint(2448,2344),GameObject.JAPAN));
        troopList.add(new Armored(new MyPoint(2580,2171),GameObject.JAPAN));
        troopList.add(new Armored(new MyPoint(1794,2111),GameObject.JAPAN));
        troopList.add(new Armored(new MyPoint(1240,2080),GameObject.JAPAN));


        troopList.add(new LightArtillery(new MyPoint(2003,988),GameObject.KMT));
        troopList.add(new LightArtillery(new MyPoint(2898,1436),GameObject.KMT));
        troopList.add(new LightArtillery(new MyPoint(2476,1531),GameObject.KMT));

        troopList.add(new LightArtillery(new MyPoint(2350,2050),GameObject.JAPAN));
        troopList.add(new LightArtillery(new MyPoint(2694,2512),GameObject.JAPAN));
        troopList.add(new LightArtillery(new MyPoint(2113,2409),GameObject.JAPAN));
        troopList.add(new LightArtillery(new MyPoint(1630,2056),GameObject.JAPAN));
        troopList.add(new LightArtillery(new MyPoint(1298,1241),GameObject.JAPAN));


        troopList.add(new RocketGun(new MyPoint(2062,1014),GameObject.KMT));
        troopList.add(new RocketGun(new MyPoint(2896,1624),GameObject.KMT));
        troopList.add(new RocketGun(new MyPoint(2047,1597),GameObject.KMT));

        troopList.add(new RocketGun(new MyPoint(2572,2402),GameObject.JAPAN));
        troopList.add(new RocketGun(new MyPoint(2339,2519),GameObject.JAPAN));
        troopList.add(new RocketGun(new MyPoint(1330,1681),GameObject.JAPAN));
        troopList.add(new RocketGun(new MyPoint(1533,770),GameObject.JAPAN));
        troopList.add(new RocketGun(new MyPoint(1148,406),GameObject.JAPAN));
        troopList.add(new RocketGun(new MyPoint(2702,1850),GameObject.JAPAN));


        footHoldList.add(new Airport(new MyPoint(2734,711),GameObject.KMT));
        footHoldList.add(new Airport(new MyPoint(2510,1001),GameObject.KMT));



        footHoldList.add(new Airport(new MyPoint(2598,2496),GameObject.JAPAN));
        footHoldList.add(new Airport(new MyPoint(2226,2381),GameObject.JAPAN));
        footHoldList.add(new Airport(new MyPoint(1872,2476),GameObject.JAPAN));
        footHoldList.add(new Airport(new MyPoint(1498,2372),GameObject.JAPAN));
        footHoldList.add(new Airport(new MyPoint(1151,769),GameObject.JAPAN));
        footHoldList.add(new Airport(new MyPoint(701,775),GameObject.JAPAN));
        this.troopList.add(new littleBurst(new MyPoint(580,830)));//首颗炸弹是哑弹，确保第一个需要的炸弹是可以爆炸的
        this.troopList.add(new BigBurst(new MyPoint(580,830)));//首颗炸弹是哑弹，确保第一个需要的炸弹是可以爆炸的



    }

}
