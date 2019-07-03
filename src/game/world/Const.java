package game.world;

import java.util.List;
import java.util.Vector;

import game.attackelements.ShootObject;
import game.guaiwu.Monster;
import game.ta.Tower;

public interface Const {
	//World world = new World();
	//SelectUnitPanel sup = new SelectUnitPanel();
	int UP = 0;//怪物向上走
	int DOWN = 1;//怪物向下走
	int LEFT = 2;//怪物向左走
	int RIGHT = 3;//怪物向右走
	int LIFE = 4;//怪物状态:生存
	int DEAD = 5;//怪物状态:死亡
	int REMOVE = 6;//怪物状态:移除
	
	List<Monster> monsters = new Vector<>();
	List<Tower> towers = new Vector<>();
	List<ShootObject> bullets = new Vector<>();
	List<UnitObject> uints = new Vector<>();
	Area noBuildings=new Area();
	
	/** 定时器周期	 */
	int cycle = 10;
	
	enum ActionType{
		STAND,STAND1,STAND2,MOVE,ATTACK,ATTACK1,ATTACK2,DEAD,MOVE_LEFT,MOVE_RIGHT,MOVE_UP,MOVE_DOWN;
	}
	
	enum GameState{
		START,RUNNING,PAUSE,LOST,WIN,OVER;
	}
	
}
