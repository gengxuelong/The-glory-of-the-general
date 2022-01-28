package code.util;

import java.awt.*;
import java.util.Random;

import static code.Obj.GameObject.*;

/**
 * @author kangzhaoxin
 */
public class values {

	public static String path = "./resource/二战/";
	public static String path_2 = "./resource/page/";
	public static String path_3 = "./resource/atlas/";
	public static Image FlagOfJapan = Toolkit.getDefaultToolkit().createImage(path+"国旗/日本.png");
	public static Image FlagOfCPC = Toolkit.getDefaultToolkit().createImage(path+"国旗/中国.jpeg");
	public static Image FlagOfKMT = Toolkit.getDefaultToolkit().createImage(path+"国旗/中国.png");
	public static Image FlagOfDenmark = Toolkit.getDefaultToolkit().createImage(path+"国旗/丹麦.jpeg");
	public static Image FlagOfFrance = Toolkit.getDefaultToolkit().createImage(path+"国旗/法国.jpeg");
	public static Image FlagOfFinland = Toolkit.getDefaultToolkit().createImage(path+"国旗/芬兰.jpeg");
	public static Image FlagOfUS = Toolkit.getDefaultToolkit().createImage(path+"国旗/美国.jpeg");
	public static Image FlagOfUSSR = Toolkit.getDefaultToolkit().createImage(path+"国旗/苏联.jpeg");
	public static Image FlagOfTurkey = Toolkit.getDefaultToolkit().createImage(path+"国旗/土耳其.jpeg");
	public static Image FlagOfSpain = Toolkit.getDefaultToolkit().createImage(path+"国旗/西班牙.jpeg");
	public static Image FlagOfUK = Toolkit.getDefaultToolkit().createImage(path+"国旗/英国.jpeg");
	public static Image FlagOfPoland = Toolkit.getDefaultToolkit().createImage(path+"国旗/波兰.jpeg");
	public static Image FlagOfGerman = Toolkit.getDefaultToolkit().createImage(path+"国旗/德国.jpg");




	public static Image TightTankOfGerman=Toolkit.getDefaultToolkit().createImage(path+"轻坦克/德国.png");
	public static Image TightTankOfJapan=Toolkit.getDefaultToolkit().createImage(path+"轻坦克/日本.png");
	public static Image TightTankOfKMT=Toolkit.getDefaultToolkit().createImage(path+"轻坦克/盟军.png");
	public static Image TightTankOfCPC=Toolkit.getDefaultToolkit().createImage(path+"轻坦克/苏联.png");
	public static Image TightTankOfUSSR=Toolkit.getDefaultToolkit().createImage(path+"轻坦克/苏联.png");

	public static Image HeavyTankOfGerman=Toolkit.getDefaultToolkit().createImage(path+"重坦克/德国.png");
	public static Image HeavyTankOfJapan=Toolkit.getDefaultToolkit().createImage(path+"重坦克/日本.png");
	public static Image HeavyTankOfKMT=Toolkit.getDefaultToolkit().createImage(path+"重坦克/美国.png");
	public static Image HeavyTankOfCPC=Toolkit.getDefaultToolkit().createImage(path+"重坦克/苏联.png");
	public static Image HeavyTankOfUS=Toolkit.getDefaultToolkit().createImage(path+"重坦克/美国_left.png");
	public static Image HeavyTankOfUSSR=Toolkit.getDefaultToolkit().createImage(path+"重坦克/苏联.png");

	public static Image MiddleTankOfGerman=Toolkit.getDefaultToolkit().createImage(path+"中型坦克/德国.png");
	public static Image MiddleTankOfJapan=Toolkit.getDefaultToolkit().createImage(path+"中型坦克/日本.png");
	public static Image MiddleTankOfKMT=Toolkit.getDefaultToolkit().createImage(path+"中型坦克/美国_left.png");
	public static Image MiddleTankOfCPC=Toolkit.getDefaultToolkit().createImage(path+"中型坦克/苏联.png");
	public static Image MiddleTankOfUS=Toolkit.getDefaultToolkit().createImage(path+"中型坦克/美国_left.png");
	public static Image MiddleTankOfUSSR=Toolkit.getDefaultToolkit().createImage(path+"中型坦克/苏联.png");
	public static Image MiddleTankOfTongyong=Toolkit.getDefaultToolkit().createImage(path+"中型坦克/通用.png");



	public static Image ARMOfJapan = Toolkit.getDefaultToolkit().createImage(path+"装甲车/日本.png");
	public static Image ARMOfCPC = Toolkit.getDefaultToolkit().createImage(path+"装甲车/中国.png");
	public static Image ARMOfKMT = Toolkit.getDefaultToolkit().createImage(path+"装甲车/美国_left.png");
	public static Image ARMOfDenmark = Toolkit.getDefaultToolkit().createImage(path+"装甲车/通用.png");
	public static Image ARMOfFrance = Toolkit.getDefaultToolkit().createImage(path+"装甲车/通用.png");
	public static Image ARMOfFinland = Toolkit.getDefaultToolkit().createImage(path+"装甲车/通用.png");
	public static Image ARMOfUS = Toolkit.getDefaultToolkit().createImage(path+"装甲车/美国_left.png");
	public static Image ARMOfUSSR = Toolkit.getDefaultToolkit().createImage(path+"装甲车/通用.png");
	public static Image ARMOfTurkey = Toolkit.getDefaultToolkit().createImage(path+"装甲车/通用.png");
	public static Image ARMOfSpain = Toolkit.getDefaultToolkit().createImage(path+"装甲车/通用.png");
	public static Image ARMOfUK = Toolkit.getDefaultToolkit().createImage(path+"装甲车/美国_left.png");
	public static Image ARMOfPoland = Toolkit.getDefaultToolkit().createImage(path+"装甲车/通用.png");
	public static Image ARMOfGerman = Toolkit.getDefaultToolkit().createImage(path+"装甲车/德国.png");



	public static Image NIOfJapan = Toolkit.getDefaultToolkit().createImage(path+"步兵/日本.png");
	public static Image NIOfCPC = Toolkit.getDefaultToolkit().createImage(path+"步兵/中国.png");
	public static Image NIOfKMT = Toolkit.getDefaultToolkit().createImage(path+"步兵/中国.png");
	public static Image NIOfDenmark = Toolkit.getDefaultToolkit().createImage(path+"步兵/通用.png");
	public static Image NIOfFrance = Toolkit.getDefaultToolkit().createImage(path+"步兵/法国.png");
	public static Image NIOfFinland = Toolkit.getDefaultToolkit().createImage(path+"步兵/通用.png");
	public static Image NIOfUS = Toolkit.getDefaultToolkit().createImage(path+"步兵/美国.png");
	public static Image NIOfUSSR = Toolkit.getDefaultToolkit().createImage(path+"步兵/苏联.png");
	public static Image NIOfTurkey = Toolkit.getDefaultToolkit().createImage(path+"步兵/通用.png");
	public static Image NIOfSpain = Toolkit.getDefaultToolkit().createImage(path+"步兵/通用.png");
	public static Image NIOfUK = Toolkit.getDefaultToolkit().createImage(path+"步兵/美国.png");
	public static Image NIOfPoland = Toolkit.getDefaultToolkit().createImage(path+"步兵/通用.png");
	public static Image NIOfGerman = Toolkit.getDefaultToolkit().createImage(path+"步兵/德国.png");

	public static Image SIOfJapan = Toolkit.getDefaultToolkit().createImage(path+"步兵_特种/德国.png");
	public static Image SIOfKMT = Toolkit.getDefaultToolkit().createImage(path+"步兵_特种/美国_left.png");
	public static Image SIOfCPC = Toolkit.getDefaultToolkit().createImage(path+"步兵_特种/苏联.png");
	public static Image SIOfDenmark = Toolkit.getDefaultToolkit().createImage(path+"步兵_特种/欧洲通用.png");
	public static Image SIOfFrance = Toolkit.getDefaultToolkit().createImage(path+"步兵_特种/欧洲通用.png");
	public static Image SIOfFinland = Toolkit.getDefaultToolkit().createImage(path+"步兵_特种/欧洲通用.png");
	public static Image SIOfUS = Toolkit.getDefaultToolkit().createImage(path+"步兵_特种/美国_left.png");
	public static Image SIOfUSSR = Toolkit.getDefaultToolkit().createImage(path+"步兵_特种/苏联.png");
	public static Image SIOfTurkey = Toolkit.getDefaultToolkit().createImage(path+"步兵_特种/欧洲通用.png");
	public static Image SIOfSpain = Toolkit.getDefaultToolkit().createImage(path+"步兵_特种/欧洲通用.png");
	public static Image SIOfUK = Toolkit.getDefaultToolkit().createImage(path+"步兵_特种/欧洲通用.png");
	public static Image SIOfPoland = Toolkit.getDefaultToolkit().createImage(path+"步兵_特种/欧洲通用.png");
	public static Image SIOfGerman = Toolkit.getDefaultToolkit().createImage(path+"步兵_特种/德国.png");

	public static Image MIOfJapan = Toolkit.getDefaultToolkit().createImage(path+"步兵_机动/通用.png");
	public static Image MIOfCPC = Toolkit.getDefaultToolkit().createImage(path+"步兵_机动/通用.png");
	public static Image MIOfKMT = Toolkit.getDefaultToolkit().createImage(path+"步兵_机动/通用.png");
	public static Image MIOfDenmark = Toolkit.getDefaultToolkit().createImage(path+"步兵_机动/通用.png");
	public static Image MIOfFrance = Toolkit.getDefaultToolkit().createImage(path+"步兵_机动/通用.png");
	public static Image MIOfFinland = Toolkit.getDefaultToolkit().createImage(path+"步兵_机动/通用.png");
	public static Image MIOfUS = Toolkit.getDefaultToolkit().createImage(path+"步兵_机动/通用.png");
	public static Image MIOfUSSR = Toolkit.getDefaultToolkit().createImage(path+"步兵_机动/通用.png");
	public static Image MIOfTurkey = Toolkit.getDefaultToolkit().createImage(path+"步兵_机动/通用.png");
	public static Image MIOfSpain = Toolkit.getDefaultToolkit().createImage(path+"步兵_机动/通用.png");
	public static Image MIOfUK = Toolkit.getDefaultToolkit().createImage(path+"步兵_机动/通用.png");
	public static Image MIOfPoland = Toolkit.getDefaultToolkit().createImage(path+"步兵_机动/通用.png");
	public static Image MIOfGerman = Toolkit.getDefaultToolkit().createImage(path+"步兵_机动/通用.png");



	public static Image TightArtilleryOfJapan = Toolkit.getDefaultToolkit().createImage(path+"火炮_轻/日本.png");
	public static Image TightArtilleryOfChina = Toolkit.getDefaultToolkit().createImage(path+"火炮_轻/美国_left.png");
	public static Image TightArtilleryOfCPC = Toolkit.getDefaultToolkit().createImage(path+"火炮_轻/美国_left.png");
	public static Image TightArtilleryOfKMT = Toolkit.getDefaultToolkit().createImage(path+"火炮_轻/美国_left.png");
	public static Image TightArtilleryOfDenmark = Toolkit.getDefaultToolkit().createImage(path+"火炮_轻/美国_left.png");
	public static Image TightArtilleryOfFrance = Toolkit.getDefaultToolkit().createImage(path+"火炮_轻/美国_left.png");
	public static Image TightArtilleryOfFinland = Toolkit.getDefaultToolkit().createImage(path+"火炮_轻/美国_left.png");
	public static Image TightArtilleryOfUS = Toolkit.getDefaultToolkit().createImage(path+"火炮_轻/美国_left.png");
	public static Image TightArtilleryOfUSSR = Toolkit.getDefaultToolkit().createImage(path+"火炮_轻/通用.png");
	public static Image TightArtilleryOfTurkey = Toolkit.getDefaultToolkit().createImage(path+"火炮_轻/日本.png");
	public static Image TightArtilleryOfSpain = Toolkit.getDefaultToolkit().createImage(path+"火炮_轻/日本.png");
	public static Image TightArtilleryOfUK = Toolkit.getDefaultToolkit().createImage(path+"火炮_轻/通用.png");
	public static Image TightArtilleryOfPoland = Toolkit.getDefaultToolkit().createImage(path+"火炮_轻/通用.png");
	public static Image TightArtilleryOfGerman = Toolkit.getDefaultToolkit().createImage(path+"火炮_轻/通用.png");

	public static Image HeavyArtilleryOfJapan = Toolkit.getDefaultToolkit().createImage(path+"火炮_重/德国.png");
	public static Image HeavyArtilleryOfChina = Toolkit.getDefaultToolkit().createImage(path+"火炮_重/美国_left.png");
	public static Image HeavyArtilleryOfCPC = Toolkit.getDefaultToolkit().createImage(path+"火炮_重/美国_left.png");
	public static Image HeavyArtilleryOfKMT = Toolkit.getDefaultToolkit().createImage(path+"火炮_重/美国_left.png");
	public static Image HeavyArtilleryOfDenmark = Toolkit.getDefaultToolkit().createImage(path+"火炮_重/苏联.png");
	public static Image HeavyArtilleryOfFrance = Toolkit.getDefaultToolkit().createImage(path+"火炮_重/美国_left.png");
	public static Image HeavyArtilleryOfFinland = Toolkit.getDefaultToolkit().createImage(path+"火炮_重/美国_left.png");
	public static Image HeavyArtilleryOfUS = Toolkit.getDefaultToolkit().createImage(path+"火炮_重/美国_left.png");
	public static Image HeavyArtilleryOfUSSR = Toolkit.getDefaultToolkit().createImage(path+"火炮_重/美国_left.png");
	public static Image HeavyArtilleryOfTurkey = Toolkit.getDefaultToolkit().createImage(path+"火炮_重/美国_left.png");
	public static Image HeavyArtilleryOfSpain = Toolkit.getDefaultToolkit().createImage(path+"火炮_重/美国_left.png");
	public static Image HeavyArtilleryOfUK = Toolkit.getDefaultToolkit().createImage(path+"火炮_重/美国_left.png");
	public static Image HeavyArtilleryOfPoland = Toolkit.getDefaultToolkit().createImage(path+"火炮_重/美国_left.png");
	public static Image HeavyArtilleryOfGerman = Toolkit.getDefaultToolkit().createImage(path+"火炮_重/德国.png");


	public static Image RocketGunOfJapan = Toolkit.getDefaultToolkit().createImage(path+"火箭炮/德国.png");
	public static Image RocketGunOfChina = Toolkit.getDefaultToolkit().createImage(path+"火箭炮/美国_left.png");
	public static Image RocketGunOfCPC = Toolkit.getDefaultToolkit().createImage(path+"火箭炮/美国.png");
	public static Image RocketGunOfKMT = Toolkit.getDefaultToolkit().createImage(path+"火箭炮/美国.png");
	public static Image RocketGunOfDenmark = Toolkit.getDefaultToolkit().createImage(path+"火箭炮/美国_left.png");
	public static Image RocketGunOfFrance = Toolkit.getDefaultToolkit().createImage(path+"火箭炮/通用.png");
	public static Image RocketGunOfFinland = Toolkit.getDefaultToolkit().createImage(path+"火箭炮/通用.png");
	public static Image RocketGunOfUS = Toolkit.getDefaultToolkit().createImage(path+"火箭炮/美国_left.png");
	public static Image RocketGunOfUSSR = Toolkit.getDefaultToolkit().createImage(path+"火箭炮/美国_left.png");
	public static Image RocketGunOfTurkey = Toolkit.getDefaultToolkit().createImage(path+"火箭炮/德国.png");
	public static Image RocketGunOfSpain = Toolkit.getDefaultToolkit().createImage(path+"火箭炮/德国.png");
	public static Image RocketGunOfUK = Toolkit.getDefaultToolkit().createImage(path+"火箭炮/通用.png");
	public static Image RocketGunOfPoland = Toolkit.getDefaultToolkit().createImage(path+"火炮_重/通用.png");
	public static Image RocketGunOfGerman = Toolkit.getDefaultToolkit().createImage(path+"火箭炮/美国_left.png");



	public static Image LargeCity = Toolkit.getDefaultToolkit().createImage(path+"城市/大城市.png");
	public static Image MiddleCity = Toolkit.getDefaultToolkit().createImage(path+"城市/中城市.png");
	public static Image SmallCity = Toolkit.getDefaultToolkit().createImage(path+"城市/小城市.png");



	public static Image atlas_QiQiShiBian = Toolkit.getDefaultToolkit().createImage(path_3+"七七事变.png");
	public static Image atlas_JiuYiBaShiBian = Toolkit.getDefaultToolkit().createImage(path_3+"九一八事变.png");
	public static Image atlas_BaoWeiYunNan = Toolkit.getDefaultToolkit().createImage(path_3+"保卫云南.png");
	public static Image atlas_BaYueFengBaoXingDong = Toolkit.getDefaultToolkit().createImage(path_3+"八月风暴行动.png");
	public static Image atlas_TaiYuanHuiZhan = Toolkit.getDefaultToolkit().createImage(path_3+"太原会战.png");
	public static Image atlas_GuangZhouHuiZhan = Toolkit.getDefaultToolkit().createImage(path_3+"广州会战.png");
	public static Image atlas_XuZhouHuiZhan = Toolkit.getDefaultToolkit().createImage(path_3+"徐州会战.png");
	public static Image atlas_KangSuZhanZheng = Toolkit.getDefaultToolkit().createImage(path_3+"抗苏战争.png");
	public static Image atlas_WuHanHuiZhan = Toolkit.getDefaultToolkit().createImage(path_3+"武汉会战.png");
	public static Image atlas_SongHuHuiZhan = Toolkit.getDefaultToolkit().createImage(path_3+"淞沪会战.png");
	public static Image atlas_BaiTuanDaZhan = Toolkit.getDefaultToolkit().createImage(path_3+"百团大战.png");
	public static Image atlas_WanNanShiBian = Toolkit.getDefaultToolkit().createImage(path_3+"皖南事变.png");
	public static Image atlas_YuXiangGuiZhanYi = Toolkit.getDefaultToolkit().createImage(path_3+"豫湘桂战役.png");
	public static Image atlas_ChangShaBaoWeiZhan = Toolkit.getDefaultToolkit().createImage(path_3+"长沙保卫战.png");


	public static Image atlas_BoLanZhanYi = Toolkit.getDefaultToolkit().createImage(path_3+"波兰战役.png");
	public static Image atlas_MoSiKeBaoWeiZhan = Toolkit.getDefaultToolkit().createImage(path_3+"莫斯科保卫战.png");
	public static Image atlas_NuoManDiDengLu = Toolkit.getDefaultToolkit().createImage(path_3+"诺曼底登陆.png");
	public static Image atlas_BoLinZhanYi = Toolkit.getDefaultToolkit().createImage(path_3+"柏林战役.png");
	public static Image atlas_DongJiChunXingXingDong = Toolkit.getDefaultToolkit().createImage(path_3+"冬季春醒行动.png");
	public static Image atlas_SiDaLingGeLeZhanYi = Toolkit.getDefaultToolkit().createImage(path_3+"斯大林格勒战役.png");
	public static Image atlas_JiFuZhanYi = Toolkit.getDefaultToolkit().createImage(path_3+"基辅战役.png");
	public static Image atlas_ShiChangHuaYuanXingDong = Toolkit.getDefaultToolkit().createImage(path_3+"市场花园行动.png");
	public static Image atlas_FaGuoZhanYi = Toolkit.getDefaultToolkit().createImage(path_3+"法国战役.png");

	public static Image bomber_China = Toolkit.getDefaultToolkit().createImage(path+"轰炸机/美国.png");
	public static Image bomber_Japan = Toolkit.getDefaultToolkit().createImage(path+"轰炸机/日本.png");
	public static Image bomber_German = Toolkit.getDefaultToolkit().createImage(path+"轰炸机/德国.png");
	public static Image bomber_US = Toolkit.getDefaultToolkit().createImage(path+"轰炸机/美国.png");
	public static Image bomber_General = Toolkit.getDefaultToolkit().createImage(path+"轰炸机/通用.png");

	public static Image fighter_China = Toolkit.getDefaultToolkit().createImage(path+"战斗机/美国.png");
	public static Image fighter_Japan = Toolkit.getDefaultToolkit().createImage(path+"战斗机/日本.png");
	public static Image fighter_German = Toolkit.getDefaultToolkit().createImage(path+"战斗机/德国.png");
	public static Image fighter_General = Toolkit.getDefaultToolkit().createImage(path+"战斗机/美国.png");

	public static Image LargeArmsFactory=Toolkit.getDefaultToolkit().createImage(path+"兵工厂/大兵工厂.png");
	public static Image MiddleArmsFactory=Toolkit.getDefaultToolkit().createImage(path+"兵工厂/中兵工厂.png");
	public static Image SmallArmsFactory=Toolkit.getDefaultToolkit().createImage(path+"兵工厂/小兵工厂.png");

	public static Image Airport_1=Toolkit.getDefaultToolkit().createImage(path+"机场/老机场 (1).png");
	public static Image Airport_2=Toolkit.getDefaultToolkit().createImage(path+"机场/老机场 (2).png");

	public static Image AirDefenceSystem=Toolkit.getDefaultToolkit().createImage(path+"要塞/防空炮.png");
	public static Image Fort=Toolkit.getDefaultToolkit().createImage(path+"要塞/机枪堡垒.png");

	private static Random random = new Random();
	public static double probability(){
		int a = random.nextInt(10);
		if(a == 0||a==1||a==2){
			return 0.5;
		}else if(a==3||a==4){
			return 0.3;
		}else if(a==5||a==6){
			return 0.7;
		}else if(a == 7){
			return 0.8;
		}else if(a==8){
			return 0.2;
		}else {
			return 0.9;
		}
	}

	public static Image  getFlag(int temp) {
		Image flag = null;
		switch(temp) {
			case CPC:flag = values.FlagOfCPC;break;
			case JAPAN:flag = values.FlagOfJapan;break;
			case DENMARK:flag = values.FlagOfDenmark;break;
			case POLAND:flag = values.FlagOfPoland;break;
			case GERMAN:flag = values.FlagOfGerman;break;
			case FRANCE:flag = values.FlagOfFrance;break;
			case FINLAND:flag = values.FlagOfFinland;break;
			case US:flag= values.FlagOfUS;break;
			case USSR:flag = values.FlagOfUSSR;break;
			case TURKEY:flag = values.FlagOfTurkey;break;
			case SPAIN:flag = values.FlagOfSpain;break;
			case UK:flag = values.FlagOfUK;break;
			case KMT:flag = values.FlagOfKMT;break;
		}
		return flag;
	}

	public static String  getCountry(int temp) {
		String flag = null;
		switch(temp) {
			case CPC:flag = "中国苏区政府";break;
			case JAPAN:flag = "日本军国";break;
			case DENMARK:flag = "丹麦";break;
			case POLAND:flag = "波兰";break;
			case GERMAN:flag = "德国法西斯政权";break;
			case FRANCE:flag = "法兰西共和国";break;
			case FINLAND:flag = "芬兰";break;
			case US:flag= "美国";break;
			case USSR:flag = "苏联";break;
			case TURKEY:flag = "土耳其";break;
			case SPAIN:flag = "西班牙";break;
			case UK:flag = "英国";break;
			case KMT:flag = "中华民国国民政府";break;
		}
		return flag;
	}
}
