package entryPage;

import code.altas.*;
import code.frame.GameFrame;
import code.util.values;
import utils.BackgroundPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author wenrui
 * @Date 2021/12/23 16:13
 */
public class SameMachineForEurope extends JFrame {

    BackgroundPanel atlas ;
    BackgroundPanel contentPane ;
    JPanel panel;
    private int choose = 1;

    /*
    frame
     */
    public SameMachineForEurope(){
        this.setSize(1200,660);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("多人同机模式——亚洲战场");
        this.setVisible(true);
        /*
        contentPane
         */
         contentPane = new BackgroundPanel();
        this.setContentPane(contentPane);
        Image image = Toolkit.getDefaultToolkit().createImage("./resource/page/Europe.jpeg");
        contentPane.setImage(image);

        /*
        atlas show
         */
         atlas = new BackgroundPanel();
        contentPane.add(atlas);
        atlas.setBounds(50,30,700,500);
        atlas.setImage(values.atlas_BoLanZhanYi);

        /*
        button
         */
        JButton button_1 = new JButton("开始");
        contentPane.add(button_1);
        button_1.setBackground(Color.ORANGE);
        button_1.setBounds(500,530,100,60);
        button_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                switch(choose){
                    case 1:
                        new GameFrame(Atlas_E_BoLanZhanYi.instance());
                        break;
                    case 2:
                        new GameFrame(Atlas_E_FaGuoZhanYi.instance());break;
                    case 3:
                        new GameFrame(Atlas_E_ShiChangHuaYuanXingDong.instance());break;
                    case 4:
                        new GameFrame(Atlas_E_DongJiChunXingXingDong.instance());break;
                    case 5:
                        new GameFrame(Atlas_E_JiFuZhanYi.instance());break;
                    case 6:
                        new GameFrame(Atlas_E_SiDaLingGeLeZhanYi.instance());break;
                    case 7:
                        new GameFrame(Atlas_E_MoSiKeBaoWeiZhan.instance());break;
                    case 8:new GameFrame(Atlas_E_NuoManDiDengLu.instance());break;
                    case 9:new GameFrame(Atlas_E_BoLingZhanYi.instance());break;

                }
            }
        });

        JButton button_2 = new JButton("返回");
        contentPane.add(button_2);
        button_2.setBackground(Color.orange);
        button_2.setBounds(100,530,100,60);
        button_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        /*
        scrollPane
         */
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane);
        scrollPane.setBounds(800,20,300,600);

        /*
        button show panel
         */
         panel = new JPanel();
         panel.setBackground(Color.orange);
        scrollPane.setViewportView(panel);
        GridLayout grid = new GridLayout(9,1,0,20);
        panel.setLayout(grid);
        addButton(1);
        addButton(2);
        addButton(3);
        addButton(4);
        addButton(5);
        addButton(6);
        addButton(7);
        addButton(8);
        addButton(9);



    }
    public void addButton(int i){
        JButton button = new JButton();
        Image image1 = values.atlas_BoLanZhanYi;//波兰战役
        Image image2 = values.atlas_BoLinZhanYi;//柏林战役
        Image image3 = values.atlas_ShiChangHuaYuanXingDong;//市场花园行动
        Image image4 = values.atlas_DongJiChunXingXingDong;//冬季春醒行动
        Image image5 = values.atlas_JiFuZhanYi;//基辅战役
        Image image6 = values.atlas_FaGuoZhanYi;//法国战役
        Image image7 = values.atlas_SiDaLingGeLeZhanYi;//斯大林格勒战役
        Image image8 = values.atlas_MoSiKeBaoWeiZhan;//莫斯科保卫战
        Image image9 = values.atlas_NuoManDiDengLu;//诺曼底登陆
        switch(i){
            case 1:
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        atlas.setImage(image1);
                        atlas.repaint();
                        choose = 1;
                    }
                });
                button.setText("波兰战役");
                break;
            case 2:
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        atlas.setImage(image6);
                        atlas.repaint();
                        choose = 2;
                    }
                });
                button.setText("法国战役");

                break;
            case 3:
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        atlas.setImage(image3);
                        atlas.repaint();
                        choose = 3;
                    }
                });

                button.setText("市场花园行动");

                break;
            case 4:
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        atlas.setImage(image4);
                        atlas.repaint();
                        choose = 4;
                    }
                });

                button.setText("冬季春醒行动");
                break;
            case 5:
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        atlas.setImage(image5);
                        atlas.repaint();
                        choose = 5;
                    }
                });
                button.setText("基辅战役");
                break;
            case 6:
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        atlas.setImage(image7);
                        atlas.repaint();
                        choose = 6;
                    }
                });

                button.setText("斯大林格勒保卫战");
                break;
            case 7:
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        atlas.setImage(image8);
                        atlas.repaint();
                        choose = 7;
                    }
                });

                button.setText("莫斯科保卫战");
                break;
            case 8:
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        atlas.setImage(image9);
                        atlas.repaint();
                        choose = 8;

                    }
                });
                button.setText("诺曼底登陆行动");
                break;

            case 9:
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        atlas.setImage(image2);
                        atlas.repaint();
                        choose = 9;
                    }
                });
                button.setText("柏林战役");
                break;
        }
        button.setBackground(Color.PINK);
        button.setPreferredSize(new Dimension(200,100));
        panel.add(button);
    }

}
