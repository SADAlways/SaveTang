package game.guaiwu;

import java.awt.image.BufferedImage;

import game.world.Images;
import game.world.Region;
/*
 * 怪物:狼人
 */
public class Wolf extends Monster{
	static int newcount = 0;
	static int removecount = 0;

	
	public Wolf() {
		super(44, 60);
		this.speed = 1;//移动速度
		this.blood = 3;//生命值
	}
	
	int moveIndex = 0;//控制图片切换
	@Override
	public BufferedImage getImage() {
		if(isLife()) {
			if(isMoveUp()) {
				img = MonsterImages.monsterMap.get("wolf_up_"+moveIndex++/10%4);
				return img;
			}else if(isMoveDown()) {
				img = MonsterImages.monsterMap.get("wolf_down_"+moveIndex++/10%4);
				return img;
			}else if(isMoveLeft()) {
				img = MonsterImages.monsterMap.get("wolf_left_"+moveIndex++/10%4);
				return img;
			}else if(isMoveRight()){
				img = MonsterImages.monsterMap.get("wolf_right_"+moveIndex++/10%4);
				return img;
			}else {
				return null;
			}
		}else {
			LifeState = REMOVE;
			return null;
		}
		
	}

	
}
