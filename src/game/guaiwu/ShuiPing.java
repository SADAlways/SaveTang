package game.guaiwu;

import java.awt.image.BufferedImage;

import game.world.Music;
import game.world.World;

public class ShuiPing extends Monster{
	public ShuiPing () {
		super(100, 100);
		this.speed = 1;
		this.blood = 15000;
		this.maxBlood = 15000;
		this.award = 200;
		
	}
	
	int moveIndex = 0;//控制图片切换
	int deadIndex = 0;
	@Override
	public BufferedImage getImage() {
		if(isLife()) {
			if(isMoveUp()) {
				img = MonsterImages.monsterMap.get("ShuiPing_up"+moveIndex++/10%8);
				return img;
			}else if(isMoveDown()) {
				img = MonsterImages.monsterMap.get("ShuiPing_down"+moveIndex++/10%8);
				return img;
			}else if(isMoveLeft()) {
				img = MonsterImages.monsterMap.get("ShuiPing_left"+moveIndex++/10%8);
				return img;
			}else{
				img = MonsterImages.monsterMap.get("ShuiPing_right"+moveIndex++/10%8);
				return img;
			}
		}else if(isDead()){
			img = MonsterImages.monsterMap.get("ShuiPing_death"+deadIndex++/10%10);
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
