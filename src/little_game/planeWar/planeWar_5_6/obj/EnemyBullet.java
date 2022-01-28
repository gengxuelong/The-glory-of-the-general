package little_game.planeWar.planeWar_5_6.obj;

import little_game.planeWar.planeWar_5_6.page.AbstractFrame;

import java.awt.*;

/**
 * 敌方子弹类
 */
public class EnemyBullet extends gameObject {

	private int shootspeed = 11;

	public EnemyBullet(Image image, int x, int y, int width, int height, AbstractFrame gameFrame) {
		super(image, x, y, width, height, gameFrame);
	}

	public void paintSelf(Graphics g) {
		super.paintSelf(g);
		y += shootspeed;
		if (this.getRec().intersects(this.gameFrame.getMyPlane().getRec())) {
			this.gameFrame.setState(2);
		}
	}

	public void setShootSpeed(int x) {
		this.shootspeed = x;
	}
}
