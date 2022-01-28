package entryPage;

import code.altas.*;
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
 * @Date 2021/12/24 9:54
 */
public class SinglePlayAsia  extends JFrame{
    BackgroundPanel atlas;
    BackgroundPanel contentPane;
    JPanel panel;
    private int choose = 1;

    public SinglePlayAsia() {
        /*
        frame
         */
        this.setSize(1200, 660);
        this.setLocationRelativeTo((Component)null);
        this.setDefaultCloseOperation(2);
        this.setTitle("人机模式——亚洲战场");
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
        JButton button_1 = new JButton("选择阵营");
        this.contentPane.add(button_1);
        button_1.setBackground(Color.ORANGE);
        button_1.setBounds(500, 530, 100, 60);
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switch(SinglePlayAsia.this.choose) {
                    case 1:
                        SinglePlayAsia.this.new ChooseCamp(Atlas_A_918ShiBian.instance());
                        break;
                    case 2:
                        SinglePlayAsia.this.new ChooseCamp(Atlas_A_77ShiBian.instance());
                        break;
                    case 3:
                        SinglePlayAsia.this.new ChooseCamp(Atlas_A_BaiTuanDaZhan.instance());
                        break;
                    case 4:
                        SinglePlayAsia.this.new ChooseCamp(Atlas_A_BaoWeiYunNan.instance());
                        break;
                    case 5:
                        SinglePlayAsia.this.new ChooseCamp(Atlas_A_BaYueFengBaoXingDong.instance());
                        break;
                    case 6:
                        SinglePlayAsia.this.new ChooseCamp(Atlas_A_ChangShaBaoWeiZhan.instance());
                        break;
                    case 7:
                        SinglePlayAsia.this.new ChooseCamp(Atlas_A_TaiYuanHuiZhan.instance());
                        break;
                    case 8:
                        SinglePlayAsia.this.new ChooseCamp(Atlas_A_XuZhouHuiZhan.instance());
                        break;
                    case 9:
                        SinglePlayAsia.this.new ChooseCamp(Atlas_A_YuXiangGuiHuiZhan.instance());
                }

            }
        });
        JButton button_2 = new JButton("返回");
        this.contentPane.add(button_2);
        button_2.setBackground(Color.orange);
        button_2.setBounds(100, 530, 100, 60);
        button_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SinglePlayAsia.this.dispose();
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
                        SinglePlayAsia.this.atlas.setImage(values.atlas_JiuYiBaShiBian);
                        SinglePlayAsia.this.atlas.repaint();
                        SinglePlayAsia.this.choose = 1;
                    }
                });
                button.setText("918事变");
                break;
            case 2:
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        SinglePlayAsia.this.atlas.setImage(values.atlas_QiQiShiBian);
                        SinglePlayAsia.this.atlas.repaint();
                        SinglePlayAsia.this.choose = 2;
                    }
                });
                button.setText("77事变");
                break;
            case 3:
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        SinglePlayAsia.this.atlas.setImage(values.atlas_BaiTuanDaZhan);
                        SinglePlayAsia.this.atlas.repaint();
                        SinglePlayAsia.this.choose = 3;
                    }
                });
                button.setText("百团大战");
                this.choose = 3;
                break;
            case 4:
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        SinglePlayAsia.this.atlas.setImage(values.atlas_BaoWeiYunNan);
                        SinglePlayAsia.this.atlas.repaint();
                        SinglePlayAsia.this.choose = 4;
                    }
                });
                button.setText("保卫云南");
                break;
            case 5:
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        SinglePlayAsia.this.atlas.setImage(values.atlas_BaYueFengBaoXingDong);
                        SinglePlayAsia.this.atlas.repaint();
                        SinglePlayAsia.this.choose = 5;
                    }
                });
                button.setText("八月风暴行动");
                break;
            case 6:
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        SinglePlayAsia.this.atlas.setImage(values.atlas_ChangShaBaoWeiZhan);
                        SinglePlayAsia.this.atlas.repaint();
                        SinglePlayAsia.this.choose = 6;
                    }
                });
                button.setText("长沙保卫战");
                break;
            case 7:
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        SinglePlayAsia.this.atlas.setImage(values.atlas_TaiYuanHuiZhan);
                        SinglePlayAsia.this.atlas.repaint();
                        SinglePlayAsia.this.choose = 7;
                    }
                });
                button.setText("太原会战");
                break;
            case 8:
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        SinglePlayAsia.this.atlas.setImage(values.atlas_XuZhouHuiZhan);
                        SinglePlayAsia.this.atlas.repaint();
                        SinglePlayAsia.this.choose = 8;
                    }
                });
                button.setText("徐州会战");
                break;
            case 9:
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        SinglePlayAsia.this.atlas.setImage(values.atlas_YuXiangGuiZhanYi);
                        SinglePlayAsia.this.atlas.repaint();
                        SinglePlayAsia.this.choose = 9;
                    }
                });
                button.setText("豫湘桂战役");
        }

        button.setBackground(Color.PINK);
        button.setPreferredSize(new Dimension(200, 100));
        this.panel.add(button);
    }

    private class ChooseCamp extends JFrame {
        private final Atlas atlas;
        private int camp1;
        private int camp2;

        public ChooseCamp(final Atlas atlas) {
            this.atlas = atlas;
            this.camp1 = atlas.getCamps()[0];
            this.camp2 = atlas.getCamps()[1];
            this.setSize(700, 400);
            this.setDefaultCloseOperation(2);
            this.setLocationRelativeTo((Component)null);
            this.setTitle("选择阵营");
            this.setVisible(true);
            BackgroundPanel contentPane = new BackgroundPanel();
            this.setContentPane(contentPane);
            contentPane.setLayout((LayoutManager)null);
            contentPane.setBorder(new TitledBorder("选择阵营"));
            contentPane.setImage(Toolkit.getDefaultToolkit().createImage("./resource/page/mainBG.jpeg"));
            JButton button_1 = new JButton("");
            JButton button_2 = new JButton("");
            button_1.setBackground(Color.PINK);
            button_2.setBackground(Color.PINK);
            contentPane.add(button_1);
            contentPane.add(button_2);
            button_1.setBounds(10, 50, 300, 250);
            button_2.setBounds(350, 50, 300, 250);
            Image image = values.getFlag(this.camp1);
            Image image2 = values.getFlag(this.camp2);
            ImageIcon icon = new ImageIcon(image);
            ImageIcon icon2 = new ImageIcon(image2);
            button_1.setIcon(icon);
            button_2.setIcon(icon2);
            button_1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new GameFrameForAI(atlas, ChooseCamp.this.camp1);
                }
            });
            button_2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new GameFrameForAI(atlas, ChooseCamp.this.camp2);
                }
            });
            JButton button = new JButton("返回");
            contentPane.add(button);
            button.setBounds(570, 310, 100, 50);
            button.setBackground(Color.gray);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    ChooseCamp.this.dispose();
                }
            });
        }
    }
}
