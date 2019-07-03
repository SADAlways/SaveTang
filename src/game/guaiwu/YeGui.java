package game.guaiwu;

import java.awt.image.BufferedImage;

public class YeGui extends Monster {
	public YeGui () {
		super(90, 90);
		this.speed = 2;
		this.blood = 1500;
		this.maxBlood = 1500;
		this.award = 50;
		
	}
	
	int moveIndex = 0;//控制图片切换
	int deadIndex = 0;
	@Override
	public BufferedImage getImage() {
		if(isLife()) {
			if(isMoveUp()) {
				img = MonsterImages.monsterMap.get("Ye_Gui_up"+moveIndex++/10%8);
				return img;
			}else if(isMoveDown()) {
				img = MonsterImages.monsterMap.get("Ye_Gui_down"+moveIndex++/10%8);
				return img;
			}else if(isMoveLeft()) {
				img = MonsterImages.monsterMap.get("Ye_Gui_left"+moveIndex++/10%8);
				return img;
			}else{
				img = MonsterImages.monsterMap.get("Ye_Gui_right"+moveIndex++/10%8);
				return img;
			}
		}else if(isDead()){
			img = MonsterImages.monsterMap.get("Ye_Gui_death"+deadIndex++/10%9);
			if(deadIndex/10==9) {
				LifeState = REMOVE;
			}	
			return img;
		}else {
			return null;
		}
		
	}

}
