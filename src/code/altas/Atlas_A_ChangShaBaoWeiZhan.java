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
 * 长沙保卫战
 * @author PYE
 *
 */
public class Atlas_A_ChangShaBaoWeiZhan extends Atlas{

	private Atlas_A_ChangShaBaoWeiZhan(Image image, int xForBg, int yForBg, int width, int height) {
		this.image = image;
		this.xForBg = xForBg;
		this.yForBg = yForBg;
		this.width = width;
		this.height = height;
		loadData();

	}
	
	public static Atlas_A_ChangShaBaoWeiZhan instance () {
		return new Atlas_A_ChangShaBaoWeiZhan(values.atlas_ChangShaBaoWeiZhan, -150, -1300, 2200, 2000);
	}

	public void loadData(){
		temps = new int[] {GameObject.KMT,GameObject.JAPAN};
		
		//加入城市
		this.footHoldList.add(new LargeCity(new MyPoint(680,1267),GameObject.KMT));//长沙
		this.footHoldList.add(new MiddleCity(new MyPoint(598,1413),GameObject.KMT));
		this.footHoldList.add(new MiddleCity(new MyPoint(631,1621),GameObject.KMT));
		this.footHoldList.add(new LargeCity(new MyPoint(1135,1119),GameObject.JAPAN));//南昌
		this.footHoldList.add(new LargeCity(new MyPoint(864,698),GameObject.JAPAN));//武汉

		
		//加入兵工厂
		this.footHoldList.add(new LargeArmsFactory(new MyPoint(485,1576),GameObject.KMT));
		this.footHoldList.add(new MiddleArmsFactory(new MyPoint(454,1331),GameObject.KMT));
		this.footHoldList.add(new MiddleArmsFactory(new MyPoint(737,1415),GameObject.KMT));
		this.footHoldList.add(new MiddleArmsFactory(new MyPoint(1108,882),GameObject.JAPAN));
		this.footHoldList.add(new MiddleArmsFactory(new MyPoint(636,738),GameObject.JAPAN));

		//加入机场
		this.footHoldList.add(new Airport(new MyPoint(795,801),GameObject.JAPAN));
		this.footHoldList.add(new Airport(new MyPoint(1242,1182),GameObject.JAPAN));
		this.footHoldList.add(new Airport(new MyPoint(762,1523),GameObject.KMT));
		this.footHoldList.add(new Airport(new MyPoint(797,1260),GameObject.KMT));
		this.footHoldList.add(new Airport(new MyPoint(518,1198),GameObject.KMT));
		
		//加入初始兵力
		this.troopList.add(new HeavyTank(new MyPoint(680,1878),GameObject.KMT));
		this.troopList.add(new HeavyTank(new MyPoint(398,1820),GameObject.KMT));
		this.troopList.add(new LightTank(new MyPoint(534,1102),GameObject.KMT));
		this.troopList.add(new NormalInfantry(new MyPoint(867,1167),GameObject.KMT));
		this.troopList.add(new NormalInfantry(new MyPoint(337,1186),GameObject.KMT));
		this.troopList.add(new NormalInfantry(new MyPoint(850,1361),GameObject.KMT));
		this.troopList.add(new NormalInfantry(new MyPoint(404,1045),GameObject.KMT));
		this.troopList.add(new NormalInfantry(new MyPoint(710,1138),GameObject.KMT));
		
		this.troopList.add(new HeavyTank(new MyPoint(467,696),GameObject.JAPAN));
		this.troopList.add(new HeavyTank(new MyPoint(910,864),GameObject.JAPAN));
		this.troopList.add(new HeavyTank(new MyPoint(1135,1255),GameObject.JAPAN));
		this.troopList.add(new NormalInfantry(new MyPoint(975,1006),GameObject.JAPAN));
		this.troopList.add(new NormalInfantry(new MyPoint(574,829),GameObject.JAPAN));
		this.troopList.add(new NormalInfantry(new MyPoint(754,936),GameObject.JAPAN));
		this.troopList.add(new NormalInfantry(new MyPoint(1170,626),GameObject.JAPAN));
		this.troopList.add(new NormalInfantry(new MyPoint(1167,734),GameObject.JAPAN));
		this.troopList.add(new NormalInfantry(new MyPoint(1275,737),GameObject.JAPAN));
		this.troopList.add(new NormalInfantry(new MyPoint(1268,631),GameObject.JAPAN));
		this.troopList.add(new NormalInfantry(new MyPoint(1054,630),GameObject.JAPAN));
		this.troopList.add(new NormalInfantry(new MyPoint(1053,716),GameObject.JAPAN));

		this.troopList.add(new littleBurst(new MyPoint(580,830)));//首颗炸弹是哑弹，确保第一个需要的炸弹是可以爆炸的

		this.troopList.add(new BigBurst(new MyPoint(580,830)));//首颗炸弹是哑弹，确保第一个需要的炸弹是可以爆炸的
	}
}