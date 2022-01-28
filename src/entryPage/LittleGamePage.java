package entryPage;

import Data.DataBase;
import little_game.planeWar.entryPage.EntryFrame;
import little_game.tankWar.entry.Entry;
import utils.BackgroundPanel;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


/**
 * @author kangzhaoxin
 */

public class LittleGamePage extends JFrame {

    private final int WIDTH = 1200;
    private final int HEIGHT = 660;

    /**
     * 界面组件
     */
    private BackgroundPanel contentPane;
    private JScrollPane scrollPane;
    private JPanel panel;
    private JPanel personPanel;
    private JPanel talkingPanel;
    private JScrollPane scr_tal;
    private JPanel bottom_tal;
    private JTextArea textArea_tal;
    private JTextField textField_tal;
    private String[] strings;

    /**
     * 私有变量，显示聊天界面的内容
     */

    /**
     * constructor function
     */
    public LittleGamePage(String[] strings){

       /*
       frame
        */
        this.strings = strings;
        DataBase.readData();
        this.setSize(1200,660);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("《将军的荣耀之二战诡云》专属游戏盒");
        this.setVisible(true);


        /*
        contentPane
         */
        contentPane = new BackgroundPanel();
        this.setContentPane(contentPane);
        contentPane.setImage(Toolkit.getDefaultToolkit().createImage("resource/page/UDPbg.jpeg"));


        /*
          装载游戏显示页面的滚动页面，scrollPane
         */
        scrollPane = new JScrollPane();
        contentPane.add(scrollPane);
        scrollPane.setBounds(0,10,800,600);
        scrollPane.setBorder(new TitledBorder("游戏选择"));
        scrollPane.setOpaque(true);

       /*
         游戏显示页面，panel
        */
        panel = new JPanel();
        scrollPane.setViewportView(panel);
        GridLayout g = new GridLayout(4,3,60,60);
        panel.setLayout(g);
        panel.setBackground(Color.GRAY);
        panel.setOpaque(true);

        addButtonToPanel(1,"飞机大战","./resource/image/plane.jpg");
        addButtonToPanel(2,"坦克大战","./resource/image/tank.jpg");
        addButtonToPanel(3,"贪吃蛇","./resource/image/贪吃蛇.jpg");
        addButtonToPanel(4,"五子棋","./resource/image/五子棋.jpg");
        addButtonToPanel(5,"中国象棋","./resource/image/中国象棋.jpg");
        addButtonToPanel(6,"打地鼠","./resource/image/打地鼠.png");
        addButtonToPanel(7,"俄罗斯方块","./resource/image/俄罗斯方块.jpg");



        /*
        退出
         */
        JButton button = new JButton("退出");
        contentPane.add(button);
        button.setBounds(950,530,220,80);
        button.setBackground(Color.PINK);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });


        /*
        个人中心
         */
        personPanel = new JPanel();
        personPanel.setOpaque(false);
        contentPane.add(personPanel);
        personPanel.setLayout(null);
        personPanel.setBounds(830,40,350,120);
        personPanel.setBorder(new TitledBorder("用户"));
        JLabel label_per = new JLabel("用户名称:"+strings[1]);
        personPanel.add(label_per);
        label_per.setFont(new Font(null,1,20));
        label_per.setBounds(10,15,340,100);
        label_per.setIcon(new ImageIcon("./resource/image/touxiang.jpeg"));

    }





    /**
     * 向panel添加按钮的方法，提高代码复用性
     */
    private void addButtonToPanel(int i,String name ,String url){

        JButton b = new JButton(name);
        b.setPreferredSize(new Dimension(200,150));
        b.setIcon(new ImageIcon(url));
        b.setBackground(Color.ORANGE);
        b.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                do_button(i);
            }
        });
        panel .add(b);
    }


    /**
     *按钮实现方法
     */
    private void do_button(int i){
       switch(i){
           case 1:
               new EntryFrame();
               break;
           case 2:
               new Entry();
               break;
           case 3:
               new little_game.snake.entry.Entry();
               break;
           case 4:
               new little_game.fiveChess.page.EntryFrame();
               break;
           case 5:
               new little_game.chineseChess.entry.Entry();
               break;
           case 6:
               new little_game.hitMouse.entry.Entry();
               break;
           case 7:
               try {
                   new little_game.tetris.EntryFrame();
               } catch (IOException e) {
                   e.printStackTrace();
               }
               break;


       }
    }

}
