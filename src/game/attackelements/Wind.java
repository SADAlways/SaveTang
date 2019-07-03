package game.attackelements;

import java.awt.image.BufferedImage;

import game.guaiwu.Monster;
import game.world.Music;
import game.world.World;
/*
 * 旋风
 * 攻击效果：范围伤害，减速效果
 */
public class Wind extends ShootObject{
	public Wind(int x,int y,Monster m) {
		super(x,y,100,100,5,m);
		Music.music.get("wind").play();

	}

	int shootIndex = 0;//控制图片切换
	@Override
	public BufferedImage getImage() {
		img = ShootImages.shootMap.get("wind_shoot"+shootIndex++/5%18);
		return img;
	}

	@Override
	public void move() {
		if(m==null)
			return;
		if(!this.isBoom()) {
			distanceX = 1.0*(m.getX()+m.getWidth()/2)-x;//相对坐标
			distanceY = 1.0*(m.getY()+m.getHeight()/2)-y;
			distance = Math.sqrt(distanceX*distanceX+distanceY*distanceY);
		}
		x+=xSpeed;
		y+=ySpeed;
		if(x<World.map.getX()||x>World.map.getX()+World.map.getWidth()
		|| y<World.map.getY()||y>World.map.getY()+World.map.getHeight()
		||xSpeed==0||ySpeed==0) {
			remove();
		}
	}
	boolean[] flags = new boolean[100];//控制每个怪物与旋风至产生一次碰撞
	@Override
	public void boom() {
		for (int i = 0; i < World.monsters.size(); i++) {
			Monster mTo = World.monsters.get(i);
			if(!flags[i] && distence(mTo)<30) {
				mTo.subBlood(getAttack());
				flags[i] = true;
				if(mTo.isLife()&&mTo.getBlood()<=0) {
					mTo.goDead();

				}
			}
		}		
	}

	@Override
	public int getAttack() {
		// TODO Auto-generated method stub
		return 800;
	}

}
