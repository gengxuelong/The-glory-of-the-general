package little_game.fiveChess.obj;

import little_game.fiveChess.page.MyFrame;
import little_game.fiveChess.utils.util;

import java.awt.*;

/**
 * @author: WenRui
 * @Date:2021/12/15
 */
public class ChessBoard  extends obj {
    int num;
    Image image;
    int x = -37;
    int y = -40;
    int size = 600;
    MyFrame myFrame;


    public ChessBoard(int num, MyFrame myFrame) {
        this.num = num;
        this.myFrame = myFrame;
        image = util.creatImage(util.QIPAN, num);
    }

    public void paintSelf(Graphics g) {
        g.drawImage(image, x, y, size, size, myFrame);
    }
}
