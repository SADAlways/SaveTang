package game.attackelements;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import game.guaiwu.Monster;
import game.ta.Tower;
import game.world.Images;
import game.world.Region;
import game.world.UnitObject;
import game.world.World;

public abstract class ShootObject extends UnitObject{
	protected static final int FLY = 1;
	protected static final int BOOM = 2;
	protected static final int REMOVE = 3;

	protected int state;
	protected int speed;
	protected static BufferedImage img;
	protected Region rgn;//图形边界
	protected Monster m;
	protected double distanceX;//相对坐标
	protected double distanceY;
	protected double distance;
	protected int xSpeed ;//x轴分速度
	protected int ySpeed ;//y轴分速度
	protected int attack;//攻击力
	
	
	public ShootObject(int x,int y,int width,int height,int speed,Monster m) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		setSize(width,height);
		this.speed = speed;
		this.m=m;
		state = FLY;
		World.map.add(this);
		Tower.shoots.add(this);
		distanceX = 1.0*(m.getX()+m.getWidth()/2)-x;//相对坐标
		distanceY = 1.0*(m.getY()+m.getHeight()/2)-y;
		distance = Math.sqrt(distanceX*distanceX+distanceY*distanceY);
		xSpeed = (int)(distanceX/distance*speed);//x轴分速度
		ySpeed = (int)(distanceY/distance*speed);//y轴分速度
		new Thread() {
			public void run() {
				while(isFly()) {
					move();
					boom();
					try {
						sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
			
		}.start();
		
	}
	public abstract BufferedImage getImage();
	
	public boolean isFly() {
		return state == FLY;
	}
	public boolean isBoom() {
		return state == BOOM;
	}
	public boolean isRemove() {
		return state == REMOVE;
	}
	public void goBoom() {
		state = BOOM;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	/*
	 * 子弹追踪怪物坐标
	 * 实时(线程或者计时器)计算子弹与怪物的相对坐标
	 * 得到x,y两个方向的分速度
	 * 
	 */

	public abstract void move();
	public Region getRegion() {
		rgn.setLocation(x, y);
		return rgn;
	}
	public void goRemove() {
		state = REMOVE;
		
	}
	public void remove() {
		state = REMOVE;
		Tower.shoots.remove(this);
		World.map.remove(this);
	}
	public abstract void boom();
	public double distence(Monster m) {
		double distanceX = 1.0*(m.getX()+m.getWidth()/2)-x;//相对坐标
		double distanceY = 1.0*(m.getY()+m.getHeight()/2)-y;
		double distance = Math.sqrt(distanceX*distanceX+distanceY*distanceY);
		return distance;
	}
	public abstract int getAttack();
	public void upAttack() {
		attack*=2;
	}
}
