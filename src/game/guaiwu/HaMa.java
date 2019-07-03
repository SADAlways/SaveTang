package game.guaiwu;

import java.awt.image.BufferedImage;

public class HaMa extends Monster{
	public HaMa () {
		super(100, 100);
		this.speed = 2;
		this.blood = 800;
		this.maxBlood = 800;
		this.award = 25;
		
	}
	
	int moveIndex = 0;//控制图片切换
	int deadIndex = 0;
	@Override
	public BufferedImage getImage() {
		if(isLife()) {
			if(isMoveUp()) {
				img = MonsterImages.monsterMap.get("Ha_Ma_up"+moveIndex++/10%8);
				return img;
			}else if(isMoveDown()) {
				img = MonsterImages.monsterMap.get("Ha_Ma_down"+moveIndex++/10%8);
				return img;
			}else if(isMoveLeft()) {
				img = MonsterImages.monsterMap.get("Ha_Ma_left"+moveIndex++/10%8);
				return img;
			}else{
				img = MonsterImages.monsterMap.get("Ha_Ma_right"+moveIndex++/10%8);
				return img;
			}
		}else if(isDead()){
			img = MonsterImages.monsterMap.get("Ha_Ma_death"+deadIndex++/10%12);
			if(deadIndex/10==12) {
				LifeState = REMOVE;
			}	
			return img;
		}else {
			return null;
		}
		
	}

}
