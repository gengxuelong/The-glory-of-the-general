package entryPage;

import Data.DataBase;
import utils.BackgroundPanel;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author KangZhaoXin
 *
 */
public class Login extends JFrame {
    private static final int WIDTH = 1200;
    private static final int HEIGHT = 660;

    private final JTextField id;
    private final JPasswordField password;

    /**
     * constructor function
     */
    public Login()  {

         /*
        frame
         */
        this.setSize(WIDTH,HEIGHT);
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
        BackgroundPanel backgroundPanel = new BackgroundPanel();
        contentPane.add(backgroundPanel);
        Image image = Toolkit.getDefaultToolkit().createImage("./resource/page/loginBG.jpeg");
        backgroundPanel.setImage(image);
        backgroundPanel.setLayout(null);
        //注册按钮
        JButton button1 = new JButton("注册");
        backgroundPanel.add(button1);
        button1.setBounds(1000,500,100,50);
        button1.setBackground(new Color(85, 76, 27, 124));
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                do_button_2();
            }
        });
        /*
        loginPanel
         */
        JPanel loginPanel = new JPanel();
        backgroundPanel.add(loginPanel);
        loginPanel.setLayout(null);
        loginPanel.setBounds(300,10,500,600);
        loginPanel.setBorder(new TitledBorder("欢迎登录将军的荣耀之二战诡云"));
        loginPanel.setOpaque(false);
        //账号
        JLabel lb_1 = new JLabel("账号:");
        loginPanel.add(lb_1);
        lb_1.setFont(new Font(null,2,35));
        lb_1.setBounds(20,40,100,80);
        id = new JTextField();
        loginPanel.add(id);
        id.setBounds(130,60,270,50);

        //密码
        JLabel lb_2 = new JLabel("密码:");
        loginPanel.add(lb_2);
        lb_2.setFont(new Font(null,2,35));
        lb_2.setBounds(20,220,100,80);
        password = new JPasswordField();
        loginPanel.add(password);
        password.setBounds(130,240,270,50);

        //登录按钮
        JButton button2 = new JButton("登录");
        loginPanel.add(button2);
        button2.setFont(new Font(null,3,30));
        button2.setBackground(Color.GRAY);
        button2.setBounds(120,400,270,70);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                do_button_1();
            }
        });
    }

    /**
     * 登录按钮的实现
     */
    private void do_button_1(){

        String id_info = id.getText();
        String pw_info = password.getText();
        /*
        健壮性考虑，如果有未填信息，则弹出提醒弹窗，避免
        可能的空指针异常
         */
        if (id_info == null || pw_info == null) {
            JOptionPane.showMessageDialog(this, "请填写完整信息", null, JOptionPane.WARNING_MESSAGE);
            return;
        }
        /*
        由于希望用户将账号设置位数在十位数以下以方便用户的记忆，这里使用int数据类型作为账号信息的承载形式，
        若用户输入信息超出十位，则会有弹窗跳出提示
         */
        if (id_info.length() > 10 || Long.parseLong(id_info) > Integer.MAX_VALUE) {
            JOptionPane.showMessageDialog(this, "账号最多10位哟,,且十位时首位不能大于2，为2时次位不能大于0，建议使用自己的学号注册哦",
                    null, JOptionPane.WARNING_MESSAGE);
            return;
        }
        int idNum = Integer.parseInt(id_info);
        String[] value = null;
        DataBase.readData();
        if (DataBase.myMap.containsKey(idNum)) {
            value = (String[]) DataBase.myMap.get(idNum);
            if ((value[0].equals(pw_info))) {
                String name = value[1];
                /*
                通过建立Customer 对象的方式新建一个页面
                 */
                String[] values= new String[]{value[0],value[1],id_info};
                MainPage page = new MainPage(values);
                /*
                弹出欢迎弹窗
                 */
                JOptionPane.showMessageDialog(page, "欢迎用户:" + name, null, JOptionPane.PLAIN_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "很遗憾，密码错误",
                        null, JOptionPane.WARNING_MESSAGE);
                password.selectAll();
            }
        } else {
            JOptionPane.showMessageDialog(this, "抱歉，您的账号尚未注册请先注册吧");
        }

    }

    /**
     * 注册按钮的实现
     */
    private void do_button_2(){

        new Register();
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        new Login();
    }
}


