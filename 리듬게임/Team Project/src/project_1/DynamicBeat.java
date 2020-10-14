package project_1;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DynamicBeat extends JFrame {

	private Image screenImage;
	private Graphics screenGraphic;
	// 더블 버퍼링을 위해 전체화면에 대한 이미지를 담는 두 인스턴스

	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameInfo.png")).getImage();
	private Image judgementInfoImage = new ImageIcon(Main.class.getResource("../images/judgementLine.png")).getImage();
	private Image noteRouteImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../images/noteRouteLine.png")).getImage();
	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/note.png")).getImage();
	
	private Image background = new ImageIcon(Main.class.getResource("../images/introBackground.png")).getImage();
	// 가져온 이미지를 담을수 있는 하나의 객체
	// Main 클래스의 위치를 기반으로 해서 background라는 리소스를 얻어온 뒤에 그것의 이미지 인스턴스를
	// background라는
	// 이미지 변수에다가 초기화를 해주겠다는 뜻;


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
	
	private ImageIcon easyButtonBasic = new ImageIcon(Main.class.getResource("../images/EasyButtonBasic.png"));
	private ImageIcon easyButtonEntered = new ImageIcon(Main.class.getResource("../images/EasyButtonEntered.png"));
	
	private ImageIcon hardButtonBasic = new ImageIcon(Main.class.getResource("../images/HardButtonBasic.png"));
	private ImageIcon hardButtonEntered = new ImageIcon(Main.class.getResource("../images/HardButtonEntered.png"));

	private ImageIcon backButtonBasic = new ImageIcon(Main.class.getResource("../images/backButtonBasic.png"));
	private ImageIcon backButtonEntered = new ImageIcon(Main.class.getResource("../images/backButtonEntered.png"));

	private JButton exitButton = new JButton(exitButtonBasicImage);
	// J버튼을 생성하고, 그 기본 디폴트값을 exitButtonBasicImage 로 설정함
	private JButton startButton = new JButton(startButtonBasic);
	private JButton quitButton = new JButton(quitButtonBasic);
	private JButton leftButton = new JButton(leftButtonBasic);
	private JButton rightButton = new JButton(rightButtonBasic);
	private JButton easyButton = new JButton(easyButtonBasic);
	private JButton hardButton = new JButton(hardButtonBasic);
	private JButton backButton = new JButton(backButtonBasic);


	private int mouseX,mouseY;
	//마우스의 X,Y좌표
	

	private boolean isMainScreen = false;
	//처음에는 메인화면이 아닌 시작화면이기때문에 false값 / 메인화면으로 바뀌면 이게 트루값
	private boolean isGameScreen = false;
	// 게임화면으로 넘어갈때 true 넣을꺼임
	
	ArrayList<Track> trackList = new ArrayList<Track>();
	//Track이라는 클래스를 이용하기 위한 명령어
	
	
	//************* Track 클래스에 쓰일 변수들 **********
	private Image selectedImage;
	private Image titleImage;
	//현재 선택된 곡의 이미지 / 시작 이미지
	private Music selectedMusic;
	private int nowSelected = 0;
	//현재 선택된 곡을 의미하며, 0을 선택함으로써 첫번째곡을 의미하도록 만들어줌.
	// 현재 선택이 된 트랙의 번호를 의미 Array는 0부터 시작하기 때문에 현재곡은 Faded가 설정될것임. 처음 넣은게 그거거든.
	private Music introMusic = new Music("introMusic.mp3", true);
	
	
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

		introMusic.start();
		
		
		trackList.add(new Track("FadedTitleimage.png", "FadedStartImage.png","FadedGameImage.png",
				"Alan Walker - Fade [NCS Release].mp3","Alan Walker - Fade [NCS Release].mp3"));
		//5개의 매개변수가 Track 클래스의 Track 생성자에 차례대로 들어감
		trackList.add(new Track("MortalsTitleimage.png", "MortalsStartImage.png","MortalsGameImage.png",
				"Warriyo - Mortals (feat. Laura Brehm) [NCS Release].mp3","Warriyo - Mortlas (feat. Laura Brehm) [NCS Release].mp3"));
		
		trackList.add(new Track("EyesTitleImage.png", "EyesStartImage.png","EyesGameImage.png",
				"Diamond Eyes - Everything [NCS Release].mp3","Diamond Eyes - Everything [NCS Release].mp3"));
		//리스트로 들어갔으니 차례대로 0 , 1, 2번째 인덱스로 들어가게 되는것임.
		
		
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
		///////////////////////////////////////버튼 간 구분선/////////////////////
		
		
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
				introMusic.close();
				//게임 시작하고나면 인트로 뮤직 끄기

				//****************게임 시작 이벤트*******************
				enterMain();

			}
		});
		add(startButton);
		///////////////////////////////////////버튼 간 구분선/////////////////////
		
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
		///////////////////////////////////////버튼 간 구분선/////////////////////
		
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
				selectLeft();
				
				
			}
		});
		add(leftButton);
		
		///////////////////////////////////////버튼 간 구분선/////////////////////
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
				//오른쪽 버튼 이벤트 요거 맨 아래 페인트 메소드 밑에 있음
				selectRight();
				
			}
		});
		add(rightButton);
		///////////////////////////////////////버튼 간 구분선/////////////////////
		easyButton.setVisible(false);
		easyButton.setBounds(375, 580, 250, 67);
		// X Y , Width , Height
		easyButton.setBorderPainted(false);
		easyButton.setContentAreaFilled(false);
		easyButton.setFocusPainted(false);
		//크기 조절 및 자연스러운 모양으로 들어가도록 해주는 3줄
		easyButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e)
			{
				easyButton.setIcon(easyButtonEntered);
				easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonenter.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e)
			{
				easyButton.setIcon(easyButtonBasic);
				easyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e)
			{
				Music buttonPressedMusic = new Music("buttonclick.mp3",false);
				buttonPressedMusic.start();
				//난이도 쉬움 이벤트
				gameStart(nowSelected,"easy");
				
				
			}
		});
		add(easyButton);
		///////////////////////////////////////버튼 간 구분선/////////////////////
		hardButton.setVisible(false);
		hardButton.setBounds(655, 580, 250, 67);
		// X Y , Width , Height
		hardButton.setBorderPainted(false);
		hardButton.setContentAreaFilled(false);
		hardButton.setFocusPainted(false);
		//크기 조절 및 자연스러운 모양으로 들어가도록 해주는 3줄
		hardButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e)
			{
				hardButton.setIcon(hardButtonEntered);
				hardButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonenter.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e)
			{
				hardButton.setIcon(hardButtonBasic);
				hardButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e)
			{
				Music buttonPressedMusic = new Music("buttonclick.mp3",false);
				buttonPressedMusic.start();
				//난이도 어려움 이벤트
				gameStart(nowSelected,"hard");
				
				
			}
		});
		add(hardButton);
		
		///////////////////////////////////////버튼 간 구분선/////////////////////
		
		backButton.setVisible(false);
		backButton.setBounds(20, 50, 60, 60);
		// X Y , Width , Height
		backButton.setBorderPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.setFocusPainted(false);
		//크기 조절 및 자연스러운 모양으로 들어가도록 해주는 3줄
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e)
			{
				backButton.setIcon(backButtonEntered);
				backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonenter.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e)
			{
				backButton.setIcon(backButtonBasic);
				backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e)
			{
				Music buttonPressedMusic = new Music("buttonclick.mp3",false);
				buttonPressedMusic.start();
				//메인으로 돌아가는 이벤트
				backMain();
				
			}
		});
		add(backButton);
		
		
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



	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIHT);
		// 1200x720의 이미지를 만들어둔 뒤에 그걸 스크린 이미지에 넣어주겠다
		screenGraphic = screenImage.getGraphics();
		// 스크린 이미지를 이용해서 그래픽 객체를 얻어오는것
		screenDraw((Graphics2D) screenGraphic);
		// 스크린 그래픽에 어떠한 그림을 그려주는것
		//Graphics2D 를 사용하면 밑에 텍스트가 조금씩 깨지는걸 해결할수있음
		g.drawImage(screenImage, 0, 0, null);
		// 스크린 이미지를 0,0의 위치에 그려주는 것

	}

	public void screenDraw(Graphics2D g) {

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
		if(isGameScreen)
		{
			g.drawImage(gameInfoImage, 0, 660, null);
			g.drawImage(judgementInfoImage, 0, 580, null);
			
			g.drawImage(noteRouteImage, 228, 30, null);//1
			g.drawImage(noteRouteImage, 332, 30, null);//2
			g.drawImage(noteRouteImage, 436, 30, null);//3
			g.drawImage(noteRouteImage, 540, 30, null);//4
			g.drawImage(noteRouteImage, 640, 30, null);//5
			g.drawImage(noteRouteImage, 744, 30, null);//6
			g.drawImage(noteRouteImage, 848, 30, null);//7
			g.drawImage(noteRouteImage, 952, 30, null);//8

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

		this.repaint();
		// paint는 JFrame을 상속받은 GUI게임에서 가장 첫번째로 화면을 그려주는 함수다
		// 이건 약속된거라 바뀌지 않는다.
	}
	
	
	public void selectTrack(int nowSelected)// 지금 선택된 곡에 번호를 넣어줌으로써 지금 선택된 곡이 뭔지 알게함
	{
		if(selectedMusic != null) // selectedMusic이 null이 아니라면 즉, 어떠한 곡이 실행되고 있다면
			selectedMusic.close();
		titleImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getTitleImage())).getImage();
		// 현재 선택된 트랙(곡)이 가지고있는 타이틀 이미지 값을 가져와서 넣어주겠다는 말
		selectedImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getStartImage())).getImage();
		// 현재 선택된 곡의 이미지를 트랙의 곡 이미지로 바꿔주고 타이틀 이미지또한 바꿔주겠다는 말
		selectedMusic = new Music (trackList.get(nowSelected).getStartMusic(),true);
		// selectedMusic을 트랙 리스트의 선택된 nowSelected에 해당하는 곡을 getStartMusic으로 가져온다는 말, true값을 넣음으로써 무한재생
		selectedMusic.start();
		
	}
	
	public void selectLeft()
	{
		if(nowSelected == 0)
			nowSelected = trackList.size() - 1;
		//0번째 곡일때 왼쪽을 누르면 가장 오른쪽에 있는 곡이 선택되어야되니까 이렇게 해줘야됨.
		else
			nowSelected --;
		selectTrack(nowSelected);
		
	}
	
	public void selectRight()
	{
		if(nowSelected == trackList.size() - 1)
			//현재 선택된곡이 가장 마지막에 있는 곡이라면
			nowSelected = 0;
		//처음으로 돌아가줌.
		else
			nowSelected ++;
		selectTrack(nowSelected);
		
	}
	public void gameStart(int nowSelected, String difficulty) {
		if(selectedMusic != null)
			selectedMusic.close();
		isMainScreen = false;
		//메인 화면이 아님 여기서부터는 인게임 화면
		isGameScreen = true;
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		easyButton.setVisible(false);
		hardButton.setVisible(false);
		background = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getGameImage())).getImage();
		backButton.setVisible(true);

	}
		
	
	public void backMain() // 백버튼을 눌럿을때 다시 메인화면으로 돌아가는 함수
	{
		isMainScreen = true;
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		easyButton.setVisible(true);
		hardButton.setVisible(true);
		//메인 배경화면을 띄우고, 각 버튼을 되살림
		background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage();
		backButton.setVisible(false); // 백버튼이 보이면 안되니까 false
		selectTrack(nowSelected); // 현재 메인화면에서 선택된 곡 다시 플레이
		isGameScreen = false;
		

	}
	
	public void enterMain()//메인화면으로 들어가는 메소드
	{
		
		background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage();
		startButton.setVisible(false);
		quitButton.setVisible(false);
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		easyButton.setVisible(true);
		hardButton.setVisible(true);
		introMusic.close();
		selectTrack(0);
		//게임이 시작되면 첫번째 인덱스 인 Faded가 재생되므로 첫번째곡인 fade를 재생해라

		isMainScreen = true;
		//시작버튼이 눌렸을때 게임화면이 띄워지게끔
	}
}
//class는 틀이라고 이해할 수 있는데, 클래스를 이용해서 하나의 실질적으로 사용할수
//있는 인스턴스라는 객체를 만들어 주엇을때 가장 먼저 실행되는 부분이 이 생성자임

//생성자의 특징은 자신의 클래스와 같은 이름을 가지고 있는 메소드이다.

/* Ctrl + shift + O 를 누르면 이클립스에서 알아서 필요한 기능들을 임포트 시켜줌 */