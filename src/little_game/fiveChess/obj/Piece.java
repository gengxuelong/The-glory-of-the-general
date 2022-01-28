package little_game.fiveChess.obj;


import little_game.fiveChess.page.MyFrame;
import little_game.fiveChess.utils.util;
import utils.MyPoint;

import java.awt.Image;
import java.awt.Graphics;

/**
 * @author: WenRui
 * @Date:2021/12/15
 */
public class Piece extends obj {
    MyPoint gridMyPoint;
    Image image;
    int size = 34;
    MyFrame myFrame;

    public Piece(MyPoint gridMyPoint, MyFrame myFrame, int kind) {
        Image imageWhite = util.creatImage(util.PIECE,myFrame.num2);
        Image imageBlack = util.creatImage(util.PIECE,myFrame.num3);
        this.gridMyPoint = gridMyPoint;
        this.myFrame = myFrame;
        switch(kind){
            case 1:image = imageWhite;break;
            case 2:image = imageBlack;break;
            default:break;
        }
    }

    public void paintSelf(Graphics g){
        MyPoint myPoint = getThePoint();
        g.drawImage(image, myPoint.x, myPoint.y, size,size,myFrame);
    }

    public MyPoint getThePoint(){

        int tempX = gridMyPoint.x;
        int tempY = gridMyPoint.y;
        int resX = tempX*37-12;
        int resY = tempY*37-14;
        return new MyPoint(resX,resY);
    }//得到paintSelf需要的起始位置
}
