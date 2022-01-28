package little_game.chineseChess.utils;

import utils.MyPoint;

/**
 * @author: gengxuelong
 * @Date:2021/12/8 2:17
 */
public class util {
    public static MyPoint getGridMyPoint(int x, int y){
        int gridX = x/70;
        int gridY = y/61;
        int yuX = x - gridX*70;
        int yuY = y - gridY*61;
        if(yuX<70/2){
            gridX = gridX;
        }else{
            gridX += 1;
        }
        if(yuY<61/2){
            gridY = gridY;
        }else{
            gridY+=1;
        }
        MyPoint myPoint = new MyPoint(gridX,gridY);
        return myPoint;
    }
}

