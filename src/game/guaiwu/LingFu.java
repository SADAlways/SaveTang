package game.guaiwu;

import java.awt.image.BufferedImage;

import game.world.Music;
import game.world.World;

public class LingFu extends Monster{
	public LingFu () {
		super(100,100);
		this.speed = 2;
		this.blood = 10000;
		this.maxBlood = 10000;
		this.award = 150;
		
	}
	
	int moveIndex = 0;//控制图片切换
	int deadIndex = 0;
	@Override
	public BufferedImage getImage() {
		if(isLife()) {
			if(isMoveUp()) {
				img = MonsterImages.monsterMap.get("Ling_Fu_up"+moveIndex++/10%9);
				return img;
			}else if(isMoveDown()) {
				img = MonsterImages.monsterMap.get("Ling_Fu_down"+moveIndex++/10%9);
				return img;
			}else if(isMoveLeft()) {
				img = MonsterImages.monsterMap.get("Ling_Fu_left"+moveIndex++/10%9);
				return img;
			}else{
				img = MonsterImages.monsterMap.get("Ling_Fu_right"+moveIndex++/10%9);
				return img;
			}
		}else if(isDead()){
			img = MonsterImages.monsterMap.get("Ling_Fu_death"+deadIndex++/10%10);
			if(deadIndex/10==10) {
				LifeState = REMOVE;
			}	
			return img;
		}else {
			return null;
		}
		
	}
	@Override
	public void goDead() {
		Music.music.get("womendead").play();
		World.money+=getAward();
		LifeState = DEAD;
	}

}
