package entryPage;

import javax.swing.*;
import java.awt.*;

/**
 * 联系我们 页面
 *
 * @author wenrui
 * @Date 2021/12/16 19:13
 */
public class Page8 extends JFrame {
    public Page8(){
        this.setSize(500,350);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    public void paint(Graphics g){
        g.setColor(Color.PINK);
        g.fillRect(0,0,500,350);
        g.setFont(new Font(null,Font.BOLD,20));
        g.setColor(Color.DARK_GRAY);
        g.drawString("第23小组游戏开发团队",20,70);
        g.drawString("团队成员：",20,100);
        g.drawString("耿雪龙   康照鑫  李晓阳",60,130);
        g.drawString("文睿  李杰  彭烨",60,160);
        g.drawString("团队邮箱：",20,190);
        g.drawString("3349495429@qq.com",60,210);
        g.drawString("团队网址：",20,240);
        g.drawString("www.gamecreatenwpu.com",60,270);
    }

}
