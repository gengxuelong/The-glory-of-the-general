package code.altas;

import java.awt.Image;

import code.Obj.FootHoldObject;
import code.Obj.TroopObject;
import utils.implemetclass.MyLinkedList;
import utils.inteface.MyList;

public abstract class Atlas {

	protected Image image;
	protected int countOfPlayer;
	protected int xForBg;
	protected int yForBg;
	protected int width;
	protected int height;

	public MyList<TroopObject> troopList = new MyLinkedList<>();
	public MyList<FootHoldObject> footHoldList = new MyLinkedList<>();
	protected int[] temps;

	

	protected abstract void loadData();
	
	
	
	public int[] getCamps() {
		return temps;
	}
	
	public int getCountOfPlayer() {
		return countOfPlayer;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}


	public int getxForBg() {
		return xForBg;
	}

	public void setxForBg(int xForBg) {
		this.xForBg = xForBg;
	}

	public int getyForBg() {
		return yForBg;
	}

	public void setyForBg(int yForBg) {
		this.yForBg = yForBg;
	}
	
}

