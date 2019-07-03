package game.ta;

import game.attackelements.Bullet;
import game.world.Music;
import game.world.World;

public class Longwang extends Tower{

	public Longwang(int x, int y) {
		super(x, y, 100, 100);
		range = 300;
		bulletX=70;
		bulletY=50;
		attackSpeed=300;
		buymoney=1500;
		World.money-=1500;
		Music.music.get("money").play();
	}
	public void attack() {
		if(target==null) {
			modle.play(ActionType.STAND);
		}else
		modle.play(ActionType.ATTACK1);
	}
	@Override
	public void shoot() {
		new Bullet(x+bulletX, y+bulletY, target);
		switch(level){
		case 3: shootObject.upAttack();
		case 2: shootObject.upAttack();
		case 1: break;
		}
	}
}
