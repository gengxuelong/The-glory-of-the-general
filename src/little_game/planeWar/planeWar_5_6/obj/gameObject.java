package little_game.planeWar.planeWar_5_6.obj;

import little_game.planeWar.planeWar_5_6.page.AbstractFrame;

import java.awt.*;

/**
 * @author:gengxuelong
 *
 * 这是游戏元素的基类，可以把所有游戏元素的共性写进这一个类里统一处理。由于他是基类，实际编码中不需要这种类的对象，
 * 所以尽量设置成接口或抽象的，更具规范性
 */
public abstract class gameObject {
    //每个游戏元素都需要有图片
    public Image image;
    //需要绘制的坐标值
    public int x;
    public int y;
    /**
     * 游戏面板属性，每个游戏元素都应该有这个属性，并且在新建对象时把所在游戏面板对其进行赋值。
     * 这会极大的利于在同一游戏面板中的游戏元素之间进行信息互动
     */
    public AbstractFrame gameFrame;
    //长宽
    public int width;
    public int height;

    /**
     *
     * 构造函数，主要用于其子类的构造函数内部，用于给公共属性进行初始化
     * @param image
     * @param x
     * @param y
     * @param width
     * @param height
     * @param gameFrame
     */
    public gameObject(Image image, int x, int y,int width, int height, AbstractFrame gameFrame) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.gameFrame = gameFrame;
        this.width = width;
        this.height = height;
    }

    /**
     * 绘制自己的函数。Java swing的绘制机制是：用那个“画板”的画笔绘画，就会绘画在哪个画板上。
     * 虽然绘制动作发生在游戏元素类的基类中，但绘画的位置至于传进来的画笔是谁的有关。为方便理解，将Java中的Graphics翻译为“画笔”
     * @param g
     */
    public void paintSelf(Graphics g){
        /*
        画笔通过drawImage 绘制图片，最后一个参数是“观察者”，不用深究其含义，把它设为null或graphics的主人（画板）
         */
        g.drawImage(image,x,y,width,height,gameFrame);
        if(y>this.gameFrame.getHeight()||y<0){
            this.gameFrame.getRemoveList().add(this);
        }
    }

    /*
    得到一个代表该游戏元素的矩形类，用于编码中的需要用到的碰撞检测得实现
     */
    public Rectangle getRec(){
        return new Rectangle(x,y,width,height);
    }


}
