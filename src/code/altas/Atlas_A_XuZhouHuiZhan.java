package code.altas;

import code.Element.cartoon.BigBurst;
import code.Element.cartoon.littleBurst;
import code.Element.footHold.*;
import code.Element.troop.*;
import code.Obj.GameObject;
import code.util.values;
import utils.MyPoint;

import java.awt.*;

/**
 * 徐州会战
 * @author 王晓阳
 *
 */
public class Atlas_A_XuZhouHuiZhan extends Atlas{

	private Atlas_A_XuZhouHuiZhan(Image image, int xForBg, int yForBg, int width, int height) {
		this.image = image;
		this.xForBg = xForBg;
		this.yForBg = yForBg;
		this.width = width;
		this.height = height;
		loadData();

	}
	
	
	
	public static Atlas_A_XuZhouHuiZhan instance () {
		return new Atlas_A_XuZhouHuiZhan(values.atlas_XuZhouHuiZhan, -150, -1590, 2800, 2500);
	}

	public void loadData(){

		temps = new int[] {GameObject.KMT,GameObject.JAPAN};
		footHoldList.add(new MiddleCity(new MyPoint(717,1168), GameObject.JAPAN));
		footHoldList.add(new LargeCity(new MyPoint(1134,2222), GameObject.JAPAN));
		footHoldList.add(new MiddleCity(new MyPoint(1373,958), GameObject.JAPAN));
		footHoldList.add(new SmallCity(new MyPoint(1102,1536), GameObject.JAPAN));
		footHoldList.add(new LargeCity(new MyPoint(706,552), GameObject.JAPAN));
		footHoldList.add(new LargeCity(new MyPoint(570,442), GameObject.JAPAN));
		footHoldList.add(new LargeCity(new MyPoint(1631,2355), GameObject.JAPAN));

		footHoldList.add(new LargeCity(new MyPoint(274,870), GameObject.KMT));
		footHoldList.add(new LargeCity(new MyPoint(163,1644), GameObject.KMT));
		footHoldList.add(new LargeCity(new MyPoint(851,2268), GameObject.KMT));
		footHoldList.add(new MiddleCity(new MyPoint(639,1672), GameObject.KMT));
		footHoldList.add(new MiddleCity(new MyPoint(438,1786), GameObject.KMT));
		footHoldList.add(new MiddleCity(new MyPoint(571,1942), GameObject.KMT));
		footHoldList.add(new SmallCity(new MyPoint(425,1335), GameObject.KMT));
		footHoldList.add(new SmallCity(new MyPoint(179,1298), GameObject.KMT));
		footHoldList.add(new SmallCity(new MyPoint(454,1102), GameObject.KMT));

		footHoldList.add(new LargeArmsFactory(new MyPoint(1306,2198), GameObject.JAPAN));
		footHoldList.add(new LargeArmsFactory(new MyPoint(648,470), GameObject.JAPAN));
		footHoldList.add(new MiddleArmsFactory(new MyPoint(1438,948), GameObject.JAPAN));

		footHoldList.add(new LargeArmsFactory(new MyPoint(580,1784), GameObject.KMT));
		footHoldList.add(new MiddleArmsFactory(new MyPoint(322,1210), GameObject.KMT));
		footHoldList.add(new SmallArmsFactory(new MyPoint(715,2160), GameObject.KMT));

		troopList.add(new NormalInfantry(new MyPoint(702,393), GameObject.JAPAN));
		troopList.add(new NormalInfantry(new MyPoint(732,429), GameObject.JAPAN));
		troopList.add(new NormalInfantry(new MyPoint(787,490), GameObject.JAPAN));
		troopList.add(new NormalInfantry(new MyPoint(856,436), GameObject.JAPAN));
		troopList.add(new NormalInfantry(new MyPoint(804,366), GameObject.JAPAN));
		troopList.add(new NormalInfantry(new MyPoint(798,1141), GameObject.JAPAN));
		troopList.add(new NormalInfantry(new MyPoint(794,1192), GameObject.JAPAN));
		troopList.add(new NormalInfantry(new MyPoint(794,1255), GameObject.JAPAN));
		troopList.add(new NormalInfantry(new MyPoint(1284,974), GameObject.JAPAN));
		troopList.add(new NormalInfantry(new MyPoint(1327,1036), GameObject.JAPAN));
		troopList.add(new NormalInfantry(new MyPoint(1261,1048), GameObject.JAPAN));
		troopList.add(new NormalInfantry(new MyPoint(730,308), GameObject.JAPAN));
		troopList.add(new NormalInfantry(new MyPoint(730,308), GameObject.JAPAN));
		troopList.add(new NormalInfantry(new MyPoint(1642,2182), GameObject.JAPAN));
		troopList.add(new NormalInfantry(new MyPoint(1442,2246), GameObject.JAPAN));
		troopList.add(new NormalInfantry(new MyPoint(1197,2364), GameObject.JAPAN));
		troopList.add(new NormalInfantry(new MyPoint(1246,2119), GameObject.JAPAN));
		troopList.add(new NormalInfantry(new MyPoint(1311,2398), GameObject.JAPAN));
		troopList.add(new NormalInfantry(new MyPoint(1140,1602), GameObject.JAPAN));

		troopList.add(new NormalInfantry(new MyPoint(288,956), GameObject.KMT));
		troopList.add(new NormalInfantry(new MyPoint(291,1036), GameObject.KMT));
		troopList.add(new NormalInfantry(new MyPoint(306,1108), GameObject.KMT));
		troopList.add(new NormalInfantry(new MyPoint(234,1164), GameObject.KMT));
		troopList.add(new NormalInfantry(new MyPoint(246,1386), GameObject.KMT));
		troopList.add(new NormalInfantry(new MyPoint(327,1462), GameObject.KMT));
		troopList.add(new NormalInfantry(new MyPoint(243,1645), GameObject.KMT));
		troopList.add(new NormalInfantry(new MyPoint(171,1735), GameObject.KMT));
		troopList.add(new NormalInfantry(new MyPoint(442,1855), GameObject.KMT));
		troopList.add(new NormalInfantry(new MyPoint(509,1743), GameObject.KMT));
		troopList.add(new NormalInfantry(new MyPoint(685,1819), GameObject.KMT));
		troopList.add(new NormalInfantry(new MyPoint(573,1866), GameObject.KMT));
		troopList.add(new NormalInfantry(new MyPoint(764,2224), GameObject.KMT));
		troopList.add(new NormalInfantry(new MyPoint(615,2137), GameObject.KMT));
		troopList.add(new NormalInfantry(new MyPoint(842,2352), GameObject.KMT));
		troopList.add(new NormalInfantry(new MyPoint(659,2276), GameObject.KMT));
		troopList.add(new NormalInfantry(new MyPoint(756,2333), GameObject.KMT));


		this.troopList.add(new littleBurst(new MyPoint(580,830)));//首颗炸弹是哑弹，确保第一个需要的炸弹是可以爆炸的

		this.troopList.add(new BigBurst(new MyPoint(580,830)));//首颗炸弹是哑弹，确保第一个需要的炸弹是可以爆炸的


	}







}