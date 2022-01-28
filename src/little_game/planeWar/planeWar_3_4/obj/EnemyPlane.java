package little_game.planeWar.planeWar_3_4.obj;

import little_game.planeWar.planeWar_3_4.page.AbstractFrame;

import java.awt.*;

/**
 * 敌方飞机类，因为敌方飞机不止一种，所以设置一个敌飞机基类类处理其公共的东西
 */
public  abstract class  EnemyPlane extends gameObject{
    public EnemyPlane(Image image, int x, int y, int width, int height, AbstractFrame gameFrame) {
        super(image, x, y, width, height, gameFrame);
    }
    public void paintSelf(Graphics g){
        super.paintSelf(g);
        if(this.getRec().intersects(this.gameFrame.getMyPlane().getRec())){
            this.gameFrame.setState(2);
        }
    }

}
