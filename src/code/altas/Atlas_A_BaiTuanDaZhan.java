package code.altas;

import code.Element.cartoon.BigBurst;
import code.Element.cartoon.littleBurst;
import code.Element.footHold.Airport;
import code.Element.footHold.*;
import code.Element.footHold.LargeCity;
import code.Element.footHold.SmallCity;
import code.Element.troop.*;
import code.Obj.GameObject;
import code.util.values;
import utils.MyPoint;

import java.awt.*;

/**
 * @author  康照鑫
 * 百团大战
 */
public class Atlas_A_BaiTuanDaZhan extends Atlas {
    private Atlas_A_BaiTuanDaZhan(Image image, int xForBg, int yForBg, int width, int height) {
        this.image = image;
        this.xForBg = xForBg;
        this.yForBg = yForBg;
        this.width = width;
        this.height = height;
        loadData();
    }

    public static Atlas_A_BaiTuanDaZhan instance () {
        return new Atlas_A_BaiTuanDaZhan(values.atlas_BaiTuanDaZhan, -150, -1590, 3000, 3000);
    }

    public void loadData() {

        temps = new int[]{GameObject.CPC, GameObject.JAPAN};

        footHoldList.add(new LargeCity(new MyPoint(694,1834), GameObject.CPC));//郑州

        footHoldList.add(new LargeCity(new MyPoint(2743,126), GameObject.JAPAN));//沈阳
        footHoldList.add(new LargeCity(new MyPoint(2695,2497), GameObject.JAPAN));//上海
        footHoldList.add(new LargeCity(new MyPoint(2394,2716), GameObject.JAPAN));//杭州
        footHoldList.add(new LargeCity(new MyPoint(2014,2378), GameObject.JAPAN));//南京
        footHoldList.add(new LargeCity(new MyPoint(1631,2409), GameObject.JAPAN));//合肥
        footHoldList.add(new LargeCity(new MyPoint(872,2719), GameObject.JAPAN));//武汉
        footHoldList.add(new LargeCity(new MyPoint(1446,1392), GameObject.JAPAN));//济南
        footHoldList.add(new LargeCity(new MyPoint(826,1111), GameObject.JAPAN));//石家庄
        footHoldList.add(new LargeCity(new MyPoint(1430,821), GameObject.JAPAN));//天津
        footHoldList.add(new LargeCity(new MyPoint(1234,670), GameObject.JAPAN));//北京
        footHoldList.add(new LargeCity(new MyPoint(146,509), GameObject.JAPAN));//呼和浩特
        footHoldList.add(new LargeCity(new MyPoint(399,1134), GameObject.JAPAN));//太原


        footHoldList.add(new SmallCity(new MyPoint(1192,900), GameObject.CPC));
        footHoldList.add(new SmallCity(new MyPoint(1820,1466), GameObject.CPC));
        footHoldList.add(new SmallCity(new MyPoint(1845,2020), GameObject.CPC));
        footHoldList.add(new SmallCity(new MyPoint(2282,2578), GameObject.CPC));
        footHoldList.add(new SmallCity(new MyPoint(558,2345), GameObject.CPC));
        footHoldList.add(new SmallCity(new MyPoint(512,2017), GameObject.CPC));
        footHoldList.add(new SmallCity(new MyPoint(1184,2063), GameObject.CPC));


        troopList.add(new NormalInfantry(new MyPoint(694,1834), GameObject.CPC));//郑州
        troopList.add(new NormalInfantry(new MyPoint(1186,933), GameObject.CPC));
        troopList.add(new NormalInfantry(new MyPoint(1850,1480), GameObject.CPC));
        troopList.add(new NormalInfantry(new MyPoint(1870,2070), GameObject.CPC));
        troopList.add(new NormalInfantry(new MyPoint(2244,2525), GameObject.CPC));
        troopList.add(new NormalInfantry(new MyPoint(600,2400), GameObject.CPC));
        troopList.add(new NormalInfantry(new MyPoint(555,2080), GameObject.CPC));
        troopList.add(new NormalInfantry(new MyPoint(1200,2080), GameObject.CPC));
        troopList.add(new NormalInfantry(new MyPoint(1332,1712), GameObject.CPC));
        troopList.add(new NormalInfantry(new MyPoint(898,1632), GameObject.CPC));

        troopList.add(new NormalInfantry(new MyPoint(2743,126), GameObject.JAPAN));//沈阳
        troopList.add(new NormalInfantry(new MyPoint(2695,2497), GameObject.JAPAN));//上海
        troopList.add(new NormalInfantry(new MyPoint(2394,2716), GameObject.JAPAN));//杭州
        troopList.add(new NormalInfantry(new MyPoint(2014,2378), GameObject.JAPAN));//南京
        troopList.add(new NormalInfantry(new MyPoint(1631,2409), GameObject.JAPAN));//合肥
        troopList.add(new NormalInfantry(new MyPoint(872,2719), GameObject.JAPAN));//武汉
        troopList.add(new NormalInfantry(new MyPoint(1446,1392), GameObject.JAPAN));//济南
        troopList.add(new NormalInfantry(new MyPoint(826,1111), GameObject.JAPAN));//石家庄
        troopList.add(new NormalInfantry(new MyPoint(1430,821), GameObject.JAPAN));//天津
        troopList.add(new NormalInfantry(new MyPoint(1234,670), GameObject.JAPAN));//北京
        troopList.add(new NormalInfantry(new MyPoint(146,509), GameObject.JAPAN));//呼和浩特
        troopList.add(new NormalInfantry(new MyPoint(399,1134), GameObject.JAPAN));//太原


        troopList.add(new MiddleTank(new MyPoint(1128,1018),GameObject.CPC));
        troopList.add(new MiddleTank(new MyPoint(1934,1673),GameObject.CPC));
        troopList.add(new MiddleTank(new MyPoint(1673,1904),GameObject.CPC));
        troopList.add(new MiddleTank(new MyPoint(2077,2682),GameObject.CPC));
        troopList.add(new MiddleTank(new MyPoint(646,2526),GameObject.CPC));
        troopList.add(new MiddleTank(new MyPoint(689,2141),GameObject.CPC));
        troopList.add(new MiddleTank(new MyPoint(744,1685),GameObject.CPC));

        troopList.add(new MiddleTank(new MyPoint(1536,569),GameObject.JAPAN));
        troopList.add(new MiddleTank(new MyPoint(1494,996),GameObject.JAPAN));
        troopList.add(new MiddleTank(new MyPoint(820,1053),GameObject.JAPAN));
        troopList.add(new MiddleTank(new MyPoint(1628,2518),GameObject.JAPAN));
        troopList.add(new MiddleTank(new MyPoint(7356,2520),GameObject.JAPAN));
        troopList.add(new MiddleTank(new MyPoint(2456,2844),GameObject.JAPAN));
        troopList.add(new MiddleTank(new MyPoint(478,1126),GameObject.JAPAN));


        troopList.add(new HeavyArtillery(new MyPoint(1108,841),GameObject.CPC));
        troopList.add(new HeavyArtillery(new MyPoint(1656,2228),GameObject.CPC));
        troopList.add(new HeavyArtillery(new MyPoint(733,1984),GameObject.CPC));

        troopList.add(new HeavyArtillery(new MyPoint(1175,765),GameObject.JAPAN));
        troopList.add(new HeavyArtillery(new MyPoint(1940,2333),GameObject.JAPAN));
        troopList.add(new HeavyArtillery(new MyPoint(2269,2780),GameObject.JAPAN));
        troopList.add(new HeavyArtillery(new MyPoint(1575,2648),GameObject.JAPAN));
        troopList.add(new HeavyArtillery(new MyPoint(1034,2647),GameObject.JAPAN));
        troopList.add(new HeavyArtillery(new MyPoint(339,420),GameObject.JAPAN));
        troopList.add(new HeavyArtillery(new MyPoint(624,1055),GameObject.JAPAN));


        troopList.add(new Armored(new MyPoint(712,2275),GameObject.CPC));
        troopList.add(new Armored(new MyPoint(982,909),GameObject.CPC));

        troopList.add(new Armored(new MyPoint(1498,654),GameObject.JAPAN));
        troopList.add(new Armored(new MyPoint(1298,580),GameObject.JAPAN));
        troopList.add(new Armored(new MyPoint(2218,1302),GameObject.JAPAN));
        troopList.add(new Armored(new MyPoint(2114,2290),GameObject.JAPAN));
        troopList.add(new Armored(new MyPoint(1725,2854),GameObject.JAPAN));
        troopList.add(new Armored(new MyPoint(613,2723),GameObject.JAPAN));


        troopList.add(new LightArtillery(new MyPoint(988,1263),GameObject.CPC));
        troopList.add(new LightArtillery(new MyPoint(970,2221),GameObject.CPC));
        troopList.add(new LightArtillery(new MyPoint(2296,2118),GameObject.CPC));
        troopList.add(new LightArtillery(new MyPoint(349,2598),GameObject.CPC));

        troopList.add(new LightArtillery(new MyPoint(1784,1251),GameObject.JAPAN));
        troopList.add(new LightArtillery(new MyPoint(1628,1757),GameObject.JAPAN));
        troopList.add(new LightArtillery(new MyPoint(2249,2084),GameObject.JAPAN));
        troopList.add(new HeavyArtillery(new MyPoint(2406,2618),GameObject.JAPAN));
        troopList.add(new LightArtillery(new MyPoint(2690,2809),GameObject.JAPAN));
        troopList.add(new LightArtillery(new MyPoint(1079,2405),GameObject.JAPAN));
        troopList.add(new HeavyArtillery(new MyPoint(767,1429),GameObject.JAPAN));


        troopList.add(new RocketGun(new MyPoint(1541,1189),GameObject.CPC));
        troopList.add(new RocketGun(new MyPoint(678,2635),GameObject.CPC));

        troopList.add(new RocketGun(new MyPoint(2718,207),GameObject.JAPAN));
        troopList.add(new RocketGun(new MyPoint(1972,505),GameObject.JAPAN));
        troopList.add(new RocketGun(new MyPoint(2001,1345),GameObject.JAPAN));
        troopList.add(new RocketGun(new MyPoint(1824,2260),GameObject.JAPAN));
        troopList.add(new RocketGun(new MyPoint(433,2826),GameObject.JAPAN));
        troopList.add(new RocketGun(new MyPoint(721,1299),GameObject.JAPAN));


        footHoldList.add(new Airport(new MyPoint(382,1921),GameObject.CPC));

        footHoldList.add(new Airport(new MyPoint(505,1487),GameObject.JAPAN));
        footHoldList.add(new Airport(new MyPoint(2335,1138),GameObject.JAPAN));
        footHoldList.add(new Airport(new MyPoint(2492,2424),GameObject.JAPAN));


        footHoldList.add(new LargeArmsFactory(new MyPoint(1216,1946),GameObject.CPC));

        footHoldList.add(new LargeArmsFactory(new MyPoint(2496,219),GameObject.JAPAN));
        footHoldList.add(new LargeArmsFactory(new MyPoint(2344,1220),GameObject.JAPAN));
        footHoldList.add(new LargeArmsFactory(new MyPoint(1951,2544),GameObject.JAPAN));


        this.troopList.add(new littleBurst(new MyPoint(580,830)));//首颗炸弹是哑弹，确保第一个需要的炸弹是可以爆炸的

        this.troopList.add(new BigBurst(new MyPoint(580,830)));//首颗炸弹是哑弹，确保第一个需要的炸弹是可以爆炸的


    }

}
