package little_game.fiveChess.utils;
import utils.MyPoint;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @author: WenRui
 * @Date:2021/12/15
 */
public class util {

    public static final int QIPAN = 1;
    public static final int PIECE = 2;

    static public String path = "./resource/imageForFiveChess/";
    //得到图片函数
    public static Image creatImage(int kind, int num) {
        if (kind == QIPAN) {
            String tempPath = path + "qipan" + num + ".jpg";
            return Toolkit.getDefaultToolkit().createImage(tempPath);

        }
        if(kind == PIECE){
            String tempPath = path + "c" + num + ".png";
            return Toolkit.getDefaultToolkit().createImage(tempPath);

        }
        return null;
    }

    public static ImageIcon creatImageIcon(int kind, int i) {
        if (kind == QIPAN) {
            ImageIcon imageIcon = new ImageIcon(path + "qipan" + i + ".jpg");
            BufferedImage bi = new BufferedImage(200, 200, 1);//BufferedImage是抽象类Image的实现类
            {
                Graphics g = bi.createGraphics();
                /**
                 * 知识点，向bufferedImage上绘画图片时，只能用ImageIcon.getImage()所的得Image对象才行，直接用Image对象不行，
                 * 我也知道为什么，实践中就是这样
                 */
                g.drawImage(imageIcon.getImage(), 0, 0, 200, 200, null);
            }
            ImageIcon icon_1 = new ImageIcon(bi);
            return icon_1;
        } else if (kind == PIECE) {
            ImageIcon imageIcon = new ImageIcon(path + "c" + i + ".png");
            BufferedImage bi = new BufferedImage(200, 200, 1);
            {
                Graphics g = bi.createGraphics();
                g.drawImage(imageIcon.getImage(), 0, 0, 200, 200, null);
            }
            ImageIcon icon_1 = new ImageIcon(bi);
            return icon_1;
        }else{
            return null;
        }

    }


    /**
     * 获得以格子为计数单位的坐标
     * 长宽均为0--14，包含14
     * @return
     */
    public static MyPoint getGrid(int x, int y){
        int tempX = x/37;
        int tempY = y/37;//得到有几个整格子
        int chaY = y - tempY*37;
        int chaX = x -tempX*37;//得到不足一格的余数像素
        if(chaX<37/2){
            tempX=tempX;
        }else{
            tempX = tempX+1;
        }
        if(chaY <37/2){
            tempY = tempY;
        }else{
            tempY =tempY+1;
        }
        return new MyPoint(tempX,tempY);
    }


    /*
    利用biteMap判断相关位置是否有棋子
    有效提高了时间效率
     */
    public static int[] a = new int[15];
    public static int[] target = new int[15];
    static {
        for(int i=0;i<15;i++){
            a[i] = 1;
            target[i]=0;
        }
    }
     public static boolean isEmpty(MyPoint myPoint) {
        int x = myPoint.x;
        int y = myPoint.y;
        if ((a[x] << y & target[x]) == 0) {
            target[x] |= (a[x] << y);
            return true;
        } else {
            return false;
        }
    }

}
