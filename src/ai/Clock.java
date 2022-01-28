package ai;

import javax.swing.*;
import java.awt.*;

/**
 * 人机模式中，ai行动时播放的过场动画
 * @author lijie
 * @Date 2021/12/21 23:30
 */
public class Clock extends JFrame {
    Clock mySelf = this;
    public  Clock(){
        //frame
        this.setSize(400,400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("AI正在急速运行");
        this.setVisible(true);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(size >0){
                    repaint();
                    try {
                        Thread.sleep(166);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                mySelf.dispose();
            }
        }).start();
    }
    private Image cache;
    private int size = 300;
    public void paint(Graphics g){//动画演出效果为多个同心圆由外向内收
        if(cache==null){
            cache = createImage(400,400);
        }
        Graphics gImage = cache.getGraphics();
        gImage.drawOval(200-size/2,200-size/2,size,size);
        size -=10;
        g.drawImage(cache,0,0,null);
    }

}
