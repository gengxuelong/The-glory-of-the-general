package code.altas;

import code.Element.cartoon.BigBurst;
import code.Element.footHold.*;
import code.Element.troop.*;
import code.Obj.GameObject;
import code.util.values;
import utils.MyPoint;

import java.awt.*;

/**
*kangzhaoxin
*/
public class Atlas_E_MoSiKeBaoWeiZhan extends Atlas{

    private Atlas_E_MoSiKeBaoWeiZhan(Image image, int xForBg, int yForBg, int width, int height) {
        this.image = image;
        this.xForBg = xForBg;
        this.yForBg = yForBg;
        this.width = width;
        this.height = height;
        loadData();
    }

    public static Atlas_E_MoSiKeBaoWeiZhan instance () {
        return
                new Atlas_E_MoSiKeBaoWeiZhan(values.atlas_MoSiKeBaoWeiZhan, -152, -137, 1700, 1180);
    }
    public void loadData() {

        temps = new int[]{GameObject.GERMAN, GameObject.USSR};

        footHoldList.add(new LargeCity(new MyPoint(341,1006), GameObject.GERMAN));//明斯克
        footHoldList.add(new LargeCity(new MyPoint(585,531), GameObject.GERMAN));
        footHoldList.add(new LargeCity(new MyPoint(774,223), GameObject.GERMAN));
        footHoldList.add(new MiddleCity(new MyPoint(759,934), GameObject.GERMAN));
        footHoldList.add(new SmallCity(new MyPoint(307,278), GameObject.GERMAN));

        footHoldList.add(new LargeCity(new MyPoint(1160,487), GameObject.USSR));
        footHoldList.add(new LargeCity(new MyPoint(1244,148), GameObject.USSR));
        footHoldList.add(new LargeCity(new MyPoint(1642,206), GameObject.USSR));
        footHoldList.add(new MiddleCity(new MyPoint(1313,917), GameObject.USSR));
        footHoldList.add(new SmallCity(new MyPoint(1075,969), GameObject.USSR));


        troopList.add(new NormalInfantry(new MyPoint(341,1006), GameObject.GERMAN));//明斯克
        troopList.add(new NormalInfantry(new MyPoint(585,531), GameObject.GERMAN));
        troopList.add(new NormalInfantry(new MyPoint(774,223), GameObject.GERMAN));
        troopList.add(new NormalInfantry(new MyPoint(759,934), GameObject.GERMAN));
        troopList.add(new NormalInfantry(new MyPoint(663,303), GameObject.GERMAN));
        troopList.add(new NormalInfantry(new MyPoint(356,825), GameObject.GERMAN));
        troopList.add(new NormalInfantry(new MyPoint(307,278), GameObject.GERMAN));

        troopList.add(new NormalInfantry(new MyPoint(1160,487), GameObject.USSR));
        troopList.add(new NormalInfantry(new MyPoint(1244,148), GameObject.USSR));
        troopList.add(new NormalInfantry(new MyPoint(1642,206), GameObject.USSR));
        troopList.add(new NormalInfantry(new MyPoint(1313,917), GameObject.USSR));
        troopList.add(new NormalInfantry(new MyPoint(1321,470), GameObject.USSR));
        troopList.add(new NormalInfantry(new MyPoint(1234,718), GameObject.USSR));
        troopList.add(new NormalInfantry(new MyPoint(1075,969), GameObject.USSR));


        troopList.add(new MiddleTank(new MyPoint(896,226),GameObject.GERMAN));
        troopList.add(new MiddleTank(new MyPoint(767,515),GameObject.GERMAN));
        troopList.add(new MiddleTank(new MyPoint(659,902),GameObject.GERMAN));

        troopList.add(new MiddleTank(new MyPoint(1013,458),GameObject.USSR));
        troopList.add(new MiddleTank(new MyPoint(1196,218),GameObject.USSR));
        troopList.add(new MiddleTank(new MyPoint(1077,794),GameObject.USSR));


        troopList.add(new HeavyArtillery(new MyPoint(684,712),GameObject.GERMAN));
        troopList.add(new HeavyArtillery(new MyPoint(800,340),GameObject.GERMAN));
        troopList.add(new HeavyArtillery(new MyPoint(495,343),GameObject.GERMAN));

        troopList.add(new HeavyArtillery(new MyPoint(1424,363),GameObject.USSR));
        troopList.add(new HeavyArtillery(new MyPoint(1142,628),GameObject.USSR));
        troopList.add(new HeavyArtillery(new MyPoint(1334,152),GameObject.USSR));


        troopList.add(new Armored(new MyPoint(587,207),GameObject.GERMAN));
        troopList.add(new Armored(new MyPoint(465,713),GameObject.GERMAN));
        troopList.add(new Armored(new MyPoint(480,1013),GameObject.GERMAN));

        troopList.add(new Armored(new MyPoint(1361,769),GameObject.USSR));
        troopList.add(new Armored(new MyPoint(1579,558),GameObject.USSR));
        troopList.add(new Armored(new MyPoint(1471,235),GameObject.USSR));


        troopList.add(new LightArtillery(new MyPoint(839,143),GameObject.GERMAN));
        troopList.add(new LightArtillery(new MyPoint(723,1069),GameObject.GERMAN));
        troopList.add(new LightArtillery(new MyPoint(777,619),GameObject.GERMAN));

        troopList.add(new LightArtillery(new MyPoint(1256,336),GameObject.USSR));
        troopList.add(new LightArtillery(new MyPoint(1336,631),GameObject.USSR));
        troopList.add(new LightArtillery(new MyPoint(1206,838),GameObject.USSR));


        troopList.add(new RocketGun(new MyPoint(500,854),GameObject.GERMAN));
        troopList.add(new RocketGun(new MyPoint(671,438),GameObject.GERMAN));
        troopList.add(new RocketGun(new MyPoint(720,113),GameObject.GERMAN));

        troopList.add(new RocketGun(new MyPoint(1101,312),GameObject.USSR));
        troopList.add(new RocketGun(new MyPoint(1160,101),GameObject.USSR));
        troopList.add(new RocketGun(new MyPoint(1031,655),GameObject.USSR));


        footHoldList.add(new Airport(new MyPoint(324,500),GameObject.GERMAN));

        footHoldList.add(new Airport(new MyPoint(1454,489),GameObject.USSR));


        footHoldList.add(new LargeArmsFactory(new MyPoint(334,649),GameObject.GERMAN));
        footHoldList.add(new MiddleArmsFactory(new MyPoint(454,139),GameObject.GERMAN));

        footHoldList.add(new LargeArmsFactory(new MyPoint(1554,930),GameObject.USSR));
        footHoldList.add(new MiddleArmsFactory(new MyPoint(1614,438),GameObject.USSR));


        this.troopList.add(new BigBurst(new MyPoint(580,830)));//首颗炸弹是哑弹，确保第一个需要的炸弹是可以爆炸的

    }

}
