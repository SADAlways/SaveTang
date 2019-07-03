package game.guaiwu;

import java.awt.image.BufferedImage;

import game.world.Music;
import game.world.World;

public class NvWa extends Monster{
	public NvWa () {
		super(100, 100);
		this.speed = 1;
		this.blood = 20000;
		this.maxBlood = 20000;
		this.award = 300;
		
	}
	
	int moveIndex = 0;//控制图片切换
	int deadIndex = 0;
	@Override
	public BufferedImage getImage() {
		if(isLife()) {
			if(isMoveUp()) {
				img = MonsterImages.monsterMap.get("NvWa_up"+moveIndex++/10%7);
				return img;
			}else if(isMoveDown()) {
				img = MonsterImages.monsterMap.get("NvWa_down"+moveIndex++/10%7);
				return img;
			}else if(isMoveLeft()) {
				img = MonsterImages.monsterMap.get("NvWa_left"+moveIndex++/10%7);
				return img;
			}else{
				img = MonsterImages.monsterMap.get("NvWa_right"+moveIndex++/10%7);
				return img;
			}
		}else if(isDead()){
			img = MonsterImages.monsterMap.get("NvWa_death"+deadIndex++/10%10);
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
