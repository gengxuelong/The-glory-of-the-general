package little_game.tetris;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;


/*
 * author WR
 */
public class Tetris extends JPanel{

	private int state;
	public static final int RUNNING = 0;
	public static final int PAUSE = 1;
	public static final int GAME_OVER = 2;
	public JFrame table;
	
	private int score;
	
	private int lines;
	
	private int level;

	private long index = 0;
	
	private int speed = 40;
	
	public static final int ROWS = 20;
	
	public static final int COLS = 10;
	
	private Cell[][] wall = new Cell[ROWS][COLS];
	/** ��������ķ��� */
	private Tetromino tetromino;
	
	private Tetromino nextOne;
	
	
	private static BufferedImage background;
	public static BufferedImage T;
	public static BufferedImage S;
	public static BufferedImage Z;
	public static BufferedImage L;
	public static BufferedImage J;
	public static BufferedImage O;
	public static BufferedImage I;
	public static BufferedImage gameOver;
	public static BufferedImage pause;
	
	
	private Timer timer;

	static{
		try{
			
			background = ImageIO.read( 
				Tetris.class.getResource("tetris.png"));
			T = ImageIO.read(
					Tetris.class.getResource("T.png")); 
			S = ImageIO.read(
					Tetris.class.getResource("S.png")); 
			Z = ImageIO.read(
					Tetris.class.getResource("Z.png")); 
			J = ImageIO.read(
					Tetris.class.getResource("J.png")); 
			L = ImageIO.read(
					Tetris.class.getResource("L.png")); 
			O = ImageIO.read(
					Tetris.class.getResource("O.png")); 
			I = ImageIO.read(
					Tetris.class.getResource("I.png"));
			gameOver = ImageIO.read(
					Tetris.class.getResource("game-over.png")); 
			pause = ImageIO.read(
					Tetris.class.getResource("pause.png")); 

		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public void action(){
		
		tetromino = Tetromino.randomOne();
		nextOne = Tetromino.randomOne();
	//	wall[10][4] = new Cell(2,4,T);
		state = RUNNING;
		KeyListener l = new KeyAdapter(){
			public void keyPressed(KeyEvent e) {
				
				int key = e.getKeyCode();
				switch(state){
				case RUNNING:processRunningKey(key);
					break;
				case PAUSE:processPauseKey(key);
					break;
				case GAME_OVER:processGameOverKey(key);
					break;
				}
				
				Tetris.this.repaint();
			}
		};
		
		this.addKeyListener(l);
		this.setFocusable(true);
		
		this.requestFocus();
		
		timer = new Timer();
		TimerTask task = new TimerTask() {
			public void run() {
				
				speed = 40-(score/1000);
				speed = speed<=1? 1: speed;
				level = 41-speed;
				if(index % speed==0){
					if(state==RUNNING){
						softDropAction();
					}
				}
				index ++;
				repaint();
			}
		};
		timer.schedule(task, 10, 10);
	}
	
	protected void processGameOverKey(int key) {
		switch(key){
		case KeyEvent.VK_Q: System.exit(0);break;
		case KeyEvent.VK_S: 
			wall=new Cell[ROWS][COLS];
			tetromino = Tetromino.randomOne();
			nextOne = Tetromino.randomOne();
			score = 0;
			lines = 0;
			index=0;
			state = RUNNING;
		}
	}
	protected void processPauseKey(int key) {
		switch(key){
		case KeyEvent.VK_Q: System.exit(0);break;
		case KeyEvent.VK_C: 
			state=RUNNING;
			index = 1;
			break;
		}
	}
	
	protected void processRunningKey(int key){
		switch(key){
		case KeyEvent.VK_RIGHT:moveRightAction();break;
		case KeyEvent.VK_LEFT:moveLeftAction();break;
		case KeyEvent.VK_DOWN:softDropAction();break;
		case KeyEvent.VK_UP:rotateRightAction();break;
		case KeyEvent.VK_Z:rotateLeftAction();break;
		case KeyEvent.VK_SPACE:hardDropAction();break;
		case KeyEvent.VK_Q:table.dispose();break;
		case KeyEvent.VK_P:state=PAUSE;break;
		}
	}


	
	public void paint(Graphics g) {
		
		g.drawImage(background, 0, 0, null);
		
		g.translate(15, 15);
		paintWall(g);
		
		this.paintTetromino(g);
		paintNextOne(g);
		
		paintScore(g);//״̬
		paintState(g);
	}
	
	private void paintState(Graphics g) {
		switch (state) {
		case PAUSE:
			g.drawImage(pause, -15, -15, null);
			break;
		case GAME_OVER:
			g.drawImage(gameOver, -15, -15, null);
			break;
		}
	}
	private void paintScore(Graphics g) {
		
		int x = 292;
		int y = 162;
		int color = 0xffffff;//0x667799
		g.setColor(new Color(color));
		Font f = 
			new Font(Font.SERIF,Font.BOLD,30);
		g.setFont(f);
		g.drawString("SCORE:"+score,x,y);
		y+=56;
		g.drawString("LINES:"+lines,x,y);
		y+=56;
		g.drawString("LEVEL:"+level,x,y);
		x = 290;
		y = 160;
		color = 0x667799;
		//            R G B
		g.setColor(new Color(color));
		g.setFont(f);
		g.drawString("SCORE:"+score,x,y);
		y+=56;
		g.drawString("LINES:"+lines,x,y);
		y+=56;
		g.drawString("LEVEL:"+level,x,y);
	}

	private void paintNextOne(Graphics g) {
		if(nextOne==null)
			return;
		Cell[] cells = nextOne.cells;
		for(int i=0; i<cells.length; i++){
			Cell c = cells[i];
			int row = c.getRow() + 1;
			int col = c.getCol() + 10;
			int x = col * CELL_SIZE;
			int y = row * CELL_SIZE;
			g.drawImage(c.getImage(), x, y, null);
		}
	}

	private void paintTetromino( Graphics g){
		
		if(tetromino==null)
			return;
		Cell[] cells = tetromino.cells;
		for(int i=0; i < cells.length; i++){
			
			Cell c = cells[i];
			int col = c.getCol();
			int row = c.getRow();
			int x = col * CELL_SIZE;
			int y = row * CELL_SIZE;
			g.drawImage(c.getImage(), x, y, null);
		}
	}
	
	public static final int CELL_SIZE = 26;
	
	private void paintWall(Graphics g){
		for(int row=0; row<ROWS; row++){
			//row = 0 1 2
			for(int col=0; col<COLS; col++){
				//col=0 1 ... 9
				Cell cell = wall[row][col];
				int x = col * CELL_SIZE;
				int y = row * CELL_SIZE;
				if(cell==null){
					//g.drawRect(x,y,CELL_SIZE,CELL_SIZE);
				}else{
					g.drawImage(cell.getImage(),x,y,null);
				}
			}
		}
	}
	
	
	public void moveRightAction(){
		tetromino.moveRight();
		
		if(outOfBounds() || concide()){
			tetromino.moveLeft();
		}
	}
	
	public void rotateRightAction(){
		tetromino.rotateRight();
		if(outOfBounds() || concide()){
			tetromino.rotateLeft();
		}
	}
	public void rotateLeftAction(){
		tetromino.rotateLeft();
		if(outOfBounds() || concide()){
			tetromino.rotateRight();
		}
	}

	
	private boolean concide() {
		Cell[] cells = tetromino.cells;
		for(int i=0; i<cells.length; i++){
			Cell cell = cells[i];
			int row = cell.getRow();
			int col = cell.getCol();
			if(wall[row][col]!=null){
				return true;
			}
		}
		return false;
	}

	public void moveLeftAction(){
		tetromino.moveLeft();
		if(outOfBounds() || concide()){
			tetromino.moveRight();
		}
	}
	
	private boolean outOfBounds() {
		Cell[] cells = tetromino.cells;
		for(int i=0; i<cells.length; i++){
			Cell c = cells[i];
			int row = c.getRow();
			int col = c.getCol();
			if(row<0||row>=ROWS||col<0||col>=COLS){
				return true;
			}
		}
		return false;
	}
	public void hardDropAction(){
		while(canDrop()){
			tetromino.softDrop();
		}
		landIntoWall();
		int lines = destroyLines() ;
		
		this.lines+=lines;
		score+=scoreTable[lines];
		
		if(isGameOver()){ 
			//System.out.println("C U!"); 
			state = GAME_OVER;
		}else{
			tetromino = nextOne;
			nextOne = Tetromino.randomOne();
		}
	}
	private int[] scoreTable = 
					{0,10,50,80,200};
	//       0  1  2  3  4
	
	public void softDropAction() {
		if (canDrop()) {
			tetromino.softDrop();
		} else {
			landIntoWall();
			int lines = destroyLines();// 0 ~ 4
			this.lines += lines;
			score += scoreTable[lines];
			if (isGameOver()) {
				// System.out.println("C U!");
				state = GAME_OVER;
			} else {
				tetromino = nextOne;
				nextOne = Tetromino.randomOne();
			}
		}
	}

	private boolean canDrop() {
		Cell[] cells = tetromino.cells;
		for (int i = 0; i < cells.length; i++) {
			Cell cell = cells[i];
			int row = cell.getRow();
			int col = cell.getCol();
			if(row==(ROWS-1)){
				return false;
			}
		}
		for (int i = 0; i < cells.length; i++) {
			Cell cell = cells[i];
			int row = cell.getRow();
			int col = cell.getCol();
			if(wall[row+1][col]!=null){
				return false;
			}
		}
		return true;
	}

	private void landIntoWall() {
		Cell[] cells = tetromino.cells;
		for (int i = 0; i < cells.length; i++) {
			Cell cell = cells[i];
			int row = cell.getRow();
			int col = cell.getCol();
			wall[row][col] = cell;
		}
	}

	private int destroyLines() {
		int lines = 0;
		for(int row=0; row<ROWS; row++){
			if(fullCells(row)){
				deleteRow(row);
				lines++;
			}
		}
		return lines;
	}
	private void deleteRow(int row) {
		for(int i=row; i>=1; i--){
			System.arraycopy(wall[i-1], 0,
					wall[i], 0, COLS);
		}
		Arrays.fill(wall[0], null);
	}

	private boolean fullCells(int row) {
		Cell[] line = wall[row];
		for (int i = 0; i < line.length; i++) {
			Cell cell = line[i];
			if(cell==null){
				return false;
			}
		}
		return true;
	}

	private boolean isGameOver() {
		Cell[] cells = nextOne.cells;
		for (int i = 0; i < cells.length; i++) {
			Cell cell = cells[i];
			int row = cell.getRow();
			int col = cell.getCol();
			if(wall[row][col]!=null){
				return true;
			}
		}
		return false;
	}

	public void init() {
		table = new JFrame();	
		table.add(this);
		table.setSize(525, 550);
		table.setLocationRelativeTo(null);
		table.setUndecorated(true);
		table.setDefaultCloseOperation(
				JFrame.EXIT_ON_CLOSE);
		
		table.setVisible(true);	}

	
}
