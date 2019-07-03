package game.guaiwu;

import java.awt.image.BufferedImage;

public class LaoYao extends Monster{
	public LaoYao() {
		super(80, 80);
		this.speed = 1;
		this.blood = 4500;
		this.maxBlood = 4500;
		this.award = 80;
		
	}
	
	int moveIndex = 0;//控制图片切换
	int deadIndex = 0;
	@Override
	public BufferedImage getImage() {
		if(isLife()) {
			if(isMoveUp()) {
				img = MonsterImages.monsterMap.get("Lao_Yao_up"+moveIndex++/10%5);
				return img;
			}else if(isMoveDown()) {
				img = MonsterImages.monsterMap.get("Lao_Yao_down"+moveIndex++/10%5);
				return img;
			}else if(isMoveLeft()) {
				img = MonsterImages.monsterMap.get("Lao_Yao_left"+moveIndex++/10%5);
				return img;
			}else{
				img = MonsterImages.monsterMap.get("Lao_Yao_right"+moveIndex++/10%5);
				return img;
			}
		}else if(isDead()){
			img = MonsterImages.monsterMap.get("Lao_Yao_death"+deadIndex++/10%10);
			if(deadIndex/10==10) {
				LifeState = REMOVE;
			}	
			return img;
		}else {
			return null;
		}
		
	}

}
