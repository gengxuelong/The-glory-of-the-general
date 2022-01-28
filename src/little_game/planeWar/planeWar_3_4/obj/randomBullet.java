package little_game.planeWar.planeWar_3_4.obj;

import little_game.planeWar.planeWar_3_4.Math.Vector;


import little_game.planeWar.planeWar_3_4.page.AbstractFrame;

import java.awt.*;
import java.util.Random;

/**
 * This class is a basic class.
 *
 * @author lijie
 * @version 1.0
 */
public class randomBullet extends gameObject {

//    Vector acceleration;
    Vector speed;
    int life;
    int time=0;


    public randomBullet(Image image, int x, int y, int width, int height, AbstractFrame gameFrame, Vector speed, int life) {
        super(image, x, y, width, height, gameFrame);
        this.speed = speed;
        this.life = life;
    }

    public void paintSelf(Graphics g) {
        super.paintSelf(g);
        x += (int)speed.getX()/2;
        y += (int)speed.getY()/2;
//        speed.add(acceleration);
        if(time%100 ==0) {
            Random r = new Random();
            boolean a=r.nextBoolean();
            if(a){speed.setX(r.nextInt(5)+5);}
            else speed.setX(-(r.nextInt(5)+5));
            speed.setY(r.nextInt(10));
        }
        time++;
        if (this.getRec().intersects(this.gameFrame.getMyPlane().getRec())) {
            this.gameFrame.setState(2);
        }
        if(time>=life){
            this.gameFrame.getRemoveList().add(this);
            x = -100;
        }

    }

}
