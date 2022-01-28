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
public class ChooseQipan extends JFrame {
    public static int num1 = 0;

    //组件元素
    public BackgroundPanel contentPane;



    private void addButton(int i){
        JButton button_1 = new JButton();
        contentPane.add(button_1);
        button_1.setBackground(Color.CYAN);
        button_1.setIcon(util.creatImageIcon(util.QIPAN,i));
        if(i<=3)
            button_1.setBounds(30+i*250,120,200,200);
        if(i>3&&i<8)
            button_1.setBounds(30+(i-4)*250,350,200,200);
        button_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = i;
                new ChoosePiece();
                dispose();
            }
        });
    }

    public ChooseQipan(){

        //frame

        this.setSize(1200,660);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);


        //contentPane

        contentPane = new BackgroundPanel();
        this.setContentPane(contentPane);
        Image image = Toolkit.getDefaultToolkit().createImage(util.path+"ChooseQipan.jpeg");//设置Panel背景
        contentPane.setImage(image);


        //stringPanel

        JPanel stringPanel = new JPanel(){
            public void paint(Graphics g){
                g.setFont(new Font(null,1,40));
                g.setColor(Color.green);
                g.drawString("请选择您要使用的棋盘样式",30,40);//设置Panel顶部的提示
            }
        };
        contentPane.add(stringPanel);
        stringPanel.setBounds(0,0,1200,100);


        //button
       addButton(0);
       addButton(1);
       addButton(2);
       addButton(3);
       addButton(4);
       addButton(5);
       addButton(6);
       addButton(7);

    }




    /**
     * 知识点：
     *      持续绘画展示的图片必须是同一个对象，在paint函数中展示的图片只有两种初始化的方法：
     *      1，在方法外初始化，让image属性有具体的对象值
     *      2。在paint中用“if(iamge == null)image = 对象值;” 的语句进行初始化。
     *
     */
}

