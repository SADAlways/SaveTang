package game.guaiwu;

import java.awt.image.BufferedImage;

public class LeiNiaoRen extends Monster{
	public LeiNiaoRen() {
		super(120, 120);
		this.speed = 2;
		this.blood = 3000;
		this.maxBlood = 3000;
		this.award = 70;
		
	}
	
	int moveIndex = 0;//控制图片切换
	int deadIndex = 0;
	@Override
	public BufferedImage getImage() {
		if(isLife()) {
			if(isMoveUp()) {
				img = MonsterImages.monsterMap.get("Lei_Niao_Ren_up"+moveIndex++/20%5);
				return img;
			}else if(isMoveDown()) {
				img = MonsterImages.monsterMap.get("Lei_Niao_Ren_down"+moveIndex++/20%5);
				return img;
			}else if(isMoveLeft()) {
				img = MonsterImages.monsterMap.get("Lei_Niao_Ren_left"+moveIndex++/20%5);
				return img;
			}else{
				img = MonsterImages.monsterMap.get("Lei_Niao_Ren_right"+moveIndex++/20%5);
				return img;
			}
		}else if(isDead()){
			img = MonsterImages.monsterMap.get("Lei_Niao_Ren_death"+deadIndex++/10%9);
			if(deadIndex/10==9) {
				LifeState = REMOVE;
			}	
			return img;
		}else {
			return null;
		}
		
	}


}
