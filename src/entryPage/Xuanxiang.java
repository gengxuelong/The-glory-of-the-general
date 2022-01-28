package entryPage;

import utils.BackgroundPanel;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * @author wenrui
 * @Date 2021/12/24 9:59
 */
public class Xuanxiang extends JFrame {

    private  Clip bgm = null;
    ImageIcon icon1 = new ImageIcon("./resource/page/1.png");
    ImageIcon icon2 = new ImageIcon("./resource/page/2.png");
    ImageIcon[] icons ;
    int pressCount = 1;

    public Xuanxiang() {
        try {
            bgm = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        AudioInputStream ais = null;
        try {
            ais = AudioSystem.getAudioInputStream(new File("./resource/sound/defeat_music.wav"));
            //ais 的参数可以为inputStream，可以是file，也可以是URL
        } catch (UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }
        try {
            assert bgm != null;
            bgm.open(ais);
        } catch (LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
        icons = new ImageIcon[]{icon1,icon2};
        this.setSize(1200, 660);
        this.setLocationRelativeTo((Component)null);
        this.setDefaultCloseOperation(2);
        this.setTitle("选项");
        BackgroundPanel contentPane = new BackgroundPanel();
        this.setContentPane(contentPane);
        Image image = Toolkit.getDefaultToolkit().createImage("./resource/page/teaching.jpeg");
        contentPane.setImage(image);
        /*
        音乐控制按钮
         */
        JLabel label = new JLabel("背景音乐:");
        label.setFont(new Font(null,Font.BOLD,30));
        contentPane.add(label);
        label.setBounds(200,200,200,100);
        JButton button = new JButton();
        contentPane.add(button);
        button.setBounds(400,200,150,150);
        button.setIcon(new ImageIcon("./resource/page/2.png"));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pressCount++;
                button.setIcon(icons[pressCount%2]);
                if(pressCount%2==0){
                    stopBGB();
                }else{
                    loadBGM();
                }
            }
        });

    }

    public void loadBGM(){

        bgm.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stopBGB(){
        bgm.stop();
    }

}
