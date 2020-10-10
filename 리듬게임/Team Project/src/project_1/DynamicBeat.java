package project_1;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DynamicBeat extends JFrame {

	private Image screenImage;
	private Graphics screenGraphic;
	// 더블 버퍼링을 위해 전체화면에 대한 이미지를 담는 두 인스턴스

	private Image background = new ImageIcon(Main.class.getResource("../images/introBackground.png")).getImage();
	// 가져온 이미지를 담을수 있는 하나의 객체
	// Main 클래스의 위치를 기반으로 해서 background라는 리소스를 얻어온 뒤에 그것의 이미지 인스턴스를
	// background라는
	// 이미지 변수에다가 초기화를 해주겠다는 뜻;
	private Image selectedImage = new ImageIcon(Main.class.getResource("../images/Start Image.jpg")).getImage();
	//현재 선택된 곡의 이미지 / 시작 이미지
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));
	// JLabel을 이용해 메뉴바 이미지 불러옴 및 생성
	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/exitEnter.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/exitBasic.png"));
	
	private ImageIcon startButtonBasic = new ImageIcon(Main.class.getResource("../images/startButtonBasic.png"));
	private ImageIcon startButtonEntered = new ImageIcon(Main.class.getResource("../images/startButtonEntered.png"));
	
	private ImageIcon quitButtonBasic = new ImageIcon(Main.class.getResource("../images/quitButtonBasic.png"));
	private ImageIcon quitButtonEntered = new ImageIcon(Main.class.getResource("../images/quitButtonEntered.png"));
	
	private ImageIcon leftButtonBasic = new ImageIcon(Main.class.getResource("../images/LeftButtonBasic.png"));
	private ImageIcon leftButtonEntered = new ImageIcon(Main.class.getResource("../images/LeftButtonEntered.png"));
	
	private ImageIcon rightButtonBasic = new ImageIcon(Main.class.getResource("../images/RightButtonBasic.png"));
	private ImageIcon rightButtonEntered = new ImageIcon(Main.class.getResource("../images/RightButtonEntered.png"));
	
	private Image titleImage = new ImageIcon(Main.class.getResource("../images/FadedTitleimage.png")).getImage();
	
	private JButton exitButton = new JButton(exitButtonBasicImage);
	// J버튼을 생성하고, 그 기본 디폴트값을 exitButtonBasicImage 로 설정함
	private JButton startButton = new JButton(startButtonBasic);
	private JButton quitButton = new JButton(quitButtonBasic);
	private JButton leftButton = new JButton(leftButtonBasic);
	private JButton rightButton = new JButton(rightButtonBasic);

	private int mouseX,mouseY;
	//마우스의 X,Y좌표
	

	private boolean isMainScreen = false;
	//처음에는 메인화면이 아닌 시작화면이기때문에 false값 / 메인화면으로 바뀌면 이게 트루값
	
	public DynamicBeat() // 생성자를 만들었음
	{
		setUndecorated(true);
		// 기본적으로 제공되는 디자인의 JLabel 미출력
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_WIDTH);
		// Main 클래스의 public static 변수 활용으로 사이즈 설정
		setResizable(false);
		// 사용자 임의대로 사이즈 설정 불가능
		setLocationRelativeTo(null);
		// 사용자가 프로그램을 실행했을때 창이 정중앙에 뜨게끔 함
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*
		 * 사용자가 창을 닫았을때 프로그램이 종료되게끔 함 이걸 안하게되면 사용자가 창을 닫아도 프로그램이 계속해서 돌아가게 됨
		 */
		setVisible(true);
		// 기본값이 false라서 우리 눈에 게임창이 보이게 하려면 트루로 설정해줘야됨.
		setBackground(new Color(0, 0, 0, 0));
		// 페인트 컴포넌트를 했을때 배경이 회색이 아니라 전부 하얀색으로 바뀜
		setLayout(null);
		// 버튼이나 JLabel을 넣었을때 그 위치 그대로 꽂히게 됨

		exitButton.setBounds(1245, 0, 30, 30);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		//크기 조절 및 자연스러운 모양으로 들어가도록 해주는 3줄
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e)
			{
				exitButton.setIcon(exitButtonEnteredImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonenter.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e)
			{
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e)
			{
				Music buttonPressedMusic = new Music("buttonclick.mp3",false);
				buttonPressedMusic.start();
				try {
					Thread.sleep(1000);
					//이걸 넣어주게되면 클릭해서 소리가 나온다음에 1초정도 있다가 프로그램이 종료됨.
				}
				catch(InterruptedException ex)
				{
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(exitButton);
		
		
		startButton.setBounds(40, 430, 400, 100);
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		//크기 조절 및 자연스러운 모양으로 들어가도록 해주는 3줄
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e)
			{
				startButton.setIcon(startButtonEntered);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonenter.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e)
			{
				startButton.setIcon(startButtonBasic);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e)
			{
				Music buttonPressedMusic = new Music("buttonclick.mp3",false);
				buttonPressedMusic.start();
				//게임 시작 이벤트
				startButton.setVisible(false);
				quitButton.setVisible(false);
				leftButton.setVisible(true);
				rightButton.setVisible(true);
				background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage();
				
				isMainScreen = true;
				//시작버튼이 눌렸을때 게임화면이 띄워지게끔
			}
		});
		add(startButton);
		
		
		quitButton.setBounds(40, 550, 400, 100);
		// X Y , Width , Height
		quitButton.setBorderPainted(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		//크기 조절 및 자연스러운 모양으로 들어가도록 해주는 3줄
		quitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e)
			{
				quitButton.setIcon(quitButtonEntered);
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonenter.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e)
			{
				quitButton.setIcon(quitButtonBasic);
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e)
			{
				Music buttonPressedMusic = new Music("buttonclick.mp3",false);
				buttonPressedMusic.start();
				try {
					Thread.sleep(1000);
					//이걸 넣어주게되면 클릭해서 소리가 나온다음에 1초정도 있다가 프로그램이 종료됨.
				}
				catch(InterruptedException ex)
				{
					ex.printStackTrace();
				}
				System.exit(0);
				
			}
		});
		
		add(quitButton);
		
		leftButton.setVisible(false);
		leftButton.setBounds(140, 310, 60, 60);
		// X Y , Width , Height
		leftButton.setBorderPainted(false);
		leftButton.setContentAreaFilled(false);
		leftButton.setFocusPainted(false);
		//크기 조절 및 자연스러운 모양으로 들어가도록 해주는 3줄
		leftButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e)
			{
				leftButton.setIcon(leftButtonEntered);
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonenter.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e)
			{
				leftButton.setIcon(leftButtonBasic);
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e)
			{
				Music buttonPressedMusic = new Music("buttonclick.mp3",false);
				buttonPressedMusic.start();
				//왼쪽 버튼 이벤트
				
				
			}
		});
		add(leftButton);
		
		
		rightButton.setVisible(false);
		rightButton.setBounds(1080, 310, 60, 60);
		// X Y , Width , Height
		rightButton.setBorderPainted(false);
		rightButton.setContentAreaFilled(false);
		rightButton.setFocusPainted(false);
		//크기 조절 및 자연스러운 모양으로 들어가도록 해주는 3줄
		rightButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e)
			{
				rightButton.setIcon(rightButtonEntered);
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonenter.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e)
			{
				rightButton.setIcon(rightButtonBasic);
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e)
			{
				Music buttonPressedMusic = new Music("buttonclick.mp3",false);
				buttonPressedMusic.start();
				//오른쪽 버튼 이벤트
				
				
			}
		});
		add(rightButton);
		
		menuBar.setBounds(0, 0, 1280, 30);
		// 메뉴바의 크기 조절
		menuBar.addMouseListener(new MouseAdapter()
				{
					@Override
					public void mousePressed(MouseEvent e)
					{
						mouseX = e.getX();
						mouseY = e.getY();
						//실제로 마우스가 눌렷을때 그 좌표를 받아온다는 소리
						
					}
					
				});
		menuBar.addMouseMotionListener(new MouseMotionAdapter()
				{
					@Override
					public void mouseDragged(MouseEvent e)
					{
						int x = e.getXOnScreen();
						int y = e.getYOnScreen();
						setLocation(x - mouseX, y-mouseY);
						//JFrame의 위치 자체를 바꿔줄수 있게됨.
						//드래그 할때 순간마다 X Y좌표를 얻어와 자동으로 게임창의 위치를 바꿔주는것
					}
					
				}
		);
		add(menuBar);



		Music introMusic = new Music("introMusic.mp3", true);
		introMusic.start();
	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIHT);
		// 1200x720의 이미지를 만들어둔 뒤에 그걸 스크린 이미지에 넣어주겠다
		screenGraphic = screenImage.getGraphics();
		// 스크린 이미지를 이용해서 그래픽 객체를 얻어오는것
		screenDraw(screenGraphic);
		// 스크린 그래픽에 어떠한 그림을 그려주는것
		g.drawImage(screenImage, 0, 0, null);
		// 스크린 이미지를 0,0의 위치에 그려주는 것

	}

	public void screenDraw(Graphics g) {

		g.drawImage(background, 0, 0, null);
		// 인트로 백그라운드를 스크린 이미지에 그려줄 수 있도록 하는것
		// 단순히 이미지를 화면에 출력해줄때 쓰는것!
		if(isMainScreen)
		{ // isMainScreen 이 트루값일때 한해서 특정한 이미지를 그려줄 수 있도록 한다.
			g.drawImage(selectedImage, 340, 100, null);
			//selectedImage를 시작화면이 아닌 메인화면일때 보여줄수 있도록 하는것
			g.drawImage(titleImage,340,70,null);
			
		}
		paintComponents(g);
		// 이미지를 단순하게 해당 screenIamge라는 변수 안에 그려주는거 외에
		// 따로 JLabel같은 것들을 JFrame안에 추가하면 그걸 그려주는 것
		//메인 프레임에 추가된 요소들을 보여주는것들을 보여주는 함수!
		//add.rightbutton 같은거

		this.repaint();
		// paint는 JFrame을 상속받은 GUI게임에서 가장 첫번째로 화면을 그려주는 함수다
		// 이건 약속된거라 바뀌지 않는다.
	}
}

//class는 틀이라고 이해할 수 있는데, 클래스를 이용해서 하나의 실질적으로 사용할수
//있는 인스턴스라는 객체를 만들어 주엇을때 가장 먼저 실행되는 부분이 이 생성자임

//생성자의 특징은 자신의 클래스와 같은 이름을 가지고 있는 메소드이다.

/* Ctrl + shift + O 를 누르면 이클립스에서 알아서 필요한 기능들을 임포트 시켜줌 */