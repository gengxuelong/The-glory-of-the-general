package little_game.planeWar.planeWar_1_2.page;

import little_game.planeWar.planeWar_1_2.obj.*;
import little_game.planeWar.util.value;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * @author: gengxuelong
 * @Date: 2021/12/13 13:17
 */
public abstract class AbstractFrame extends JFrame {
    public abstract void launch();
    public abstract void paint(Graphics g);
    public abstract void createObj1();
    public abstract void createObj2();


    protected int state = 0;
    protected static int width = 1200;
    protected static int height = 660;
    protected int hitEnemyNum = 0;//击中敌机的数量
    protected int count = 0;
    protected int tempState = 0;


    /**
     * 元素对象
     */
    protected MyPlane myPlane = new MyPlane(value.myPlane,width/2,500,25,25,this);
    protected Boss boss_1 = new Boss(value.boss1,width/2,50,90,60,this);
    protected Boss boss_2 = new Boss(value.boss2,width/2,50,90,60,this);
    
    /**
     *元素列表
     */
    protected ArrayList<gameObject> objList = new ArrayList<>();
    protected  ArrayList<gameObject> removeList = new ArrayList<>();
    protected  ArrayList<EnemyPlane> enemyList = new ArrayList<>();
    protected  ArrayList<Stone> stoneList = new ArrayList<>();
    protected  ArrayList<gameObject> addList = new ArrayList<>();

    //自定义线程对象
    protected MyThread myThread = new MyThread();
    protected Image offScreenImage;//双缓存用图


    /**
     * 自定义私有线程类
     */
    private class MyThread implements Runnable{
        @Override
        public void run() {
            while(true){
                if(state ==1){
                    createObj1();
                    createObj2();
                    repaint();
                }
                if(state == 4){
                    createObj1();
                    repaint();
                }
                try{
                    Thread.sleep(25);
                    count++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public int getState() {
        return state;
    }

    @Override
    public void setState(int state) {
        this.state = state;
    }

    public int getHitEnemyNum() {
        return hitEnemyNum;
    }

    public void setHitEnemyNum(int hitEnemyNum) {
        this.hitEnemyNum = hitEnemyNum;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTempState() {
        return tempState;
    }

    public void setTempState(int tempState) {
        this.tempState = tempState;
    }

    public MyPlane getMyPlane() {
        return myPlane;
    }

    public void setMyPlane(MyPlane myPlane) {
        this.myPlane = myPlane;
    }

    public Boss getBoss_1() {
        return boss_1;
    }

    public void setBoss_1(Boss boss_1) {
        this.boss_1 = boss_1;
    }
    
    public Boss getBoss_2() {
    	return boss_2;
    }

    public ArrayList<gameObject> getObjList() {
        return objList;
    }

    public void setObjList(ArrayList<gameObject> objList) {
        this.objList = objList;
    }

    public ArrayList<gameObject> getRemoveList() {
        return removeList;
    }

    public void setRemoveList(ArrayList<gameObject> removeList) {
        this.removeList = removeList;
    }

    public ArrayList<EnemyPlane> getEnemyList() {
        return enemyList;
    }

    public void setEnemyList(ArrayList<EnemyPlane> enemyList) {
        this.enemyList = enemyList;
    }

    public ArrayList<Stone> getStoneList() {
        return stoneList;
    }

    public void setStoneList(ArrayList<Stone> stoneList) {
        this.stoneList = stoneList;
    }

    public ArrayList<gameObject> getAddList() {
        return addList;
    }

    public void setAddList(ArrayList<gameObject> addList) {
        this.addList = addList;
    }

    public MyThread getMyThread() {
        return myThread;
    }

    public void setMyThread(MyThread myThread) {
        this.myThread = myThread;
    }

    public Image getOffScreenImage() {
        return offScreenImage;
    }

    public void setOffScreenImage(Image offScreenImage) {
        this.offScreenImage = offScreenImage;
    }
}
