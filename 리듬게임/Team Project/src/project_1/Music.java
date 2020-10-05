package project_1;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread{
	//Thread��°��� �ϳ��� ���α׷� ���� ���� ���α׷��̶�� �Ҽ�����
	
	private Player player;
	//�÷��̾ javazoom ���̺귯�� �� �ϳ�
	private boolean isLoop;
	//���� ���� ���ѹݺ����� �ƴ� ���������� ���� ����
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	
	public Music(String name, boolean isLoop)
	{
		//���� �̸���, �ش� ���� ���ѷ��� ���� �޾��ִ� ������
		try {
			this.isLoop = isLoop;
			//isLoop ���� �ʱ�ȭ
			file = new File(Main.class.getResource("../music/"+name).toURI());
			//music�̶�� ���� �ȿ��ִ� �ش� �̸��� ���� ������ ��ġ�� ������ �� �ְԲ� ��
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			//�ش� ������ ���ۿ� ��Ƽ� �о�ü� �ֵ��� �ϴ°�
			player = new Player(bis);
			// �ش������� ������ �ֵ��� ����
			
		
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	public int getTime()
	{
		//���� ����ǰ� �ִ� ������ ���ġ�� ����ǰ� �ִ��� �˷���
		//��Ʈ�� ����߸��� �� ��Ÿ���� �̿��ؼ� �м��ϰ� �ɰ���
		if (player == null)
			return 0;
		return player.getPosition();
	}
	
	public void close()
	{
		isLoop = false;
		player.close();
		this.interrupt();
		//�÷��̾ ���� ����ϴٰ� �ڷΰ��� ��ư�� ������
		//�� �޼ҵ带 ������� �ش� �����带 �������·� ����Ŵ�.
	}
	
	@Override
	public void run()
	{
		try {
			//���� �����Ű�� �޼ҵ�
			do
			{
				player.play();
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis);
			}	
			while(isLoop);
			//isLoop�� ���� true��� �ش� ���� ���ѹݺ����� �����.
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			//������ �߻��Ѱ�� �ش� �����޼��� ����
		}
	}

}
