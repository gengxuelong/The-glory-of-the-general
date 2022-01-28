package little_game.chineseChess.obj;

import little_game.chineseChess.page.GameFrame;
import utils.MyPoint;

import java.awt.*;

/**
 * @author: 王晓阳
 *
 */
public class BlueQizi extends Qizi {
    {
        camp = 2;
    }
    public void paintSelf(Graphics g){
        int x = gridMyPoint.x*70 -25;
        int y = gridMyPoint.y*61 - 25;
        if(isChoose){
            g.setColor(Color.BLUE);
            g.drawRect(x,y,50,50);
        }
        g.setColor(Color.YELLOW);
        g.fillOval(x,y,width,height);
        g.setColor(Color.PINK);
        g.drawOval(x,y,width,height);
        g.setColor(Color.blue);
        g.setFont(new Font(null, Font.BOLD,30));
        g.drawString(value,x+10,y+35);


    }


    public boolean isCanMove(MyPoint thePoint){
        int inX = thePoint.x;
        int inY = thePoint.y;
        int x = this.gridMyPoint.x;
        int y = this.gridMyPoint.y;
        for(Qizi qizi :frame.getQizis()){
           if( qizi.getGridMyPoint().equals(thePoint)){
                return false;
            }
        }
        if(inX<0||inX>8||inY<0||inY>9){
            return false;
        }
        switch(kind){
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                if(y >= 5){
                    if(Math.abs(inX - x)==1 ||inY-y == 1){
                        return true;
                    }
                }else{
                    if(inY-y == 1){
                        return true;
                    }
                }
                break;
            case 6:
            case 7:
            case 8:
            case 9:
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
                if(Math.abs(inX -x) == 1&& Math.abs(inY-y)==2||Math.abs(inX -x) == 2&& Math.abs(inY-y)==1){
                    return true;
                }
                break;
            case 12:
            case 13:
                if(inY<=4&&Math.abs(inX -x) == 2&& Math.abs(inY-y)==2){
                    return true;
                }
                break;
            case 14:
            case 15:
                if(x<=5&&x>=3&&y>=0&&y<=2){
                    if(Math.abs(inX - x)==1&&Math.abs(inY - y)==1){
                        return true;
                    }
                }
                break;
            case 16:
                if(x<=5&&x>=3&&y>=0&&y<=2){
                    if(x==inX && Math.abs(inY - y)==1||inY == y&& Math.abs(inX - x)==1){
                        return true;
                    }
                }
        }
        return false;
    }


    public boolean isObstacle(MyPoint point){



        return false;
    }
    public BlueQizi(GameFrame frame,MyPoint myPoint, int kind){
        this.frame = frame;
        this.gridMyPoint = myPoint;
        this.kind = kind;
        switch (this.kind){
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:value = "卒";break;
            case 6:
            case 7:value = "炮";break;
            case 8:
            case 9:value = "车";break;
            case 10:
            case 11:value = "马";break;
            case 12:
            case 13:value = "象";break;
            case 14:
            case 15:value = "士";break;
            case 16:value = "将";break;
            default:break;
        }
    }
    public BlueQizi(GameFrame frame,int kind){
        this.frame = frame;
        this.kind = kind;
        switch (kind){
            case 1:
                gridMyPoint = new MyPoint(0,3);break;
            case 2:
                gridMyPoint = new MyPoint(2,3);break;
            case 3:
                gridMyPoint = new MyPoint(4,3);break;
            case 4:
                gridMyPoint = new MyPoint(6,3);break;
            case 5:
                gridMyPoint = new MyPoint(8,3);break;

            case 6:
                gridMyPoint = new MyPoint(1,2);break;
            case 7:
                gridMyPoint = new MyPoint(7,2);break;

            case 8:
                gridMyPoint = new MyPoint(0,0);break;
            case 9:
                gridMyPoint = new MyPoint(8,0);break;
            case 10:
                gridMyPoint = new MyPoint(1,0);break;
            case 11:
                gridMyPoint = new MyPoint(7,0);break;

            case 12:
                gridMyPoint = new MyPoint(2,0);break;
            case 13:
                gridMyPoint = new MyPoint(6,0);break;

            case 14:
                gridMyPoint = new MyPoint(3,0);break;
            case 15:
                gridMyPoint = new MyPoint(5,0);break;

            case 16:
                gridMyPoint = new MyPoint(4,0);break;
            default:break;
        }

        switch (this.kind){
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:value = "卒";break;
            case 6:
            case 7:value = "炮";break;
            case 8:
            case 9:value = "车";break;
            case 10:
            case 11:value = "马";break;
            case 12:
            case 13:value = "象";break;
            case 14:
            case 15:value = "士";break;
            case 16:value = "将";break;
            default:break;
        }
    }


    private Qizi mySelf = this;

}
