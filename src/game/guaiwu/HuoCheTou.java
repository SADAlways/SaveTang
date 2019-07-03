package game.guaiwu;

import java.awt.image.BufferedImage;

import game.world.Music;
import game.world.World;

public class HuoCheTou extends Monster {
	public HuoCheTou() {
		super(100, 100);
		this.speed = 1;
		this.blood = 100000;
		this.maxBlood = 100000;
		this.award = 600;
		
	}
	
	int moveIndex = 0;//控制图片切换
	int deadIndex = 0;
	@Override
	public BufferedImage getImage() {
		if(isLife()) {
			if(isMoveUp()) {
				img = MonsterImages.monsterMap.get("Huo_Che_Tou_up"+moveIndex++/10%8);
				return img;
			}else if(isMoveDown()) {
				img = MonsterImages.monsterMap.get("Huo_Che_Tou_down"+moveIndex++/10%8);
				return img;
			}else if(isMoveLeft()) {
				img = MonsterImages.monsterMap.get("Huo_Che_Tou_left"+moveIndex++/10%8);
				return img;
			}else{
				img = MonsterImages.monsterMap.get("Huo_Che_Tou_right"+moveIndex++/10%8);
				return img;
			}
		}else if(isDead()){
			img = MonsterImages.monsterMap.get("Huo_Che_Tou_death"+deadIndex++/10%9);
			if(deadIndex/10==9) {
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
