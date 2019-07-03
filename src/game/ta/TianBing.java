package game.ta;

import game.attackelements.Bullet;
import game.attackelements.Lightning;
import game.attackelements.MonkeyKingBar;
import game.attackelements.ShootObject;
import game.world.Music;
import game.world.World;

public class TianBing extends Tower{

	public TianBing(int x, int y) {
		super(x, y, 100, 100);
		range = 300;
		bulletX=50;
		bulletY=50;
		attackSpeed=500;
		buymoney=800;
		World.money-=800;
		Music.music.get("money").play();
	}
	public void attack() {
		if(target==null) {
			modle.play(ActionType.STAND);
		}else
		modle.play(ActionType.ATTACK);
	}
	@Override
	public void shoot() {
		new MonkeyKingBar(x+bulletX, y+bulletY, target);
		switch(level){
		case 3: shootObject.upAttack();
		case 2: shootObject.upAttack();
		case 1: break;
		}
	}
}
