package game.attackelements;

import java.awt.image.BufferedImage;
import java.util.HashMap;

import game.world.Images;
/*
 * 射击飞行物图片类
 */
public class ShootImages {
	public static HashMap<String,BufferedImage> shootMap = new HashMap<>();
	static {
		/*
		 * 紫色子弹射击
		 */
		shootMap.put("bullet_shoot", Images.readImage("attack//bullet0.png"));
		shootMap.put("magic_shoot", Images.readImage("attack//magic//magic.png"));
		
		for (int i = 1; i < 6; i++) {
			shootMap.put("bullet_boom_"+i, Images.readImage("attack//bullet"+i+".png"));
		}
		/*
		 * 金箍棒
		 */
		for (int i = 0; i < 4; i++) {
			shootMap.put("MKB_shoot"+i, Images.readImage("attack//MKB//mkb"+i+".png"));
			/*
			 * maigic
			 */
		}
		/*
		 * 旋风
		 */
		for(int i = 0;i< 18;i++) {
			shootMap.put("wind_shoot"+i, Images.readImage("attack//wind//wind"+i+".png"));
		}
		/*
		 * 闪电攻击
		 */
		for(int i = 0;i< 3;i++) {
			shootMap.put("lightning_shoot_"+i, Images.readImage("attack//lightning//"+i+".png"));
		}

	}
}
