package little_game.snake;

import javax.swing.*;
import java.awt.*;

/**
 * @author 李杰
 */
public class FrameMain extends JFrame
{
    public FrameMain(){
        this.setDefaultCloseOperation(3);
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height=Toolkit.getDefaultToolkit().getScreenSize().height;
        this.setBounds((width-1200)/2,(height-660)/2,1200,660);
        this.setTitle("李杰作");
        this.setResizable(false);
        GamePanel p=new GamePanel();
        this.add(p);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

}
