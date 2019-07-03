package game.world;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class GameStart extends JPanel{
	int width = World.WIDTH;
	int height = World.HEIGHT;
	String state;
	static GameStart self=new GameStart();
	GameButton[] bt = GameButton.gb;
	BufferedImage bg = Images.readImage("gamestate/start.png");
	protected boolean gameInfor;
	protected boolean teamInfor;
	public static Music theme;
	
	private GameStart() {
		final JFrame f=new JFrame();
		f.setSize(width, height);
		this.setLayout(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		
		for(int i=0;i<bt.length;i++){
			GameButton b=bt[i];
			b.setSize(getWidth()/2, getHeight()/8);
			b.setLocation(getWidth()/4, getHeight()/8*(i+1));
			add(b);
			
		}
		
		f.setVisible(true);
		f.add(this);
		
		new Thread(){
			@Override
			public void run() {
				theme = Music.music.get("theme");
				theme.loop();
				while(true){
					if(state=="进入游戏"){
						theme.loopStop();
						theme = Music.music.get("start");
						theme.loop();
						f.dispose();
						World.self.action();
						return;
					}
					if(state=="退出游戏"){
						System.exit(0);
					}
					
					teamInfor=false;
					if(state=="制作团队"){
						teamInfor=true;
					}
					gameInfor=false;
					if(state=="游戏介绍"){
						gameInfor=true;
					}
					
					if(getWidth()!=f.getWidth() || getHeight()!=f.getHeight())
						setSize(f.getWidth()-16,f.getHeight()-36);
					repaint();
					try {
						sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
		}.start();
	}
	
	int inforIndex=0;
	protected void gameInfor(Graphics g) {
		// 游戏介绍		
		g.setFont(new Font("楷体", 30, 30));
		if(inforIndex<255)inforIndex+=5;
		g.setColor(new Color(100,100,50,inforIndex/2));
		g.fillRoundRect(10, getHeight()/8-35, 550, 500, 50, 50);
		g.setColor(new Color(255,255,0,inforIndex));
		int i =0;
		String str[] =new String[16];
		str[i++]="	游戏背景：";
		str[i++]="话说唐僧师徒四人西天取经，";
		str[i++]="最终修成正果。";
		str[i++]= "唐僧此时正在返回东土大唐的路上，";
		str[i++]= "不料各路妖魔鬼怪闻讯后纷纷秘密集结，";
		str[i++]= "商讨吃肉大计以报九九八十一仇。";
		str[i++]= "玉皇大帝听说此事后，";
		str[i++]="紧急联合如来佛祖召开第一届佛道大会，";
		str[i++]="以驰援玄奘。";
		str[i++]= "这一日，";
		str[i++]="唐僧路过五指山遗址，";
		str[i++]="准备好好留念一番，";
		str[i++]="但妖怪们早已做好埋伏，";
		str[i++]= "只需瓮中捉鳖，";
		str[i++]="各路神仙也纷纷赶到，";
		str[i++]="一场正邪大战拉开帷幕......";
		for (int j = 0; j < str.length; j++) {
			g.drawString(str[j], 30, getHeight()/8+j*30);
		}
		
		
	}

	protected void teamInfor(Graphics g) {
		// 制作团队
		/*
	制作团队：
	技术总监 ：黄仕元 (组长)
	策划总监 ：周  明 
	创意总监 ：卢渝康 
	产品总监 ：	罗  鹏  
	UI总监：    黄于膑 

	
		 */
		g.setFont(new Font("楷体", 30, 30));
		if(inforIndex<255)inforIndex+=5;
		g.setColor(new Color(100,100,50,inforIndex/2));
		g.fillRoundRect(10, getHeight()/4-35, 400, 200, 50, 50);
		g.setColor(new Color(255,255,0,inforIndex));
		int i =0;
		String str[] =new String[6];
		str[i++]="    制作团队：";
		str[i++]="技术总监 ：黄仕元 (组长)";
		str[i++]="策划总监 ：周  明 ";
		str[i++]="创意总监 ：卢渝康 ";
		str[i++]="产品总监 ：罗  鹏  ";
		str[i++]="  UI总监 ：黄于膑 ";
		for (int j = 0; j < str.length; j++) {
			g.drawString(str[j], 30, getHeight()/4+j*30);
		}
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
		for(int i=0;i<bt.length;i++){
			GameButton b=bt[i];
			b.setSize(getWidth()/6, getHeight()/10);
			b.setLocation(getWidth()-b.getWidth()-10, getHeight()/8*(i+4));
			g.drawImage(b.img, b.getX(), b.getY(), b.getWidth(), b.getHeight(), this);
		}
		if(gameInfor)gameInfor(g);
		if(teamInfor)teamInfor(g);
		
	}
	public void run(){}
	public static void main(String[] args) {
		GameStart.self.run();
		

	}

}
