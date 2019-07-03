package game.attackelements;

import java.awt.image.BufferedImage;

import game.guaiwu.Monster;
import game.world.Music;
import game.world.World;

public class Lightning extends ShootObject{
	
	public Lightning(int x,int y,Monster m) {
		super(x,y,55,319,10,m);
		Music.music.get("lightning").play();
	}

	int shootIndex = 0;//控制射击图片切换
	int boomIndex = 0;
	@Override
	public BufferedImage getImage() {
		if(isFly()) {
			img = ShootImages.shootMap.get("lightning_shoot_"+shootIndex);
			return img;
		}else if(isBoom()){
			img = ShootImages.shootMap.get("lightning_shoot_"+boomIndex++/10%3);
			if(boomIndex==29)
				state=REMOVE;
			return img;
		}else {
			remove();
			return null;
		}
		
	}

	@Override
	public void move() {
		if(m==null)
			return;
		distanceX = 1.0*(m.getX()+m.getWidth()/2)-x;//相对坐标
		distanceY = 1.0*(m.getY()+m.getHeight()/2-250)-y;
		distance = Math.sqrt(distanceX*distanceX+distanceY*distanceY);
		xSpeed = (int)(distanceX/distance*speed);//x轴分速度
		ySpeed = (int)(distanceY/distance*speed);//y轴分速度
		x+=xSpeed;
		y+=ySpeed;
		if(m.isDead()||distance<10) {
			remove();
		}
	}

	@Override
	public void boom() {
		if(m.isLife()&&this.isFly()&& distance<=20) {
			m.subBlood(getAttack());
			this.state = BOOM;
			if(m.getBlood()<=0) {
				m.goDead();
				
			}
		}
	
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getAttack() {
		// TODO Auto-generated method stub
		return 300;
	}
}
