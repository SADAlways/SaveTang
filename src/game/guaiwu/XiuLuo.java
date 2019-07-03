package game.guaiwu;

import java.awt.image.BufferedImage;

import game.world.Images;

/*
 * 怪物:修罗
 */
public class XiuLuo extends Monster {

	public XiuLuo() {
		super(80, 80);
		this.speed = 1;
		this.blood = 60000;
		this.maxBlood = 60000;
		this.award = 450;
		
	}
	
	int moveIndex = 0;//控制图片切换
	int deadIndex = 0;
	@Override
	public BufferedImage getImage() {
		if(isLife()) {
			if(isMoveUp()) {
				img = MonsterImages.monsterMap.get("xiuluo_up_"+moveIndex++/10%4);
				return img;
			}else if(isMoveDown()) {
				img = MonsterImages.monsterMap.get("xiuluo_down_"+moveIndex++/10%4);
				return img;
			}else if(isMoveLeft()) {
				img = MonsterImages.monsterMap.get("xiuluo_left_"+moveIndex++/10%4);
				return img;
			}else{
				img = MonsterImages.monsterMap.get("xiuluo_right_"+moveIndex++/10%4);
				return img;
			}
		}else if(isDead()){
			img = MonsterImages.monsterMap.get("xiuluo_death_"+deadIndex++/10%7);
			if(deadIndex/10==8) {
				LifeState = REMOVE;
			}	
			return img;
		}else {
			return null;
		}
		
	}

}
