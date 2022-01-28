package little_game.planeWar.planeWar_5_6.obj;

import little_game.planeWar.planeWar_5_6.page.AbstractFrame;

import java.awt.*;

public class EnemyPlane3 extends EnemyPlane {
	public EnemyPlane3(Image image, int x, int y, int width, int height, AbstractFrame gameFrame) {
		super(image, x, y, width, height, gameFrame);
	}

	public void paintSelf(Graphics g) {
		super.paintSelf(g);

		int a = 5, b = 4;
		y += a;
		x -= b;
	}
}
