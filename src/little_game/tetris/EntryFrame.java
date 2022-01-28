package little_game.tetris;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;




/*
 * author WR
 */
public class EntryFrame extends JFrame{

	private JButton start = new JButton("开始游戏");
	private JButton cancel = new JButton("退出游戏");
	private static int WIDTH = 525;
	private static int HEIGHT = 550;
	private BufferedImage entry;
	
	public class EntryPanel extends JPanel{

		public EntryPanel(){
			this.setLayout(null);
		}

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			 g.drawImage(entry,0,0,null);
	}
	}
	private EntryPanel panel = new EntryPanel() ;
	
	public EntryFrame() throws IOException {
		
	    entry = ImageIO.read(new File("src/little_game/tetris/entry.jpg"));
	    
	    //button
	    start.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				

Tetris tetris = new Tetris();
				
				tetris.init();
				tetris.action();
				dispose();
			}
			});
	    
	    cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
	    	
	    });
	    
		//panel
	    start.setBounds(60,480,150,60);//前两个参数似乎失效了 that's why？
		cancel.setBounds(321,480,150,60);
		start.setBackground(Color.cyan);
	    start.setFont(new Font(null,1,20));
	    cancel.setBackground(Color.cyan);
	    cancel.setFont(new Font(null,1,20));
		panel.add(start);
		panel.add(cancel);
		panel.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		
		//frame
		this.add(panel);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	

}
