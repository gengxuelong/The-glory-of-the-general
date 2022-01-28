package entryPage;

import Data.DataBase;
import code.altas.Atlas;
import code.frame.GameFrameForUDP;
import code.frame.GameFrameForUDPForClient;
import utils.BackgroundPanel;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.spec.ECField;

/**
 * @author kangzhaoxin
 * @Date 2021/12/23 11:33
 */
public class UDPLobby extends JFrame {

    private final JPanel talkingPanel ;
    private final BackgroundPanel contentPane ;
    private JTextArea textArea_tal;
    private JTextField textField_tal;
    private StringBuilder sb ;
    private JScrollPane scr_tal;
    private String[] strings;

    private Atlas atlas ;
    public UDPLobby(String[] strings,Atlas atlas){
        /*
        frame
         */
        this.atlas = atlas;
        this.strings = strings;
        DataBase.readData();
        sb = new StringBuilder(DataBase.talkingInfo);
        this.setSize(1200,660);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);


        /*
        contentPane
         */
        contentPane = new BackgroundPanel();
        this.setContentPane(contentPane);
        contentPane.setImage(Toolkit.getDefaultToolkit().createImage("resource/page/UDP2.jpeg"));



          /*
        聊天大厅，talkingPanel
         */
        talkingPanel = new JPanel();
        contentPane.add(talkingPanel);
        talkingPanel.setLayout(null);
        talkingPanel.setBounds(10,10,350,500);
        talkingPanel.setBorder(new TitledBorder("世界聊天大厅"));

        //滚动面板
        scr_tal = new JScrollPane();
        talkingPanel.add(scr_tal);
        scr_tal.setBounds(10,15,330,500);
        scr_tal.setBorder(new TitledBorder(""));


        //输入面板
        JPanel bottom_tal = new JPanel();
        contentPane.add(bottom_tal);
        bottom_tal.setLayout(null);
        bottom_tal.setBounds(10,520,350,60);
        bottom_tal.setBorder(new TitledBorder("输入信息"));

        //信息显示框
        textArea_tal = new JTextArea();
        textArea_tal.setText(sb.toString());
        scr_tal.setViewportView(textArea_tal);

        //信息输入框
        textField_tal = new JTextField();
        bottom_tal .add(textField_tal);
        textField_tal.setBounds(10,20,220,30);

        //发送按钮
        JButton b_tal = new JButton("发送");
        bottom_tal.add(b_tal);
        b_tal.setBounds(250,20,60,30);
        b_tal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField_tal.getText();
                sb.append(strings[1]).append(":").append(text).append("\n");
                textArea_tal.setText(sb.toString());
                textField_tal.setText("");
                DataBase.writeToTalkingInfo(sb.toString());
            }
        });


        /*
        新建房间
         */
        JPanel panel1 = new JPanel();
        contentPane.add(panel1);
        panel1.setLayout(null);
        panel1.setBounds(380,5,750,300);
        panel1.setBorder(new TitledBorder("创建房间"));
        panel1.setOpaque(false);
        label_1 = new JLabel("请设置我方端口号：");
        panel1.add(label_1);
        label_1.setBounds(150,100,280,50);
        label_1.setFont(new Font(null,Font.BOLD,30));
        textField_1 = new JTextField();
        panel1.add(textField_1);
        textField_1.setBounds(410,100,200,50);
        JButton button_1 = new JButton("新建房间");
        panel1.add(button_1);
        button_1.setBounds(400,220,200,60);
        button_1.setBackground(Color.PINK);
        button_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int port = Integer.parseInt(textField_1.getText());
                    new GameFrameForUDP(atlas,port);
                }catch (Exception event){
                    System.out.println("端口设置失败");
                }
            }
        });



        /*
        加入房间
         */
        JPanel panel2 = new JPanel();
        contentPane.add(panel2);
        panel2.setLayout(null);
        panel2.setBounds(380,320,750,300);
        panel2.setBorder(new TitledBorder("加入房间"));
        panel2.setOpaque(false);


        label_2 = new JLabel("对方IP：");
        panel2.add(label_2);
        label_2.setBounds(100,20,280,50);
        label_2.setFont(new Font(null,Font.BOLD,30));
        textField_2 = new JTextField();
        panel2.add(textField_2);
        textField_2.setBounds(360,20,200,50);

        label_3 = new JLabel("对方端口号：");
        panel2.add(label_3);
        label_3.setBounds(100,100,280,50);
        label_3.setFont(new Font(null,Font.BOLD,30));
        textField_3 = new JTextField();
        panel2.add(textField_3);
        textField_3.setBounds(360,100,200,50);


          label_4 = new JLabel("请设置我方端口：");
        panel2.add(label_4);
        label_4.setBounds(30,220,280,50);
        label_4.setFont(new Font(null,Font.BOLD,30));
        textField_4 = new JTextField();
        panel2.add(textField_4);
        textField_4.setBounds(300,220,200,50);

        JButton button_2 = new JButton("加入房间");
        panel2.add(button_2);
        button_2.setBounds(530,220,200,60);
        button_2.setBackground(Color.PINK);
        button_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String enemyIP = textField_2.getText();
                    int enemyPort =  Integer.parseInt(textField_3.getText());
                    int port = Integer.parseInt(textField_4.getText());
                    new GameFrameForUDPForClient(atlas,enemyIP,enemyPort,port);
                }catch (Exception event){
                    System.out.println("端口设置失败");
                }
            }

        });


    }
    private final JLabel label_1;
    private final JTextField textField_1;
    private final JLabel label_2;
    private final JTextField textField_2;
    private final JLabel label_3;
    private final JTextField textField_3;
    private final JLabel label_4;
    private final JTextField textField_4;

}
