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
 * 八月风暴行动
 * @author PYE
 *
 */
public class Atlas_A_BaYueFengBaoXingDong extends Atlas{

	private Atlas_A_BaYueFengBaoXingDong(Image image, int xForBg, int yForBg, int width, int height) {
		this.image = image;
		this.xForBg = xForBg;
		this.yForBg = yForBg;
		this.width = width;
		this.height = height;
		loadData();

	}
	
	public static Atlas_A_BaYueFengBaoXingDong instance () {
		return new Atlas_A_BaYueFengBaoXingDong(values.atlas_BaYueFengBaoXingDong, -150, -1000, 2000, 1700);
	}

	public void loadData(){
		temps = new int[] {GameObject.JAPAN,GameObject.USSR};
		
		//城市
		this.footHoldList.add(new LargeCity(new MyPoint(850,1546),GameObject.JAPAN));//北平
		this.footHoldList.add(new MiddleCity(new MyPoint(451,1465),GameObject.JAPAN));//呼和浩特
		this.footHoldList.add(new LargeCity(new MyPoint(1668,1556),GameObject.JAPAN));//平壤
		this.footHoldList.add(new LargeCity(new MyPoint(1412,1271),GameObject.JAPAN));//沈阳
		this.footHoldList.add(new MiddleCity(new MyPoint(1524,1008),GameObject.JAPAN));//长春
		this.footHoldList.add(new LargeCity(new MyPoint(1584,767),GameObject.JAPAN));//哈尔滨
		
		this.footHoldList.add(new SmallCity(new MyPoint(1572,325),GameObject.USSR));
		this.footHoldList.add(new MiddleCity(new MyPoint(80,657),GameObject.USSR));//乌兰巴托
		
		//兵工厂
		this.footHoldList.add(new MiddleArmsFactory(new MyPoint(250,670),GameObject.USSR));
		this.footHoldList.add(new MiddleArmsFactory(new MyPoint(1455,301),GameObject.USSR));
		this.footHoldList.add(new LargeArmsFactory(new MyPoint(1633,1462),GameObject.JAPAN));
		this.footHoldList.add(new LargeArmsFactory(new MyPoint(1488,902),GameObject.JAPAN));
		this.footHoldList.add(new LargeArmsFactory(new MyPoint(676,1458),GameObject.JAPAN));
		this.footHoldList.add(new MiddleArmsFactory(new MyPoint(1557,1228),GameObject.JAPAN));
		
		//机场
		this.footHoldList.add(new Airport(new MyPoint(822,1391),GameObject.JAPAN));
		this.footHoldList.add(new Airport(new MyPoint(1697,745),GameObject.JAPAN));
		this.footHoldList.add(new Airport(new MyPoint(225,789),GameObject.USSR));
		
		//加入初始兵力
		this.troopList.add(new HeavyTank(new MyPoint(888,1390),GameObject.JAPAN));
		this.troopList.add(new SpecialInfantry(new MyPoint(996,1517),GameObject.JAPAN));
		this.troopList.add(new MiddleTank(new MyPoint(464,1343),GameObject.JAPAN));
		this.troopList.add(new NormalInfantry(new MyPoint(364,1403),GameObject.JAPAN));
		this.troopList.add(new NormalInfantry(new MyPoint(1026,1404),GameObject.JAPAN));
		this.troopList.add(new HeavyTank(new MyPoint(1512,635),GameObject.JAPAN));
		this.troopList.add(new MiddleTank(new MyPoint(1401,704),GameObject.JAPAN));
		this.troopList.add(new HeavyTank(new MyPoint(1277,1175),GameObject.JAPAN));
		this.troopList.add(new LightTank(new MyPoint(1382,1058),GameObject.JAPAN));
		this.troopList.add(new NormalInfantry(new MyPoint(1219,1044),GameObject.JAPAN));
		this.troopList.add(new NormalInfantry(new MyPoint(1344,581),GameObject.JAPAN));
		this.troopList.add(new SpecialInfantry(new MyPoint(1330,882),GameObject.JAPAN));
		this.troopList.add(new SpecialInfantry(new MyPoint(1696,620),GameObject.JAPAN));
		
		this.troopList.add(new HeavyTank(new MyPoint(1845,752),GameObject.USSR));
		this.troopList.add(new HeavyTank(new MyPoint(962,1205),GameObject.USSR));
		this.troopList.add(new HeavyTank(new MyPoint(198,1043),GameObject.USSR));
		this.troopList.add(new HeavyTank(new MyPoint(461,892),GameObject.USSR));
		this.troopList.add(new HeavyTank(new MyPoint(715,801),GameObject.USSR));
		this.troopList.add(new HeavyTank(new MyPoint(690,444),GameObject.USSR));
		this.troopList.add(new HeavyTank(new MyPoint(947,228),GameObject.USSR));
		this.troopList.add(new HeavyTank(new MyPoint(1294,370),GameObject.USSR));
		this.troopList.add(new HeavyTank(new MyPoint(1776,532),GameObject.USSR));
		this.troopList.add(new MiddleTank(new MyPoint(699,636),GameObject.USSR));
		this.troopList.add(new MiddleTank(new MyPoint(314,877),GameObject.USSR));
		this.troopList.add(new MiddleTank(new MyPoint(1050,462),GameObject.USSR));
		this.troopList.add(new NormalInfantry(new MyPoint(154,923),GameObject.USSR));
		this.troopList.add(new SpecialInfantry(new MyPoint(492,745),GameObject.USSR));
		this.troopList.add(new NormalInfantry(new MyPoint(612,744),GameObject.USSR));
		this.troopList.add(new NormalInfantry(new MyPoint(547,515),GameObject.USSR));
		this.troopList.add(new SpecialInfantry(new MyPoint(728,293),GameObject.USSR));
		this.troopList.add(new NormalInfantry(new MyPoint(846,209),GameObject.USSR));
		this.troopList.add(new MobileInfantry(new MyPoint(1133,315),GameObject.USSR));
		this.troopList.add(new NormalInfantry(new MyPoint(1464,414),GameObject.USSR));
		this.troopList.add(new MobileInfantry(new MyPoint(1762,383),GameObject.USSR));
		this.troopList.add(new NormalInfantry(new MyPoint(905,384),GameObject.USSR));
		this.troopList.add(new NormalInfantry(new MyPoint(883,558),GameObject.USSR));
		this.troopList.add(new MiddleTank(new MyPoint(1724,215),GameObject.USSR));
		this.troopList.add(new MiddleTank(new MyPoint(1233,229),GameObject.USSR));
		this.troopList.add(new NormalInfantry(new MyPoint(1939,338),GameObject.USSR));
		this.troopList.add(new NormalInfantry(new MyPoint(1637,460),GameObject.USSR));
		this.footHoldList.add(new Airport(new MyPoint(580,830),GameObject.JAPAN));
		this.troopList.add(new BigBurst(new MyPoint(580,830)));
		this.troopList.add(new BigBurst(new MyPoint(580,830)));//首颗炸弹是哑弹，确保第一个需要的炸弹是可以爆炸的
		this.troopList.add(new littleBurst(new MyPoint(580,830)));//首颗炸弹是哑弹，确保第一个需要的炸弹是可以爆炸的
	}

}