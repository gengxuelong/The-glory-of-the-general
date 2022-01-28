package little_game.planeWar.planeWar_3_4.obj;

import little_game.planeWar.planeWar_3_4.page.AbstractFrame;

import java.awt.*;


/**
 * 我方子弹类
 */
public class MyBullet extends gameObject{
    public MyBullet(Image image, int x, int y, int width, int height, AbstractFrame gameFrame) {
        super(image, x, y, width, height, gameFrame);
    }
    public void paintSelf(Graphics g){
        super.paintSelf(g);
        y-=7;
        for(EnemyPlane enemyPlane : this.gameFrame.getEnemyList()) {
            if (this.getRec().intersects(enemyPlane.getRec())){
                //虽然把击中的飞机从绘制列表中移除，可是在敌机列表中还在，下次检测时还会检测到它，就出现了“空洞”，应该将其坐标移动到不碍事的位置
                Burst burst = new Burst(null,enemyPlane.x-15,enemyPlane.y-15,30,30,this.gameFrame);
                this.gameFrame.getAddList().add(burst);
                this.gameFrame.getRemoveList().add(this);
                this.gameFrame.getRemoveList().add(enemyPlane);
                enemyPlane.x = -100;
                this.gameFrame.setHitEnemyNum(this.gameFrame.getHitEnemyNum()+1);
            }
            if(this.getRec().intersects(this.gameFrame.getBoss_1().getRec())){
                this.gameFrame.getBoss_1().live -=1;
                this.gameFrame.getRemoveList().add(this);
                if(this.gameFrame.getBoss_1().live<10){
                    this.gameFrame.getRemoveList().add(this.gameFrame.getBoss_1());
                    Burst burst = new Burst(null,this.gameFrame.getBoss_1().x,this.gameFrame.getBoss_1().y,90,90,this.gameFrame);
                    this.gameFrame.getAddList().add(burst);
                    this.gameFrame.getBoss_1().x = -100;
                    this.gameFrame.setState(4);
                }
            }
        }
    }
}
