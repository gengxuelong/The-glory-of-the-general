package little_game.chineseChess.obj;

import little_game.chineseChess.page.GameFrame;
import utils.MyPoint;

import java.awt.*;

/**
 * @author: 王晓阳
 *
 */
public class RedQizi extends Qizi {

    {
        camp = 1;
    }
    public void paintSelf(Graphics g){
        int x = gridMyPoint.x*70 -25;
        int y = gridMyPoint.y*61 - 25;
        if(isChoose){
            g.setColor(Color.RED);
            g.drawRect(x,y,50,50);
        }
        g.setColor(Color.YELLOW);
        g.fillOval(x,y,width,height);
        g.setColor(Color.PINK);
        g.drawOval(x,y,width,height);
        g.setColor(Color.RED);
        g.setFont(new Font(null,1,30));
        g.drawString(value,x+10,y+35);
    }

    public boolean isCanMove(MyPoint gridMyPoint){
        int inX = gridMyPoint.x;
        int inY = gridMyPoint.y;
        int x = this.gridMyPoint.x;
        int y = this.gridMyPoint.y;
        switch(kind) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                if (y <= 4) {
                    if (Math.abs(inX - 1)==1||inY-y ==-1) {
                        return true;
                    }
                } else {
                    if (inY - y == -1) {
                        return true;
                    }
                }
                break;
            case 6:
            case 7://炮
            case 8:
            case 9://车
                if(inX == x){
                    boolean flag = true;
                    for(Qizi qizi :frame.getQizis()){
                        int tempX = qizi.getGridMyPoint().x;
                        int tempY = qizi.getGridMyPoint().y;
                        if(inY>y&&qizi!=this){
                            if(tempX == x && tempY>y&&tempY<inY){
                                flag = false;
                            }
                        }else if(inY <y&&qizi!=this){
                            if(tempX == x && tempY>inY&&tempY<y){
                                flag = false;
                            }
                        }
                    }
                    return flag;
                }else if(inY == y){
                    boolean flag = true;
                    for(Qizi qizi :frame.getQizis()){
                        int tempX = qizi.getGridMyPoint().x;
                        int tempY = qizi.getGridMyPoint().y;
                        if(inX >x){
                            if(tempY == y && tempX>x&&tempX<inX){
                                flag = false;
                            }
                        }else {
                            if(tempY == y && tempX>inX&&tempX<x){
                                flag = false;
                            }
                        }
                    }
                    return flag;
                }
                break;
            case 10:
            case 11:
                if (Math.abs(inX - x) == 1 && Math.abs(inY - y) == 2 || Math.abs(inX - x) == 2 && Math.abs(inY - y) == 1) {
                    return true;
                }
                break;
            case 12:
            case 13:
                if (inY >=5&&Math.abs(inX - x) == 2 && Math.abs(inY - y) == 2) {
                    return true;
                }
                break;
            case 14:
            case 15:
                if (x <= 5 && x >= 3 && y >= 7 && y <= 9) {
                    if (Math.abs(inX - x) == 1 && Math.abs(inY - y) == 1) {
                        return true;
                    }
                }
                break;
            case 16:
                if (x <= 5 && x >= 3 && y >= 7 && y <= 9) {
                    if (x == inX && Math.abs(inY - y) == 1 || inY == y && Math.abs(inX - x) == 1) {
                        return true;
                    }
                }
                break;
            default:break;
        }
        return false;
    }




    public RedQizi(GameFrame frame,MyPoint myPoint, int kind){
        this.frame = frame;
        this.gridMyPoint = myPoint;
        this.kind = kind;
        switch (this.kind){
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:value = "兵";break;
            case 6:
            case 7:value = "炮";break;
            case 8:
            case 9:value = "车";break;
            case 10:
            case 11:value = "马";break;
            case 12:
            case 13:value = "相";break;
            case 14:
            case 15:value = "士";break;
            case 16:value = "帅";break;
            default:break;
        }
    }
    public RedQizi(GameFrame frame,int kind){
        this.frame = frame;
        this.kind = kind;
        switch (kind){
            case 1:
                gridMyPoint = new MyPoint(0,6);break;
            case 2:
                gridMyPoint = new MyPoint(2,6);break;
            case 3:
                gridMyPoint = new MyPoint(4,6);break;
            case 4:
                gridMyPoint = new MyPoint(6,6);break;
            case 5:
                gridMyPoint = new MyPoint(8,6);break;

            case 6:
                gridMyPoint = new MyPoint(1,7);break;
            case 7:
                gridMyPoint = new MyPoint(7,7);break;

            case 8:
                gridMyPoint = new MyPoint(0,9);break;
            case 9:
                gridMyPoint = new MyPoint(8,9);break;

            case 10:
                gridMyPoint = new MyPoint(1,9);break;
            case 11:
                gridMyPoint = new MyPoint(7,9);break;

            case 12:
                gridMyPoint = new MyPoint(2,9);break;
            case 13:
                gridMyPoint = new MyPoint(6,9);break;

            case 14:
                gridMyPoint = new MyPoint(3,9);break;
            case 15:
                gridMyPoint = new MyPoint(5,9);break;

            case 16:
                gridMyPoint = new MyPoint(4,9);break;
            default:break;
        }

        switch (this.kind){
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:value = "兵";break;
            case 6:
            case 7:value = "炮";break;
            case 8:
            case 9:value = "车";break;
            case 10:
            case 11:value = "马";break;
            case 12:
            case 13:value = "相";break;
            case 14:
            case 15:value = "士";break;
            case 16:value = "帅";break;
            default:break;
        }
    }

}
