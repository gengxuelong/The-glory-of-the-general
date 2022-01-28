package little_game.planeWar.util;

import java.awt.*;

public class value {

    /**
     * 获取图片的方式，把图片变成Image类对象才可以操作，只需要掌握一种获得图片对象的方式即可，这是我认为最简单方便的
     *
     * 根据你具体把图片文件放到哪里，仅更改path的值即可。"./"代表当前工作空间(我用的是idea，在eclipse指的是啥不太了解）
     */
    public static String path = "./resource/imageForPlane/";
    public static Image myPlane = Toolkit.getDefaultToolkit().createImage(path+"this.gif");
    public static Image boss1 = Toolkit.getDefaultToolkit().createImage(path+"bossA.gif");
    public static Image boss2 = Toolkit.getDefaultToolkit().createImage(path+"bossB.gif");
    public static Image boss3 = Toolkit.getDefaultToolkit().createImage(path+"bossC.gif");
    public static Image enemy1 = Toolkit.getDefaultToolkit().createImage(path+"enemyA.gif");
    public static Image enemy2 = Toolkit.getDefaultToolkit().createImage(path+"enemyB.gif");
    public static Image enemy3 = Toolkit.getDefaultToolkit().createImage(path+"enemyC.gif");
    public static Image enemy4 = Toolkit.getDefaultToolkit().createImage(path+"enemyD.gif");
    public static Image myBullet = Toolkit.getDefaultToolkit().createImage(path+"ballSilver.gif");
    public static Image shell_red = Toolkit.getDefaultToolkit().createImage(path+"ballRed.gif");
    public static Image shell_green = Toolkit.getDefaultToolkit().createImage(path+"ballGreen.gif");
    public static Image shell_blue = Toolkit.getDefaultToolkit().createImage(path+"ballBlue.gif");
    public static Image shell_B_1 = Toolkit.getDefaultToolkit().createImage(path+"beam2.gif");
    public static Image shell_B_2 = Toolkit.getDefaultToolkit().createImage(path+"beam3.gif");
    public static Image stone = Toolkit.getDefaultToolkit().createImage(path+"stone.jpg");
    public static Image entryBeijing = Toolkit.getDefaultToolkit().createImage(path+"beijing.jpeg");
    public static Image entryBeijing_2 = Toolkit.getDefaultToolkit().createImage(path+"entryBeijing.jpg");




    public static void fillWord(Graphics g,String word,Color color,int x,int y,int size){
        g.setColor(color);
        g.setFont(new Font(null,Font.BOLD,size));
        g.drawString(word,x,y);
    }
}
