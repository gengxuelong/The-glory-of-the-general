package code.altas;

import code.Element.cartoon.BigBurst;
import code.Element.footHold.*;
import code.Element.troop.*;
import code.Obj.GameObject;
import code.util.values;
import utils.MyPoint;

import java.awt.*;

/**
 * 
 * @author PYE
 *
 */
public class Atlas_E_FaGuoZhanYi extends Atlas{

	private Atlas_E_FaGuoZhanYi(Image image, int xForBg, int yForBg, int width, int height) {
		this.image = image;
		this.xForBg = xForBg;
		this.yForBg = yForBg;
		this.width = width;
		this.height = height;
		loadData();

	}
	
	public static Atlas_E_FaGuoZhanYi instance () {
		return new Atlas_E_FaGuoZhanYi(values.atlas_FaGuoZhanYi, -150, 0, 2100, 1400);
	}

	public void loadData(){
		temps = new int[] {GameObject.GERMAN,GameObject.FRANCE};
		
		//加入城市
		this.footHoldList.add(new LargeCity(new MyPoint(200,971),GameObject.FRANCE));
		this.footHoldList.add(new MiddleCity(new MyPoint(341,594),GameObject.FRANCE));
		this.footHoldList.add(new MiddleCity(new MyPoint(782,906),GameObject.FRANCE));
		this.footHoldList.add(new MiddleCity(new MyPoint(994,1159),GameObject.FRANCE));
		this.footHoldList.add(new MiddleCity(new MyPoint(558,588),GameObject.FRANCE));
		this.footHoldList.add(new LargeCity(new MyPoint(1917,310),GameObject.GERMAN));
		this.footHoldList.add(new SmallCity(new MyPoint(942,681),GameObject.GERMAN));
		this.footHoldList.add(new SmallCity(new MyPoint(691,261),GameObject.GERMAN));
		this.footHoldList.add(new MiddleCity(new MyPoint(1047,80),GameObject.GERMAN));
		this.footHoldList.add(new MiddleCity(new MyPoint(1382,330),GameObject.GERMAN));
		this.footHoldList.add(new MiddleCity(new MyPoint(2064,893),GameObject.GERMAN));
		this.footHoldList.add(new SmallCity(new MyPoint(1593,1312),GameObject.GERMAN));
		
		//加入兵工厂
		this.footHoldList.add(new LargeArmsFactory(new MyPoint(274,857),GameObject.FRANCE));
		this.footHoldList.add(new LargeArmsFactory(new MyPoint(338,1032),GameObject.FRANCE));
		this.footHoldList.add(new MiddleArmsFactory(new MyPoint(458,669),GameObject.FRANCE));
		this.footHoldList.add(new MiddleArmsFactory(new MyPoint(849,1079),GameObject.FRANCE));
		this.footHoldList.add(new MiddleArmsFactory(new MyPoint(649,929),GameObject.FRANCE));
		this.footHoldList.add(new LargeArmsFactory(new MyPoint(1814,288),GameObject.GERMAN));
		this.footHoldList.add(new LargeArmsFactory(new MyPoint(1887,468),GameObject.GERMAN));
		this.footHoldList.add(new MiddleArmsFactory(new MyPoint(1171,154),GameObject.GERMAN));
		this.footHoldList.add(new MiddleArmsFactory(new MyPoint(1473,424),GameObject.GERMAN));
		this.footHoldList.add(new SmallArmsFactory(new MyPoint(1987,954),GameObject.GERMAN));
		this.footHoldList.add(new SmallArmsFactory(new MyPoint(1645,1239),GameObject.GERMAN));
		this.footHoldList.add(new MiddleArmsFactory(new MyPoint(992,577),GameObject.GERMAN));
		
		//加入机场
		this.footHoldList.add(new Airport(new MyPoint(443,763),GameObject.FRANCE));
		this.footHoldList.add(new Airport(new MyPoint(661,1091),GameObject.FRANCE));
		this.footHoldList.add(new Airport(new MyPoint(1079,682),GameObject.GERMAN));
		this.footHoldList.add(new Airport(new MyPoint(836,304),GameObject.GERMAN));
		this.footHoldList.add(new Airport(new MyPoint(1744,614),GameObject.GERMAN));
		
		//加入初始兵力
		this.troopList.add(new NormalInfantry(new MyPoint(720,550),GameObject.FRANCE));
		this.troopList.add(new NormalInfantry(new MyPoint(563,728),GameObject.FRANCE));
		this.troopList.add(new NormalInfantry(new MyPoint(680,818),GameObject.FRANCE));
		this.troopList.add(new NormalInfantry(new MyPoint(922,1029),GameObject.FRANCE));
		this.troopList.add(new NormalInfantry(new MyPoint(1088,1118),GameObject.FRANCE));
		this.troopList.add(new HeavyTank(new MyPoint(287,720),GameObject.FRANCE));
		this.troopList.add(new HeavyTank(new MyPoint(800,1222),GameObject.FRANCE));
		
		this.troopList.add(new NormalInfantry(new MyPoint(800,1222),GameObject.GERMAN));
		this.troopList.add(new NormalInfantry(new MyPoint(1014,773),GameObject.GERMAN));
		this.troopList.add(new NormalInfantry(new MyPoint(898,608),GameObject.GERMAN));
		this.troopList.add(new NormalInfantry(new MyPoint(613,346),GameObject.GERMAN));
		this.troopList.add(new NormalInfantry(new MyPoint(750,384),GameObject.GERMAN));
		this.troopList.add(new NormalInfantry(new MyPoint(1538,1225),GameObject.GERMAN));
		this.troopList.add(new HeavyTank(new MyPoint(1152,610),GameObject.GERMAN));
		this.troopList.add(new MiddleTank(new MyPoint(972,260),GameObject.GERMAN));
		this.troopList.add(new HeavyTank(new MyPoint(1589,276),GameObject.GERMAN));
		this.troopList.add(new BigBurst(new MyPoint(580,830)));//首颗炸弹是哑弹，确保第一个需要的炸弹是可以爆炸的

	}
}