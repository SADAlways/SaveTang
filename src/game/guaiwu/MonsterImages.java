package game.guaiwu;

import java.awt.image.BufferedImage;
import java.util.HashMap;

import game.world.Images;
/**
 * 怪物图片类
 * @author TEDU
 *
 */
public class MonsterImages {
	public static HashMap<String,BufferedImage> monsterMap = new HashMap<>();
	
	static {
		for (int i = 0; i < 4; i++) {
			/*
			 * 豺狼Wolf
			 */
			monsterMap.put("wolf_left_"+i, Images.readImage("/guaiwu1/wolf/wolfleft"+i+".png"));
			monsterMap.put("wolf_right_"+i, Images.readImage("/guaiwu1/wolf/wolfright"+i+".png"));
			monsterMap.put("wolf_up_"+i, Images.readImage("/guaiwu1/wolf/wolfup"+i+".png"));
			monsterMap.put("wolf_down_"+i, Images.readImage("/guaiwu1/wolf/wolfdown"+i+".png"));
			/*
			 * 修罗XiuLuo
			 */
			monsterMap.put("xiuluo_left_"+i, Images.readImage("/guaiwu1/xiuluo/xiuluoleft"+i+".png"));
			monsterMap.put("xiuluo_right_"+i, Images.readImage("/guaiwu1/xiuluo/xiuluoright"+i+".png"));
			monsterMap.put("xiuluo_down_"+i, Images.readImage("/guaiwu1/xiuluo/xiuluoright"+i+".png"));
			monsterMap.put("xiuluo_up_"+i, Images.readImage("/guaiwu1/xiuluo/xiuluoup"+i+".png"));
		}
		for (int i = 0; i < 7; i++) {//修罗	
			monsterMap.put("xiuluo_death_"+i, Images.readImage("/guaiwu1/xiuluo/xiuluodeath"+i+".png"));
		}
		for (int i = 0; i < 5; i++) {
			/*
			 * 鬼将Gui_Jiang
			 */
			monsterMap.put("Gui_Jiang_left"+i, Images.readImage("/guaiwu1/guijiang/guijiany"+(i+1)+".png"));
			monsterMap.put("Gui_Jiang_right"+i, Images.readImage("/guaiwu1/guijiang/guijianq"+(i+1)+".png"));
			monsterMap.put("Gui_Jiang_up"+i, Images.readImage("/guaiwu1/guijiang/guijianh"+(i+1)+".png"));
			monsterMap.put("Gui_Jiang_down"+i, Images.readImage("/guaiwu1/guijiang/guijianq"+(i+1)+".png"));
			/*
			 * 老妖Lao_Yao
			 */
			monsterMap.put("Lao_Yao_left"+i, Images.readImage("/guaiwu1/laoyao/heishanq"+(i+1)+".png"));
			monsterMap.put("Lao_Yao_right"+i, Images.readImage("/guaiwu1/laoyao/heishany"+(i+1)+".png"));
			monsterMap.put("Lao_Yao_up"+i, Images.readImage("/guaiwu1/laoyao/heishanh"+(i+1)+".png"));
			monsterMap.put("Lao_Yao_down"+i, Images.readImage("/guaiwu1/laoyao/heishany"+(i+1)+".png"));
			/*
			 * 雷鸟人Lei_Niao_Ren
			 */
			monsterMap.put("Lei_Niao_Ren_left"+i, Images.readImage("/guaiwu1/leiniaoren/leiniaorenq"+(i+1)+".png"));
			monsterMap.put("Lei_Niao_Ren_right"+i, Images.readImage("/guaiwu1/leiniaoren/leiniaoreny"+(i+1)+".png"));
			monsterMap.put("Lei_Niao_Ren_up"+i, Images.readImage("/guaiwu1/leiniaoren/leiniaorenh"+(i+1)+".png"));
			monsterMap.put("Lei_Niao_Ren_down"+i, Images.readImage("/guaiwu1/leiniaoren/leiniaoreny"+(i+1)+".png"));
			/*
			 * 僵尸JiangShi
			 */
			monsterMap.put("Jiang_Shi_left"+i, Images.readImage("/guaiwu1/jiangshi/jiangshiy"+(i+1)+".png"));
			monsterMap.put("Jiang_Shi_right"+i, Images.readImage("/guaiwu1/jiangshi/jiangshiq"+(i+1)+".png"));
			monsterMap.put("Jiang_Shi_up"+i, Images.readImage("/guaiwu1/jiangshi/jiangshih"+(i+1)+".png"));
			monsterMap.put("Jiang_Shi_down"+i, Images.readImage("/guaiwu1/jiangshi/jiangshiq"+(i+1)+".png"));
		}
		
		for (int i = 0; i < 10; i++) {//僵尸
			monsterMap.put("Jiang_Shi_Ren_death"+i, Images.readImage("/guaiwu1/jiangshi/jiangshis"+(i+1)+".png"));
		}
		
		for (int i = 0; i < 9; i++) {//雷鸟人
			monsterMap.put("Lei_Niao_Ren_death"+i, Images.readImage("/guaiwu1/leiniaoren/leiniaorens"+(i+1)+".png"));
		}
		
		for (int i = 0; i < 9; i++) {//鬼将
			monsterMap.put("Gui_Jiang_death"+i, Images.readImage("/guaiwu1/guijiang/guijians"+(i+1)+".png"));
		}
		for (int i = 0; i < 10; i++) {//黑山老妖
			monsterMap.put("Lao_Yao_death"+i, Images.readImage("/guaiwu1/laoyao/heishans"+(i+1)+".png"));
		}
		
		for (int i = 0; i <8 ; i++) {
		/*
		 * 火车头Huo_Che_Tou
		 */
		monsterMap.put("Huo_Che_Tou_left"+i, Images.readImage("/guaiwu1/huochetou/huochetouy"+(i+1)+".png"));
		monsterMap.put("Huo_Che_Tou_right"+i, Images.readImage("/guaiwu1/huochetou/huochetouq"+(i+1)+".png"));
		monsterMap.put("Huo_Che_Tou_up"+i, Images.readImage("/guaiwu1/huochetou/huochetouh"+(i+1)+".png"));
		monsterMap.put("Huo_Che_Tou_down"+i, Images.readImage("/guaiwu1/huochetou/huochetouq"+(i+1)+".png"));
		/*
		 * 吸血鬼Xi_Xue_Gui
		 */
		monsterMap.put("Xi_Xue_Gui_left"+i, Images.readImage("/guaiwu1/xixuegui/xixueguiy"+(i+1)+".png"));
		monsterMap.put("Xi_Xue_Gui_right"+i, Images.readImage("/guaiwu1/xixuegui/xixueguiq"+(i+1)+".png"));
		monsterMap.put("Xi_Xue_Gui_up"+i, Images.readImage("/guaiwu1/xixuegui/xixiuguih"+(i+1)+".png"));
		monsterMap.put("Xi_Xue_Gui_down"+i, Images.readImage("/guaiwu1/xixuegui/xixueguiq"+(i+1)+".png"));
		/*
		 * 老虎Lao_Hu_
		 */
		monsterMap.put("Lao_Hu_left"+i, Images.readImage("/guaiwu1/laohu/laohuy"+(i+1)+".png"));
		monsterMap.put("Lao_Hu_right"+i, Images.readImage("/guaiwu1/laohu/laohuq"+(i+1)+".png"));
		monsterMap.put("Lao_Hu_up"+i, Images.readImage("/guaiwu1/laohu/laohuh"+(i+1)+".png"));
		monsterMap.put("Lao_Hu_down"+i, Images.readImage("/guaiwu1/laohu/laohuq"+(i+1)+".png"));
		/*
		 * 野鬼Ye_Gui
		 */
		monsterMap.put("Ye_Gui_left"+i, Images.readImage("/guaiwu1/yegui/yeguiy"+(i+1)+".png"));
		monsterMap.put("Ye_Gui_right"+i, Images.readImage("/guaiwu1/yegui/yeguiq"+(i+1)+".png"));
		monsterMap.put("Ye_Gui_up"+i, Images.readImage("/guaiwu1/yegui/yeguih"+(i+1)+".png"));
		monsterMap.put("Ye_Gui_down"+i, Images.readImage("/guaiwu1/yegui/yeguiq"+(i+1)+".png"));
		/*
		 * 蛤蟆Ha_Ma
		 */
		monsterMap.put("Ha_Ma_left"+i, Images.readImage("/guaiwu1/hama/hamojingy"+(i+1)+".png"));
		monsterMap.put("Ha_Ma_right"+i, Images.readImage("/guaiwu1/hama/hamojingq"+(i+1)+".png"));
		monsterMap.put("Ha_Ma_up"+i, Images.readImage("/guaiwu1/hama/hamojingh"+(i+1)+".png"));
		monsterMap.put("Ha_Ma_down"+i, Images.readImage("/guaiwu1/hama/hamojingq"+(i+1)+".png"));
		/*
		 * 骷髅怪Ku_Lou_Guai
		 */
		monsterMap.put("Ku_Lou_Guai_left"+i, Images.readImage("/guaiwu1/kulouguai/kuluguaiy"+(i+1)+".png"));
		monsterMap.put("Ku_Lou_Guai_right"+i, Images.readImage("/guaiwu1/kulouguai/kuluguaiq"+(i+1)+".png"));
		monsterMap.put("Ku_Lou_Guai_up"+i, Images.readImage("/guaiwu1/kulouguai/kuluguaih"+(i+1)+".png"));
		monsterMap.put("Ku_Lou_Guai_down"+i, Images.readImage("/guaiwu1/kulouguai/kuluguaiq"+(i+1)+".png"));
		/*
		 * 狼Lang
		 */
		monsterMap.put("Lang_left"+i, Images.readImage("/guaiwu1/lang/langy"+(i+1)+".png"));
		monsterMap.put("Lang_right"+i, Images.readImage("/guaiwu1/lang/langq"+(i+1)+".png"));
		monsterMap.put("Lang_up"+i, Images.readImage("/guaiwu1/lang/langh"+(i+1)+".png"));
		monsterMap.put("Lang_down"+i, Images.readImage("/guaiwu1/lang/langq"+(i+1)+".png"));
		/*
		 * 灵符Ling_Fu
		 */
		monsterMap.put("Ling_Fu_left"+i, Images.readImage("/guaiwu1/lingfu/lingfuy"+(i+1)+".png"));
		monsterMap.put("Ling_Fu_right"+i, Images.readImage("/guaiwu1/lingfu/lingfuq"+(i+1)+".png"));
		monsterMap.put("Ling_Fu_up"+i, Images.readImage("/guaiwu1/lingfu/lingfuh"+(i+1)+".png"));
		monsterMap.put("Ling_Fu_down"+i, Images.readImage("/guaiwu1/lingfu/lingfuq"+(i+1)+".png"));
		/*
		 * 九头怪Jiu_Tou_Guai
		 */
		monsterMap.put("Jiu_Tou_Guai_left"+i, Images.readImage("/guaiwu1/jiutouguai/jiutouy"+(i+1)+".png"));
		monsterMap.put("Jiu_Tou_Guai_right"+i, Images.readImage("/guaiwu1/jiutouguai/jiutouq"+(i+1)+".png"));
		monsterMap.put("Jiu_Tou_Guai_up"+i, Images.readImage("/guaiwu1/jiutouguai/jiutouh"+(i+1)+".png"));
		monsterMap.put("Jiu_Tou_Guai_down"+i, Images.readImage("/guaiwu1/jiutouguai/jiutouq"+(i+1)+".png"));
		/*
		 * 羊头怪Yang_Tou_Guai
		 */
		monsterMap.put("Yang_Tou_Guai_left"+i, Images.readImage("/guaiwu1/yangtouguai/yantouguaiy"+(i+1)+".png"));
		monsterMap.put("Yang_Tou_Guai_right"+i, Images.readImage("/guaiwu1/yangtouguai/yantouguaiq"+(i+1)+".png"));
		monsterMap.put("Yang_Tou_Guai_up"+i, Images.readImage("/guaiwu1/yangtouguai/yantouguaih"+(i+1)+".png"));
		monsterMap.put("Yang_Tou_Guai_down"+i, Images.readImage("/guaiwu1/yangtouguai/yantouguaiq"+(i+1)+".png"));
		/*
		 * 水瓶怪ShuiPing
		 */
		monsterMap.put("ShuiPing_left"+i, Images.readImage("/guaiwu1/shuiping/pingziy"+(i+1)+".png"));
		monsterMap.put("ShuiPing_right"+i, Images.readImage("/guaiwu1/shuiping/pingziq"+(i+1)+".png"));
		monsterMap.put("ShuiPing_up"+i, Images.readImage("/guaiwu1/shuiping/pingzih"+(i+1)+".png"));
		monsterMap.put("ShuiPing_down"+i, Images.readImage("/guaiwu1/shuiping/pingziq"+(i+1)+".png"));
		}
		for (int i = 0; i < 10; i++) {//水瓶怪
		monsterMap.put("ShuiPing_death"+i, Images.readImage("/guaiwu1/shuiping/pingzis"+(i+1)+".png"));
		}
		for (int i = 0; i < 8; i++) {//羊头怪
		monsterMap.put("Yang_Tou_Guai_death"+i, Images.readImage("/guaiwu1/yangtouguai/yantouguais"+(i+1)+".png"));
		}
		for (int i = 0; i < 8; i++) {//九头怪
		monsterMap.put("Jiu_Tou_Guai_death"+i, Images.readImage("/guaiwu1/jiutouguai/jiutous"+(i+1)+".png"));
		}
		for (int i = 0; i < 10; i++) {//灵符
		monsterMap.put("Ling_Fu_death"+i, Images.readImage("/guaiwu1/lingfu/lingfus"+(i+1)+".png"));
		}
		for (int i = 0; i < 9; i++) {//狼
		monsterMap.put("Lang_death"+i, Images.readImage("/guaiwu1/lang/langs"+(i+1)+".png"));
		}
		for (int i = 0; i < 10; i++) {//骷髅怪
		monsterMap.put("Ku_Lou_Guai_death"+i, Images.readImage("/guaiwu1/kulouguai/kuluguais"+(i+1)+".png"));
		}
		for (int i = 0; i < 12; i++) {//蛤蟆
		monsterMap.put("Ha_Ma_death"+i, Images.readImage("/guaiwu1/hama/hamojings"+(i+1)+".png"));
		}
		for (int i = 0; i < 9; i++) {//野鬼
		monsterMap.put("Ye_Gui_death"+i, Images.readImage("/guaiwu1/yegui/yeguis"+(i+1)+".png"));
		}
		for (int i = 0; i < 7; i++) {//老虎
		monsterMap.put("Lao_Hu_death"+i, Images.readImage("/guaiwu1/laohu/laohus"+(i+1)+".png"));
		}
		for (int i = 0; i < 8; i++) {//吸血鬼
		monsterMap.put("Xi_Xue_Gui_death"+i, Images.readImage("/guaiwu1/xixuegui/xixiuguis"+(i+1)+".png"));
		}
		
		for (int i = 0; i < 9; i++) {//火车头
		monsterMap.put("Huo_Che_Tou_death"+i, Images.readImage("/guaiwu1/huochetou/huochetous"+(i+1)+".png"));
		}
		
		for (int i = 0; i <7; i++) {
			/*
			 * 女娲NvWa
			 */
			monsterMap.put("NvWa_left"+i, Images.readImage("/guaiwu1/nvwa/nvway"+(i+1)+".png"));
			monsterMap.put("NvWa_right"+i, Images.readImage("/guaiwu1/nvwa/nvwaq"+(i+1)+".png"));
			monsterMap.put("NvWa_up"+i, Images.readImage("/guaiwu1/nvwa/nvwah"+(i+1)+".png"));
			monsterMap.put("NvWa_down"+i, Images.readImage("/guaiwu1/nvwa/nvwaq"+(i+1)+".png"));
			}
			for (int i = 0; i < 9; i++) {//女娲
			monsterMap.put("NvWa_death"+i, Images.readImage("/guaiwu1/nvwa/nvwas"+(i+1)+".png"));
			}
		}
			
}

