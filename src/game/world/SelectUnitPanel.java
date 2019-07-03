package game.world;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.image.BufferedImage;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * 选择单位建设面板
 * 初始显示8格单位类型。
 * 锁定模式：当当前条件没达到建设要求时图片显示锁定模式，不接收点击响应。
 * 点击能建设的类型时进入建设状态（生成单位虚像跟随鼠标，显示可建绿方块或不可建红方块）右键或Esc取消建设状态。
 * 当鼠标移至地图可建设位置时，在地图相应位置显示绿色方块，如果该位置不可建设，显示红色方块
 * 在可建设位置单击，生成单位，取消建设状态
 *	
 */
public class SelectUnitPanel extends Panel implements Const{
	BufferedImage[] builder = new BufferedImage[8];
	String[] buildInfo = new String[8];
	public int InfoIndex = -1;
	public int buildIndex = -1;
	public int buildInfoX,buildInfoY;
	public SelectUnitPanel() {
		super(Images.unittypepanel);
		int i=0;
		builder[i] = Images.readImage("Ta/houzi/houzi_stand_0.png");
		buildInfo[i++]="孙悟空,$3000,攻击力1000,攻击范围500";
		builder[i] = Images.readImage("Ta/zhubajie/zhu_stand_0.png");
		buildInfo[i++]="猪八戒,$1500,攻击力800,攻击范围300";
		builder[i] = Images.readImage("Ta/shaseng/shaseng_stand_0.png");
		buildInfo[i++]="沙悟净,$1000,攻击力500,攻击范围200";
		builder[i] = Images.readImage("Ta/longwang/longwang_stand_down_00.png");
		buildInfo[i++]="东海龙王,$1500,攻击力500,攻击范围300";
		builder[i] = Images.readImage("Ta/tianbing/tianbing_stand_00.png");
		buildInfo[i++]="天兵,$800,攻击力300,攻击范围300";
		buildInfo[i++]="观音";
		buildInfo[i++]="龙太子";
		buildInfo[i++]="龟承相";

	}
	@Override
	public void leftClick(int cx,int cy) {

		//System.out.println("鼠标进入第"+getBuildIndex(cx,cy)+"区域");
		buildIndex = getBuildIndex(cx,cy);
		//System.out.println(buildIndex);
	}
	public int getBuildIndex(int bx,int by) {
		double xset=0.1275*width;
		double yset=0.5233*height;
		double xend=width*0.8766;
		double yend=height*0.9755;
		if(bx<=xset||bx>=xend||by<=yset||by>=yend) return -1;
		return (int) ((bx-xset)*8/(xend-xset));
	}
	//73,49-124,91
	private void creatUnit(String string) {
		// TODO Auto-generated method stub
		
	}
	
	protected void mouseMove(int x,int y) {
		
		InfoIndex = getBuildIndex(x,y);
		if(InfoIndex==-1)return;
		buildInfoX=x;
		buildInfoY=y;
	}
	
	public void drawString(Graphics g) {
		if(InfoIndex==-1)return;
		g.setColor(Color.cyan);
		g.setFont(new Font("黑体",0,15));
		g.drawString(buildInfo[InfoIndex], buildInfoX-20, buildInfoY);
	}
	
	@Override
	public void paint(Graphics g){
		g.drawImage(img, x, y, getWidth(),getHeight(),null);
		
		drawString(g);
		
	}
}

//586*93










