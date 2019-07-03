package game.guaiwu;

import java.awt.image.BufferedImage;

public class YangTouGuai extends Monster{
	public YangTouGuai () {
		super(100, 100);
		this.speed = 2;
		this.blood = 1000;
		this.maxBlood = 1000;
		this.award = 30;
		
	}
	
	int moveIndex = 0;//控制图片切换
	int deadIndex = 0;
	@Override
	public BufferedImage getImage() {
		if(isLife()) {
			if(isMoveUp()) {
				img = MonsterImages.monsterMap.get("Yang_Tou_Guai_up"+moveIndex++/10%8);
				return img;
			}else if(isMoveDown()) {
				img = MonsterImages.monsterMap.get("Yang_Tou_Guai_down"+moveIndex++/10%8);
				return img;
			}else if(isMoveLeft()) {
				img = MonsterImages.monsterMap.get("Yang_Tou_Guai_left"+moveIndex++/10%8);
				return img;
			}else{
				img = MonsterImages.monsterMap.get("Yang_Tou_Guai_right"+moveIndex++/10%8);
				return img;
			}
		}else if(isDead()){
			img = MonsterImages.monsterMap.get("Yang_Tou_Guai_death"+deadIndex++/10%8);
			if(deadIndex/10==8) {
				LifeState = REMOVE;
			}	
			return img;
		}else {
			return null;
		}
		
	}


}
