package little_game.hitMouse.obj;

import little_game.hitMouse.page.MyFrame;
import little_game.hitMouse.utils.util;
import utils.MyPoint;

/**
 * @author: 彭烨
 *
 */
public class Mouse extends Obj{
    {
        image = util.mouse;
        width = 50;
        height = 70;
    }
    public Mouse(MyFrame frame, MyPoint point){
        this.myFrame = frame;
        this.myPoint = point;
    }
}
