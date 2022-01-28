package little_game.hitMouse.utils;

import utils.MyPoint;
import utils.implemetclass.MyLinkedList;
import utils.inteface.MyList;

/**
 * @author: 彭烨
 */
public class Data {
    public final static MyList<MyPoint>  pointList = new MyLinkedList<>();
    static{
        pointList.add(new MyPoint(689,408));
        pointList.add(new MyPoint(345,435));
        pointList.add(new MyPoint(160,563));
        pointList.add(new MyPoint(544,527));
        pointList.add(new MyPoint(775,613));
        pointList.add(new MyPoint(1061,536));
        pointList.add(new MyPoint(1051,430));
    }
}
