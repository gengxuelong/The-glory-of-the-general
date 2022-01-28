package code.altas;

import code.Element.cartoon.littleBurst;
import code.Element.footHold.*;
import code.Element.troop.*;
import code.Obj.GameObject;
import code.util.values;
import utils.MyPoint;

import java.awt.*;

/**
 * @author 康照鑫
 * 皖南事变
 */
public class Atlas_9 extends Atlas{
    private Atlas_9(Image image, int xForBg, int yForBg, int width, int height) {
        this.image = image;
        this.xForBg = xForBg;
        this.yForBg = yForBg;
        this.width = width;
        this.height = height;
        loadData();
    }

    public static Atlas_9 instance () {
        return new Atlas_9(values.atlas_WanNanShiBian, -150, -1590, 1700, 2500);
    }
    public void loadData() {

        temps = new int[]{GameObject.CPC, GameObject.JAPAN,GameObject.KMT};

        footHoldList.add(new LargeCity(new MyPoint(1261,550), GameObject.KMT));//南京
        footHoldList.add(new LargeCity(new MyPoint(873,608), GameObject.KMT));//南昌
        footHoldList.add(new LargeCity(new MyPoint(611,1727), GameObject.KMT));//武汉
        footHoldList.add(new LargeCity(new MyPoint(134,1097), GameObject.KMT));//合肥
        footHoldList.add(new SmallCity(new MyPoint(987,1058), GameObject.KMT));

        footHoldList.add(new SmallCity(new MyPoint(345,446), GameObject.CPC));
        footHoldList.add(new SmallCity(new MyPoint(528,1234), GameObject.CPC));
        footHoldList.add(new SmallCity(new MyPoint(1244,1585), GameObject.CPC));
        footHoldList.add(new SmallCity(new MyPoint(322,2278), GameObject.CPC));


        troopList.add(new NormalInfantry(new MyPoint(1261,550), GameObject.KMT));//南京
        troopList.add(new NormalInfantry(new MyPoint(873,608), GameObject.KMT));//南昌
        troopList.add(new NormalInfantry(new MyPoint(611,1727), GameObject.KMT));//武汉
        troopList.add(new NormalInfantry(new MyPoint(134,1097), GameObject.KMT));//合肥
        troopList.add(new NormalInfantry(new MyPoint(987,1058), GameObject.KMT));

        troopList.add(new NormalInfantry(new MyPoint(360,470), GameObject.CPC));
        troopList.add(new NormalInfantry(new MyPoint(555,1270), GameObject.CPC));
        troopList.add(new NormalInfantry(new MyPoint(1273,1612), GameObject.CPC));
        troopList.add(new NormalInfantry(new MyPoint(345,2298), GameObject.CPC));
        troopList.add(new NormalInfantry(new MyPoint(270,1702), GameObject.CPC));
        troopList.add(new NormalInfantry(new MyPoint(1403,1883), GameObject.CPC));


        footHoldList.add(new SmallArmsFactory(new MyPoint(612,929),GameObject.CPC));

        footHoldList.add(new LargeArmsFactory(new MyPoint(902,1552),GameObject.KMT));
        footHoldList.add(new SmallArmsFactory(new MyPoint(1514,394),GameObject.KMT));

        footHoldList.add(new LargeArmsFactory(new MyPoint(985,167),GameObject.JAPAN));


        troopList.add(new MiddleTank(new MyPoint(461,640),GameObject.CPC));
        troopList.add(new MiddleTank(new MyPoint(1448,781),GameObject.CPC));
        troopList.add(new MiddleTank(new MyPoint(1556,1614),GameObject.CPC));
        troopList.add(new MiddleTank(new MyPoint(328,2071),GameObject.CPC));

        troopList.add(new MiddleTank(new MyPoint(769,522),GameObject.KMT));
        troopList.add(new MiddleTank(new MyPoint(1486,578),GameObject.KMT));
        troopList.add(new MiddleTank(new MyPoint(897,1688),GameObject.KMT));
        troopList.add(new MiddleTank(new MyPoint(111,806),GameObject.KMT));

        troopList.add(new MiddleTank(new MyPoint(888,170),GameObject.JAPAN));


        troopList.add(new HeavyArtillery(new MyPoint(145,494),GameObject.CPC));
        troopList.add(new HeavyArtillery(new MyPoint(630,2348),GameObject.CPC));

        troopList.add(new HeavyArtillery(new MyPoint(748,1458),GameObject.KMT));
        troopList.add(new HeavyArtillery(new MyPoint(1071,739),GameObject.KMT));
        troopList.add(new HeavyArtillery(new MyPoint(521,1521),GameObject.KMT));

        troopList.add(new HeavyArtillery(new MyPoint(1272,130),GameObject.JAPAN));
        troopList.add(new HeavyArtillery(new MyPoint(721,331),GameObject.JAPAN));


        footHoldList.add(new Airport(new MyPoint(1212,2180),GameObject.KMT));


        troopList.add(new Armored(new MyPoint(150,1525),GameObject.CPC));
        troopList.add(new Armored(new MyPoint(1357,1362),GameObject.CPC));

        troopList.add(new Armored(new MyPoint(669,1860),GameObject.KMT));
        troopList.add(new Armored(new MyPoint(1569,481),GameObject.KMT));
        troopList.add(new Armored(new MyPoint(1306,2041),GameObject.KMT));
        troopList.add(new Armored(new MyPoint(1022,1476),GameObject.KMT));

        troopList.add(new Armored(new MyPoint(1092,94),GameObject.JAPAN));
        troopList.add(new Armored(new MyPoint(985,360),GameObject.JAPAN));


        troopList.add(new LightArtillery(new MyPoint(498,849),GameObject.CPC));
        troopList.add(new LightArtillery(new MyPoint(658,1277),GameObject.CPC));
        troopList.add(new LightArtillery(new MyPoint(511,2115),GameObject.CPC));

        troopList.add(new LightArtillery(new MyPoint(986,1277),GameObject.KMT));
        troopList.add(new LightArtillery(new MyPoint(1474,244),GameObject.KMT));
        troopList.add(new LightArtillery(new MyPoint(907,828),GameObject.KMT));
        troopList.add(new HeavyArtillery(new MyPoint(654,2042),GameObject.KMT));

        troopList.add(new HeavyArtillery(new MyPoint(751,224),GameObject.JAPAN));
        troopList.add(new LightArtillery(new MyPoint(1252,295),GameObject.JAPAN));


        troopList.add(new RocketGun(new MyPoint(866,798),GameObject.KMT));
        troopList.add(new RocketGun(new MyPoint(1104,1748),GameObject.KMT));
        troopList.add(new RocketGun(new MyPoint(398,1878),GameObject.KMT));
        troopList.add(new RocketGun(new MyPoint(1329,1002),GameObject.KMT));

        troopList.add(new RocketGun(new MyPoint(597,258),GameObject.JAPAN));
        troopList.add(new RocketGun(new MyPoint(1386,234),GameObject.JAPAN));
        this.troopList.add(new littleBurst(new MyPoint(580,830)));//首颗炸弹是哑弹，确保第一个需要的炸弹是可以爆炸的



    }


}
