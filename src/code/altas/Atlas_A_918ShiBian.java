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
 * 九一八事变，特点是日本初始城市少但兵力多，民国初始城市多但兵力少
 * @author PYE
 *
 */
public class Atlas_A_918ShiBian extends Atlas{

	private Atlas_A_918ShiBian(Image image, int xForBg, int yForBg, int width, int height) {
		this.image = image;
		this.xForBg = xForBg;
		this.yForBg = yForBg;
		this.width = width;
		this.height = height;
		loadData();

	}
	
	public static Atlas_A_918ShiBian instance() {
		return new Atlas_A_918ShiBian(values.atlas_JiuYiBaShiBian, -150, -1590, 2000, 3000);
	}

	public void loadData(){
		temps = new int[] {GameObject.KMT,GameObject.JAPAN};
		
		//加入大城市
		this.footHoldList.add(new LargeCity(new MyPoint(861,1750),GameObject.KMT));//沈阳
		this.footHoldList.add(new LargeCity(new MyPoint(1070,1395),GameObject.KMT));//长春
		this.footHoldList.add(new LargeCity(new MyPoint(1202,1064),GameObject.KMT));//哈尔滨
		this.footHoldList.add(new LargeCity(new MyPoint(1350,2148),GameObject.JAPAN));//平壤
		this.footHoldList.add(new LargeCity(new MyPoint(1372,1449),GameObject.KMT));//吉林
		
		//加入中小城市
		this.footHoldList.add(new MiddleCity(new MyPoint(706,2140),GameObject.JAPAN));//大连（旅顺）
		this.footHoldList.add(new SmallCity(new MyPoint(515,1898),GameObject.KMT));//锦州
		this.footHoldList.add(new SmallCity(new MyPoint(718,1949),GameObject.KMT));//营口
		this.footHoldList.add(new MiddleCity(new MyPoint(1048,1992),GameObject.JAPAN));//安东
		this.footHoldList.add(new MiddleCity(new MyPoint(1570,2360),GameObject.JAPAN));//首尔
		this.footHoldList.add(new MiddleCity(new MyPoint(333,1401),GameObject.KMT));
		this.footHoldList.add(new SmallCity(new MyPoint(563,1018),GameObject.KMT));
		
		//加入兵工厂
		this.footHoldList.add(new LargeArmsFactory(new MyPoint(1192,1526),GameObject.KMT));
		this.footHoldList.add(new LargeArmsFactory(new MyPoint(1312,2242),GameObject.JAPAN));
		this.footHoldList.add(new MiddleArmsFactory(new MyPoint(1665,2386),GameObject.JAPAN));
		this.footHoldList.add(new LargeArmsFactory(new MyPoint(683,1797),GameObject.KMT));
		this.footHoldList.add(new MiddleArmsFactory(new MyPoint(1283,1236),GameObject.KMT));
		this.footHoldList.add(new SmallArmsFactory(new MyPoint(914,1377),GameObject.KMT));
		this.footHoldList.add(new SmallArmsFactory(new MyPoint(996,1181),GameObject.KMT));
		this.footHoldList.add(new MiddleArmsFactory(new MyPoint(962,1881),GameObject.KMT));

		//加入机场
		this.footHoldList.add(new Airport(new MyPoint(1519,2066),GameObject.JAPAN));
		
		//加入初始兵力
		this.troopList.add(new HeavyTank(new MyPoint(790,2094),GameObject.JAPAN));
		this.troopList.add(new MiddleTank(new MyPoint(923,2043),GameObject.JAPAN));
		this.troopList.add(new MiddleTank(new MyPoint(1228,1956),GameObject.JAPAN));
		this.troopList.add(new HeavyTank(new MyPoint(1342,1839),GameObject.JAPAN));
		this.troopList.add(new HeavyArtillery(new MyPoint(1398,2028),GameObject.JAPAN));
		this.troopList.add(new NormalInfantry(new MyPoint(842,2032),GameObject.JAPAN));
		this.troopList.add(new HeavyTank(new MyPoint(660,2058),GameObject.JAPAN));
		this.troopList.add(new NormalInfantry(new MyPoint(1233,1869),GameObject.JAPAN));
		this.troopList.add(new HeavyTank(new MyPoint(1396,1728),GameObject.JAPAN));
		this.troopList.add(new MiddleTank(new MyPoint(1568,1768),GameObject.JAPAN));
		this.troopList.add(new NormalInfantry(new MyPoint(1134,1839),GameObject.JAPAN));
		this.troopList.add(new HeavyArtillery(new MyPoint(1462,2241),GameObject.JAPAN));
		
		this.troopList.add(new NormalInfantry(new MyPoint(259,1965),GameObject.KMT));
		this.troopList.add(new NormalInfantry(new MyPoint(862,1921),GameObject.KMT));
		this.troopList.add(new NormalInfantry(new MyPoint(997,1733),GameObject.KMT));
		this.troopList.add(new NormalInfantry(new MyPoint(723,1514),GameObject.KMT));
		this.troopList.add(new NormalInfantry(new MyPoint(402,1678),GameObject.KMT));
		this.troopList.add(new NormalInfantry(new MyPoint(1106,1644),GameObject.KMT));
		this.troopList.add(new NormalInfantry(new MyPoint(1307,1609),GameObject.KMT));
		this.troopList.add(new NormalInfantry(new MyPoint(569,1534),GameObject.KMT));
		this.troopList.add(new NormalInfantry(new MyPoint(602,1690),GameObject.KMT));
		this.troopList.add(new NormalInfantry(new MyPoint(1652,1465),GameObject.KMT));
		this.troopList.add(new HeavyTank(new MyPoint(111,1523),GameObject.KMT));
		this.troopList.add(new HeavyTank(new MyPoint(738,1283),GameObject.KMT));
		this.troopList.add(new HeavyArtillery(new MyPoint(1016,1502),GameObject.KMT));

		this.troopList.add(new littleBurst(new MyPoint(580,830)));//首颗炸弹是哑弹，确保第一个需要的炸弹是可以爆炸的

		this.troopList.add(new BigBurst(new MyPoint(580,830)));//首颗炸弹是哑弹，确保第一个需要的炸弹是可以爆炸的

	}
}