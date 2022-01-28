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
 * @Date 2021/12/24 9:55
 */
public class SinglePlayEurope extends JFrame {
    BackgroundPanel atlas;
    BackgroundPanel contentPane;
    JPanel panel;
    private int choose = 1;

    public SinglePlayEurope() {
        /*
        frame
         */
        this.setSize(1200, 660);
        this.setLocationRelativeTo((Component)null);
        this.setDefaultCloseOperation(2);
        this.setTitle("人机模式——欧洲战场");
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
        this.atlas.setImage(values.atlas_BoLanZhanYi);
        JButton button_1 = new JButton("选择阵营");
        this.contentPane.add(button_1);

        button_1.setBackground(Color.ORANGE);
        button_1.setBounds(500, 530, 100, 60);
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switch(SinglePlayEurope.this.choose) {
                    case 1:
                        SinglePlayEurope.this.new ChooseCamp(Atlas_E_BoLanZhanYi.instance());
                        break;
                    case 2:
                        SinglePlayEurope.this.new ChooseCamp(Atlas_E_FaGuoZhanYi.instance());
                        break;
                    case 3:
                        SinglePlayEurope.this.new ChooseCamp(Atlas_E_ShiChangHuaYuanXingDong.instance());
                        break;
                    case 4:
                        SinglePlayEurope.this.new ChooseCamp(Atlas_E_DongJiChunXingXingDong.instance());
                        break;
                    case 5:
                        SinglePlayEurope.this.new ChooseCamp(Atlas_E_JiFuZhanYi.instance());
                        break;
                    case 6:
                        SinglePlayEurope.this.new ChooseCamp(Atlas_E_SiDaLingGeLeZhanYi.instance());
                        break;
                    case 7:
                        SinglePlayEurope.this.new ChooseCamp(Atlas_E_MoSiKeBaoWeiZhan.instance());
                        break;
                    case 8:
                        SinglePlayEurope.this.new ChooseCamp(Atlas_E_NuoManDiDengLu.instance());
                        break;
                    case 9:
                        SinglePlayEurope.this.new ChooseCamp(Atlas_E_BoLingZhanYi.instance());
                }

            }
        });
        JButton button_2 = new JButton("返回");
        this.contentPane.add(button_2);
        button_2.setBackground(Color.orange);
        button_2.setBounds(100, 530, 100, 60);
        button_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SinglePlayEurope.this.dispose();
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
        final Image image1 = values.atlas_BoLanZhanYi;
        final Image image2 = values.atlas_BoLinZhanYi;
        final Image image3 = values.atlas_ShiChangHuaYuanXingDong;
        final Image image4 = values.atlas_DongJiChunXingXingDong;
        final Image image5 = values.atlas_JiFuZhanYi;
        final Image image6 = values.atlas_FaGuoZhanYi;
        final Image image7 = values.atlas_SiDaLingGeLeZhanYi;
        final Image image8 = values.atlas_MoSiKeBaoWeiZhan;
        final Image image9 = values.atlas_NuoManDiDengLu;
        switch(i) {
            case 1:
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        SinglePlayEurope.this.atlas.setImage(image1);
                        SinglePlayEurope.this.atlas.repaint();
                        SinglePlayEurope.this.choose = 1;
                    }
                });
                button.setText("波兰战役");
                break;
            case 2:
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        SinglePlayEurope.this.atlas.setImage(image6);
                        SinglePlayEurope.this.atlas.repaint();
                        SinglePlayEurope.this.choose = 2;
                    }
                });
                button.setText("法国战役");
                break;
            case 3:
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        SinglePlayEurope.this.atlas.setImage(image3);
                        SinglePlayEurope.this.atlas.repaint();
                        SinglePlayEurope.this.choose = 3;
                    }
                });
                button.setText("市场花园行动");
                break;
            case 4:
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        SinglePlayEurope.this.atlas.setImage(image4);
                        SinglePlayEurope.this.atlas.repaint();
                        SinglePlayEurope.this.choose = 4;
                    }
                });
                button.setText("冬季春醒行动");
                break;
            case 5:
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        SinglePlayEurope.this.atlas.setImage(image5);
                        SinglePlayEurope.this.atlas.repaint();
                        SinglePlayEurope.this.choose = 5;
                    }
                });
                button.setText("基辅战役");
                break;
            case 6:
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        SinglePlayEurope.this.atlas.setImage(image7);
                        SinglePlayEurope.this.atlas.repaint();
                        SinglePlayEurope.this.choose = 6;
                    }
                });
                button.setText("斯大林格勒保卫战");
                break;
            case 7:
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        SinglePlayEurope.this.atlas.setImage(image8);
                        SinglePlayEurope.this.atlas.repaint();
                        SinglePlayEurope.this.choose = 7;
                    }
                });
                button.setText("莫斯科保卫战");
                break;
            case 8:
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        SinglePlayEurope.this.atlas.setImage(image9);
                        SinglePlayEurope.this.atlas.repaint();
                        SinglePlayEurope.this.choose = 8;
                    }
                });
                button.setText("诺曼底登陆行动");
                break;
            case 9:
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        SinglePlayEurope.this.atlas.setImage(image2);
                        SinglePlayEurope.this.atlas.repaint();
                        SinglePlayEurope.this.choose = 9;
                    }
                });
                button.setText("柏林战役");
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
