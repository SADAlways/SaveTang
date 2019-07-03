package game.guaiwu;

import java.awt.image.BufferedImage;

public class LaoHu extends Monster{
	public LaoHu () {
		super(90, 80);
		this.speed = 3;
		this.blood = 500;
		this.maxBlood = 500;
		this.award = 20;
		
	}
	
	int moveIndex = 0;//控制图片切换
	int deadIndex = 0;
	@Override
	public BufferedImage getImage() {
		if(isLife()) {
			if(isMoveUp()) {
				img = MonsterImages.monsterMap.get("Lao_Hu_up"+moveIndex++/10%8);
				return img;
			}else if(isMoveDown()) {
				img = MonsterImages.monsterMap.get("Lao_Hu_down"+moveIndex++/10%8);
				return img;
			}else if(isMoveLeft()) {
				img = MonsterImages.monsterMap.get("Lao_Hu_left"+moveIndex++/10%8);
				return img;
			}else{
				img = MonsterImages.monsterMap.get("Lao_Hu_right"+moveIndex++/10%8);
				return img;
			}
		}else if(isDead()){
			img = MonsterImages.monsterMap.get("Lao_Hu_death"+deadIndex++/10%7);
			if(deadIndex/10==7) {
				LifeState = REMOVE;
			}	
			return img;
		}else {
			return null;
		}
		
	}


}
