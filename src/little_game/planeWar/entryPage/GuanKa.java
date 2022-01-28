package little_game.planeWar.entryPage;

import little_game.planeWar.planeWar_1_2.page.PYFrameONE;
import little_game.planeWar.planeWar_1_2.page.PYFrameTWO;
import little_game.planeWar.planeWar_3_4.page.GameFrame;
import little_game.planeWar.planeWar_3_4.page.GameFrame_2;
import little_game.planeWar.planeWar_5_6.page.Frame2;
import little_game.planeWar.util.value;
import utils.BackgroundPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author: gengxuelong
 * @Date: 2021/12/14 1:37
 */
public class GuanKa extends JFrame {
    private static final int WIDTH = 1200;
    private static final int HEIGHT = 660;

    BackgroundPanel contentPane;
    public GuanKa(){

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
         contentPane = new BackgroundPanel(){
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                g.setFont(new Font(null,Font.BOLD,80));
                g.setColor(Color.green);
                g.drawString("选择关卡",100,100);
                g.setFont(new Font(null,Font.BOLD,20));
                g.setColor(Color.BLACK);
                g.drawString("邪恶势力想要染指银河系" +
                        "这是银河帝国和你我都不能接受的事情",500,550);
            }
        };
        this.setContentPane(contentPane);
        Image image = value.entryBeijing_2;
        contentPane.setImage(image);
        /*
        button
         */
        addButtonToContent(1);
        addButtonToContent(2);
        addButtonToContent(3);
        addButtonToContent(4);
        addButtonToContent(5);
        addButtonToContent(6);

    }

    private void addButtonToContent(int i){
        JButton button = new JButton(""+i);
        contentPane.add(button);
        if(i <= 3){
            button.setBounds(100+300*i-300,160,200,100);
        }
        else if(i<=6){
            button.setBounds(100+(i-3)*300-300,400,200,100);
        }
        button.setBackground(Color.PINK);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                do_button(i);
            }
        });
    }

    private void do_button(int i) {

        switch(i){
            case 1:new PYFrameONE();break;
            case 2:new PYFrameTWO();break;
            case 3:new GameFrame();break;
            case 4:new GameFrame_2();break;
            case 5:new little_game.planeWar.planeWar_5_6.page.GameFrame();break;
            case 6:new Frame2();break;
        }
    }


}
