package little_game.planeWar.planeWar_1_2.page;

import little_game.planeWar.planeWar_1_2.obj.Burst;
import little_game.planeWar.planeWar_1_2.obj.Stone;
import little_game.planeWar.planeWar_1_2.obj.gameObject;
import little_game.planeWar.planeWar_3_4.page.GameFrame;
import little_game.planeWar.util.value;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

/**
 * boss战，无小怪，boss有特殊
 * @author PYE
 *
 */
public class PYFrameTWO extends AbstractFrame {

    private final PYFrameTWO frameTwo = this;
    public void launch(){
    	this.getBoss_2().setBossSpeed(0, 1);
    	this.getBoss_2().setBossType(2);
    	this.getBoss_2().setBossXY(550, 130);
        this.setSize(width,height);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setTitle("飞机大战");

        //把首颗的哑弹上膛，放在不碍事的位置
        /*
        仅根据经验第一个炸弹类不会展示，我也不知道为啥，只要起始时在一个无碍的地方先放一炮就行了
         */
        Burst burst = new Burst(null,-100,-100,50,50,this);
        objList.add(burst);
        //把我方飞机和BOSS装载到objList 中
        objList.add(myPlane);
        objList.add(boss_2);
        //必须是mouseMotionListener 才可以有效的利用mouse的坐标，mouseMove的代码才有作用
        //mouseListener 没有这个作用
        //同时，mouseClicked的代码只在mouseListener中才起作用。。
        this.addMouseListener(new MouseAdapter() {//鼠标监听器
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getButton()==1&&state == 0){//鼠标左击事件
                    state = 1;
                }
            }
        });
        this.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                    myPlane.x = e.getX();
                    myPlane.y = e.getY();

            }
        });
        this.addKeyListener(new KeyAdapter() {//键盘监听器
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if(key == 32&&state == 3){
                    state = 1;
                }
                if(key == KeyEvent.VK_P){

                    if(state !=3){
                        tempState = state;
                        state = 3;
                    }else{
                        state = tempState;
                    }
                    repaint();
                }
                if(key == KeyEvent.VK_Q) {               	
                	myPlane.setBullet(0);
                }
                if(key == KeyEvent.VK_W) {               	
                	myPlane.setBullet(1);
                }
                if(key == KeyEvent.VK_E) {               	
                	myPlane.setBullet(2);
                }
                if(key == KeyEvent.VK_R) {               	
                	myPlane.setBullet(3);
                }

                if(key == KeyEvent.VK_SPACE&&state == 2){
                    frameTwo.dispose();
                    new PYFrameTWO();
                }
            }
        });

        new Thread(myThread).start();//自定义线程开始

    }

    /**
     * 构造函数，执行launch方法，其实把launch方法内的所有内容直接写到构造方法里当然也可以，用个启动函数显得更靓
     */
    public PYFrameTWO(){
        launch();
    }

    /**
     * 双缓存技术特别重要，必须按我这个模式，先把要绘制的一切险绘制到过渡图片上，再把过渡图片画在gamePanel上；
     * 这样才能起到每25毫秒重绘一次应该有的动画感，不然会一直闪。原因详情我也不知道
     *
     * paint function
     * @param g
     */
    public void paint(Graphics g){
    	
        if(offScreenImage == null){
            offScreenImage = createImage(width,height);
        }
        Graphics gImage = offScreenImage.getGraphics();
        gImage .setColor(Color.BLACK);
        gImage.fillRect(0,0,width,height);
        if(state == 0){//state 代表游戏状态
            value.fillWord(gImage,"鼠标点击屏幕开始游戏",Color.BLUE,300,200,60);

        }
        if(state == 1){
        	if(count>100) {
        		this.getBoss_2().setBossSpeed(0, 0);
        	}
            //绘制元素
            value.fillWord(gImage,"得分:"+hitEnemyNum,Color.blue,1000,80,30);
            value.fillWord(gImage,"按Q切换成基础弹",Color.blue,1030,160,18);
            value.fillWord(gImage,"按W切换成速射弹",Color.blue,1030,180,18);
            value.fillWord(gImage,"按E切换成穿透弹",Color.blue,1030,200,18);
            value.fillWord(gImage,"按R切换成散弹",Color.blue,1030,220,18);
            gImage.setColor(Color.white);
            gImage.drawRect(20,50,100,20);
            gImage.setColor(Color.red);
            gImage.fillRect(20,51,boss_2.live/5,19);
            for(Stone s : stoneList){
                s.paintSelf(gImage);
            }
            for(gameObject obj : objList){
                obj.paintSelf(gImage);
            }
            objList.removeAll(removeList);
            objList.addAll(addList);
            addList = new ArrayList<>();
            stoneList.removeAll(removeList);
            System.out.println(objList.size());
        }
        if(state ==2){
            value.fillWord(gImage,"GAME OVER",Color.BLUE,500,300,60);
            value.fillWord(gImage, "按空格键重新开始", Color.BLUE, 500, 400, 40);

        }
        if(state == 3){
            value.fillWord(gImage,"暂停中",Color.BLUE,500,300,60);
        }
        if(state == 4) {
            value.fillWord(gImage,"得分:"+hitEnemyNum,Color.blue,1000,80,30);
            gImage.setColor(Color.white);
            gImage.drawRect(20,50,100,20);
            gImage.setColor(Color.red);
            gImage.fillRect(20,51,boss_2.live/15,19);
            for(Stone s : stoneList){
                s.paintSelf(gImage);
            }
            for(gameObject obj : objList){
                obj.paintSelf(gImage);
            }
            objList.removeAll(removeList);
            objList.addAll(addList);
            addList = new ArrayList<>();
            stoneList.removeAll(removeList);
            System.out.println(objList.size());
            value.fillWord(gImage,"胜利",Color.BLUE,500,300,60);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.dispose();
            new GameFrame();

        }

        g.drawImage(offScreenImage,0,0,this);
    }

    private Random random = new Random();

    //创造函数，每次重绘时都执行该函数，用于源源不断的生成新的元素，同时，特别注意，所有出界的元素都要从绘制列表中移除，
    //不然他仍会被绘制，积少成多一段时间后游戏将十分卡顿
    public void createObj1() {
        if (count % 10 == 0) {//创造陨石
            int x = random.nextInt(1200);
            Stone stone = new Stone(value.stone, x, 0, 5, 5, this);
            stoneList.add(stone);
        }
        if (count % 60 == 0) {//创造行星
            int x = random.nextInt(1200);
            int a = random.nextInt(6);
            Image image = Toolkit.getDefaultToolkit().createImage(value.path + "star" + (a + 1) + ".jpg");
            Stone stone = new Stone(image, x, 0, 40, 40, this);
            stoneList.add(stone);
        }
        if (count % 100 == 0) {//创造星系
            int x = random.nextInt(1200);
            int a = random.nextInt(5);
            Image image = Toolkit.getDefaultToolkit().createImage(value.path + "xingxi" + (a + 1) + ".jpg");
            Stone stone = new Stone(image, x, 0, 50, 50, this);
            stoneList.add(stone);
        }
    }
    public void createObj2(){}//不生成小怪


}

