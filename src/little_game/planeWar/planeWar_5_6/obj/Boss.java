package little_game.planeWar.planeWar_5_6.obj;

import little_game.planeWar.planeWar_5_6.page.AbstractFrame;
import little_game.planeWar.util.value;

import java.awt.*;
import java.util.Random;

public class Boss extends gameObject {
	int speed = 4;
	public int live = 5000;

	public Boss(Image image, int x, int y, int width, int height, AbstractFrame gameFrame) {
		super(image, x, y, width, height, gameFrame);
	}

	/**
	 * 重写paintSelf方法，在基础绘制功能的基础上，添加一些其他和绘制无关的动作，因为JavaSwing游戏只要靠每几十毫秒重绘一次才实现动画“假象”的；
	 * 所以如果某个动作需要时刻执行，则放进paintself里面
	 *
	 * @param g
	 */
	public void paintSelf(Graphics g) {
		super.paintSelf(g);// 实现基础功能

		/*
		 * 运动的实现：每25毫秒移动若干像素
		 */
		Random r = new Random();
		int h = r.nextInt(950);
		if (h < 10 && x > 200 && x < this.gameFrame.getWidth() - 250) {
			speed = -speed;
		}
		if (x > this.gameFrame.getWidth() - 50 || x < 0) {
			speed = -speed;
		}
		x += speed;

		/*
		 * 每隔一段时间攻击一次
		 */
		if (this.gameFrame.getCount() % 15 == 0) {
			attack();
		}

		/*
		 * 碰撞检测的实现，同时体现了在同一面板中不同元素之间借助gameFrame属性的信息互动 矩形类的intersects方法是用来实现碰撞检测的
		 */
		if (this.getRec().intersects(this.gameFrame.getMyPlane().getRec())) {
			this.gameFrame.setState(2);
		}
	}

	/**
	 * 攻击函数的实现
	 */
	private void attack() {
		/*
		 * 生成一个敌人子弹类的对象，并将其放入待添加列表中，主面板有一个元素列表和待添加列表和待删除列表。元素列表每25毫秒遍历并逐一绘制一遍
		 * 之所以不能直接删除或添加，是因为在遍历某个列表时，不能对该列表的元素个数进行更改，否则会报错
		 */
		EnemyBullet bu = new EnemyBullet(value.shell_B_1, this.x + 45, this.y + 60, 5, 10, this.gameFrame);
		this.gameFrame.getAddList().add(bu);
	}

}
