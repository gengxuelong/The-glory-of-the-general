package little_game.planeWar.planeWar_3_4.obj;

import little_game.planeWar.planeWar_3_4.page.AbstractFrame;

import java.awt.*;

public class PropP extends gameObject{
    /**
     * 构造函数，主要用于其子类的构造函数内部，用于给公共属性进行初始化
     *
     * @param image
     * @param x
     * @param y
     * @param width
     * @param height
     * @param gameFrame
     */
    int speed = 3;
    public PropP(Image image, int x, int y, int width, int height, AbstractFrame gameFrame) {
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
            this.gameFrame.getMyPlane().setModern(2);
            this.gameFrame.getRemoveList().add(this);
            x = -100;
        }
    }

}
