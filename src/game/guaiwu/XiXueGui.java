package game.guaiwu;

import java.awt.image.BufferedImage;

import game.world.Music;
import game.world.World;

public class XiXueGui extends Monster{
	public XiXueGui() {
		super(90, 90);
		this.speed = 2;
		this.blood = 5000;
		this.maxBlood = 5000;
		this.award = 100;
		
	}
	
	int moveIndex = 0;//控制图片切换
	int deadIndex = 0;
	@Override
	public BufferedImage getImage() {
		if(isLife()) {
			if(isMoveUp()) {
				img = MonsterImages.monsterMap.get("Xi_Xue_Gui_up"+moveIndex++/10%8);
				return img;
			}else if(isMoveDown()) {
				img = MonsterImages.monsterMap.get("Xi_Xue_Gui_down"+moveIndex++/10%8);
				return img;
			}else if(isMoveLeft()) {
				img = MonsterImages.monsterMap.get("Xi_Xue_Gui_left"+moveIndex++/10%8);
				return img;
			}else{
				img = MonsterImages.monsterMap.get("Xi_Xue_Gui_right"+moveIndex++/10%8);
				return img;
			}
		}else if(isDead()){
			img = MonsterImages.monsterMap.get("Xi_Xue_Gui_death"+deadIndex++/10%8);
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

