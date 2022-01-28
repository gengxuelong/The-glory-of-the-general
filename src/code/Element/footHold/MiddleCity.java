package code.Element.footHold;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.net.UnknownHostException;

import code.Element.troop.MobileInfantry;
import code.Element.troop.NormalInfantry;
import code.Obj.TroopObject;
import code.util.Tip;
import code.util.values;
import utils.MyPoint;

import javax.swing.*;

/**
 * 
 * @author PYE
 *
 */
public class MiddleCity extends City{


	
	int choice;
	
	public MiddleCity(MyPoint point, int temp) {
		super(point, temp);

		this.image = values.MiddleCity;
		this.gold = 32;
		this.iron = 12;
	}
	
    @Override
    public void keyPressed(KeyEvent e) {
    	int key = e.getKeyCode();

    	if(frame.getNowCamp()==camp){
			if(key == 49) {
				choice = NI;
				produceTroop(NI);
				if(server!=null){
					try {
						server.send("hold"+"_"+myPoint.x+"_"+myPoint.y+"_"+choice);

					} catch (UnknownHostException ex) {
						ex.printStackTrace();
					}
				}
				if(client!=null){
					try {
						client.send("hold"+"_"+myPoint.x+"_"+myPoint.y+"_"+choice);
					} catch (UnknownHostException ex) {
						ex.printStackTrace();
					}
				}
			}else if(key == 50) {
				choice = MI;
				produceTroop(MI);
				if(server!=null){
					try {
						server.send("hold"+"_"+myPoint.x+"_"+myPoint.y+"_"+choice);
					} catch (UnknownHostException ex) {
						ex.printStackTrace();
					}
				}
				if(client!=null){
					try {
						client.send("hold"+"_"+myPoint.x+"_"+myPoint.y+"_"+choice);
					} catch (UnknownHostException ex) {
						ex.printStackTrace();
					}
				}
			}
		}
		if(key == KeyEvent.VK_Q){
			JOptionPane.showMessageDialog(frame,"中型城市，，可以招募普通步兵和机动步兵\n按1招募普通步兵，按2 招募机动步兵\n普通步兵花费：80金币； 机动步兵花费：110金币，50 工业值\n每回合产值：32金币，12工业值",null,1,new ImageIcon(image));
		}
    }

    public void paintSelf(Graphics g){
        super.paintSelf(g);
    }



    @Override
    public void produceTroop(int choice) {
    	boolean empty = true;
		for(TroopObject t:this.frame.getTroopsObjects()) {
			if(t.canClick(myPoint)) {
				empty = false;
			}
		}
		if(empty) {
			if(choice == NI) {
				if(this.frame.getNowResource().x>=80) {
					NormalInfantry newNI = new NormalInfantry(this.frame,this.myPoint,this.camp);
					this.frame.getTroopsObjects().add(newNI);
					this.frame.getNowResource().setX(this.frame.getNowResource().x - 80);
				}else {
					frame.getAddList().add(new Tip(frame,"资源不足，无法生产普通步兵",myPoint));
				}
			}else if(choice == MI) {
				if(this.frame.getNowResource().x>=110 && this.frame.getNowResource().y>=50) {
					MobileInfantry newMI = new MobileInfantry(this.frame,this.myPoint,this.camp);
					this.frame.getTroopsObjects().add(newMI);
					this.frame.getNowResource().setX(this.frame.getNowResource().x - 110);
					this.frame.getNowResource().setY(this.frame.getNowResource().y - 50);
				}else {
					frame.getAddList().add(new Tip(frame,"资源不足，无法生产机动步兵",myPoint));
				}
			}
		}else{
			frame.getAddList().add(new Tip(frame,"兵工厂内已经有作战单位，无法继续生产单位",myPoint));
		}
	}

}
