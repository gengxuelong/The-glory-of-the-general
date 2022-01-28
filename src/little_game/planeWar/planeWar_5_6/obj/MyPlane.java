package little_game.planeWar.planeWar_5_6.obj;

import little_game.planeWar.planeWar_5_6.page.AbstractFrame;
import little_game.planeWar.util.value;

import java.awt.*;

/**
 * 我方飞机类
 */
public class MyPlane extends gameObject{
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
        MyBullet bu = new MyBullet(value.myBullet,this.x+2,this.y,5,5,this.gameFrame);
        this.gameFrame.getAddList().add(bu);
    }

}
