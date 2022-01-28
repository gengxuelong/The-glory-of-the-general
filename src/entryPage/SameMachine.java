package entryPage;

import utils.BackgroundPanel;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author wenrui
 * @Date 2021/12/23 15:26
 */
public class SameMachine extends JFrame {
    public SameMachine(){
        /*
        frame
         */
        this.setSize (700,400);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("多人同机模式");
        this.setVisible(true);
        /*
        contentPane
         */
        BackgroundPanel contentPane = new BackgroundPanel();
        this.setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBorder(new TitledBorder("开始"));
        contentPane.setImage(Toolkit.getDefaultToolkit().createImage("./resource/page/mainBG.jpeg"));

        /*
        two button
         */
        JButton button_1 = new JButton("欧洲战场");
        JButton button_2 = new JButton("东亚战场");
        button_1.setBackground(Color.PINK);
        button_2.setBackground(Color.PINK);
        contentPane.add(button_1);
        contentPane.add(button_2);
        button_1.setBounds(10,50,300,250);
        button_2.setBounds(350,50,300,250);
        ImageIcon icon = new ImageIcon("./resource/page/欧洲战场.jpeg");
        ImageIcon icon2 = new ImageIcon("./resource/page/东亚战场.jpeg");
        button_1.setIcon(icon);
        button_2.setIcon(icon2);
        button_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SameMachineForEurope();
            }
        });
        button_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SameMachineForAsia();
            }
        });



        /*
        返回
         */
        JButton button = new JButton("返回");
        contentPane.add(button);
        button.setBounds(570,310,100,50);
        button.setBackground(Color.gray);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });


    }

}
