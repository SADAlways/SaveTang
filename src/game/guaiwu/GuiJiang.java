package game.guaiwu;

import java.awt.image.BufferedImage;

import game.world.Music;
import game.world.World;

public class GuiJiang extends Monster{

	public GuiJiang() {
		super(120, 120);
		this.speed = 1;
		this.blood = 80000;
		this.maxBlood = 80000; 
		this.award = 500;
		
	}
	
	int moveIndex = 0;//控制图片切换
	int deadIndex = 0;
	@Override
	public BufferedImage getImage() {
		if(isLife()) {
			if(isMoveUp()) {
				img = MonsterImages.monsterMap.get("Gui_Jiang_up"+moveIndex++/10%5);
				return img;
			}else if(isMoveDown()) {
				img = MonsterImages.monsterMap.get("Gui_Jiang_down"+moveIndex++/10%5);
				return img;
			}else if(isMoveLeft()) {
				img = MonsterImages.monsterMap.get("Gui_Jiang_left"+moveIndex++/10%5);
				return img;
			}else{
				img = MonsterImages.monsterMap.get("Gui_Jiang_right"+moveIndex++/10%5);
				return img;
			}
		}else if(isDead()){
			img = MonsterImages.monsterMap.get("Gui_Jiang_death"+deadIndex++/10%9);
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
		Music.music.get("mendead").play();
		World.money+=getAward();
		LifeState = DEAD;
	}


}
