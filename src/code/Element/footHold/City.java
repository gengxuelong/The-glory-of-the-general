package code.Element.footHold;

import code.Obj.FootHoldObject;
import utils.MyPoint;

import java.awt.*;
import java.awt.event.KeyEvent;


/**
 *
 * @author PYE
 *
 */
public abstract class City extends FootHoldObject {
	
	//造兵时用
	public static int NI = 1;//普通步兵
	public static int MI = 2;//机动兵
	public static int SI = 3;//特种兵
	
    protected int gold;
    protected int iron;
    
    {
        size = 60;
    }
    public City( MyPoint point,int temp){
        this.myPoint = point;
        this.setCamp(temp);
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    public void paintSelf(Graphics g){
        super.paintSelf(g);
    }


    @Override
    public void produceResource() {
        this.frame.getNowResource().setX(this.frame.getNowResource().x + this.gold);
        this.frame.getNowResource().setY(this.frame.getNowResource().y + this.iron);
    }
	public void produceTroop(int choice) {
		// TODO Auto-generated method stub
		
	}
}
