package game.guaiwu;

import java.awt.image.BufferedImage;

public class JiangShi extends Monster{
	public JiangShi () {
		super(80, 80);
		this.speed = 1;
		this.blood = 2000;
		this.maxBlood = 2000;
		this.award = 50;
		
	}
	
	int moveIndex = 0;//控制图片切换
	int deadIndex = 0;
	@Override
	public BufferedImage getImage() {
		if(isLife()) {
			if(isMoveUp()) {
				img = MonsterImages.monsterMap.get("Jiang_Shi_up"+moveIndex++/10%5);
				return img;
			}else if(isMoveDown()) {
				img = MonsterImages.monsterMap.get("Jiang_Shi_down"+moveIndex++/10%5);
				return img;
			}else if(isMoveLeft()) {
				img = MonsterImages.monsterMap.get("Jiang_Shi_left"+moveIndex++/10%5);
				return img;
			}else{
				img = MonsterImages.monsterMap.get("Jiang_Shi_right"+moveIndex++/10%5);
				return img;
			}
		}else if(isDead()){
			img = MonsterImages.monsterMap.get("Jiang_Shi_death"+deadIndex++/10%10);
			if(deadIndex/10==10) {
				LifeState = REMOVE;
			}	
			return img;
		}else {
			return null;
		}
		
	}


}
