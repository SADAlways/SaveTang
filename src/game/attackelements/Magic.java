package game.attackelements;

import java.awt.image.BufferedImage;

import game.guaiwu.Monster;
import game.world.Music;

public class Magic extends ShootObject{
	public Magic(int x,int y,Monster m) {
		super(x,y,120,120,5,m);
		Music.music.get("water").play();
	
	}
	
	

	int shootIndex = 1;//控制射击图片切换
	int shootSpeed = 0;//控制图片切换速率
	@Override
	public BufferedImage getImage() {
		if(isFly()) {
			img = ShootImages.shootMap.get("magic_shoot");
			return img;
		}else {
			return null;
		}
		
	}
	public void move() {
		if(m==null)
			return;
		distanceX = 1.0*(m.getX()+m.getWidth()/2)-x;//相对坐标
		distanceY = 1.0*(m.getY()+m.getHeight()/2)-y;
		distance = Math.sqrt(distanceX*distanceX+distanceY*distanceY);
		xSpeed = (int)(distanceX/distance*speed);//x轴分速度
		ySpeed = (int)(distanceY/distance*speed);//y轴分速度
		x+=xSpeed;
		y+=ySpeed;
		if(!m.isLife()||distance<10) {
			remove();
		}
	
	}
	public void boom() {
		if(m.isLife()&&this.isFly()&& distance<=20) {
			m.subBlood(getAttack());
			this.state = BOOM;
			if(m.getBlood()<=0) {
				m.goDead();
				
				
			}
		}
	}
	@Override
	public int getAttack() {
		// TODO Auto-generated method stub
		return 800;
	}



}
