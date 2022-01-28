package little_game.planeWar.entryPage;

import little_game.planeWar.util.value;
import utils.BackgroundPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author: gengxuelong
 * @Date: 2021/12/14 1:07
 */
public class EntryFrame extends JFrame {
    private static final int WIDTH = 1200;
    private static final int HEIGHT = 660;

    public EntryFrame(){

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
                g.drawString("准备启航了阁下，为了银河帝国的荣誉" +
                        "\n我们虽死犹荣",700,500);
            }
        };
        this.setContentPane(contentPane);
        Image image = value.entryBeijing;
        contentPane.setImage(image);
        /*
        button
         */
        JButton button_1 = new JButton("开始游戏");
        contentPane.add(button_1);
        button_1.setBounds(100,300,200,70);
        button_1.setBackground(Color.PINK);
        button_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                do_button_1();
            }
        });


        JButton button_2 = new JButton("退出");
        contentPane.add(button_2);
        button_2.setBounds(100,420,200,70);
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
         new GuanKa();
    }


}
