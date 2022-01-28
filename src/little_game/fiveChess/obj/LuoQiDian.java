package little_game.fiveChess.obj;


import little_game.fiveChess.page.MyFrame;
import utils.MyPoint;

import java.awt.*;

/**
 * @author: WenRui
 * @Date:2021/12/15 
 */
public class LuoQiDian extends obj implements Comparable<LuoQiDian>{

    public MyPoint gridMyPoint;
    public int count = 0;
    private int kind = 0;//1代表白子，2代表黑子，0代表没有子
    public Piece piece;
    public MyFrame myFrame;



    public LuoQiDian(MyPoint gridMyPoint, MyFrame f){
        this.gridMyPoint = gridMyPoint;
        myFrame = f;
    }

    public int getKind() {
        return kind;
    }

    public void setKind(int kind) {
        this.kind = kind;
        piece = new Piece(gridMyPoint,myFrame,kind);
        myFrame.AI.calculateTheCount();
        if(isWin()){
            if(kind == 1)
                myFrame.state = 1;
            if(kind ==2){
                myFrame.state = 2;
            }
        }
    }

    @Override
    public void paintSelf(Graphics g) {
        if(piece != null){
            piece.paintSelf(g);
        }

    }


    @Override
    public int compareTo(LuoQiDian o) {
        if(this.count > o.count)return 1;
        else if(this.count<o.count)return -1;
        else return 0;
    }

    public boolean isWin(){
        MyPoint p = gridMyPoint;
        int x = p.x;
        int y = p.y;
        int count_x = 0;
        int count_y = 0;
        int count_up = 0;
        int count_down = 0;


        //判断y方向
        for(int run = 0;run < 5;run ++){
            count_y =0;
            for(int i = -4+run; i<= 0+run;i++){
                int temp_y = y+i;
                if(temp_y >= 0){
                    MyPoint pp = new MyPoint(x,y);//必须新建一个对象，仅仅新建一个引用指向老的point最终的处理仍然会影响到老point
                    pp.y = temp_y;
                    if(isHadFiend(pp)){//isEmpty 是判断后“有责改善无则加勉”，，，，
                        count_y++;
                    }
                }
            }
            if (count_y == 5) {
                break;
            }
        }

        //判断x方向
        for(int run = 0;run < 5;run ++){
            count_x =0;
            for(int i = -4+run; i<= 0+run;i++){
                int temp_x = x+i;
                if(temp_x >= 0){
                    MyPoint pp = new MyPoint(x,y);
                    pp.x = temp_x;
                    if(isHadFiend(pp)){//isEmpty 是判断后“有责改善无则加勉”，，，，
                        count_x++;
                    }
                }
            }
            if (count_x == 5) {
                break;
            }

        }

        //判断down方向
        for(int run = 0;run < 5;run ++){
            count_down =0;
            for(int i = -4+run; i<= 0+run;i++){
                int temp_y = y+i;
                int temp_x = x+i;
                if(temp_y >= 0&&temp_x>=0){
                    MyPoint pp = new MyPoint(x,y);
                    pp.y = temp_y;
                    pp.x = temp_x;
                    if(isHadFiend(pp)){//isEmpty 是判断后“有责改善无则加勉”，，，，
                        count_down++;
                    }
                }
            }
            if (count_down == 5) {
                break;
            }

        }

        //判断up方向
        for(int run = 0;run < 5;run ++){
            count_up =0;
            for(int i = -4+run; i<= 0+run;i++){
                int temp_y = y+i;
                int temp_x = x-i;
                if(temp_y >= 0&&temp_x>=0){
                    MyPoint pp = new MyPoint(x,y);
                    pp.y = temp_y;
                    pp.x = temp_x;
                    if(isHadFiend(pp)){//isEmpty 是判断后“有责改善无则加勉”，，，，
                        count_up++;
                    }
                }
            }
            if (count_up == 5) {
                break;
            }

        }
        if(count_y ==5 ||count_x ==5 ||count_down ==5 ||count_up ==5){
            return true;
        }else{
            return false;
        }

    }

    public Boolean isHadFiend(MyPoint p){
        int x = p.x;
        int y = p.y;
        if(x >= 15||y>=15)return false;
        LuoQiDian[][] luoQiDians = myFrame.luoQiDians;
        int tempKind = luoQiDians[y][x].kind;
        if(tempKind==0){
            return false;
        }else{
            if(tempKind==kind){
                return true;
            }
            return false;
        }
    }
}
