package little_game.planeWar.planeWar_1_2.obj;

import little_game.planeWar.planeWar_1_2.page.AbstractFrame;
import little_game.planeWar.util.value;

import java.awt.*;

public class Boss extends gameObject {
	int BossType = 1;
    int speedX = 3;
    int speedY = 4;
    public int live = 500;
    public Boss(Image image, int x, int y, int width, int height, AbstractFrame gameFrame) {
        super(image, x, y, width, height, gameFrame);
    }

    /**
     * 重写paintSelf方法，在基础绘制功能的基础上，添加一些其他和绘制无关的动作，因为JavaSwing游戏只要靠每几十毫秒重绘一次才实现动画“假象”的；
     * 所以如果某个动作需要时刻执行，则放进paintself里面
     *
     * @param g
     */
    public void paintSelf(Graphics g){
        super.paintSelf(g);//实现基础功能

        /*
        运动的实现：每25毫秒移动若干像素
         */
        if(x>this.gameFrame.getWidth()-50||x<30){
            speedX = -speedX;
        }
        x +=speedX;
        
        if(y<50||y>=300) {
        	speedY = -speedY;
        }
        y += speedY;
        
        
        	
        /*
        每隔一段时间攻击一次
         */
        if(BossType == 1) {
        	if(this.gameFrame.getCount()%10==0){
        		attack();
        	}
        }
        
        //boss战中的特殊攻击模式
        if(BossType == 2) {
        	int nowCount = this.gameFrame.getCount()-200;
        	int count = nowCount%100;
        	if(nowCount>=0&&count%40 == 0) {
        		for(int i=0;i<2;i++) {
        		EnemyBullet bu = new EnemyBullet(value.shell_red,this.x+45-2*i,
    					this.y+60,5,10,this.gameFrame,4,4);
    			this.gameFrame.getAddList().add(bu);
        		}
        		for(int i=0;i<2;i++) {
            		EnemyBullet bu = new EnemyBullet(value.shell_red,this.x+41-2*i,
        					this.y+60,5,10,this.gameFrame,3,4);
        			this.gameFrame.getAddList().add(bu);
            	}
        		for(int i=0;i<2;i++) {
            		EnemyBullet bu = new EnemyBullet(value.shell_red,this.x+37-2*i,
        					this.y+60,5,10,this.gameFrame,2,4);
        			this.gameFrame.getAddList().add(bu);
            	}
        		for(int i=0;i<2;i++) {
            		EnemyBullet bu = new EnemyBullet(value.shell_red,this.x+34-2*i,
        					this.y+60,5,10,this.gameFrame,1,4);
        			this.gameFrame.getAddList().add(bu);
            	}
        		for(int i=0;i<2;i++) {
            		EnemyBullet bu = new EnemyBullet(value.shell_red,this.x+30-2*i,
        					this.y+60,5,10,this.gameFrame,0,4);
        			this.gameFrame.getAddList().add(bu);
            	}
        		for(int i=0;i<2;i++) {
            		EnemyBullet bu = new EnemyBullet(value.shell_red,this.x+15+2*i,
        					this.y+60,5,10,this.gameFrame,-4,4);
        			this.gameFrame.getAddList().add(bu);
            	}
        		for(int i=0;i<2;i++) {
            		EnemyBullet bu = new EnemyBullet(value.shell_red,this.x+19+2*i,
        					this.y+60,5,10,this.gameFrame,-3,4);
        			this.gameFrame.getAddList().add(bu);
            	}
        		for(int i=0;i<2;i++) {
            		EnemyBullet bu = new EnemyBullet(value.shell_red,this.x+23+2*i,
        					this.y+60,5,10,this.gameFrame,-2,4);
        			this.gameFrame.getAddList().add(bu);
            	}
        		for(int i=0;i<2;i++) {
            		EnemyBullet bu = new EnemyBullet(value.shell_red,this.x+27+2*i,
        					this.y+60,5,10,this.gameFrame,-1,4);
        			this.gameFrame.getAddList().add(bu);
            	}
        		for(int i=0;i<2;i++) {
            		EnemyBullet bu = new EnemyBullet(value.shell_red,this.x+31+2*i,
        					this.y+60,5,10,this.gameFrame,0,4);
        			this.gameFrame.getAddList().add(bu);
            	}
        	}
        	if((nowCount>=0&&nowCount<400)||(nowCount>=800&&nowCount<1200)||nowCount>=3200) {
        			EnemyBullet bu = new EnemyBullet(value.shell_red,this.x+45-count/3,
        					this.y+60-count/6,5,10,this.gameFrame,-count/25,8-count/25);
        			this.gameFrame.getAddList().add(bu);
        			bu = new EnemyBullet(value.shell_red,this.x+15-count/6,this.y+60-count/3,
        					5,10,this.gameFrame,-4-count/25,4-count/25);
        			this.gameFrame.getAddList().add(bu);
        			bu = new EnemyBullet(value.shell_red,this.x+15-count/6,this.y+30-count/3,
        					5,10,this.gameFrame,-8+count/25,-count/25);
        			this.gameFrame.getAddList().add(bu);
        			bu = new EnemyBullet(value.shell_red,this.x+15+count/3,this.y-count/6,
        					5,10,this.gameFrame,-4+count/25,-4-count/25);
        			this.gameFrame.getAddList().add(bu);
        			bu = new EnemyBullet(value.shell_red,this.x+45+count/3,this.y+count/6,
        					5,10,this.gameFrame,count/25,-8+count/25);
        			this.gameFrame.getAddList().add(bu);
        			bu = new EnemyBullet(value.shell_red,this.x+75+count/6,this.y+count/3,
        					5,10,this.gameFrame,4+count/25,-4+count/25);
        			this.gameFrame.getAddList().add(bu);
        			bu = new EnemyBullet(value.shell_red,this.x+75-count/6,this.y+30+count/3,
        					5,10,this.gameFrame,8-count/25,count/25);
        			this.gameFrame.getAddList().add(bu);  
        			bu = new EnemyBullet(value.shell_red,this.x+75-count/3,this.y+60+count/6,
        					5,10,this.gameFrame,4-count/25,4+count/25);
        			this.gameFrame.getAddList().add(bu);
        	}
        	if((nowCount>=400&&nowCount<800)||(nowCount>=1200&&nowCount<1600)||nowCount>=3200) {
    			EnemyBullet bu = new EnemyBullet(value.shell_red,this.x+45+count/3,
    					this.y+60-count/6,5,10,this.gameFrame,count/25,8-count/25);
    			this.gameFrame.getAddList().add(bu);
    			bu = new EnemyBullet(value.shell_red,this.x+15+count/3,this.y+60+count/6,
    					5,10,this.gameFrame,-4+count/25,4+count/25);
    			this.gameFrame.getAddList().add(bu);
    			bu = new EnemyBullet(value.shell_red,this.x+15+count/6,this.y+30+count/3,
    					5,10,this.gameFrame,-8+count/25,+count/25);
    			this.gameFrame.getAddList().add(bu);
    			bu = new EnemyBullet(value.shell_red,this.x+15-count/6,this.y+count/3,
    					5,10,this.gameFrame,-4-count/25,-4+count/25);
    			this.gameFrame.getAddList().add(bu);
    			bu = new EnemyBullet(value.shell_red,this.x+45-count/3,this.y+count/6,
    					5,10,this.gameFrame,-count/25,-8+count/25);
    			this.gameFrame.getAddList().add(bu);
    			bu = new EnemyBullet(value.shell_red,this.x+75-count/3,this.y-count/6,
    					5,10,this.gameFrame,4-count/25,-4-count/25);
    			this.gameFrame.getAddList().add(bu);
    			bu = new EnemyBullet(value.shell_red,this.x+75-count/6,this.y+30-count/3,
    					5,10,this.gameFrame,8-count/25,-count/25);
    			this.gameFrame.getAddList().add(bu);  
    			bu = new EnemyBullet(value.shell_red,this.x+75+count/6,this.y+60-count/3,
    					5,10,this.gameFrame,4+count/25,4-count/25);
    			this.gameFrame.getAddList().add(bu);
        	}
        	int secCnt = nowCount%200;
        	if(nowCount>=1700) {
        		if(secCnt % 8 ==0) {
        			EnemyBullet bu = new EnemyBullet(value.shell_green,this.x+15-300+3*secCnt,
        					this.y+60,5,10,this.gameFrame,0,8);
        			this.gameFrame.getAddList().add(bu);
        			bu = new EnemyBullet(value.shell_green,this.x+300+75-3*secCnt,
        					this.y+60,5,10,this.gameFrame,0,8);
        			this.gameFrame.getAddList().add(bu);
        			bu = new EnemyBullet(value.shell_green,this.x+75,
        					this.y+260-2*secCnt,5,10,this.gameFrame,8,0);
        			this.gameFrame.getAddList().add(bu);
        			bu = new EnemyBullet(value.shell_green,this.x+75,
        					this.y-200+2*secCnt,5,10,this.gameFrame,8,0);
        			this.gameFrame.getAddList().add(bu);
        			bu = new EnemyBullet(value.shell_green,this.x+15,
        					this.y-200+2*secCnt,5,10,this.gameFrame,-8,0);
        			this.gameFrame.getAddList().add(bu);
        			bu = new EnemyBullet(value.shell_green,this.x+15,
        					this.y+260-2*secCnt,5,10,this.gameFrame,-8,0);
        			this.gameFrame.getAddList().add(bu);
        		}
        	}
        }

        /*
        碰撞检测的实现，同时体现了在同一面板中不同元素之间借助gameFrame属性的信息互动
        矩形类的intersects方法是用来实现碰撞检测的
         */
        if(this.getRec().intersects(this.gameFrame.getMyPlane().getRec())){
            this.gameFrame.setState(2);
        }
    }


    /**
     * 攻击函数的实现
     */
    private void attack(){
        /*
        生成一个敌人子弹类的对象，并将其放入待添加列表中，主面板有一个元素列表和待添加列表和待删除列表。元素列表每25毫秒遍历并逐一绘制一遍
        之所以不能直接删除或添加，是因为在遍历某个列表时，不能对该列表的元素个数进行更改，否则会报错
         */
        EnemyBullet bu = new EnemyBullet(value.shell_B_1,this.x+45,this.y+60,5,10,this.gameFrame,0,7);
        this.gameFrame.getAddList().add(bu);
    }
    
    public void setBossHP(int HP) {
    	this.live = HP;
    }
    
    public void setBossSpeed(int x,int y) {
    	this.speedX = x;
    	this.speedY = y;
    }
    
    public void setBossXY(int x,int y) {
    	this.x = x;
    	this.y = y;
    }
    
    public void setBossType(int type) {
    	this.BossType = type;
    }
}
