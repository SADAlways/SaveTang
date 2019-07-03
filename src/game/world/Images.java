package game.world;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.imageio.ImageIO;


public class Images {
	public static BufferedImage 	
		map=readImage("map.png"),
		minimap=readImage("minimap.png"),
		unittypepanel=readImage("unittypepanel.png"),
		gamestart = readImage("gamestate/start.png"),
		gamewin = readImage("gamestate/win.png"),
		gamelost = readImage("gamestate/lost.png"),
		
		moneypanle=readImage("金币框.png");
	
	

	public static BufferedImage readImage(String fileName) {
		try {
			BufferedImage img = ImageIO.read(new File("images\\"+fileName));
			//System.out.println("图片加载成功");
			return img;
		}catch(Exception e) {
			e.printStackTrace();
			//System.out.println("图片出错！！");
			throw new RuntimeException();
		}
		
	}
	public static Map<String,BufferedImage> readImageAll(String directoryName){
		File dir = new File("images\\"+directoryName);
		//System.out.println(dir.getPath());
		if(!dir.isDirectory())throw new RuntimeException("非法参数，要求传入文件夹");
		Map<String,BufferedImage> hash = new HashMap<>();
		for (File f : dir.listFiles()) {
			String name = f.getName();
			//System.out.println("Images:"+name);
			String houzui=name.substring(name.length()-4).toLowerCase();//文件后缀		
			//System.out.println("Images:"+houzui);
			if(!houzui.equals(".png"))continue;
			name = name.substring(0,name.length()-4);

			//System.out.println("Images:"+name);
			try {
				hash.put(name, ImageIO.read(f));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return hash;
		
	}
//	public static void main(String[] args) {
//		Map<String,BufferedImage> hh = readImageAll("guaiwu1/kulouguai");
//		for ( Entry e : hh.entrySet()) {
//			System.out.println(e.getKey());
//		}
//	}
//	
}
