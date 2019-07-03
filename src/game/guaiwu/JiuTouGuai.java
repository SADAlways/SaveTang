package game.guaiwu;

import java.awt.image.BufferedImage;

import game.world.Music;
import game.world.World;

public class JiuTouGuai extends Monster{
	public JiuTouGuai () {
		super(100, 100);
		this.speed = 2;
		this.blood = 35000;
		this.maxBlood = 35000;
		this.award = 350;
		
	}
	
	int moveIndex = 0;//控制图片切换
	int deadIndex = 0;
	@Override
	public BufferedImage getImage() {
		if(isLife()) {
			if(isMoveUp()) {
				img = MonsterImages.monsterMap.get("Jiu_Tou_Guai_up"+moveIndex++/10%8);
				return img;
			}else if(isMoveDown()) {
				img = MonsterImages.monsterMap.get("Jiu_Tou_Guai_down"+moveIndex++/10%8);
				return img;
			}else if(isMoveLeft()) {
				img = MonsterImages.monsterMap.get("Jiu_Tou_Guai_left"+moveIndex++/10%8);
				return img;
			}else{
				img = MonsterImages.monsterMap.get("Jiu_Tou_Guai_right"+moveIndex++/10%8);
				return img;
			}
		}else if(isDead()){
			img = MonsterImages.monsterMap.get("Jiu_Tou_Guai_death"+deadIndex++/10%8);
			if(deadIndex/10==8) {
				LifeState = REMOVE;
			}	
			return img;
		}else {
			return null;
		}
		
	}
	@Override
	public void goDead() {
		Music.music.get("mendead").play();
		World.money+=getAward();
		LifeState = DEAD;
	}

}
