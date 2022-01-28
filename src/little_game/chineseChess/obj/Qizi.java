package little_game.chineseChess.obj;

import little_game.chineseChess.page.GameFrame;
import little_game.chineseChess.utils.Tip;
import utils.MyPoint;

import java.awt.*;

/**
 * @author: 王晓阳
 *
 */
public abstract class Qizi {
    protected int camp;//阵营
    protected MyPoint gridMyPoint;//以格子为单位的坐标位置
    protected int width = 50;
    protected int height = 50;
    protected String value;//名称
    protected int kind;//兵种
    protected boolean isChoose = false;//是否被选中
    protected GameFrame frame;

    public abstract boolean isCanMove(MyPoint gridMyPoint);//初步判断

    public boolean isCanEat(Qizi qizi) {
        if (kind != 6 && kind != 7) {

            if(this.isCanRealMove(qizi.getGridMyPoint())){
                return this.camp != qizi.camp;
            }
        }else{

            int count= 0;
            int x = this.gridMyPoint.x;
            int y = this.gridMyPoint.y;
            int inX = qizi.getGridMyPoint().x;
            int inY = qizi.getGridMyPoint().y;
            if(inX == x){
                boolean flag = true;
                for(Qizi qz :frame.getQizis()){
                    int tempX = qz.getGridMyPoint().x;
                    int tempY = qz.getGridMyPoint().y;
                    if(inY>y&&qz!=this){
                        if(tempX == x && tempY>y&&tempY<inY){
                            count++;
                        }
                    }else if(inY <y&&qz!=this){
                        if(tempX == x && tempY>inY&&tempY<y){
                            count++;
                        }
                    }
                }
            }else if(inY == y){
                boolean flag = true;
                for(Qizi qz :frame.getQizis()){
                    int tempX = qz.getGridMyPoint().x;
                    int tempY = qz.getGridMyPoint().y;
                    if(inX >x){
                        if(tempY == y && tempX>x&&tempX<inX){
                            count++;
                        }
                    }else {
                        if(tempY == y && tempX>inX&&tempX<x){
                            count++;
                        }
                    }
                }
            }

            if(count==1){
                return true;
            }
        }

        return false;
    }

    public boolean isCanRealMove(MyPoint gridMyPoint){//带羁绊的判断
        if(isCanMove(gridMyPoint)){
            if(kind==12||kind==13){
                MyPoint myPoint = getGridMyPoint();
                if(myPoint.x- gridMyPoint.x>0&&myPoint.y-gridMyPoint.y>0){
                    MyPoint point1 = new MyPoint(gridMyPoint.x-1,gridMyPoint.y-1);
                    for(Qizi qizi : frame.getQizis()){
                        MyPoint temp = qizi.getGridMyPoint();
                        if(temp .equals(point1)){
                            frame.getAddList().add(new Tip(frame,"行动有羁绊",gridMyPoint));
                            return false;
                        }
                    }
                }
                if(myPoint.x- gridMyPoint.x<0&&myPoint.y-gridMyPoint.y<0){
                    MyPoint point1 = new MyPoint(gridMyPoint.x+1,gridMyPoint.y+1);
                    for(Qizi qizi : frame.getQizis()){
                        MyPoint temp = qizi.getGridMyPoint();
                        if(temp .equals(point1)){
                            frame.getAddList().add(new Tip(frame,"行动有羁绊",gridMyPoint));
                            return false;
                        }
                    }
                }if(myPoint.x- gridMyPoint.x>0&&myPoint.y-gridMyPoint.y<0){
                    MyPoint point1 = new MyPoint(gridMyPoint.x-1,gridMyPoint.y+1);
                    for(Qizi qizi : frame.getQizis()){
                        MyPoint temp = qizi.getGridMyPoint();
                        if(temp .equals(point1)){
                            frame.getAddList().add(new Tip(frame,"行动有羁绊",gridMyPoint));
                            return false;
                        }
                    }
                }if(myPoint.x- gridMyPoint.x<0&&myPoint.y-gridMyPoint.y>0){
                    MyPoint point1 = new MyPoint(gridMyPoint.x+1,gridMyPoint.y-1);
                    for(Qizi qizi : frame.getQizis()){
                        MyPoint temp = qizi.getGridMyPoint();
                        if(temp .equals(point1)){
                            frame.getAddList().add(new Tip(frame,"行动有羁绊",gridMyPoint));
                            return false;
                        }
                    }
                }
            }
            if(kind==10||kind==11){
                MyPoint myPoint = getGridMyPoint();
                if(myPoint.x-gridMyPoint.x==2){
                    MyPoint point1 = new MyPoint(myPoint.x-1,myPoint.y);
                    for(Qizi qizi : frame.getQizis()){
                        MyPoint temp = qizi.getGridMyPoint();
                        if(temp .equals(point1)){
                            frame.getAddList().add(new Tip(frame,"行动有羁绊",gridMyPoint));
                            return false;
                        }
                    }
                }
                if(myPoint.x-gridMyPoint.x==-2){
                    MyPoint point1 = new MyPoint(myPoint.x+1,myPoint.y);
                    for(Qizi qizi : frame.getQizis()){
                        MyPoint temp = qizi.getGridMyPoint();
                        if(temp .equals(point1)){
                            frame.getAddList().add(new Tip(frame,"行动有羁绊",gridMyPoint));
                            return false;
                        }
                    }
                }
                if(myPoint.y-gridMyPoint.y==2){
                    MyPoint point1 = new MyPoint(myPoint.x,myPoint.y-1);
                    for(Qizi qizi : frame.getQizis()){
                        MyPoint temp = qizi.getGridMyPoint();
                        if(temp .equals(point1)){
                            frame.getAddList().add(new Tip(frame,"行动有羁绊",gridMyPoint));
                            return false;
                        }
                    }
                }
                if(myPoint.y-gridMyPoint.x==-2){
                    MyPoint point1 = new MyPoint(myPoint.x,myPoint.y+1);
                    for(Qizi qizi : frame.getQizis()){
                        MyPoint temp = qizi.getGridMyPoint();
                        if(temp .equals(point1)){
                            frame.getAddList().add(new Tip(frame,"行动有羁绊",gridMyPoint));
                            return false;
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    /*
    具体的动作
     */
    public boolean move(MyPoint gridMyPoint){
        if (isCanRealMove(gridMyPoint)) {
            this.setGridMyPoint(gridMyPoint);
            return true;
        }
        return false;
    }
    public boolean eat(Qizi qizi){

        if(this.isCanEat(qizi)){
            frame.getAddList().add(new Tip(frame,"吃",qizi.gridMyPoint));
            frame.getRemoveList().add(qizi);
            this.setGridMyPoint(qizi.gridMyPoint);
            if(qizi.getKind()==16){
                if(this.camp == 1)
                    frame.getAddList().add(new Tip(frame,"红方获胜",new MyPoint(5,5)));
                else
                    frame.getAddList().add(new Tip(frame,"蓝方获胜",new MyPoint(5,5)));

            }
            return true;
        }
        return false;
    }

    public abstract void paintSelf(Graphics g);





    public MyPoint getGridMyPoint() {
        return gridMyPoint;
    }

    public void setGridMyPoint(MyPoint gridMyPoint) {
        this.gridMyPoint = gridMyPoint;
    }

    public boolean isChoose() {
        return isChoose;
    }

    public void setChoose(boolean choose) {
        isChoose = choose;
    }

    public int getCamp() {
        return camp;
    }

    public void setCamp(int camp) {
        this.camp = camp;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getKind() {
        return kind;
    }

    public void setKind(int kind) {
        this.kind = kind;
    }

    public GameFrame getFrame() {
        return frame;
    }

    public void setFrame(GameFrame fame) {
        this.frame = fame;
    }
}
