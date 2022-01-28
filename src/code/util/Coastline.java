package code.util;

import utils.MyPoint;
import utils.implemetclass.MyLinkedList;

/**
 * This class is a basic class.
 *
 * @author lijie
 * @version 1.0
 */
public class Coastline {


    public static boolean CoastlineJudge(MyLinkedList<MyPoint> coastline,MyPoint myPoint){
        int x =myPoint.getX();
        int y =myPoint.getY();
        for(int i=0;i<(coastline.size()-1);i++){
            MyPoint tmp = coastline.get(i);
            if(x==tmp.getX()){
                if(y>tmp.getY()){
                    return true;
                }
                else return false;
            }
            if(x>tmp.getX()&&x<coastline.get(i+1).getX()){
                int k = (coastline.get(i+1).getY()-tmp.getY())/(coastline.get(i+1).getX()-tmp.getX());
                if(y<((x-tmp.getX())*k+tmp.getY())){
                    return true;
                }
                else return false;
            }
        }
        return false;
    }




}
