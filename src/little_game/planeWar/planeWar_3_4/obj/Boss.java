package little_game.planeWar.planeWar_3_4.obj;

import little_game.planeWar.planeWar_3_4.Math.Vector;
import little_game.planeWar.planeWar_3_4.page.AbstractFrame;
import little_game.planeWar.util.value;

import java.awt.*;
import java.util.Random;

public class Boss extends gameObject {
    public int live = 500;
    public int speed = 5;
    public Boss(Image image, int x, int y, int width, int height, AbstractFrame gameFrame) {
        super(image, x, y, width, height, gameFrame);
    }

    /**
     * 重写paintSelf方法，在基础绘制功能的基础上，添加一些其他和绘制无关的动作，因为JavaSwing游戏只要靠每几十毫秒重绘一次才实现动画“假象”的；
     * 所以如果某个动作需要时刻执行，则放进paintself里面
     *
     * @param g
     */
    public void paintSelf(Graphics g){
        super.paintSelf(g);//实现基础功能
        /*
        运动的实现：每25毫秒移动若干像素
         */
        x+=speed;
        if(x<400)speed=+5;
        if(x>800)speed=-5;

        /*
        每隔一段时间攻击一次
         */
        if(this.gameFrame.getCount()%80==0){
            attack_1();
        }

//        if(this.gameFrame.getCount()%200==10){
//            attack_2();
//        }
//        if(this.gameFrame.getCount()%200==30){
//            attack_2();
//        }
//        if(this.gameFrame.getCount()%200==50){
//            attack_2();
//        }
//        if(this.gameFrame.getCount()%200==70){
//            attack_2();
//        }


//        if(this.gameFrame.getCount()%400==10){
//            attack_3();
//        }
//        if(this.gameFrame.getCount()%400==30){
//            attack_3();
//        }
//        if(this.gameFrame.getCount()%400==50){
//            attack_3();
//        }
//        if(this.gameFrame.getCount()%400==70){
//            attack_3();
//        }

//        if(live<=1000){//行动逻辑2
//            if(this.gameFrame.getCount()%300==20){
//                attack_4();
//            }
//            if(this.gameFrame.getCount()%300==40){
//                attack_4();
//            }
//            if(this.gameFrame.getCount()%300==60){
//                attack_4();
//            }
//
//            if(this.gameFrame.getCount()%300==80){
//                attack_5();
//            }
//            if(this.gameFrame.getCount()%300==100){
//                attack_5();
//            }
//            if(this.gameFrame.getCount()%300==120){
//                attack_5();
//            }
//
//            if(this.gameFrame.getCount()%100==0){
//                attack_6();
//            }
//            if(this.gameFrame.getCount()%100==5){
//                attack_6();
//            }
//            if(this.gameFrame.getCount()%100==10){
//                attack_6();
//            }
//            if(this.gameFrame.getCount()%100==15){
//                attack_6();
//            }
//            if(this.gameFrame.getCount()%100==20){
//                attack_6();
//            }
//            if(this.gameFrame.getCount()%100==25){
//                attack_6();
//            }
//            if(this.gameFrame.getCount()%100==30){
//                attack_6();
//            }



//        }

        /*
        碰撞检测的实现，同时体现了在同一面板中不同元素之间借助gameFrame属性的信息互动
        矩形类的intersects方法是用来实现碰撞检测的
         */
        if(this.getRec().intersects(this.gameFrame.getMyPlane().getRec())){
            this.gameFrame.setState(2);
        }
    }


    /**
     * 攻击函数的实现
     */
    private void attack_1(){
        /*
        生成一个敌人子弹类的对象，并将其放入待添加列表中，主面板有一个元素列表和待添加列表和待删除列表。元素列表每25毫秒遍历并逐一绘制一遍
        之所以不能直接删除或添加，是因为在遍历某个列表时，不能对该列表的元素个数进行更改，否则会报错
         */
        Bullet bu_1 = new Bullet(value.shell_B_1,this.x-60,this.y+20,5,5,this.gameFrame,new Vector(-9,6),2000);
        this.gameFrame.getAddList().add(bu_1);
        Bullet bu_2 = new Bullet(value.shell_B_1,this.x-30,this.y+40,5,5,this.gameFrame,new Vector(-4,6),2000);
        this.gameFrame.getAddList().add(bu_2);
        Bullet bu_3 = new Bullet(value.shell_B_1,this.x,this.y+40,5,5,this.gameFrame,new Vector(0,6),2000);
        this.gameFrame.getAddList().add(bu_3);
        Bullet bu_4 = new Bullet(value.shell_B_1,this.x+30,this.y+40,5,5,this.gameFrame,new Vector(4,6),2000);
        this.gameFrame.getAddList().add(bu_4);
        Bullet bu_5 = new Bullet(value.shell_B_1,this.x+60,this.y+20,5,5,this.gameFrame,new Vector(9,6),2000);
        this.gameFrame.getAddList().add(bu_5);

    }

    private void attack_2(){

        Random r = new Random();
        randomBullet bu = new randomBullet(value.shell_red,this.x+r.nextInt(100),this.y+r.nextInt(100),5,10,this.gameFrame,new Vector(6,6),1500);
        this.gameFrame.getAddList().add(bu);
        randomBullet bu_1 = new randomBullet(value.shell_red,this.x+r.nextInt(100),this.y-r.nextInt(100),5,10,this.gameFrame,new Vector(6,6),1500);
        this.gameFrame.getAddList().add(bu_1);
        randomBullet bu_2 = new randomBullet(value.shell_red,this.x+r.nextInt(100),this.y-r.nextInt(100),5,10,this.gameFrame,new Vector(6,6),1500);
        this.gameFrame.getAddList().add(bu_2);

    }

    private void attack_3(){
        CircleBullet bu_1 = new CircleBullet(value.shell_B_1,this.x-60,this.y+20,5,5,this.gameFrame,new Vector(-8,2),1600);
        CircleBullet bu_2 = new CircleBullet(value.shell_B_1,this.x-40,this.y+20,5,5,this.gameFrame,new Vector(-6,3),1600);
        CircleBullet bu_3 = new CircleBullet(value.shell_B_1,this.x-20,this.y+20,5,5,this.gameFrame,new Vector(-4,5),1600);
        CircleBullet bu_4 = new CircleBullet(value.shell_B_1,this.x-0,this.y+20,5,5,this.gameFrame,new Vector(-2,6),1600);
        CircleBullet bu_5 = new CircleBullet(value.shell_B_1,this.x+20,this.y+20,5,5,this.gameFrame,new Vector(-0,6),1600);
        CircleBullet bu_6 = new CircleBullet(value.shell_B_1,this.x+40,this.y+20,5,5,this.gameFrame,new Vector(2,6),1600);
        CircleBullet bu_7 = new CircleBullet(value.shell_B_1,this.x+60,this.y+20,5,5,this.gameFrame,new Vector(4,6),1600);
        CircleBullet bu_8 = new CircleBullet(value.shell_B_1,this.x+80,this.y+20,5,5,this.gameFrame,new Vector(6,6),1600);
        this.gameFrame.getAddList().add(bu_1);
        this.gameFrame.getAddList().add(bu_2);
        this.gameFrame.getAddList().add(bu_3);
        this.gameFrame.getAddList().add(bu_4);
        this.gameFrame.getAddList().add(bu_5);
        this.gameFrame.getAddList().add(bu_6);
        this.gameFrame.getAddList().add(bu_7);
        this.gameFrame.getAddList().add(bu_8);


    }

    private void attack_4(){
        Bullet bu_1 = new Bullet(value.shell_B_1,this.x-60,this.y+20,5,5,this.gameFrame,new Vector(-8,9),600);
        Bullet bu_2 = new Bullet(value.shell_B_1,this.x-40,this.y+20,5,5,this.gameFrame,new Vector(-8,9),600);
        Bullet bu_3 = new Bullet(value.shell_B_1,this.x-20,this.y+20,5,5,this.gameFrame,new Vector(-8,9),600);
        Bullet bu_4 = new Bullet(value.shell_B_1,this.x-0,this.y+20,5,5,this.gameFrame,new Vector(-8,9),600);
        Bullet bu_5 = new Bullet(value.shell_B_1,this.x+20,this.y+20,5,5,this.gameFrame,new Vector(-8,9),600);
        Bullet bu_6 = new Bullet(value.shell_B_1,this.x+40,this.y+20,5,5,this.gameFrame,new Vector(-8,9),600);
        Bullet bu_7 = new Bullet(value.shell_B_1,this.x+60,this.y+20,5,5,this.gameFrame,new Vector(-8,9),600);
        Bullet bu_8 = new Bullet(value.shell_B_1,this.x+80,this.y+20,5,5,this.gameFrame,new Vector(-8,9),600);
        this.gameFrame.getAddList().add(bu_1);
        this.gameFrame.getAddList().add(bu_2);
        this.gameFrame.getAddList().add(bu_3);
        this.gameFrame.getAddList().add(bu_4);
        this.gameFrame.getAddList().add(bu_5);
        this.gameFrame.getAddList().add(bu_6);
        this.gameFrame.getAddList().add(bu_7);
        this.gameFrame.getAddList().add(bu_8);


    }

    private void attack_5(){
        Bullet bu_1 = new Bullet(value.shell_B_1,this.x-60,this.y+20,5,5,this.gameFrame,new Vector(9,9),600);
        Bullet bu_2 = new Bullet(value.shell_B_1,this.x-40,this.y+20,5,5,this.gameFrame,new Vector(9,9),600);
        Bullet bu_3 = new Bullet(value.shell_B_1,this.x-20,this.y+20,5,5,this.gameFrame,new Vector(9,9),600);
        Bullet bu_4 = new Bullet(value.shell_B_1,this.x-0,this.y+20,5,5,this.gameFrame,new Vector(9,9),600);
        Bullet bu_5 = new Bullet(value.shell_B_1,this.x+20,this.y+20,5,5,this.gameFrame,new Vector(9,9),600);
        Bullet bu_6 = new Bullet(value.shell_B_1,this.x+40,this.y+20,5,5,this.gameFrame,new Vector(9,9),600);
        Bullet bu_7 = new Bullet(value.shell_B_1,this.x+60,this.y+20,5,5,this.gameFrame,new Vector(9,9),600);
        Bullet bu_8 = new Bullet(value.shell_B_1,this.x+80,this.y+20,5,5,this.gameFrame,new Vector(9,9),600);
        this.gameFrame.getAddList().add(bu_1);
        this.gameFrame.getAddList().add(bu_2);
        this.gameFrame.getAddList().add(bu_3);
        this.gameFrame.getAddList().add(bu_4);
        this.gameFrame.getAddList().add(bu_5);
        this.gameFrame.getAddList().add(bu_6);
        this.gameFrame.getAddList().add(bu_7);
        this.gameFrame.getAddList().add(bu_8);


    }

    private void attack_6(){

        Bullet bu_1 = new Bullet(value.shell_B_1,this.x-40,this.y+20,5,5,this.gameFrame,new Vector(-9,6),2000);
        this.gameFrame.getAddList().add(bu_1);
        Bullet bu_2 = new Bullet(value.shell_B_1,this.x-10,this.y+40,5,5,this.gameFrame,new Vector(-4,6),2000);
        this.gameFrame.getAddList().add(bu_2);
        Bullet bu_3 = new Bullet(value.shell_B_1,this.x+20,this.y+40,5,5,this.gameFrame,new Vector(0,6),2000);
        this.gameFrame.getAddList().add(bu_3);
        Bullet bu_4 = new Bullet(value.shell_B_1,this.x+70,this.y+20,5,5,this.gameFrame,new Vector(4,6),2000);
        this.gameFrame.getAddList().add(bu_4);



    }


}
