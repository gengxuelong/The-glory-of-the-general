package little_game.fiveChess.page;

import little_game.fiveChess.obj.*;
import little_game.fiveChess.utils.util;
import utils.MyPoint;
import utils.implemetclass.MyLinkedList;
import utils.inteface.MyList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author: WenRui
 * @Date:2021/12/15
 */
public class MyFrame extends JFrame {
    private static int WIDTH = 1200;
    private static int HEIGHT = 660;
    public int num1;//棋盘的样式
    public int num2;//棋子样式
    public int num3;
    public static int state = 0;
    static int kind = 1 ;
    //元素属性
    public MyList<obj> objMyList = new MyLinkedList<>();
    public MyList<obj> removeMyList = new MyLinkedList<>();
    public AIBot AI = new AIBot(this);
    private MyFrame frame = this;
    public LuoQiDian[][] luoQiDians = new LuoQiDian[15][15];
    {
        for(int i = 0;i<15;i++){
            for(int j = 0; j<15;j++){
                MyPoint gridMyPoint = new MyPoint(j,i);
                luoQiDians[i][j] = new LuoQiDian(gridMyPoint,this);
            }
        }
    }

    boolean flag2 = false;//true代表构造函数已经执行
    public MyFrame(int num1,int num2,int num3) {//num1 代表棋盘的样式

        //frame
        this.setSize(WIDTH,HEIGHT);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setBackground(Color.ORANGE);
        AI.calculateTheCount();

        //num
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
        qiPan = new ChessBoard(num1,this);
        flag2 = true;

        //鼠标监听器
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               if(state == 0&&flag){
                   int x = e.getX()-340;
                   int y = e.getY()-80;
                   MyPoint gridMyPoint = util.getGrid(x,y);
                   //初始化棋子队列
                   if(util.isEmpty(gridMyPoint)){
                       LuoQiDian luoQiDian = luoQiDians[gridMyPoint.y][gridMyPoint.x];
                       luoQiDian.setKind(kind);
                       repaint();//重绘组件
                      new Thread(new MyThread()).start();
                   }else{
                       objMyList.add(new tip(frame));
                       repaint();
                   }

               }
            }
        });

        //键盘监视器
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if(key == KeyEvent.VK_SPACE){
                    if(state != 0){
                        for(int i = 0;i<15;i++){
                            for(int j = 0; j<15;j++){
                                MyPoint gridMyPoint = new MyPoint(j,i);
                                luoQiDians[i][j] = new LuoQiDian(gridMyPoint,frame);
                            }
                        }
                        /*
                        清空biteMap中的数据
                         */
                        util.a = new int [15];
                        util.target = new int [15];
                        state = 0;
                        repaint();
                    }

                }
            }
        });

    }

    private ChessBoard qiPan ;
    private  Image image_2 ;//双缓存专用图
    public void paint(Graphics g){
        if(image_2 == null){
            image_2 = this.createImage(WIDTH,HEIGHT);
        }
        Graphics gImage = image_2.getGraphics();
        gImage.translate(340,80);

        if(flag2)
         qiPan.paintSelf(gImage);

        /*
            state ：
         */
       if(state == 0){
           for(int i = 0;i<15;i++){
               for(int j = 0; j<15;j++){
                   LuoQiDian luoQiDian = luoQiDians[i][j];
                   luoQiDian.paintSelf(gImage);
               }
           }
           for(int i = 0; i< objMyList.size(); i++){
               objMyList.get(i).paintSelf(gImage);
           }
       }else if(state == 1){
           for(int i = 0;i<15;i++){
               for(int j = 0; j<15;j++){
                   LuoQiDian luoQiDian = luoQiDians[i][j];
                   luoQiDian.paintSelf(gImage);
               }
           }
           for(obj b : objMyList){
               b.paintSelf(g);
           }
           gImage.setFont(new Font(null,1,30));
           if(EntryFrame.format == 0){
               gImage.drawString("玩家1获胜，按空格键再来一局",100,200);
           }else if(EntryFrame.format == 1)
           {
               gImage.drawString("您获得胜利,按空格键再来一局",100,200);
           }
       }else if(state == 2){
           for(int i = 0;i<15;i++){
               for(int j = 0; j<15;j++){
                   LuoQiDian luoQiDian = luoQiDians[i][j];
                   luoQiDian.paintSelf(gImage);
               }
           }
           for(int i = 0; i< objMyList.size(); i++){
               objMyList.get(i).paintSelf(gImage);
           }
           gImage.setFont(new Font(null,1,30));
           if(EntryFrame.format == 0) {
               gImage.drawString("玩家2获胜，按空格键再来一局 ",100,200);
           }
           else if(EntryFrame.format == 1) {
               gImage.drawString("很不幸，机器人获得胜利。。。您输了", 40, 200);
               gImage.drawString("按空格键再来一局", 40, 300);
           }
       }
        objMyList.removeAll(removeMyList);
        g.drawImage(image_2,0,0,this);
    }




    private boolean flag = true;
    private class MyThread implements Runnable{

        @Override
        public void run() {


            if(EntryFrame.format == 0) {
                flag = false;
                if (MyFrame.kind == 1)
                    MyFrame.kind = 2;
                else {
                    MyFrame.kind = 1;
                }
                flag = true;
            }


            else if(EntryFrame.format == 1){
            try {
                flag = false;
                // 通过将线程沉睡
                if(state == 0){
                    Thread.sleep(100);
                    AI.chessInCount();
                    MyFrame.kind = 1;
                }
                repaint();
                flag = true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            }

        }
    }
}
