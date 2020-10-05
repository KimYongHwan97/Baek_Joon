package project_1;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class DynamicBeat extends JFrame {
	
	private Image screenImage;
	private Graphics screenGraphic;
	//���� ���۸��� ���� ��üȭ�鿡 ���� �̹����� ��� �� �ν��Ͻ�
	
	private Image introBackground;
	//������ �̹����� ������ �ִ� �ϳ��� ��ü
	
	public DynamicBeat() // �����ڸ� �������
	{
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH,Main.SCREEN_WIDTH);
		//Main Ŭ������ public static ���� Ȱ������ ������ ����
		setResizable(false);
		//����� ���Ǵ�� ������ ���� �Ұ���
		setLocationRelativeTo(null);
		//����ڰ� ���α׷��� ���������� â�� ���߾ӿ� �߰Բ� ��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*����ڰ� â�� �ݾ����� ���α׷��� ����ǰԲ� �� �̰� ���ϰԵǸ�
		 * ����ڰ� â�� �ݾƵ� ���α׷��� ����ؼ� ���ư��� ��*/	
		setVisible(true);
		//�⺻���� false�� �츮 ���� ����â�� ���̰� �Ϸ��� Ʈ��� ��������ߵ�.
		
		introBackground = new ImageIcon(Main.class.getResource("../images/introBackground.jpg")).getImage();
		//Main Ŭ������ ��ġ�� ������� �ؼ� introBackground��� ���ҽ��� ���� �ڿ� �װ��� �̹��� �ν��Ͻ��� introBackground���
		//�̹��� �������ٰ� �ʱ�ȭ�� ���ְڴٴ� ��
		
		Music introMusic = new Music("introMusic.mp3",true);
		introMusic.start();
	}
	
	public void paint(Graphics g) {
	screenImage = createImage(Main.SCREEN_WIDTH,Main.SCREEN_HEIHT);
	//1200x720�� �̹����� ������ �ڿ� �װ� ��ũ�� �̹����� �־��ְڴ�
	screenGraphic = screenImage.getGraphics();
	// ��ũ�� �̹����� �̿��ؼ� �׷��� ��ü�� �����°�
	screenDraw(screenGraphic);
	// ��ũ�� �׷��ȿ� ��� �׸��� �׷��ִ°�
	g.drawImage(screenImage, 0, 0, null);
	// ��ũ�� �̹����� 0,0�� ��ġ�� �׷��ִ� ��

	}
	public void screenDraw(Graphics g) {
		
		g.drawImage(introBackground, 0, 0, null);
		//��Ʈ�� ��׶��带 ��ũ�� �̹����� �׷��� �� �ֵ��� �ϴ°�
		this.repaint();
		//paint�� JFrame�� ��ӹ��� GUI���ӿ��� ���� ù��°�� ȭ���� �׷��ִ� �Լ���
		// �̰� ��ӵȰŶ� �ٲ��� �ʴ´�.
	}
}




//class�� Ʋ�̶�� ������ �� �ִµ�, Ŭ������ �̿��ؼ� �ϳ��� ���������� ����Ҽ�
//�ִ� �ν��Ͻ���� ��ü�� ����� �־����� ���� ���� ����Ǵ� �κ��� �� ��������

//�������� Ư¡�� �ڽ��� Ŭ������ ���� �̸��� ������ �ִ� �޼ҵ��̴�.

/*Ctrl + shift + O �� ������ ��Ŭ�������� �˾Ƽ� �ʿ��� ��ɵ��� ����Ʈ ������*/