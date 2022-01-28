package little_game.chineseChess.page;

import little_game.chineseChess.obj.BlueQizi;
import little_game.chineseChess.obj.Qizi;
import little_game.chineseChess.obj.RedQizi;
import little_game.chineseChess.utils.util;
import little_game.chineseChess.utils.value;
import utils.MyPoint;
import utils.implemetclass.MyLinkedList;
import utils.inteface.MyList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author: 王晓阳
 *
 */
public class GameFrame extends JFrame {

    private static int WIDTH = 1200;
    private static int HEIGHT = 660;



    //游戏元素
     MyList<Qizi> qizis = new MyLinkedList<>();
     MyList<Qizi> addList = new MyLinkedList<>();
     MyList<Qizi> removeList = new MyLinkedList<>();
     Qizi chooseQizi =null;
     Qizi lastChoose = null;
     int nowCamp = 1;

     public void next(){
         if(nowCamp == 1){
             nowCamp = 2;
         }else{
             nowCamp = 1;
         }
     }


    public GameFrame(){
        //frame
        this.setSize(WIDTH,HEIGHT);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setBackground(Color.ORANGE);

        //元素初始化化
        {
            for(int i = 1;i<=16;i++){
                RedQizi red = new RedQizi(this,i);
                BlueQizi blue = new BlueQizi(this,i);
                qizis.add(red);
                qizis.add(blue);
            }
        }

        /*
        鼠标监听器
         */
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX()-315;
                int y = e.getY()-65;

                MyPoint gridPoint = util.getGridMyPoint(x,y);
                System.out.println(x+";"+y);
                System.out.println(gridPoint.x+";"+gridPoint.y);

                if(chooseQizi != null){
                    lastChoose = chooseQizi;
                    chooseQizi.setChoose(false);
                    chooseQizi = null;
                }else{
                    lastChoose = null;
                }
                for(Qizi qizi : qizis){
                    if(qizi.getGridMyPoint().equals(gridPoint)){
                        chooseQizi = qizi;
                        if(qizi.getCamp()==nowCamp)
                             qizi.setChoose(true);
                        System.out.println("点中了"+qizi.getValue());
                    }
                }
                if(chooseQizi!= null&&chooseQizi .getCamp() ==nowCamp){
                }else if(chooseQizi!=null&&chooseQizi.getCamp()!= nowCamp){
                    if(lastChoose!= null&&lastChoose.getCamp()==nowCamp&&lastChoose.eat(chooseQizi)){
                        next();
                    }
                }else{
                    if(lastChoose!=null&&lastChoose.getCamp()==nowCamp&&lastChoose.move(gridPoint)){
                        next();
                    }
                }
            }
        });


        /**
         * 定时器
         */
        Timer timer = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        timer.start();
    }



    private Image cache;
    Image image = Toolkit.getDefaultToolkit().createImage("./resource/imageForChineseChess/beijing.jpeg");
    public void paint(Graphics g){
        if(cache == null){
             cache = createImage(1200,660);

        }
        Graphics gImage = cache .getGraphics();
        gImage.drawImage(image,0,0,1200,660,null);
        gImage.drawImage(value.qipan,300,40,600,600,this);
        gImage.translate(315,65);
        for(Qizi q : qizis){
            q.paintSelf(gImage);
        }
        g.drawImage(cache ,0,0,1200,660,this);
        qizis.removeAll(removeList);
        addList.removeAll(removeList);
        qizis.addAll(addList);
    }


    public MyList<Qizi> getQizis() {
        return qizis;
    }

    public void setQizis(MyList<Qizi> qizis) {
        this.qizis = qizis;
    }

    public MyList<Qizi> getAddList() {
        return addList;
    }

    public void setAddList(MyList<Qizi> addList) {
        this.addList = addList;
    }

    public MyList<Qizi> getRemoveList() {
        return removeList;
    }

    public void setRemoveList(MyList<Qizi> removeList) {
        this.removeList = removeList;
    }

    public Qizi getChooseQizi() {
        return chooseQizi;
    }

    public void setChooseQizi(Qizi chooseQizi) {
        this.chooseQizi = chooseQizi;
    }

    public Qizi getLastChoose() {
        return lastChoose;
    }

    public void setLastChoose(Qizi lastChoose) {
        this.lastChoose = lastChoose;
    }


}
