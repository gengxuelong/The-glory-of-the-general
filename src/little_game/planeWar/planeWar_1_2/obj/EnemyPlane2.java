package little_game.planeWar.planeWar_1_2.obj;

import little_game.planeWar.planeWar_1_2.page.AbstractFrame;


import java.awt.*;

public class EnemyPlane2 extends EnemyPlane{
    public EnemyPlane2(Image image, int x, int y, int width, int height, AbstractFrame gameFrame) {
        super(image, x, y, width, height, gameFrame);
    }
    public void paintSelf(Graphics g){
        super.paintSelf(g);
        y+= 5;
        x-=2;
    }
}
