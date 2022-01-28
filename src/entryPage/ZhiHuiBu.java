package entryPage;

import utils.BackgroundPanel;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * @author wenrui
 * @Date 2021/12/24 10:31
 */
public class ZhiHuiBu extends JFrame {

    private String[] strings;
    public ZhiHuiBu(String[] strings){
        this.strings = strings;
        this.setSize(1200,660);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("指挥部/个人中心");
        this.setVisible(true);

        /*
        contentPane
         */
        BackgroundPanel contentPane = new BackgroundPanel();
        this.setContentPane(contentPane);
        contentPane.setImage(Toolkit.getDefaultToolkit().createImage("./resource/page/zhihuibu.jpeg"));

         /*
        个人中心
         */
         JPanel personPanel = new JPanel();
        personPanel.setOpaque(true);
        contentPane.add(personPanel);
        personPanel.setBackground(Color.GRAY);
        personPanel.setLayout(null);
        personPanel.setBounds(50,40,700,400);
        personPanel.setBorder(new TitledBorder("个人中心"));
        JLabel label_per = new JLabel("用户名称:"+strings[1]);
        personPanel.add(label_per);
        label_per.setFont(new Font(null, Font.BOLD,20));
        label_per.setBounds(10,15,340,100);
        label_per.setIcon(new ImageIcon("./resource/image/touxiang.jpeg"));
        JLabel label2 = new JLabel("用户账号:"+strings[2]);
        personPanel.add(label2);
        label2.setFont(new Font(null, Font.BOLD,20));
        label2.setBounds(100,150,340,100);
        JLabel label3 = new JLabel("用户账号密码:"+strings[0]);
        personPanel.add(label3);
        label3.setFont(new Font(null, Font.BOLD,20));
        label3.setBounds(100,300,340,100);



    }



}
