package little_game.hitMouse.page;

import little_game.hitMouse.obj.Hammer;
import little_game.hitMouse.obj.Mouse;
import little_game.hitMouse.obj.Obj;
import little_game.hitMouse.utils.Data;
import little_game.hitMouse.utils.util;
import utils.MyPoint;
import utils.implemetclass.MyLinkedList;
import utils.inteface.MyList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

/**
 * @author: 彭烨
 *
 */
public class MyFrame extends JFrame {

    public static final int WIDTH = 1200;
    public static final int HEIGHT = 660;

    private int count = 0;
    public MyFrame(){
        /*
        frame
         */
        this.setSize(WIDTH,HEIGHT);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                System.out.println(x+";"+y);
                hammer.paintContinue();
            }
        });
        this.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                MyPoint p = new MyPoint(x,y);
                hammer.setMyPoint(p);
            }
        });

        Timer timer = new Timer(25, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
                count++;
                if(count%20==0){
                    produce();
                }
            }
        });
        timer.start();
    }

    public void produce(){
        MyList<MyPoint> list = Data.pointList;
        Random random = new Random();
        int index = random.nextInt(7);
        MyPoint point = list.get(index);
        boolean flag = true;
        for(Obj o :objList){
            if(o.getMyPoint().equals(point)){
                flag = false;
            }
        }
        if(flag){
            this.objList.add(new Mouse(this,point));
        }else{
             index = random.nextInt(7);
             point = list.get(index);
            this.objList.add(new Mouse(this,point));
        }
    }

    /*
    元素列表
     */
    public MyList<Obj> objList = new MyLinkedList<>();
    public MyList<Obj> removeList = new MyLinkedList<>();
    Hammer hammer = new Hammer(this,new MyPoint(100,100));
    Image cache ;
    private int state = 1;
    public void paint(Graphics g){

        if(cache == null){
            cache =  this.createImage(WIDTH,HEIGHT);
        }
        Graphics gImage = cache .getGraphics();
        gImage .drawImage(util.hitMouse,0,0,WIDTH,HEIGHT,this);
        if(state == 1){
                for(Obj o :objList){
                    o.paintSelf(gImage);
                }
                hammer.paintSelf(gImage);
                objList.removeAll(removeList);
        }else{
            gImage.setFont(new Font(null,Font.BOLD,40));
            gImage.drawString("您输了",500,300);
        }
        if(objList.size() >= 8){
            state=2;
        }

        g.drawImage(cache,0,0,WIDTH,HEIGHT,this);

    }


}
