package little_game.planeWar.planeWar_1_2.obj;

import little_game.planeWar.planeWar_1_2.page.AbstractFrame;

import java.awt.*;

/**
 * 敌方子弹类
 */
public class EnemyBullet extends gameObject{
	
	private int spX;
	private int spY;
	
    public EnemyBullet(Image image, int x, int y, int width, int height, AbstractFrame gameFrame,int speedX,int speedY) {
        super(image, x, y, width, height, gameFrame);
        this.spX = speedX;
        this.spY = speedY;
    }
    public void paintSelf(Graphics g){
        super.paintSelf(g);
        y+=spY;
        x+=spX;
        if (this.getRec().intersects(this.gameFrame.getMyPlane().getRec())) {
            this.gameFrame.setState(2);
        }
    }
}
