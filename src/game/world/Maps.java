package game.world;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.JPanel;

import game.guaiwu.Monster;
import game.ta.Ranges;
import game.ta.TangSeng;
import game.ta.Tower;

public class Maps extends JPanel implements Const{
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	//Rectangle rect;
	List<UnitObject> list = new ArrayList<>();
	int width,height;
	public int x;
	public int y;
	BufferedImage img = Images.map;
	
	int builderX,builderY;
	Color canBuildColor = new Color(0,255,0,128);
	Color noBuildColor = new Color(255,0,0,128);
	boolean canBuild;
	public Maps() {
		//LinkedList<Object> c = new LinkedList<>();
		
		width=img.getWidth();
		height=img.getHeight();
		this.setSize(width,height);
		//rect = getBounds();
//		this.addMouseListener(new MouseListener() {
//			
//			@Override
//			public void mouseReleased(MouseEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void mousePressed(MouseEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void mouseExited(MouseEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				System.out.println(e.getX()+","+e.getY());
//				
//			}
//		});
	}
	
	public void drawBuilder(Graphics g) {
		if(World.sup.buildIndex==-1)return;
		int i = World.sup.buildIndex;
		BufferedImage img = World.sup.builder[i];
		if(img==null)return;
		g.setColor(canBuildColor);
		g.fillRect(builderX-40, builderY-80, 80, 80);
		if(noBuildings.contains(builderX-40, builderY-80, 80, 80)){
			canBuild=false;
			List<Rectangle> ts = noBuildings.getTouch();
			for (Rectangle t : ts) {
				t.setLocation(t.x-x,t.y-y);
				System.out.println(t.getWidth());
				System.out.println(t.width);
				g.setColor(noBuildColor);
				g.fillRect(t.x,t.y,t.width,t.height);
			}
			
		}else canBuild=true;
		g.drawImage(img, builderX-img.getWidth()/2, builderY-img.getHeight(), null);
	}
	



	public void paint(Graphics g){
		//if(World.gameState!=GameState.RUNNING)return;
		g.drawImage(Images.map, x, y, null);
		list.clear();
		for (int i = 0; i < this.getComponentCount(); i++) {
			if(getComponent(i) instanceof Ranges){
				Ranges u = (Ranges)getComponent(i);
				u.paint(g);
			}else if(getComponent(i) instanceof UnitObject){
				list.add((UnitObject) getComponent(i));
			}
		}
		Collections.sort( list, comparator);
		for (UnitObject u : list) {
			g.drawImage(u.getImage(), u.getX()+x, u.getY()+y,u.getWidth(),u.getHeight(), null);
			if(u instanceof Monster)drowBlood(g,(Monster)u);
			if(u instanceof TangSeng)drowBlood(g,(TangSeng)u);
		}
		drawBuilder(g);
//		World.moneypanel.drawMoney(g);
		noBuildings.paint(g);
	}
	
	Comparator<UnitObject> comparator = new Comparator<UnitObject>(){

		@Override
		public int compare(UnitObject a, UnitObject b) {
			return b.getY()-a.getY();
		}
	};
	
	private Color c=new Color(255,0,0,200);
	public void drowBlood(Graphics g,Monster m){
		if(!m.isLife())return;
		g.setColor(c);
		//double b = 1.0*blood/maxBlood;
		
		g.fillRect(m.x+x+m.width/4, m.y+y, m.width/2*m.blood/m.maxBlood, 3);
		g.drawRoundRect(m.x-1+x+m.width/4, m.y-1+y, m.width/2, 4, 5, 5);
	}
	public void drowBlood(Graphics g,TangSeng m){
		if(!m.isLife())return;
		g.setColor(c);
		//double b = 1.0*blood/maxBlood;
		
		g.fillRect(m.x+x+m.width/4, m.y+y, m.width/2*m.blood/m.maxBlood, 3);
		g.drawRoundRect(m.x-1+x+m.width/4, m.y-1+y, m.width/2, 4, 5, 5);
	}

	
	void action(){
		
	}
	
	
	public BufferedImage getImage(){
		return Images.map;
	}
	
}
