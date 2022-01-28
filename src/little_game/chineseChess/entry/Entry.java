package little_game.chineseChess.entry;


import little_game.chineseChess.page.GameFrame;
import utils.BackgroundPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author 王晓阳
 *
 */
public class Entry extends JFrame {
    private static final int WIDTH = 1200;
    private static final int HEIGHT = 660;

    public Entry(){

        /*
        frame
         */
        this.setSize(WIDTH,HEIGHT);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        /*
        contentPane
         */
        BackgroundPanel contentPane = new BackgroundPanel(){
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                g.setFont(new Font(null,Font.BOLD,80));
                g.setFont(new Font(null,Font.BOLD,20));
                g.setColor(Color.GRAY);
                g.setFont(new Font(null,Font.BOLD,70));
                g.drawString("中国象棋",200,200);
            }
        };
        this.setContentPane(contentPane);
        Image image = Toolkit.getDefaultToolkit().createImage("./resource/imageForChineseChess/beijing.jpeg");
        contentPane.setImage(image);
        /*
        button
         */
        JButton button_1 = new JButton("开始游戏");
        contentPane.add(button_1);
        button_1.setBounds(800,300,200,70);
        button_1.setBackground(Color.PINK);
        button_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                do_button_1();
            }
        });


        JButton button_2 = new JButton("退出");
        contentPane.add(button_2);
        button_2.setBounds(800,420,200,70);
        button_2.setBackground(Color.PINK);
        button_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                do_button_2();
            }
        });


    }

    private void do_button_2() {
        dispose();
    }

    private void do_button_1() {
        new GameFrame();
    }


}
