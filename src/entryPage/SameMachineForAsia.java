package entryPage;

import code.altas.*;
import code.frame.GameFrame;
import code.frame.GameFrameForAI;
import code.util.values;
import utils.BackgroundPanel;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author wenrui
 * @Date 2021/12/23 21:31
 */
public class SameMachineForAsia extends JFrame {

    BackgroundPanel atlas;
    BackgroundPanel contentPane;
    JPanel panel;
    private int choose = 1;

    public SameMachineForAsia() {
        /*
        frame
         */
        this.setSize(1200, 660);
        this.setLocationRelativeTo((Component)null);
        this.setDefaultCloseOperation(2);
        this.setTitle("多人同机模式——亚洲战场");
        this.setVisible(true);
        /*
        contentPanel
         */
        this.contentPane = new BackgroundPanel();
        this.setContentPane(this.contentPane);
        Image image = Toolkit.getDefaultToolkit().createImage("./resource/page/Europe.jpeg");
        this.contentPane.setImage(image);
        this.atlas = new BackgroundPanel();
        this.contentPane.add(this.atlas);
        this.atlas.setBounds(50, 30, 700, 500);
        this.atlas.setImage(values.atlas_JiuYiBaShiBian);

        JButton button_1 = new JButton("开始");
        this.contentPane.add(button_1);
        button_1.setBackground(Color.ORANGE);
        button_1.setBounds(500, 530, 100, 60);
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switch(choose) {
                    case 1:
                       new GameFrame(Atlas_A_918ShiBian.instance());
                        break;
                    case 2:
                        new GameFrame(Atlas_A_77ShiBian.instance());
                        break;
                    case 3:
                        new GameFrame(Atlas_A_BaiTuanDaZhan.instance());
                        break;
                    case 4:
                        new GameFrame(Atlas_A_BaoWeiYunNan.instance());
                        break;
                    case 5:
                        new GameFrame(Atlas_A_BaYueFengBaoXingDong.instance());
                        break;
                    case 6:
                        new GameFrame(Atlas_A_ChangShaBaoWeiZhan.instance());
                        break;
                    case 7:
                        new GameFrame(Atlas_A_TaiYuanHuiZhan.instance());
                        break;
                    case 8:
                        new GameFrame(Atlas_A_XuZhouHuiZhan.instance());
                        break;
                    case 9:
                        new GameFrame(Atlas_A_YuXiangGuiHuiZhan.instance());
                }

            }
        });
        JButton button_2 = new JButton("返回");
        this.contentPane.add(button_2);
        button_2.setBackground(Color.orange);
        button_2.setBounds(100, 530, 100, 60);
        button_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                      dispose();
            }
        });
        JScrollPane scrollPane = new JScrollPane();
        this.contentPane.add(scrollPane);
        scrollPane.setBounds(800, 20, 300, 600);
        this.panel = new JPanel();
        this.panel.setBackground(Color.orange);
        scrollPane.setViewportView(this.panel);
        GridLayout grid = new GridLayout(9, 1, 0, 20);
        this.panel.setLayout(grid);
        this.addButton(1);
        this.addButton(2);
        this.addButton(3);
        this.addButton(4);
        this.addButton(5);
        this.addButton(6);
        this.addButton(7);
        this.addButton(8);
        this.addButton(9);
    }

    public void addButton(int i) {
        JButton button = new JButton();
        switch(i) {
            case 1:
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        atlas.setImage(values.atlas_JiuYiBaShiBian);
                        atlas.repaint();
                        choose = 1;

                    }
                });
                button.setText("918事变");
                break;
            case 2:
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        atlas.setImage(values.atlas_QiQiShiBian);
                       atlas.repaint();
                        choose = 2;
                    }
                });
                button.setText("77事变");
                break;
            case 3:
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                      atlas.setImage(values.atlas_BaiTuanDaZhan);
                        atlas.repaint();
                     choose = 3;
                    }
                });
                button.setText("百团大战");
                this.choose = 3;
                break;
            case 4:
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                     atlas.setImage(values.atlas_BaoWeiYunNan);
                      atlas.repaint();
                       choose = 4;
                    }
                });
                button.setText("保卫云南");
                break;
            case 5:
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                       atlas.setImage(values.atlas_BaYueFengBaoXingDong);
                   atlas.repaint();
                       choose = 5;
                    }
                });
                button.setText("八月风暴行动");
                break;
            case 6:
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        atlas.setImage(values.atlas_ChangShaBaoWeiZhan);
                       atlas.repaint();
                        choose = 6;
                    }
                });
                button.setText("长沙保卫战");
                break;
            case 7:
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                      atlas.setImage(values.atlas_TaiYuanHuiZhan);
                       atlas.repaint();
                       choose = 7;
                    }
                });
                button.setText("太原会战");
                break;
            case 8:
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                     atlas.setImage(values.atlas_XuZhouHuiZhan);
                      atlas.repaint();
                      choose = 8;
                    }
                });
                button.setText("徐州会战");
                break;
            case 9:
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                     atlas.setImage(values.atlas_YuXiangGuiZhanYi);
                     atlas.repaint();
                      choose = 9;
                    }
                });
                button.setText("豫湘桂战役");
        }

        button.setBackground(Color.PINK);
        button.setPreferredSize(new Dimension(200, 100));
        this.panel.add(button);
    }


}
