package little_game.planeWar.planeWar_5_6.obj;

import little_game.planeWar.planeWar_5_6.page.AbstractFrame;

import java.awt.*;

public class EnemyPlane1 extends EnemyPlane {
	public EnemyPlane1(Image image, int x, int y, int width, int height, AbstractFrame gameFrame) {
		super(image, x, y, width, height, gameFrame);
	}

	public void paintSelf(Graphics g) {
		super.paintSelf(g);
		int a = 6, b = 3;

		y += a;
		x += b;
	}
}
