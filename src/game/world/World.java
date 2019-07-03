

package game.world;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;

import game.guaiwu.*;
import game.ta.*;
//import game.ta.ZhuBaJie;

public class World extends JFrame implements Const{
	/*
	 * 游戏状态
	 */
//	public static final int START = 1;//游戏开始
//	public static final int RUNNING = 2;//游戏进行
//	public static final int PAUSE = 3;//游戏暂停
//	public static final int GAME_WIN = 4;//游戏胜利
//	public static final int GAME_OVER = 5;//游戏失败
	public static GameState gameState = GameState.RUNNING;
	TangSeng monk = new TangSeng();//唐僧
	
	/*
	 * 一些游戏参数
	 */
	public static int money = 1000;//初始玩家金币
	/**
	 * 每波怪物数量
	 */
	public static int numberOfPieces = 55;//每波怪物数量
	int level = 1;//初始关卡
	
	//*/
	private static final long serialVersionUID = 1L;
	public static final int WIDTH=1000,HEIGHT=600;
	//public static World world = new World();
	int mouseX,mouseY;
	static SelectUnitPanel sup;
	public static Maps map  = new Maps();
	static MiniMap minimap = new MiniMap();
	static MiniBound minibound = new MiniBound();
	static MoneyPanel moneypanel = new MoneyPanel();
	static World self = new World();
	/** 定时器计数器	 */
	
	World(){
		setSize(WIDTH, HEIGHT);
		this.setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		//setResizable(false);
		GC.start();
		sup=new SelectUnitPanel();
		add(sup);
		
		add(moneypanel);
		add(minimap);
		add(minibound);
		add(map);
	
		
		sup.setLocation(this.getWidth()-sup.getWidth(), this.getHeight()-sup.getHeight()-39);
		minibound.setLocation(0, this.getHeight()-minibound.getHeight()-39);
		minimap.setLocation(20, this.getHeight()-minimap.getHeight()-59);

		//System.out.println(map.getVisibleRect());
		this.map.action();

		setVisible(true);
		setFocusable(true);
	}
	public void monstersMoveAction() {
		for (int i = 0; i < monsters.size(); i++) {
			monsters.get(i).move();
		}
	}

		
	
	int enterNumbers = 0;
	int enterIndex = 0;	
	public void monstersEnterAction() {
		if(enterIndex++%60==0) {
			//System.out.println(deadNumber+","+level);
			if(monsters.size()==numberOfPieces) {
				boolean flag = true;
				for (int i = 0; i < monsters.size(); i++) {
					if(!monsters.get(i).isRemove()) {
						flag = false;
					}
				}
				if(flag) {
					level++;
					monsters.clear();
					Tower.shoots.clear();
					enterNumbers = 0;
				}			
			}
			if(level==1 && enterNumbers<numberOfPieces) {
				new Lang();
				enterNumbers++;
			}else if(level==2 && enterNumbers<numberOfPieces) {
				new LaoHu();
				enterNumbers++;
			}else if(level==3 && enterNumbers<numberOfPieces) {
				new HaMa();
				enterNumbers++;
			}else if(level==4 && enterNumbers<numberOfPieces) {
				new YangTouGuai();
				enterNumbers++;
			}else if(level==5 && enterNumbers<numberOfPieces) {
				new YeGui();
				enterNumbers++;
			}else if(level==6 && enterNumbers<numberOfPieces) {
				new JiangShi();
				enterNumbers++;
			}else if(level==7 && enterNumbers<numberOfPieces) {
				new KuLouGuai();
				enterNumbers++;
			}else if(level==8 && enterNumbers<numberOfPieces) {
				new LeiNiaoRen();
				enterNumbers++;
			}else if(level==9 && enterNumbers<numberOfPieces) {
				new LaoYao();
				enterNumbers++;
			}else if(level==10 && enterNumbers<numberOfPieces) {
				new XiXueGui();
				enterNumbers++;
			}else if(level==11 && enterNumbers<numberOfPieces) {
				new LingFu();
				enterNumbers++;
			}else if(level==12 && enterNumbers<numberOfPieces) {
				new ShuiPing();
				enterNumbers++;
			}else if(level==13 && enterNumbers<numberOfPieces) {
				new NvWa();
				enterNumbers++;
			}else if(level==14 && enterNumbers<numberOfPieces) {
				new JiuTouGuai();
				enterNumbers++;
			}else if(level==15 && enterNumbers<numberOfPieces) {
				new XiuLuo();
				enterNumbers++;
			}else if(level==16 && enterNumbers<numberOfPieces) {
				new GuiJiang();
				enterNumbers++;
			}else if(level==17 && enterNumbers<numberOfPieces) {
				new HuoCheTou();
				enterNumbers++;
			}else if(level==18 && enterNumbers<numberOfPieces) {
				gameState = GameState.WIN;
				GameStart.theme.loopStop();
				GameStart.theme = Music.music.get("theme");
				GameStart.theme.loop();
			}
		}
		
	}

	public void HurtTangSengAction() {
		for (Monster m : monsters) {
			if(m.isLife()&&monk.isLife()&&monk.isHurt(m)) {
				m.goDead();
				monk.subBlood();
				if(monk.getBlood()<=0) {
					monk.goDead();
					gameState = GameState.LOST;
					GameStart.theme.loopStop();
					GameStart.theme = Music.music.get("gamelost");
					GameStart.theme.play();
				}
			}
		}
	}
	public void checkGameoverAction() {
		if(gameState==GameState.LOST) {
			gameState=GameState.OVER;
			add(new GameLost());
		}
		if(gameState==GameState.WIN) {
			gameState=GameState.OVER;
			add(new GameWin());
		}
	}
	
	
	void action(){
		
		new Timer().schedule(new TimerTask(){

			@Override
			public void run() {
				//shootAction();//子弹射击
				if(gameState==GameState.RUNNING) {
					monstersEnterAction();//怪物进场
					monstersMoveAction();//怪物移动
					HurtTangSengAction();//怪物与唐僧的碰撞
					checkGameoverAction();//检查游戏是否结束
				}
				
				repaint();

				
			}
			
		}, 10, 10);
		
		MouseMotionListener l = new MouseMotionListener() {
			
			//new //new //new //new //new 
			public void setBuilderPoint(int x,int y) {
				if(sup.buildIndex==-1)return;
				map.builderX=x;
				map.builderY=y;
			}
			@Override
			public void mouseMoved(MouseEvent e) {
				setBuilderPoint(e.getX(),e.getY());//new //new //new 
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				int xstep=e.getX()-mouseX;
				int ystep=e.getY()-mouseY;
				map.x+=xstep;
				map.y+=ystep;
				//noBuildings.setLocation(map.x, map.y);
				
				if(map.x<getWidth()-map.width)map.x=getWidth()-map.width;
				
				if(map.y<getHeight()-map.height)map.y=getHeight()-map.height;
				if(map.x>0)map.x=0;
				if(map.y>0)map.y=0;
				mouseX=e.getX();
				mouseY=e.getY();
				
			}
		};
		
		
		this.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX=e.getX();
				mouseY=e.getY();
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				Music.music.get("mouseclick").play();
				if(sup.buildIndex==-1 || !map.canBuild)return;
//				int x = e.getX()-60-map.x;
//				int y = e.getY()-60-map.y;
				if(sup.buildIndex==0) {		
					int x = e.getX()-100-map.x;
					int y = e.getY()-180-map.y;
					//g.fillRect(builderX-40, builderY-80, 80, 80);
					if(money>=3000){
						map.add(new HouZi(x,y));
						noBuildings.add(map.builderX-40-map.x,map.builderY-80-map.y,80,80);
					}
					
				}else if(sup.buildIndex==1) {	
					int x = e.getX()-50-map.x;
					int y = e.getY()-100-map.y;
					if(money>=1500){
						map.add(new ZhuBaJie(x,y));
						noBuildings.add(map.builderX-40-map.x,map.builderY-80-map.y,80,80);
					}
					
				}else if(sup.buildIndex==2) {	
					int x = e.getX()-50-map.x;
					int y = e.getY()-100-map.y;
					if(money>=1000){
						map.add(new ShaSeng(x,y));
						noBuildings.add(map.builderX-40-map.x,map.builderY-80-map.y,80,80);
					}
					
				}else if(sup.buildIndex==3) {	
					int x = e.getX()-50-map.x;
					int y = e.getY()-100-map.y;
					if(money>=1500){
						map.add(new Longwang(x,y));
						noBuildings.add(map.builderX-40-map.x,map.builderY-80-map.y,80,80);
					}
					
				}else if(sup.buildIndex==4) {	
					int x = e.getX()-50-map.x;
					int y = e.getY()-100-map.y;
					if(money>=800){
						map.add(new TianBing(x,y));
						noBuildings.add(map.builderX-40-map.x,map.builderY-80-map.y,80,80);
					}
					
				}
				
				
				
				sup.buildIndex=-1;
			}
		});
		this.addMouseMotionListener(l);
		
		this.addComponentListener(new ComponentListener() {

			@Override
			public void componentHidden(ComponentEvent arg0) {
				
			}

			@Override
			public void componentMoved(ComponentEvent arg0) {
				
			}

			@Override
			public void componentResized(ComponentEvent e) {
				
				sup.worldChangeAction(getWidth(),getHeight());
//				for (int i = 0; i < sup.getComponentCount(); i++) {
//					
//					if (sup.getComponent(i) instanceof Panel) {
//						Panel ut = (Panel) sup.getComponent(i);
//						ut.worldChangeAction(getWidth(),getHeight());
//					}
//					
//				}
				minibound.worldChangeAction(getWidth(),getHeight());				
				minimap.worldChangeAction(getWidth(),getHeight());
				moneypanel.worldChangeAction(getWidth(),getHeight());
				sup.setLocation(getWidth()-sup.getWidth(), getHeight()-sup.getHeight()-39);
				minibound.setLocation(0, getHeight()-minibound.getHeight()-39);
				minimap.setLocation(minibound.getWidth()/2-minimap.getWidth()/2, 
						getHeight()-39-minibound.getHeight()/2-minimap.getHeight()/2);
				
				limitMap();
				
				
			}

			@Override
			public void componentShown(ComponentEvent arg0) {
				
			}
			
		});
	}
	
	public void limitMap() {
		if(map.x<getWidth()-map.width)map.x=getWidth()-map.width;		
		if(map.y<getHeight()-map.height)map.y=getHeight()-map.height;
		if(map.x>0)map.x=0;
		if(map.y>0)map.y=0;
	}
	
//	public static void main(String[] args) {
//		//World.self.action();
//		
//
//	}

}
