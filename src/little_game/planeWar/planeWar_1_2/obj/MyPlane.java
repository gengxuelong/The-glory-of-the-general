package little_game.planeWar.planeWar_1_2.obj;

import little_game.planeWar.planeWar_1_2.page.AbstractFrame;
import little_game.planeWar.util.value;

import java.awt.*;

/**
 * 我方飞机类
 */
public class MyPlane extends gameObject{
	
	int Basic = 0;//普通弹
	int Rapid = 1;//速射弹
	int Piercing = 2;//穿透弹
	int Shrapnel = 3;//散弹
	
	private int bullet = Basic;
	
    public MyPlane(Image image, int x, int y, int width, int height, AbstractFrame gameFrame) {
        super(image, x, y, width, height, gameFrame);
    }
    public void paintSelf(Graphics g){
        super.paintSelf(g);
        if(this.gameFrame.getCount()%10==0){
            attack();
        }
    }
    private void attack(){
        if(bullet == Basic) {
        	MyBullet bu = new MyBullet(value.myBullet,this.x+2,this.y,5,5,this.gameFrame,0,-7);
        	this.gameFrame.getAddList().add(bu);
        }else if(bullet == Rapid) {
        	MyBullet buONE = new MyBullet(value.myBullet,this.x+2,this.y,5,5,this.gameFrame,0,-7);
        	MyBullet buTWO = new MyBullet(value.myBullet,this.x+2,this.y-14,5,5,this.gameFrame,0,-7);
        	this.gameFrame.getAddList().add(buONE);
        	this.gameFrame.getAddList().add(buTWO);
        }else if(bullet == Shrapnel) {
        	MyBullet buONE = new MyBullet(value.myBullet,this.x+2,this.y,5,5,this.gameFrame,3,-7);
        	MyBullet buTWO = new MyBullet(value.myBullet,this.x+2,this.y,5,5,this.gameFrame,-3,-7);
        	MyBullet buTHREE = new MyBullet(value.myBullet,this.x+2,this.y,5,5,this.gameFrame,0,-7);
        	this.gameFrame.getAddList().add(buTHREE);
        	this.gameFrame.getAddList().add(buONE);
        	this.gameFrame.getAddList().add(buTWO);
        }else if(bullet == Piercing) {
        	PiercingBullet bu = new PiercingBullet(value.myBullet,this.x+2,this.y,5,5,this.gameFrame,0,-14);
        	this.gameFrame.getAddList().add(bu);
        }
    }
    
    public void setBullet(int bullet) {
    	this.bullet = bullet;
    }
}
