package little_game.planeWar.planeWar_1_2.obj;

import little_game.planeWar.planeWar_1_2.page.AbstractFrame;
import little_game.planeWar.util.value;

import java.awt.*;

/**
 * 爆炸类的编写
 *
 */
public class Burst extends gameObject{


    /**
     * 每个爆炸类的对象只有在刚生成的一段时间可展示图片，既所有的爆炸类对象都是一次性的
     */
    static Image[] images = new Image[7];
     static{
         for(int i= 0;i<7;i++){
             Image image = Toolkit.getDefaultToolkit().createImage(value.path+"largeBurst"+i+".gif");
             images[i] = image;
         }
     }
     private int burstCount = 0;//统计该对象的绘制次数，超过某数量便不再绘制并将其从绘制列表中移除
    public Burst(Image image, int x, int y, int width, int height, AbstractFrame gameFrame) {
        super(image, x, y, width, height, gameFrame);
    }
    public void paintSelf(Graphics g){
        if(burstCount<7){
            g.drawImage(images[burstCount],x,y,null);
            burstCount++;
        }
        if(burstCount>=7){
            this.gameFrame.getRemoveList().add(this);
        }
    }

}
