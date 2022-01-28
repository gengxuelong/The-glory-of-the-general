package little_game.fiveChess.obj;


import little_game.fiveChess.page.MyFrame;

import java.awt.*;

/**
 * @author: WenRui
 * @Date:2021/12/15
 */
public class tip extends obj {

    private tip thi = this;
    String str = "该位置已有棋子";
    MyFrame myFrame;

    public tip(MyFrame myFrame){
        this.myFrame = myFrame;
    }

    public tip(MyFrame myFrame, String string){
        str = string;
    }
    tip t = this;
    @Override
    public void paintSelf(Graphics g) {
        {
            g.setFont(new Font(null,1,40));
            g.drawString(str,250,250);
        }
       new Thread(){
            public void run(){
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                myFrame.removeMyList.add(thi);
                myFrame.repaint();
                this.stop();
            }
       }.start();

    }
}
