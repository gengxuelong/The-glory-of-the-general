package little_game.planeWar.planeWar_3_4.obj;

import little_game.planeWar.planeWar_3_4.page.AbstractFrame;

import java.awt.*;

/**
 * 这个类其实是充当背景的一切队形的概括，其唯一的功能就是以某个速度向下移动，以营造出我放飞机在前进的效果
 * 它需要单独有一个绘制列表，绘制时先绘制它，在绘制主元素列表，可以确保背景不会遮挡主元素
 */
public class Stone extends gameObject {
    public Stone(Image image, int x, int y, int width, int height, AbstractFrame gameFrame) {
        super(image, x, y, width, height, gameFrame);
    }
    public void paintSelf(Graphics g){
        super.paintSelf(g);
        y+=3;
    }
}

