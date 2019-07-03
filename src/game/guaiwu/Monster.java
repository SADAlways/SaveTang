package game.guaiwu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import game.attackelements.ShootObject;
import game.world.Images;
import game.world.Music;
import game.world.Panel;
import game.world.Region;
import game.world.UnitObject;
import game.world.World;

public abstract class Monster extends UnitObject{
//	protected static final int UP = 0;//怪物向上走
//	protected static final int DOWN = 1;//怪物向下走
//	protected static final int LEFT = 2;//怪物向左走
//	protected static final int RIGHT = 3;//怪物向右走
//	protected static final int LIFE = 4;//怪物状态:生存
//	protected static final int DEAD = 5;//怪物状态:死亡
//	protected static final int REMOVE = 6;//怪物状态:移除
//	
//	protected int MoveState = DOWN;//初始怪物移动方向
//	protected int LifeState = LIFE;//初始怪物状态
	public int speed;//怪物移动速度
	public int blood;//怪物血量
	public int maxBlood=1;//怪物最大血量
	public int award;//怪物赏金
	
	protected static BufferedImage img;
	protected Region rgn;//图形边界
	
	
	public Monster(int width,int height) {
		this.width = width;
		this.height = height;
		this.x = 1580;
		this.y = -this.height;
		World.map.add(this);
		World.monsters.add(this);
		rgn = new Region(getImage());
		
	}
	public abstract BufferedImage getImage();
//	public void drowBlood(Graphics g){
//		if(!isLife())return;
//		g.setColor(Color.red);
//		//double b = 1.0*blood/maxBlood;
//		
//		g.fillRect(x, y, width/2*blood/maxBlood, 3);
//		g.drawRoundRect(x-1, y-1, width/2, 5, 5, 5);
//	}
	/*
	 * get和set方法
	 */
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
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	/*
	 * 判断怪物当前移动状态
	 */
	public boolean isMoveUp() {
		return MoveState==UP;
	}
	public boolean isMoveDown() {
		return MoveState==DOWN;
	}
	public boolean isMoveLeft() {
		return MoveState==LEFT;
	}
	public boolean isMoveRight() {
		return MoveState==RIGHT;
	}
	/*
	 * 怪物生存状态
	 */
	
	/*
	 * 怪物移动
	 * 怪物的几个拐点：
	 * 1.向左拐(1580,80)
	 * 2.向下拐(120,80)
	 * 3.向右拐(120,760)
	 * 4.向上拐(290,760)
	 * 5.向右拐(290,250)
	 * 6.向下拐(460,250)
	 * 7.向右拐(460,840)
	 * 8.向上拐(710,840)
	 * 9.向右拐(240,710)
	 * 10.向下拐(1450,220)
	 * 11.向右拐(1450,420)
	 * 12.向下拐(870,450)
	 * 13.向右拐(870,580)
	 * 14.向下拐(1450,580)
	 */
	int swagPoint = 1;//第几个拐点
	public void move() {
		if(y>=60 && swagPoint ==1) {
			MoveState = LEFT;
			swagPoint++;
		}else if(x<=100 && swagPoint ==2) {
			MoveState = DOWN;
			swagPoint++;
		}else if(y>=760 && swagPoint ==3) {
			MoveState = RIGHT;
			swagPoint++;
		}else if(x>=270 && swagPoint ==4) {
			MoveState = UP;
			swagPoint++;
		}else if(y<=250 && swagPoint ==5) {
			MoveState = RIGHT;
			swagPoint++;
		}else if(x>=440 && swagPoint ==6) {
			MoveState = DOWN;
			swagPoint++;
		}else if(y>=840 && swagPoint ==7) {
			MoveState = RIGHT;
			swagPoint++;
		}else if(x>=690 && swagPoint ==8) {
			MoveState = UP;
			swagPoint++;
		}else if(y<=240 && swagPoint ==9) {
			MoveState = RIGHT;
			swagPoint++;
		}else if(x>=1450 && swagPoint ==10) {
			MoveState = DOWN;
			swagPoint++;
		}else if(y>=420 && swagPoint ==11) {
			MoveState = LEFT;
			swagPoint++;
		}else if(x<=870 && swagPoint ==12) {
			MoveState = DOWN;
			swagPoint++;
		}else if(y>=580 && swagPoint ==13) {
			MoveState = RIGHT;
			swagPoint++;
		}else if(x>=1430 && swagPoint ==14) {
			MoveState = DOWN;
			swagPoint++;
		}
		if(isLife()) {
			switch(MoveState) {
			case UP:y-=speed;break;
			case DOWN:y+=speed;break;
			case LEFT:x-=speed;break;
			case RIGHT:x+=speed;break;
			}
		}
		
	}

	public Region getRegion() {
		rgn.setLocation(x, y);
		return rgn;
	}
	/*
	 * 判断像素碰撞是否触发
	 */
	public boolean isHit(ShootObject other) {
		if(!isLife()||!other.isFly())return false;
		return(getRegion().intersects(other.getRegion()));

	}
	public void subBlood(int attack) {
		blood-=attack;
	}
	public int getBlood() {
		return blood;
	}
	public int getAward() {
		return award;
	}
	public void goDead() {
		Music.music.get("dead").play();
		World.money+=getAward();
		LifeState = DEAD;
	}
}
