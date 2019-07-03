package game.ta;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import game.guaiwu.Monster;
import game.world.Images;
import game.world.UnitObject;
import game.world.World;

public class TangSeng extends UnitObject{

	public int blood;
	public int maxBlood=20;
	private static BufferedImage img;
	
	private int LifeState = LEFT;
	
	public TangSeng() {

		this.x = 1450;
		this.y = 850;
		this.width = 60;
		this.height = 120;
		this.blood = 20;
		World.map.add(this);
	}
	public boolean isLife() {
		return LifeState == LEFT;
	}
	public boolean isDead() {
		return LifeState == DEAD;
	}
	int standIndex = 0;
	@Override
	public BufferedImage getImage() {
		if(isLife()) {
			img = Images.readImage("ta/tangseng/tangseng"+standIndex++/10%7+".png");
			return img;
		}else {
			return null;
		}
	}
	public void subBlood() {
		blood--;
	}
	public void goDead() {
		LifeState = DEAD;
	}
	public int getBlood() {
		return blood;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	//判断唐僧是否被伤害
	public boolean isHurt(Monster m) {
		int x1 = this.x-m.getWidth();
		int x2 = this.x+this.getWidth();
		int y1 = this.y-m.getHeight();
		int y2 = this.y+this.getHeight();
		int x = m.getX();
		int y = m.getY();
		return x>x1 && x<x2 && y>y1 && y<y2;
	}

}
