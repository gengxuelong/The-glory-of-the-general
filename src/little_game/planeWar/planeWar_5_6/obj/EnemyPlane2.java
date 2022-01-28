package little_game.planeWar.planeWar_5_6.obj;

import little_game.planeWar.planeWar_5_6.page.AbstractFrame;

import java.awt.*;
import java.util.Random;

public class EnemyPlane2 extends EnemyPlane {
	public EnemyPlane2(Image image, int x, int y, int width, int height, AbstractFrame gameFrame) {
		super(image, x, y, width, height, gameFrame);
	}

	public void paintSelf(Graphics g) {
		super.paintSelf(g);
		int a = 7, b = 2;
		Random r = new Random();

		y += a;
		x -= b;
	}
}
