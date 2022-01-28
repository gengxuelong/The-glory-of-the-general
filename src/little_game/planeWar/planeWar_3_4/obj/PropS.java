package little_game.planeWar.planeWar_3_4.obj;

import little_game.planeWar.planeWar_3_4.page.AbstractFrame;

import java.awt.*;

/**
 * This class is a basic class.
 *
 * @author lijie
 * @version 1.0
 */
public class PropS extends gameObject{
    int speed = 3;
    public PropS(Image image, int x, int y, int width, int height, AbstractFrame gameFrame) {
        super(image, x, y, width, height, gameFrame);
    }

    public void paintSelf(Graphics g){
        super.paintSelf(g);
        y += 7;
        if(x>this.gameFrame.getWidth()-50||x<0){
            speed = -speed;
        }
        x +=speed;

        if (this.getRec().intersects(this.gameFrame.getMyPlane().getRec())) {
            this.gameFrame.getMyPlane().setModern(3);
            this.gameFrame.getRemoveList().add(this);
            x = -100;
        }
    }


}
