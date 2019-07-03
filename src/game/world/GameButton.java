package game.world;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class GameButton extends JPanel{
	BufferedImage img_default;
	BufferedImage img_active;
	BufferedImage img;
	String name;
	static GameButton[] gb=new GameButton[4];
	static{
		for (int i = 0; i < gb.length; i++) {
			gb[i] = new GameButton();
		}
		int i=0;
		gb[i].img=gb[i].img_default=Images.readImage("gamestate/游戏介绍1.png");
		gb[i].name="游戏介绍";
		gb[i++].img_active=Images.readImage("gamestate/游戏介绍0.png");
		gb[i].img=gb[i].img=gb[i].img_default=Images.readImage("gamestate/进入游戏1.png");
		gb[i].name="进入游戏";
		gb[i++].img_active=Images.readImage("gamestate/进入游戏0.png");
		gb[i].img=gb[i].img_default=Images.readImage("gamestate/退出游戏1.png");
		gb[i].name="退出游戏";
		gb[i++].img_active=Images.readImage("gamestate/退出游戏0.png");
		gb[i].img=gb[i].img_default=Images.readImage("gamestate/制作团队1.png");
		gb[i].name="制作团队";
		gb[i++].img_active=Images.readImage("gamestate/制作团队0.png");
	}
	
	public GameButton() {		
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				img=img_default;
				
				//System.out.println("mouseExited");
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				img=img_active;
				Music.music.get("mousetouch").play();
				//System.out.println("mouseEntered");
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				GameStart.self.inforIndex=0;
				if(GameStart.self.state!=name)GameStart.self.state=name;
				else GameStart.self.state="";
				Music.music.get("mouseclick").play();
				
			}
		});

	}

	public void ClickAction() {
		//System.out.println();
		
	}
}
	

