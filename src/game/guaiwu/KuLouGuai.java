package game.guaiwu;

import java.awt.image.BufferedImage;

public class KuLouGuai extends Monster{
	public KuLouGuai() {
		super(90, 80);
		this.speed = 1;
		this.blood = 2500;
		this.maxBlood = 2500;
		this.award = 60;
		
	}
	
	int moveIndex = 0;//控制图片切换
	int deadIndex = 0;
	@Override
	public BufferedImage getImage() {
		if(isLife()) {
			if(isMoveUp()) {
				img = MonsterImages.monsterMap.get("Ku_Lou_Guai_up"+moveIndex++/10%8);
				return img;
			}else if(isMoveDown()) {
				img = MonsterImages.monsterMap.get("Ku_Lou_Guai_down"+moveIndex++/10%8);
				return img;
			}else if(isMoveLeft()) {
				img = MonsterImages.monsterMap.get("Ku_Lou_Guai_left"+moveIndex++/10%8);
				return img;
			}else{
				img = MonsterImages.monsterMap.get("Ku_Lou_Guai_right"+moveIndex++/10%8);
				return img;
			}
		}else if(isDead()){
			img = MonsterImages.monsterMap.get("Ku_Lou_Guai_death"+deadIndex++/10%10);
			if(deadIndex/10==10) {
				LifeState = REMOVE;
			}	
			return img;
		}else {
			return null;
		}
		
	}


}
