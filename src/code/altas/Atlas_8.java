package code.altas;

import code.Element.cartoon.littleBurst;
import code.Element.footHold.*;
import code.Element.troop.*;
import code.Obj.GameObject;
import code.util.values;
import utils.MyPoint;

import java.awt.*;

/**
 * 抗苏战争
 * @author 王晓阳
 */
public class Atlas_8 extends Atlas{

    private Atlas_8(Image image, int xForBg, int yForBg, int width, int height) {
        this.image = image;
        this.xForBg = xForBg;
        this.yForBg = yForBg;
        this.width = width;
        this.height = height;
        loadData();

    }



    public static Atlas_8 instance(){ return new Atlas_8(values.atlas_KangSuZhanZheng, -150, -1590, 3000, 3000);}




    public void loadData(){

        temps = new int[] {GameObject.KMT,GameObject.USSR};
        footHoldList.add(new MiddleCity(new MyPoint(845,104), GameObject.USSR));
        footHoldList.add(new SmallCity(new MyPoint(1112,106), GameObject.USSR));
        footHoldList.add(new SmallCity(new MyPoint(1412,110), GameObject.USSR));
        footHoldList.add(new MiddleCity(new MyPoint(829,227), GameObject.USSR));
        footHoldList.add(new LargeCity(new MyPoint(1155,224), GameObject.USSR));
        footHoldList.add(new LargeArmsFactory(new MyPoint(1416,214), GameObject.USSR));
        footHoldList.add(new MiddleArmsFactory(new MyPoint(1584,108), GameObject.USSR));
        footHoldList.add(new MiddleArmsFactory(new MyPoint(1568,246), GameObject.USSR));


        footHoldList.add(new LargeCity(new MyPoint(1207,2099), GameObject.KMT));
        footHoldList.add(new SmallCity(new MyPoint(1052,1949), GameObject.KMT));
        footHoldList.add(new SmallCity(new MyPoint(855,1804), GameObject.KMT));
        footHoldList.add(new MiddleCity(new MyPoint(1397,2345), GameObject.KMT));
        footHoldList.add(new MiddleArmsFactory(new MyPoint(781,1596), GameObject.KMT));
        footHoldList.add(new MiddleArmsFactory(new MyPoint(927,1598), GameObject.KMT));
        footHoldList.add(new MiddleArmsFactory(new MyPoint(836,1698), GameObject.KMT));


        troopList.add(new HeavyTank(new MyPoint(1510,499), GameObject.USSR));
        troopList.add(new HeavyTank(new MyPoint(1444,382), GameObject.USSR));
        troopList.add(new HeavyTank(new MyPoint(1291,312), GameObject.USSR));
        troopList.add(new HeavyTank(new MyPoint(1105,303), GameObject.USSR));
        troopList.add(new HeavyTank(new MyPoint(969,317), GameObject.USSR));
        troopList.add(new HeavyTank(new MyPoint(850,382), GameObject.USSR));
        troopList.add(new HeavyTank(new MyPoint(794,465), GameObject.USSR));
        troopList.add(new HeavyTank(new MyPoint(776,582), GameObject.USSR));
        troopList.add(new HeavyTank(new MyPoint(806,705), GameObject.USSR));
        troopList.add(new HeavyTank(new MyPoint(1076,397), GameObject.USSR));
        troopList.add(new HeavyTank(new MyPoint(1144,511), GameObject.USSR));
        troopList.add(new HeavyTank(new MyPoint(1192,599), GameObject.USSR));

        troopList.add(new NormalInfantry(new MyPoint(946,450), GameObject.USSR));
        troopList.add(new NormalInfantry(new MyPoint(894,497), GameObject.USSR));
        troopList.add(new NormalInfantry(new MyPoint(1024,502), GameObject.USSR));
        troopList.add(new NormalInfantry(new MyPoint(867,567), GameObject.USSR));
        troopList.add(new NormalInfantry(new MyPoint(967,573), GameObject.USSR));
        troopList.add(new NormalInfantry(new MyPoint(1041,577), GameObject.USSR));
        troopList.add(new NormalInfantry(new MyPoint(886,675), GameObject.USSR));
        troopList.add(new NormalInfantry(new MyPoint(1004,673), GameObject.USSR));

        troopList.add(new NormalInfantry(new MyPoint(1203,404), GameObject.USSR));

        troopList.add(new NormalInfantry(new MyPoint(1206,470), GameObject.USSR));
        troopList.add(new NormalInfantry(new MyPoint(1310,477), GameObject.USSR));
        troopList.add(new NormalInfantry(new MyPoint(1409,478), GameObject.USSR));

        troopList.add(new NormalInfantry(new MyPoint(965,115), GameObject.USSR));
        troopList.add(new NormalInfantry(new MyPoint(962,192), GameObject.USSR));
        troopList.add(new NormalInfantry(new MyPoint(1263,105), GameObject.USSR));
        troopList.add(new NormalInfantry(new MyPoint(1270,192), GameObject.USSR));
        troopList.add(new NormalInfantry(new MyPoint(1624,485), GameObject.USSR));








        troopList.add(new HeavyTank(new MyPoint(885,1244), GameObject.KMT));
        troopList.add(new HeavyTank(new MyPoint(990,1318), GameObject.KMT));
        troopList.add(new HeavyTank(new MyPoint(1188,1300), GameObject.KMT));
        troopList.add(new HeavyTank(new MyPoint(1291,1149), GameObject.KMT));
        troopList.add(new HeavyTank(new MyPoint(1312,1006), GameObject.KMT));
        troopList.add(new HeavyTank(new MyPoint(1419,924), GameObject.KMT));
        troopList.add(new HeavyTank(new MyPoint(1514,1106), GameObject.KMT));
        troopList.add(new HeavyTank(new MyPoint(1615,1201), GameObject.KMT));

        troopList.add(new NormalInfantry(new MyPoint(1024,1334), GameObject.KMT));
        troopList.add(new NormalInfantry(new MyPoint(916,1392), GameObject.KMT));
        troopList.add(new NormalInfantry(new MyPoint(1013,1413), GameObject.KMT));
        troopList.add(new NormalInfantry(new MyPoint(1148,1413), GameObject.KMT));
        troopList.add(new NormalInfantry(new MyPoint(1249,1409), GameObject.KMT));
        troopList.add(new NormalInfantry(new MyPoint(1311,1382), GameObject.KMT));
        troopList.add(new NormalInfantry(new MyPoint(1360,1333), GameObject.KMT));
        troopList.add(new NormalInfantry(new MyPoint(1407,1246), GameObject.KMT));
        troopList.add(new NormalInfantry(new MyPoint(1420,1170), GameObject.KMT));
        troopList.add(new NormalInfantry(new MyPoint(1502,1270), GameObject.KMT));
        troopList.add(new NormalInfantry(new MyPoint(1589,1334), GameObject.KMT));
        troopList.add(new NormalInfantry(new MyPoint(1334,1910), GameObject.KMT));
        troopList.add(new NormalInfantry(new MyPoint(1333,2072), GameObject.KMT));
        troopList.add(new NormalInfantry(new MyPoint(1143,1896), GameObject.KMT));
        troopList.add(new NormalInfantry(new MyPoint(1259,2011), GameObject.KMT));
        troopList.add(new NormalInfantry(new MyPoint(718,1658), GameObject.KMT));
        troopList.add(new NormalInfantry(new MyPoint(938,1689), GameObject.KMT));
        troopList.add(new NormalInfantry(new MyPoint(860,1508), GameObject.KMT));
        troopList.add(new NormalInfantry(new MyPoint(965,1813), GameObject.KMT));




        this.troopList.add(new littleBurst(new MyPoint(580,830)));//首颗炸弹是哑弹，确保第一个需要的炸弹是可以爆炸的



    }

}
