package code.altas;

import code.Element.cartoon.BigBurst;
import code.Element.footHold.LargeCity;
import code.Element.footHold.MiddleArmsFactory;
import code.Element.footHold.MiddleCity;
import code.Element.footHold.SmallCity;
import code.Element.troop.*;
import code.Obj.GameObject;
import code.util.values;
import utils.MyPoint;

import java.awt.*;

/**
*kangzhaoxin
*/
public class Atlas_E_NuoManDiDengLu extends Atlas{

    private Atlas_E_NuoManDiDengLu(Image image, int xForBg, int yForBg, int width, int height) {
        this.image = image;
        this.xForBg = xForBg;
        this.yForBg = yForBg;
        this.width = width;
        this.height = height;
        loadData();
    }

    public static Atlas_E_NuoManDiDengLu instance () {
        return
                new Atlas_E_NuoManDiDengLu(values.atlas_NuoManDiDengLu, -0, -0, 1200, 700);
    }

    public void loadData() {

        temps = new int[]{GameObject.GERMAN, GameObject.UK};

        footHoldList.add(new LargeCity(new MyPoint(680,426), GameObject.GERMAN));//勒阿弗尔
        footHoldList.add(new LargeCity(new MyPoint(1043,634), GameObject.GERMAN));// 巴黎
        footHoldList.add(new SmallCity(new MyPoint(526,632), GameObject.GERMAN));

        footHoldList.add(new MiddleCity(new MyPoint(35,85), GameObject.UK));

        footHoldList.add(new MiddleCity(new MyPoint(809,83), GameObject.UK));


        troopList.add(new NormalInfantry(new MyPoint(680,426), GameObject.GERMAN));//勒阿弗尔
        troopList.add(new NormalInfantry(new MyPoint(1043,634), GameObject.GERMAN));// 巴黎
        troopList.add(new NormalInfantry(new MyPoint(526,632), GameObject.GERMAN));
        troopList.add(new NormalInfantry(new MyPoint(443,502), GameObject.GERMAN));

        troopList.add(new NormalInfantry(new MyPoint(35,85), GameObject.UK));
        troopList.add(new NormalInfantry(new MyPoint(369,124), GameObject.UK));

        troopList.add(new NormalInfantry(new MyPoint(809,83), GameObject.UK));
        troopList.add(new NormalInfantry(new MyPoint(594,126), GameObject.UK));


        footHoldList.add(new MiddleArmsFactory(new MyPoint(1058,531),GameObject.GERMAN));


        troopList.add(new HeavyArtillery(new MyPoint(684,658),GameObject.GERMAN));
        troopList.add(new MiddleTank(new MyPoint(649,603),GameObject.GERMAN));
        troopList.add(new Armored(new MyPoint(319,612),GameObject.GERMAN));
        troopList.add(new LightArtillery(new MyPoint(934,482),GameObject.GERMAN));
        troopList.add(new RocketGun(new MyPoint(1110,362),GameObject.GERMAN));
        troopList.add(new HeavyTank(new MyPoint(899,603),GameObject.GERMAN));


        troopList.add(new NormalInfantry(new MyPoint(29,166),GameObject.UK));
        troopList.add(new MiddleTank(new MyPoint(202,102),GameObject.UK));
        troopList.add(new Armored(new MyPoint(120,348),GameObject.UK));
        troopList.add(new LightArtillery(new MyPoint(347,339),GameObject.UK));
        troopList.add(new RocketGun(new MyPoint(354,268),GameObject.UK));
        troopList.add(new MiddleTank(new MyPoint(154,489),GameObject.UK));


        troopList.add(new NormalInfantry(new MyPoint(703,94),GameObject.UK));
        troopList.add(new MiddleTank(new MyPoint(938,164),GameObject.UK));
        troopList.add(new Armored(new MyPoint(699,240),GameObject.UK));
        troopList.add(new LightArtillery(new MyPoint(847,327),GameObject.UK));
        troopList.add(new RocketGun(new MyPoint(1010,206),GameObject.UK));
        troopList.add(new MiddleTank(new MyPoint(554,353),GameObject.UK));

        this.troopList.add(new BigBurst(new MyPoint(580,830)));//首颗炸弹是哑弹，确保第一个需要的炸弹是可以爆炸的

    }
}
