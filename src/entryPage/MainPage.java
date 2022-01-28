package entryPage;

import utils.BackgroundPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author KangZhaoXin
 * @Date 2021/12/16 16:22
 */
public class MainPage extends JFrame {

    private static final int WIDTH = 1200;
    private static final int HEIGHT = 660;
    private final Xuanxiang xuanxiang = new Xuanxiang();

    private final String[] value;

    //private final JTextField id;
    //private final JTextField password;

    /**
     * constructor function
     */
    Image image = Toolkit.getDefaultToolkit().createImage("./resource/page/main.jpeg");
    Image image_2 = Toolkit.getDefaultToolkit().createImage("./resource/page/mainBG_2.png");
    Image image1 = Toolkit.getDefaultToolkit().createImage("./resource/page/二.png");
    Image image2 = Toolkit.getDefaultToolkit().createImage("./resource/page/战.png");
    Image image3 = Toolkit.getDefaultToolkit().createImage("./resource/page/诡.png");
    Image image4 = Toolkit.getDefaultToolkit().createImage("./resource/page/云.png");
    public MainPage(String[] strings) {

        xuanxiang.loadBGM();

         /*
        frame
         */
        this.value = strings;
        this.setSize(WIDTH, HEIGHT);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("将军的荣耀之二战诡云");
        this.setVisible(true);

        /*
        contentPane
         */
        JPanel contentPane = new BackgroundPanel();
        this.setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(Color.GRAY);
        contentPane.setOpaque(true);
        contentPane.setLayout(new BorderLayout());

        /*
         backgroundPanel
         */
        BackgroundPanel backgroundPanel = new BackgroundPanel() {
            public void paint(Graphics g) {
                super.paint(g);
                g.drawImage(image_2,10,0,700,220,this);
                g.setFont(new Font(null,Font.BOLD,100));
                g.drawImage(image1,150+50,230,140,140,null);
                g.drawImage(image2,280+100,230,140,140,null);
                g.drawImage(image3,410+150,230,140,140,null);
                g.drawImage(image4,540+200,230,140,140,null);
            }
        };
        contentPane.add(backgroundPanel);
        backgroundPanel.setImage(image);
        backgroundPanel.setLayout(null);

        //选项按钮
        JButton button1 = new JButton("选项");
        backgroundPanel.add(button1);
        button1.setBackground(Color.gray);
        button1.setBounds(950, 530, 250, 75);
        button1.setOpaque(true);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuanxiang.setVisible(true);
            }
        });

        //指挥部
        JButton button2 = new JButton("指挥部");
        backgroundPanel.add(button2);
        button2.setBackground(Color.gray);
        button2.setBounds(950, 405, 250, 75);
        button2.setOpaque(true);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ZhiHuiBu(value);
            }
        });


        //联机模式
        JButton button4 = new JButton("联机模式");
        backgroundPanel.add(button4);
        button4.setBackground(Color.gray);
        button4.setBounds(950, 280, 250, 75);
        button4.setOpaque(true);
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LianJi(value);
            }
        });

        //人机模式
        JButton button5 = new JButton("人机模式");
        backgroundPanel.add(button5);
        button5.setBackground(Color.gray);
        button5.setBounds(950, 155, 250, 75);
        button5.setOpaque(true);
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SinglePlay();
            }
        });


        //多人同机模式
        JButton button6 = new JButton("多人同机模式");
        backgroundPanel.add(button6);
        button6.setBackground(Color.gray);
        button6.setBounds(950, 30, 250, 75);
        button6.setOpaque(true);
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SameMachine();
            }
        });

        //探索更多游戏
        JButton button7 = new JButton("探索更多游戏");
        backgroundPanel.add(button7);
        button7.setBackground(Color.gray);
        button7.setBounds(0, 520, 120, 75);
        button7.setOpaque(true);
        button7.addActionListener(e ->{

            new LittleGamePage(strings);
        });

        //联系我们
        JButton button8 = new JButton("联系我们");
        backgroundPanel.add(button8);
        button8.setBackground(Color.gray);
        button8.setBounds(130, 520, 100, 75);
        button8.setOpaque(true);
        button8.addActionListener(e -> new Page8());





    }
}
