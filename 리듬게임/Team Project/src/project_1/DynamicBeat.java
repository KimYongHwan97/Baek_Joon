package project_1;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class DynamicBeat extends JFrame {
	
	private Image screenImage;
	private Graphics screenGraphic;
	//더블 버퍼링을 위해 전체화면에 대한 이미지를 담는 두 인스턴스
	
	private Image introBackground;
	//가져온 이미지를 담을수 있는 하나의 객체
	
	public DynamicBeat() // 생성자를 만들었음
	{
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH,Main.SCREEN_WIDTH);
		//Main 클래스의 public static 변수 활용으로 사이즈 설정
		setResizable(false);
		//사용자 임의대로 사이즈 설정 불가능
		setLocationRelativeTo(null);
		//사용자가 프로그램을 실행했을때 창이 정중앙에 뜨게끔 함
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*사용자가 창을 닫았을때 프로그램이 종료되게끔 함 이걸 안하게되면
		 * 사용자가 창을 닫아도 프로그램이 계속해서 돌아가게 됨*/	
		setVisible(true);
		//기본값이 false라서 우리 눈에 게임창이 보이게 하려면 트루로 설정해줘야됨.
		
		introBackground = new ImageIcon(Main.class.getResource("../images/introBackground.jpg")).getImage();
		//Main 클래스의 위치를 기반으로 해서 introBackground라는 리소스를 얻어온 뒤에 그것의 이미지 인스턴스를 introBackground라는
		//이미지 변수에다가 초기화를 해주겠다는 뜻
		
		Music introMusic = new Music("introMusic.mp3",true);
		introMusic.start();
	}
	
	public void paint(Graphics g) {
	screenImage = createImage(Main.SCREEN_WIDTH,Main.SCREEN_HEIHT);
	//1200x720의 이미지를 만들어둔 뒤에 그걸 스크린 이미지에 넣어주겠다
	screenGraphic = screenImage.getGraphics();
	// 스크린 이미지를 이용해서 그래픽 객체를 얻어오는것
	screenDraw(screenGraphic);
	// 스크린 그래픽에 어떠한 그림을 그려주는것
	g.drawImage(screenImage, 0, 0, null);
	// 스크린 이미지를 0,0의 위치에 그려주는 것

	}
	public void screenDraw(Graphics g) {
		
		g.drawImage(introBackground, 0, 0, null);
		//인트로 백그라운드를 스크린 이미지에 그려줄 수 있도록 하는것
		this.repaint();
		//paint는 JFrame을 상속받은 GUI게임에서 가장 첫번째로 화면을 그려주는 함수다
		// 이건 약속된거라 바뀌지 않는다.
	}
}




//class는 틀이라고 이해할 수 있는데, 클래스를 이용해서 하나의 실질적으로 사용할수
//있는 인스턴스라는 객체를 만들어 주엇을때 가장 먼저 실행되는 부분이 이 생성자임

//생성자의 특징은 자신의 클래스와 같은 이름을 가지고 있는 메소드이다.

/*Ctrl + shift + O 를 누르면 이클립스에서 알아서 필요한 기능들을 임포트 시켜줌*/