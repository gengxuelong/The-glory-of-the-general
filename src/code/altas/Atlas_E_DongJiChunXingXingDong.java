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
public class Atlas_E_DongJiChunXingXingDong extends Atlas{

    private Atlas_E_DongJiChunXingXingDong(Image image, int xForBg, int yForBg, int width, int height) {
        this.image = image;
        this.xForBg = xForBg;
        this.yForBg = yForBg;
        this.width = width;
        this.height = height;
        loadData();
    }

    public static Atlas_E_DongJiChunXingXingDong instance () {
        return
                new Atlas_E_DongJiChunXingXingDong(values.atlas_DongJiChunXingXingDong, -0, -0, 1700, 1180);
    }
    public void loadData() {

        temps = new int[]{GameObject.GERMAN, GameObject.USSR};

        footHoldList.add(new LargeCity(new MyPoint(702,229), GameObject.GERMAN));//维也纳
        footHoldList.add(new LargeCity(new MyPoint(603,1019), GameObject.GERMAN));//萨格勒布
        footHoldList.add(new SmallCity(new MyPoint(289,484), GameObject.GERMAN));
        footHoldList.add(new SmallCity(new MyPoint(104,181), GameObject.GERMAN));

        footHoldList.add(new LargeCity(new MyPoint(886,202), GameObject.USSR));//布拉迪斯拉发
        footHoldList.add(new LargeCity(new MyPoint(1288,450), GameObject.USSR));//布拉佩斯
        footHoldList.add(new SmallCity(new MyPoint(1137,835), GameObject.USSR));
        footHoldList.add(new SmallCity(new MyPoint(1517,1022), GameObject.USSR));


        troopList.add(new NormalInfantry(new MyPoint(702,229), GameObject.GERMAN));//维也纳
        troopList.add(new NormalInfantry(new MyPoint(603,1019), GameObject.GERMAN));//萨格勒布
        troopList.add(new NormalInfantry(new MyPoint(289,484), GameObject.GERMAN));
        troopList.add(new NormalInfantry(new MyPoint(104,181), GameObject.GERMAN));
        troopList.add(new NormalInfantry(new MyPoint(366,388), GameObject.GERMAN));
        troopList.add(new NormalInfantry(new MyPoint(767,878), GameObject.GERMAN));

        troopList.add(new NormalInfantry(new MyPoint(886,202), GameObject.USSR));//布拉迪斯拉发
        troopList.add(new NormalInfantry(new MyPoint(1288,450), GameObject.USSR));//布拉佩斯
        troopList.add(new NormalInfantry(new MyPoint(1137,835), GameObject.USSR));
        troopList.add(new NormalInfantry(new MyPoint(1517,1022), GameObject.USSR));
        troopList.add(new NormalInfantry(new MyPoint(1321,644), GameObject.USSR));
        troopList.add(new NormalInfantry(new MyPoint(1128,121), GameObject.USSR));


        troopList.add(new MiddleTank(new MyPoint(498,391),GameObject.GERMAN));
        troopList.add(new MiddleTank(new MyPoint(347,97),GameObject.GERMAN));
        troopList.add(new MiddleTank(new MyPoint(443,834),GameObject.GERMAN));

        troopList.add(new MiddleTank(new MyPoint(984,235),GameObject.USSR));
        troopList.add(new MiddleTank(new MyPoint(1435,554),GameObject.USSR));
        troopList.add(new MiddleTank(new MyPoint(1129,869),GameObject.USSR));


        troopList.add(new HeavyArtillery(new MyPoint(534,206),GameObject.GERMAN));
        troopList.add(new HeavyArtillery(new MyPoint(476,660),GameObject.GERMAN));
        troopList.add(new HeavyArtillery(new MyPoint(722,1006),GameObject.GERMAN));

        troopList.add(new HeavyArtillery(new MyPoint(1145,696),GameObject.USSR));
        troopList.add(new HeavyArtillery(new MyPoint(1071,347),GameObject.USSR));
        troopList.add(new HeavyArtillery(new MyPoint(1232,514),GameObject.USSR));


        troopList.add(new Armored(new MyPoint(320,257),GameObject.GERMAN));
        troopList.add(new Armored(new MyPoint(766,696),GameObject.GERMAN));
        troopList.add(new Armored(new MyPoint(399,978),GameObject.GERMAN));

        troopList.add(new Armored(new MyPoint(1414,801),GameObject.USSR));
        troopList.add(new Armored(new MyPoint(1137,226),GameObject.USSR));
        troopList.add(new Armored(new MyPoint(1091,517),GameObject.USSR));


        troopList.add(new LightArtillery(new MyPoint(662,865),GameObject.GERMAN));
        troopList.add(new LightArtillery(new MyPoint(709,488),GameObject.GERMAN));
        troopList.add(new LightArtillery(new MyPoint(615,82),GameObject.GERMAN));

        troopList.add(new LightArtillery(new MyPoint(1346,259),GameObject.USSR));
        troopList.add(new LightArtillery(new MyPoint(1212,974),GameObject.USSR));
        troopList.add(new LightArtillery(new MyPoint(985,737),GameObject.USSR));


        troopList.add(new RocketGun(new MyPoint(228,742),GameObject.GERMAN));
        troopList.add(new RocketGun(new MyPoint(715,351),GameObject.GERMAN));
        troopList.add(new RocketGun(new MyPoint(614,364),GameObject.GERMAN));

        troopList.add(new RocketGun(new MyPoint(947,484),GameObject.USSR));
        troopList.add(new RocketGun(new MyPoint(1016,879),GameObject.USSR));
        troopList.add(new RocketGun(new MyPoint(952,94),GameObject.USSR));


        footHoldList.add(new Airport(new MyPoint(99,404),GameObject.GERMAN));

        footHoldList.add(new Airport(new MyPoint(1532,145),GameObject.USSR));


        footHoldList.add(new LargeArmsFactory(new MyPoint(139,599),GameObject.GERMAN));
        footHoldList.add(new MiddleArmsFactory(new MyPoint(629,692),GameObject.GERMAN));

        footHoldList.add(new LargeArmsFactory(new MyPoint(1542,402),GameObject.USSR));
        footHoldList.add(new MiddleArmsFactory(new MyPoint(1385,982),GameObject.USSR));
        this.troopList.add(new BigBurst(new MyPoint(580,830)));//首颗炸弹是哑弹，确保第一个需要的炸弹是可以爆炸的



    }



}
