package project_1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;

public class Game extends Thread{
	//쓰레드라는건 프로그램에서 돌아가는 조그만 프로그램 이라 할수있음
	//게임이라는 틀 안에서 작동하는 하나의 게임
	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameInfo.png")).getImage();
	private Image judgementInfoImage = new ImageIcon(Main.class.getResource("../images/judgementLine.png")).getImage();
	private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../images/noteRouteLine.png")).getImage();
	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/note.png")).getImage();
	private Image noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	
	
	
	
	
	public void screenDraw(Graphics2D g) 
	{
		g.drawImage(gameInfoImage, 0, 660, null);
		g.drawImage(judgementInfoImage, 0, 580, null);
		
		g.drawImage(noteRouteSImage, 228, 30, null);//1
		g.drawImage(noteRouteDImage, 332, 30, null);//2
		g.drawImage(noteRouteFImage, 436, 30, null);//3
		g.drawImage(noteRouteSpace1Image, 540, 30, null);//4
		g.drawImage(noteRouteSpace2Image, 640, 30, null);//5
		g.drawImage(noteRouteJImage, 744, 30, null);//6
		g.drawImage(noteRouteKImage, 848, 30, null);//7
		g.drawImage(noteRouteLImage, 952, 30, null);//8

		g.drawImage(noteRouteLineImage, 224, 30, null);//1
		g.drawImage(noteRouteLineImage, 328, 30, null);//2
		g.drawImage(noteRouteLineImage, 432, 30, null);//3
		g.drawImage(noteRouteLineImage, 536, 30, null);//4
		g.drawImage(noteRouteLineImage, 740, 30, null);//5
		g.drawImage(noteRouteLineImage, 844, 30, null);//6
		g.drawImage(noteRouteLineImage, 948, 30, null);//7
		g.drawImage(noteRouteLineImage, 1052, 30, null);//8
		
		g.drawImage(noteBasicImage, 228, 30, null);//1
		g.drawImage(noteBasicImage, 322, 30, null);//2
		g.drawImage(noteBasicImage, 436, 30, null);//3
		g.drawImage(noteBasicImage, 540, 30, null);//4
		g.drawImage(noteBasicImage, 640, 30, null);//5
		g.drawImage(noteBasicImage, 744, 30, null);//6
		g.drawImage(noteBasicImage, 848, 30, null);//7
		g.drawImage(noteBasicImage, 952, 30, null);//8
		
		g.setColor(Color.white);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		//위 코드를 추가함으로써 밑에 Alan Walker 글자의 깨짐현상을 해결할 수 있음.
		g.setFont(new Font("Arial",Font.BOLD,30));
		g.drawString("Alan Walker - Fade", 20, 702);
		g.drawString("Easy",1190,702);
		g.setFont(new Font("Arial",Font.PLAIN,26));
		g.setColor(Color.DARK_GRAY);
		g.drawString("S", 270, 609);
		g.drawString("D", 374, 609);
		g.drawString("F", 478, 609);
		g.drawString("Space Bar", 580, 609);
		g.drawString("J", 784, 609);
		g.drawString("K", 889, 609);
		g.drawString("L", 993, 609);
		g.setColor(Color.LIGHT_GRAY);
		g.setFont(new Font("Elephant",Font.BOLD,30));
		g.drawString("000000", 565, 702);
	}
	
	public void pressS()//S를 입력했을때 나타나는 이벤트
	{
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePress.png")).getImage();
	}
	public void relaseS()//S를 뗏을때 나타나는 이벤트
	{
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	
	public void pressD()
	{
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoutePress.png")).getImage();
	}
	public void relaseD()
	{
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	
	public void pressF()
	{
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoutePress.png")).getImage();
	}
	public void relaseF()
	{
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	
	public void pressSpace()
	{
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoutePress.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoutePress.png")).getImage();
	}
	public void relaseSpace()
	{
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	
	public void pressJ()
	{
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoutePress.png")).getImage();
	}
	public void relaseJ()
	{
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	
	public void pressK()
	{
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoutePress.png")).getImage();
	}
	public void relaseK()
	{
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	
	public void pressL()
	{
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoutePress.png")).getImage();
	}
	public void relaseL()
	{
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	
	@Override
	public void run()
	{
		
	}
}
