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
public class Atlas_E_ShiChangHuaYuanXingDong extends Atlas{

	private Atlas_E_ShiChangHuaYuanXingDong(Image image, int xForBg, int yForBg, int width, int height) {
		this.image = image;
		this.xForBg = xForBg;
		this.yForBg = yForBg;
		this.width = width;
		this.height = height;
		loadData();

	}
	
	public static Atlas_E_ShiChangHuaYuanXingDong instance () {
		return new Atlas_E_ShiChangHuaYuanXingDong(values.atlas_ShiChangHuaYuanXingDong, -150, 0, 2100, 1400);
	}
	public void loadData(){
		temps = new int[] {GameObject.GERMAN,GameObject.US};
		
		//加入城市
		this.footHoldList.add(new MiddleCity(new MyPoint(1372,197),GameObject.GERMAN));
		this.footHoldList.add(new MiddleCity(new MyPoint(1684,696),GameObject.GERMAN));
		this.footHoldList.add(new MiddleCity(new MyPoint(1744,1284),GameObject.GERMAN));
		this.footHoldList.add(new MiddleCity(new MyPoint(1478,974),GameObject.GERMAN));
		this.footHoldList.add(new MiddleCity(new MyPoint(953,597),GameObject.US));
		this.footHoldList.add(new LargeCity(new MyPoint(783,1052),GameObject.US));
		this.footHoldList.add(new LargeCity(new MyPoint(459,266),GameObject.US));
			
		//加入兵工厂
		this.footHoldList.add(new LargeArmsFactory(new MyPoint(402,363),GameObject.US));
		this.footHoldList.add(new LargeArmsFactory(new MyPoint(700,966),GameObject.US));
		this.footHoldList.add(new MiddleArmsFactory(new MyPoint(794,768),GameObject.US));
		this.footHoldList.add(new LargeArmsFactory(new MyPoint(1781,914),GameObject.GERMAN));
		this.footHoldList.add(new MiddleArmsFactory(new MyPoint(1828,1157),GameObject.GERMAN));
		this.footHoldList.add(new SmallArmsFactory(new MyPoint(1589,264),GameObject.GERMAN));
		
		//加入机场
		this.footHoldList.add(new Airport(new MyPoint(539,400),GameObject.US));
		this.footHoldList.add(new Airport(new MyPoint(790,952),GameObject.US));
		this.footHoldList.add(new Airport(new MyPoint(1449,275),GameObject.GERMAN));
		this.footHoldList.add(new Airport(new MyPoint(1686,800),GameObject.GERMAN));
		this.footHoldList.add(new Airport(new MyPoint(1635,1129),GameObject.GERMAN));
		
		//加入初始兵力
		this.troopList.add(new NormalInfantry(new MyPoint(642,384),GameObject.US));
		this.troopList.add(new NormalInfantry(new MyPoint(996,510),GameObject.US));
		this.troopList.add(new NormalInfantry(new MyPoint(1069,678),GameObject.US));
		this.troopList.add(new NormalInfantry(new MyPoint(945,969),GameObject.US));
		this.troopList.add(new NormalInfantry(new MyPoint(936,1100),GameObject.US));
		this.troopList.add(new NormalInfantry(new MyPoint(929,817),GameObject.US));
		this.troopList.add(new NormalInfantry(new MyPoint(762,666),GameObject.US));
		this.troopList.add(new NormalInfantry(new MyPoint(665,804),GameObject.US));
		this.troopList.add(new NormalInfantry(new MyPoint(1068,788),GameObject.US));
		this.troopList.add(new NormalInfantry(new MyPoint(1032,1126),GameObject.US));
		this.troopList.add(new NormalInfantry(new MyPoint(870,1198),GameObject.US));
		this.troopList.add(new NormalInfantry(new MyPoint(977,1311),GameObject.US));
		this.troopList.add(new NormalInfantry(new MyPoint(801,556),GameObject.US));

		this.troopList.add(new HeavyTank(new MyPoint(1335,329),GameObject.GERMAN));
		this.troopList.add(new MiddleTank(new MyPoint(1486,398),GameObject.GERMAN));
		this.troopList.add(new HeavyTank(new MyPoint(1563,780),GameObject.GERMAN));
		this.troopList.add(new MiddleTank(new MyPoint(1442,1104),GameObject.GERMAN));
		this.troopList.add(new HeavyTank(new MyPoint(1598,909),GameObject.GERMAN));
		this.troopList.add(new LightTank(new MyPoint(1570,1272),GameObject.GERMAN));
		this.troopList.add(new SpecialInfantry(new MyPoint(1580,559),GameObject.GERMAN));
		this.troopList.add(new BigBurst(new MyPoint(580,830)));//首颗炸弹是哑弹，确保第一个需要的炸弹是可以爆炸的

	}
}