package little_game.hitMouse.obj;

import little_game.hitMouse.page.MyFrame;
import utils.MyPoint;

import java.awt.*;

/**
 * @author: 彭烨
 *
 */
public class Obj {
    protected MyPoint myPoint;
    protected Image image;
    protected MyFrame myFrame;
    protected int width;
    protected int height;

    public void paintSelf(Graphics g){
        g.drawImage(image,myPoint.x-width/2,myPoint.y-height/2,width,height,myFrame);
    }
    public Rectangle getRec(){
        return new Rectangle(myPoint.x-width/2,myPoint.y-height/2,width,height);
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

    public MyPoint getMyPoint() {
        return myPoint;
    }

    public void setMyPoint(MyPoint myPoint) {
        this.myPoint = myPoint;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public MyFrame getMyFrame() {
        return myFrame;
    }

    public void setMyFrame(MyFrame myFrame) {
        this.myFrame = myFrame;
    }
}
