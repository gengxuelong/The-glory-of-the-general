package little_game.planeWar.planeWar_3_4.obj;

import little_game.planeWar.planeWar_3_4.page.AbstractFrame;
import little_game.planeWar.util.value;

import java.awt.*;

/**
 * 我方飞机类
 */
public class MyPlane extends gameObject{

    int modern =1 ;
    public MyPlane(Image image, int x, int y, int width, int height, AbstractFrame gameFrame) {
        super(image, x, y, width, height, gameFrame);
    }
    public void paintSelf(Graphics g){
        super.paintSelf(g);
        if(this.gameFrame.getCount()%10==0){
            if(modern==1)attack();
            if(modern==2)pAttack();
        }
    }
    private void attack(){
        MyBullet bu = new MyBullet(value.myBullet,this.x+2,this.y,5,5,this.gameFrame);
        this.gameFrame.getAddList().add(bu);
    }

    private void pAttack(){
        MyBullet bullet_1 = new MyBullet_1(value.myBullet,this.x-2,this.y,8,8,this.gameFrame);
        this.gameFrame.getAddList().add(bullet_1);
        MyBullet bullet_2 = new MyBullet(value.myBullet,this.x,this.y,8,8,this.gameFrame);
        this.gameFrame.getAddList().add(bullet_2);
        MyBullet bullet_3 = new MyBullet_2(value.myBullet,this.x+2,this.y,8,8,this.gameFrame);
        this.gameFrame.getAddList().add(bullet_3);

    }


    public void setModern(int modern){
        this.modern = modern;
    }

    public int getModern(){
        return this.modern;
    }


}
