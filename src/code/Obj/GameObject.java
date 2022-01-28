package code.Obj;

import java.awt.*;
import java.awt.event.KeyEvent;

import code.frame.Frame;
import code.util.values;
import utils.*;


/**
 * 
 * @author PYE
 * @version 1.0
 */
public abstract class GameObject {
	
	//不同的国家
	public final static int CPC = 0;
	public final static int JAPAN = 1;
	public final static int DENMARK = 2;
	public final static int GERMAN = 3;
	public final static int UK = 4;
	public final static int FRANCE = 5;
	public final static int US = 6;
	public final static int TURKEY = 7;
	public final static int FINLAND = 8;
	public final static int SPAIN = 9;
	public final static int USSR = 10;
	public final static int POLAND = 11;
	public final static int KMT = 12;
		
	protected Image flag;//国旗，代表国别
	protected Image image;//元素图片
	protected int size;//大小
	protected int camp;//国家
	protected Frame frame;//系统
	protected MyPoint myPoint;//坐标
	protected boolean isChoose;//是否被选择


	public boolean isChoose() {
		return isChoose;
	}

	public void setChoose(boolean choose) {
		isChoose = choose;
	}

	public MyPoint getMyPoint() {
		return this.myPoint;
	}
	
	public void setMyPoint(MyPoint point) {
		this.myPoint = point;
	}
	
	public void setMyPoint(int x,int y) {
		this.myPoint = new MyPoint(x,y);
	}
	
	public int getSize() {
		return this.size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public int getCamp() {
		return this.camp;
	}
	
	public void setCamp(int camp) {//更改阵营的同时更改该国旗
		this.camp = camp;
		setFlag(camp);
	}
	
	public Frame getFrame() {
		return this.frame;
	}
	
	public void setFrame(Frame frame) {
		this.frame = frame;
	}
	
	private void setFlag(int temp) {
		switch(temp) {
			case CPC:this.flag = values.FlagOfCPC;break;
			case JAPAN:this.flag = values.FlagOfJapan;break;
			case DENMARK:this.flag = values.FlagOfDenmark;break;
			case POLAND:this.flag = values.FlagOfPoland;break;
			case GERMAN:this.flag = values.FlagOfGerman;break;
			case FRANCE:this.flag = values.FlagOfFrance;break;
			case FINLAND:this.flag = values.FlagOfFinland;break;
			case US:this.flag = values.FlagOfUS;break;
			case USSR:this.flag = values.FlagOfUSSR;break;
			case TURKEY:this.flag = values.FlagOfTurkey;break;
			case SPAIN:this.flag = values.FlagOfSpain;break;
			case UK:this.flag = values.FlagOfUK;break;
			case KMT:this.flag = values.FlagOfKMT;break;
			
		}
	}


	public  void keyPressed(KeyEvent e){};

	public boolean canClick(MyPoint point) {
		if(Math.abs(point.x-myPoint.x)<(size/2)&&Math.abs(point.y-myPoint.y)<(size/2)) {
			return true;
		}
		return false;
	}
	public void paintSelf(Graphics g){
        
        g.drawImage(image,myPoint.getX()-size/2,myPoint.getY()-size/2,size,size,null);
        g.drawImage(flag,myPoint.getX()-size/2,myPoint.getY()-size/2-3*size/8,size*2/4,3*size/9,null);
    }

    public Rectangle getRec(){
		return new Rectangle(myPoint.x-size/2,myPoint.y-size/2,size,size);
	}
}
