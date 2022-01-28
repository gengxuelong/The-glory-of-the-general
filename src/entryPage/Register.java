package entryPage;

/**
 * @author KangZhaoXin
 *
 */
import Data.DataBase;
import utils.BackgroundPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;



public class Register extends JFrame {


    private final int WIDTH = 1200;
    private final int HEIGHT = 660;

    private JPanel contentPane;
    private BackgroundPanel backgroundPanel;

    /**
     * 界面组件
     */
    private  String text = "ASRE";
    private JLabel yanzhen;
    private TextField f1 = new TextField();//账号
    private TextField f2 = new TextField();//用户名
    private JPasswordField f3 = new JPasswordField();//密码
    private JPasswordField f4 = new JPasswordField();//确认密码
    private JTextField f5 = new JTextField();//验证码



    /**
     * constructor function
     */
    public Register(){
         /*
        frame
         */
        this.setSize(WIDTH,HEIGHT);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("乐多多游戏盒");
        this.setVisible(true);

        /*
        contentPane
         */
        contentPane = new BackgroundPanel();
        this.setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setOpaque(true);
        contentPane.setLayout(new BorderLayout());

         /*
         backgroundPanel
         */
        backgroundPanel = new BackgroundPanel();
        contentPane.add(backgroundPanel);
        Image image = Toolkit.getDefaultToolkit().getImage("./resource/page/loginBG.jpeg");
        backgroundPanel.setImage(image);

        /*
        decorate backgroundPanel
         */
         /*
        创建标签
         */
        JLabel label_1 = new JLabel("账号:");
        JLabel label_2 = new JLabel("用户名:");
        JLabel label_3 = new JLabel("密码:");
        JLabel label_4 = new JLabel("确认密码:");
        JLabel label_5 = new JLabel("验证码:");

        /*
        加入输入框和标签
         */
        backgroundPanel.add(f1);
        backgroundPanel.add(f2);
        backgroundPanel.add(f3);
        backgroundPanel.add(f4);
        backgroundPanel.add(f5);
        backgroundPanel.add(label_1);
        backgroundPanel.add(label_2);
        backgroundPanel.add(label_3);
        backgroundPanel.add(label_4);
        backgroundPanel.add(label_5);
        /*
        标签和输入框的具体设计
         */
        label_1.setBounds(50, 20, 130, 60);
        label_2.setBounds(50, 170, 130, 60);
        label_3.setBounds(50, 330, 130, 60);
        label_4.setBounds(50, 485, 130, 60);
        label_5.setBounds(650, 20, 100, 60);

        label_1.setFont(new Font(null,4,30));
        label_2.setFont(new Font(null,4,30));
        label_3.setFont(new Font(null,4,30));
        label_4.setFont(new Font(null,4,30));
        label_5.setFont(new Font(null,4,30));

        f1.setFont(new Font(null, 1, 40));
        f2.setFont(new Font(null, 1, 40));
        f3.setFont(new Font(null, 1, 40));
        f4.setFont(new Font(null, 1, 40));
        f5.setFont(new Font(null, 1, 40));

        f1.setBounds(180, 20, 300, 60);
        f2.setBounds(180, 170, 300, 60);
        f3.setBounds(180, 330, 300, 60);
        f4.setBounds(180, 485, 300, 60);
        f5.setBounds(770, 20, 250, 60);

        /*
        起到展示验证码的标签
         */
        yanzhen = new JLabel(text);
        backgroundPanel.add(yanzhen);
        yanzhen.setBounds(650, 225, 200, 100);
        yanzhen.setBackground(Color.yellow);
        yanzhen.setFont(new Font(null, 1, 50));
        yanzhen.setOpaque(true);

        /*
        按钮的构造
         */
        JButton button_1 = new JButton("看不清？换一张");
        backgroundPanel.add(button_1);
        button_1.setBounds(900, 235, 150, 80);
        button_1.setBackground(Color.PINK);
        JButton button_2 = new JButton("注册");
        backgroundPanel.add(button_2);
        button_2.setBounds(720, 475, 300, 100);
        button_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                do_button_1();
            }
        });
        button_2.setBackground(Color.magenta);
        button_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                do_button_2();
            }
        });
    }

    /**
     * 换验证码图片
     */
    private void do_button_1() {
        Random random = new Random();
        char alphabet_1 ;
        StringBuilder res = new StringBuilder();
        for(int i = 0;i<4;i++){
            int capital = random.nextInt(2);
            if(capital == 0){
                int letter = random.nextInt(26)+65;
                alphabet_1 = (char)letter;
            }else {
                int letter = random.nextInt(26)+97;
                alphabet_1 = (char)letter;
            }
            res.append(alphabet_1);
        }
        text = res.toString();
        yanzhen.setText(text);
    }

    /**
     * 注册
     */
    private void do_button_2() {

        String id = f1.getText();//账号
        String name = f2.getText();//用户名
        String password = f3.getText();//密码
        String password_2 = f4.getText();//密码确认
        String security = f5.getText();//验证码
        /*
        健壮性的考虑
         */
        try {
            Integer.parseInt(id);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "账号信息格式不对哦亲");
            return;
        }
        if (id.length() > 10 || Long.parseLong(id) > Integer.MAX_VALUE) {
            JOptionPane.showMessageDialog(this, "账号不能超过十位,十位时前两位应不超过20哦，这样更方便记忆呢！！",
                    null, JOptionPane.PLAIN_MESSAGE);
            return;
        }
        /*
        当设置的密码和确认密码栏内容不一致时弹出提示框
         */
        if (!(password.equals(password_2))) {
            JOptionPane.showMessageDialog(this, "两次输入的密码不一样呀亲！！",
                    null, JOptionPane.PLAIN_MESSAGE);
            return;
        }
        if (f5.getText().equals(text) && !((f1.getText()).equals("")) && !((f2.getText()).equals("")) && !((f3.getText()).equals("")) && !((f4.getText()).equals(""))) {
            JOptionPane.showMessageDialog(this, "恭喜！注册成功，请去登录吧！！",
                    null, JOptionPane.PLAIN_MESSAGE);
            DataBase.myMap.put(Integer.parseInt(id), new String[]{password, name});
            PrintWriter p = null;
            try {
                p = new PrintWriter(new FileWriter("./Data/user.txt",true));
                p.println(id + "-" + password + "-" + name);
                p.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            /*
            当未填写正确的验证码时
             */
            if (!(f5.getText().equals(text)))
                JOptionPane.showMessageDialog(this, "请填写正确的验证码！！",
                        null, JOptionPane.PLAIN_MESSAGE);
                /*
                当用户未将信息填写全时
                 */
            else {
                JOptionPane.showMessageDialog(this, "请填写有效信息！！",
                        null, JOptionPane.PLAIN_MESSAGE);
            }
        }



    }


}
