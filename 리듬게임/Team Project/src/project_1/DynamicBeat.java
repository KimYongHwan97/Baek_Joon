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
	// ���� ���۸��� ���� ��üȭ�鿡 ���� �̹����� ��� �� �ν��Ͻ�

	private Image background = new ImageIcon(Main.class.getResource("../images/introBackground.png")).getImage();
	// ������ �̹����� ������ �ִ� �ϳ��� ��ü
	// Main Ŭ������ ��ġ�� ������� �ؼ� background��� ���ҽ��� ���� �ڿ� �װ��� �̹��� �ν��Ͻ���
	// background���
	// �̹��� �������ٰ� �ʱ�ȭ�� ���ְڴٴ� ��;
	private Image selectedImage = new ImageIcon(Main.class.getResource("../images/Start Image.jpg")).getImage();
	//���� ���õ� ���� �̹��� / ���� �̹���
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));
	// JLabel�� �̿��� �޴��� �̹��� �ҷ��� �� ����
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
	// J��ư�� �����ϰ�, �� �⺻ ����Ʈ���� exitButtonBasicImage �� ������
	private JButton startButton = new JButton(startButtonBasic);
	private JButton quitButton = new JButton(quitButtonBasic);
	private JButton leftButton = new JButton(leftButtonBasic);
	private JButton rightButton = new JButton(rightButtonBasic);

	private int mouseX,mouseY;
	//���콺�� X,Y��ǥ
	

	private boolean isMainScreen = false;
	//ó������ ����ȭ���� �ƴ� ����ȭ���̱⶧���� false�� / ����ȭ������ �ٲ�� �̰� Ʈ�簪
	
	public DynamicBeat() // �����ڸ� �������
	{
		setUndecorated(true);
		// �⺻������ �����Ǵ� �������� JLabel �����
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_WIDTH);
		// Main Ŭ������ public static ���� Ȱ������ ������ ����
		setResizable(false);
		// ����� ���Ǵ�� ������ ���� �Ұ���
		setLocationRelativeTo(null);
		// ����ڰ� ���α׷��� ���������� â�� ���߾ӿ� �߰Բ� ��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*
		 * ����ڰ� â�� �ݾ����� ���α׷��� ����ǰԲ� �� �̰� ���ϰԵǸ� ����ڰ� â�� �ݾƵ� ���α׷��� ����ؼ� ���ư��� ��
		 */
		setVisible(true);
		// �⺻���� false�� �츮 ���� ����â�� ���̰� �Ϸ��� Ʈ��� ��������ߵ�.
		setBackground(new Color(0, 0, 0, 0));
		// ����Ʈ ������Ʈ�� ������ ����� ȸ���� �ƴ϶� ���� �Ͼ������ �ٲ�
		setLayout(null);
		// ��ư�̳� JLabel�� �־����� �� ��ġ �״�� ������ ��

		exitButton.setBounds(1245, 0, 30, 30);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		//ũ�� ���� �� �ڿ������� ������� ������ ���ִ� 3��
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
					//�̰� �־��ְԵǸ� Ŭ���ؼ� �Ҹ��� ���´����� 1������ �ִٰ� ���α׷��� �����.
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
		//ũ�� ���� �� �ڿ������� ������� ������ ���ִ� 3��
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
				//���� ���� �̺�Ʈ
				startButton.setVisible(false);
				quitButton.setVisible(false);
				leftButton.setVisible(true);
				rightButton.setVisible(true);
				background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage();
				
				isMainScreen = true;
				//���۹�ư�� �������� ����ȭ���� ������Բ�
			}
		});
		add(startButton);
		
		
		quitButton.setBounds(40, 550, 400, 100);
		// X Y , Width , Height
		quitButton.setBorderPainted(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		//ũ�� ���� �� �ڿ������� ������� ������ ���ִ� 3��
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
					//�̰� �־��ְԵǸ� Ŭ���ؼ� �Ҹ��� ���´����� 1������ �ִٰ� ���α׷��� �����.
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
		//ũ�� ���� �� �ڿ������� ������� ������ ���ִ� 3��
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
				//���� ��ư �̺�Ʈ
				
				
			}
		});
		add(leftButton);
		
		
		rightButton.setVisible(false);
		rightButton.setBounds(1080, 310, 60, 60);
		// X Y , Width , Height
		rightButton.setBorderPainted(false);
		rightButton.setContentAreaFilled(false);
		rightButton.setFocusPainted(false);
		//ũ�� ���� �� �ڿ������� ������� ������ ���ִ� 3��
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
				//������ ��ư �̺�Ʈ
				
				
			}
		});
		add(rightButton);
		
		menuBar.setBounds(0, 0, 1280, 30);
		// �޴����� ũ�� ����
		menuBar.addMouseListener(new MouseAdapter()
				{
					@Override
					public void mousePressed(MouseEvent e)
					{
						mouseX = e.getX();
						mouseY = e.getY();
						//������ ���콺�� �������� �� ��ǥ�� �޾ƿ´ٴ� �Ҹ�
						
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
						//JFrame�� ��ġ ��ü�� �ٲ��ټ� �ְԵ�.
						//�巡�� �Ҷ� �������� X Y��ǥ�� ���� �ڵ����� ����â�� ��ġ�� �ٲ��ִ°�
					}
					
				}
		);
		add(menuBar);



		Music introMusic = new Music("introMusic.mp3", true);
		introMusic.start();
	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIHT);
		// 1200x720�� �̹����� ������ �ڿ� �װ� ��ũ�� �̹����� �־��ְڴ�
		screenGraphic = screenImage.getGraphics();
		// ��ũ�� �̹����� �̿��ؼ� �׷��� ��ü�� �����°�
		screenDraw(screenGraphic);
		// ��ũ�� �׷��ȿ� ��� �׸��� �׷��ִ°�
		g.drawImage(screenImage, 0, 0, null);
		// ��ũ�� �̹����� 0,0�� ��ġ�� �׷��ִ� ��

	}

	public void screenDraw(Graphics g) {

		g.drawImage(background, 0, 0, null);
		// ��Ʈ�� ��׶��带 ��ũ�� �̹����� �׷��� �� �ֵ��� �ϴ°�
		// �ܼ��� �̹����� ȭ�鿡 ������ٶ� ���°�!
		if(isMainScreen)
		{ // isMainScreen �� Ʈ�簪�϶� ���ؼ� Ư���� �̹����� �׷��� �� �ֵ��� �Ѵ�.
			g.drawImage(selectedImage, 340, 100, null);
			//selectedImage�� ����ȭ���� �ƴ� ����ȭ���϶� �����ټ� �ֵ��� �ϴ°�
			g.drawImage(titleImage,340,70,null);
			
		}
		paintComponents(g);
		// �̹����� �ܼ��ϰ� �ش� screenIamge��� ���� �ȿ� �׷��ִ°� �ܿ�
		// ���� JLabel���� �͵��� JFrame�ȿ� �߰��ϸ� �װ� �׷��ִ� ��
		//���� �����ӿ� �߰��� ��ҵ��� �����ִ°͵��� �����ִ� �Լ�!
		//add.rightbutton ������

		this.repaint();
		// paint�� JFrame�� ��ӹ��� GUI���ӿ��� ���� ù��°�� ȭ���� �׷��ִ� �Լ���
		// �̰� ��ӵȰŶ� �ٲ��� �ʴ´�.
	}
}

//class�� Ʋ�̶�� ������ �� �ִµ�, Ŭ������ �̿��ؼ� �ϳ��� ���������� ����Ҽ�
//�ִ� �ν��Ͻ���� ��ü�� ����� �־����� ���� ���� ����Ǵ� �κ��� �� ��������

//�������� Ư¡�� �ڽ��� Ŭ������ ���� �̸��� ������ �ִ� �޼ҵ��̴�.

/* Ctrl + shift + O �� ������ ��Ŭ�������� �˾Ƽ� �ʿ��� ��ɵ��� ����Ʈ ������ */