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
public class ChoosePieceForBot extends JFrame {

    public static int num3 = 0;

    //组件元素
    public BackgroundPanel contentPane;



    private void addButton(int i){
        JButton button_1 = new JButton();
        contentPane.add(button_1);
        button_1.setBackground(Color.CYAN);
        button_1.setIcon(util.creatImageIcon(util.PIECE,i));
        if(i == 6){
            button_1.setBounds(30,120,200,200);
        }if(i==8){
            button_1.setBounds(330,120,200,200);
        }
        button_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num3 = i;
                new MyFrame(ChooseQipan.num1,ChoosePiece.num2,num3);
                dispose();
            }
        });
    }

    public ChoosePieceForBot(){

        //frame

        this.setSize(1200,660);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);


        //contentPane

        contentPane = new BackgroundPanel();
        this.setContentPane(contentPane);
        Image image = Toolkit.getDefaultToolkit().createImage(util.path+"ChooseQipan.jpeg");
        contentPane.setImage(image);


        //stringPanel

        JPanel stringPanel = new JPanel(){
            public void paint(Graphics g){
                g.setFont(new Font(null,1,40));
                g.setColor(Color.green);
                if(EntryFrame.format==0)
                g.drawString("请选择玩家二要使用的棋子样式",30,40);
                else
                	g.drawString("请选择计算机要使用的棋子样式",30,40);
            }
        };
        contentPane.add(stringPanel);
        stringPanel.setBounds(0,0,1200,100);


        //button
        addButton(6);
        addButton(8);
    }
}
