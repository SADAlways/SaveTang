package game.ta;

import game.attackelements.Magic;
import game.attackelements.MonkeyKingBar;
import game.world.Music;
import game.world.World;
import sun.nio.cs.ext.MacArabic;

public class ZhuBaJie extends Tower{

	public ZhuBaJie(int x, int y) {
		super(x, y,100,100);
		range = 300;//攻击范围
		bulletX = 0;//子弹X
		bulletY = 0;//子弹y
		attackSpeed=1000;//子弹速度
		buymoney=1500;//金币
		World.money-=1500;
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
		shootObject = new Magic(x+bulletX,y+bulletY,target);
		switch (level) {
		case 3:shootObject.upAttack();
		case 2:shootObject.upAttack();
		case 1:break;
		}
	}

}
