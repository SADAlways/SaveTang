package game.ta;

import game.attackelements.MonkeyKingBar;
import game.world.Music;
import game.world.World;
public class HouZi extends Tower{

	public HouZi(int x,int y) {
		super(x, y, 200, 200);
		range = 500;
		bulletX=70;
		bulletY=50;
		attackSpeed=1000;
		buymoney =3000;
		World.money-=3000;
		Music.music.get("money").play();

	}
	public void attack() {
		if(target==null) {
			modle.play(ActionType.STAND);
		}else
		modle.play(ActionType.ATTACK);
	}
	
	public void shoot() {
		shootObject = new MonkeyKingBar(x+bulletX, y+bulletY, target);
		switch(level){
		case 3: shootObject.upAttack();
		case 2: shootObject.upAttack();
		case 1: break;
		}
		
	}
	
}
