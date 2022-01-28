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
public class Atlas_E_JiFuZhanYi extends Atlas{

	private Atlas_E_JiFuZhanYi(Image image, int xForBg, int yForBg, int width, int height) {
		this.image = image;
		this.xForBg = xForBg;
		this.yForBg = yForBg;
		this.width = width;
		this.height = height;
		loadData();

	}
	
	public static Atlas_E_JiFuZhanYi instance () {
		return new Atlas_E_JiFuZhanYi(values.atlas_JiFuZhanYi, -150, 0, 2100, 1400);
	}

	public void loadData(){
		temps = new int[] {GameObject.GERMAN,GameObject.USSR};
		
		//加入城市
		this.footHoldList.add(new LargeCity(new MyPoint(1083,644),GameObject.USSR));//基辅
		this.footHoldList.add(new MiddleCity(new MyPoint(1258,692),GameObject.USSR));
		this.footHoldList.add(new MiddleCity(new MyPoint(1067,816),GameObject.USSR));
		this.footHoldList.add(new SmallCity(new MyPoint(642,116),GameObject.GERMAN));
		this.footHoldList.add(new SmallCity(new MyPoint(253,235),GameObject.GERMAN));
		this.footHoldList.add(new MiddleCity(new MyPoint(970,84),GameObject.GERMAN));
				
		//加入兵工厂
		this.footHoldList.add(new LargeArmsFactory(new MyPoint(1198,804),GameObject.USSR));
		this.footHoldList.add(new LargeArmsFactory(new MyPoint(1060,932),GameObject.USSR));
		this.footHoldList.add(new LargeArmsFactory(new MyPoint(776,101),GameObject.GERMAN));
		this.footHoldList.add(new MiddleArmsFactory(new MyPoint(479,120),GameObject.GERMAN));

		//加入机场
		this.footHoldList.add(new Airport(new MyPoint(1151,591),GameObject.USSR));
		
		//加入初始兵力
		this.troopList.add(new HeavyTank(new MyPoint(1448,633),GameObject.USSR));
		this.troopList.add(new HeavyTank(new MyPoint(1282,970),GameObject.USSR));
		this.troopList.add(new NormalInfantry(new MyPoint(906,885),GameObject.USSR));
		this.troopList.add(new NormalInfantry(new MyPoint(1326,590),GameObject.USSR));
		this.troopList.add(new NormalInfantry(new MyPoint(948,603),GameObject.USSR));
		
		this.troopList.add(new HeavyTank(new MyPoint(202,728),GameObject.GERMAN));
		this.troopList.add(new HeavyTank(new MyPoint(90,469),GameObject.GERMAN));
		this.troopList.add(new MiddleTank(new MyPoint(157,322),GameObject.GERMAN));
		this.troopList.add(new MiddleTank(new MyPoint(166,601),GameObject.GERMAN));
		this.troopList.add(new MiddleTank(new MyPoint(719,239),GameObject.GERMAN));
		this.troopList.add(new HeavyTank(new MyPoint(394,198),GameObject.GERMAN));
		this.troopList.add(new SpecialInfantry(new MyPoint(875,180),GameObject.GERMAN));
		this.troopList.add(new NormalInfantry(new MyPoint(567,201),GameObject.GERMAN));
		this.troopList.add(new BigBurst(new MyPoint(580,830)));//首颗炸弹是哑弹，确保第一个需要的炸弹是可以爆炸的

	}
}