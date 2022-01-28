package code.Element.footHold;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.net.UnknownHostException;

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
public class SmallCity extends City{


	
	int choice;
	
	public SmallCity(MyPoint point, int temp) {
		super(point, temp);

		this.image = values.SmallCity;
		this.gold = 20;
		this.iron = 5;
	}
	
    @Override
    public void keyPressed(KeyEvent e) {
    	int key = e.getKeyCode();
    	if(frame.getNowCamp()==camp)
			if(key == KeyEvent.VK_1) {
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
			}
		if(key == KeyEvent.VK_Q){
			JOptionPane.showMessageDialog(frame,"小型城市，，可以招募普通步兵\n按1招募普通步兵\n普通步兵花费：80金币\n每回合产值：20金币，5工业值",null,1,new ImageIcon(image));
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
			}
		}else{
			frame.getAddList().add(new Tip(frame,"兵工厂内已经有作战单位，无法继续生产单位",myPoint));
		}
	}

}
