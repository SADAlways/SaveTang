package game.attackelements;

import java.awt.image.BufferedImage;
import java.util.Random;

import game.guaiwu.Monster;
import game.world.Music;
import game.world.World;

/*
 * 金箍棒
 * 攻击效果：弹射，暴击
 */
public class MonkeyKingBar extends ShootObject{

	public MonkeyKingBar(int x,int y,Monster m) {
		super(x, y, 40, 40, 10, m);
		Music.music.get("mkb").play();
		// TODO Auto-generated constructor stub
	}
	
	int shootIndex = 1;//控制射击图片切换
	@Override
	public BufferedImage getImage() {
		if(isFly()) {
			img = ShootImages.shootMap.get("MKB_shoot"+shootIndex++/10%4);
			return img;
		}else {
			return null;
		}
		
	}
	
	@Override
	public void move() {
		if(m==null)
			return;
		if(flag || !m.isLife()) {
			bounce();		
		}else {
			distanceX = 1.0*(m.getX()+m.getWidth()/2)-x;//相对坐标
			distanceY = 1.0*(m.getY()+m.getHeight()/2)-y;
			distance = Math.sqrt(distanceX*distanceX+distanceY*distanceY);
			xSpeed = (int)(distanceX/distance*speed);//x轴分速度
			ySpeed = (int)(distanceY/distance*speed);//y轴分速度
			x+=xSpeed;
			y+=ySpeed;
		}	
		
	}
	int xIndex = 0;//x轴位移
	int yIndex = 0;//y轴位移
	int times =0;//控制时间
	int cx = -1;int cy = -1;
	boolean[] flags = new boolean[100];//控制只碰撞一次
	public void bounce() {
		if(times>=3)
			remove();
		if(cx==-1)
			cx = new Random().nextInt(2);
		if(cy==-1)
			cy = new Random().nextInt(2);	
		//x方向控制
		if(cx==0) {
			x+=1;xIndex++;
			if(xIndex>=100) {
				cx=1;times++;
			}
		}else {
			x-=1;xIndex--;
			if(xIndex<=-100) {
				cx=0;times++;
			}
		}	
		//y方向控制
		if(cy==0) {
			y+=1;yIndex++;
			if(yIndex>=100) {
				cy=1;
			}
		}else {
			y-=1;yIndex--;
			if(yIndex<=-100) {
				cy=0;
			}
		}	
	
		//判断碰撞
//		if(World.monsters.size()==0) {
//			remove();
//		}
		
		for (int i = 0;i<World.monsters.size();i++) {
			try {
				Monster mTo = World.monsters.get(i);
			if(!flags[i] && this.distence(mTo)<=20) {
				mTo.subBlood(getAttack());
				flags[i] = true;
				if(mTo.isLife()&&mTo.getBlood()<=0) {
					mTo.goDead();
					
				}
			}
			} catch (ArrayIndexOutOfBoundsException e) {
				remove();
			}
		}
	}

	boolean flag = false;
	@Override
	public void boom() {
		if(m.isLife()&&this.isFly()&& distance<=20&&!flag) {
			m.subBlood(getAttack());
			flag = true;
			if(m.isLife()&&m.getBlood()<=0) {
				m.goDead();
				
			}
		}
	}

	@Override
	public int getAttack() {
		// TODO Auto-generated method stub
		return 1000;
	}
}
