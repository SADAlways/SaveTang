package game.ta;

import java.awt.Desktop.Action;

import game.attackelements.Bullet;
import game.attackelements.MonkeyKingBar;
import game.attackelements.Wind;
import game.world.Music;
import game.world.World;
import game.world.Const.ActionType;

public class ShaSeng extends Tower{

	public ShaSeng(int x, int y) {
		super(x, y, 100,100);
		range=200;
		bulletX=0;
		bulletY=0;
		attackSpeed = 1000;
		buymoney =1000;
		World.money-=1000;
		Music.music.get("money").play();
	}


	//攻击
		public void attack() {
			//敌人为null 站立状态 不然攻击状态
			if(target==null) {
				modle.play(ActionType.STAND);
			}else {
				modle.play(ActionType.ATTACK);
			}
		}
		
		//射击
		public void shoot() {
			shootObject = new Wind(x+bulletX,y+bulletY,target);
			switch (level) {
			case 3:shootObject.upAttack();
			case 2:shootObject.upAttack();
			case 1:break;
			}
		}

	
}
