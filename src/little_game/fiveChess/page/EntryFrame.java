package little_game.fiveChess.page;

import little_game.fiveChess.utils.util;
import utils.BackgroundPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author: WenRui
 * @Date:2021/12/15
 */
public class EntryFrame extends JFrame {

	public static int format;
    public EntryFrame(){
        /*
        frame
         */
        this.setSize(1200,660);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);

        /*
        contentPane
         */
        BackgroundPanel contentPane = new BackgroundPanel();
        this.setContentPane(contentPane);
        Image image = Toolkit.getDefaultToolkit().createImage(util.path+"entry2.jpeg");//获取图片
        contentPane.setImage(image);
        /*
        button
         */
        JButton button_0=new JButton("双人模式");
        contentPane.add(button_0);
        button_0.setBounds(100,350,200,60);
        button_0.setBackground(Color.pink);
        button_0.setFont(new Font(null,1,20));
        button_0.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				format=0;
				new ChooseQipan();
				dispose();
				
			}
        	
        });
        
        JButton button_1 = new JButton("人机模式");
        contentPane.add(button_1);
        button_1.setBounds(100,450,200,60);
        button_1.setBackground(Color.pink);
        button_1.setFont(new Font(null,1,20));
        button_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	format=1;
                new ChooseQipan();
                dispose();
            }
        });
        
        JButton button_2 = new JButton("退出");
        contentPane.add(button_2);
        button_2.setBounds(100,550,200,60);
        button_2.setBackground(Color.pink);
        button_2.setFont(new Font(null,1,20));
        button_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        new EntryFrame();
    }
}
	
