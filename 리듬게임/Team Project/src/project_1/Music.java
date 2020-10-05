package project_1;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread{
	//Thread라는것은 하나의 프로그램 안의 작은 프로그램이라고 할수있음
	
	private Player player;
	//플레이어가 javazoom 라이브러리 중 하나
	private boolean isLoop;
	//현재 곡이 무한반복인지 아님 꺼지는지에 대한 설정
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	
	public Music(String name, boolean isLoop)
	{
		//곡의 이름과, 해당 곡이 무한루프 인지 받아주는 생성자
		try {
			this.isLoop = isLoop;
			//isLoop 변수 초기화
			file = new File(Main.class.getResource("../music/"+name).toURI());
			//music이라는 폴더 안에있는 해당 이름을 가진 파일의 위치를 가져올 수 있게끔 함
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			//해당 파일을 버퍼에 담아서 읽어올수 있도록 하는것
			player = new Player(bis);
			// 해당파일을 담을수 있도록 해줌
			
		
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	public int getTime()
	{
		//현재 실행되고 있는 음악이 어떤위치에 실행되고 있는지 알려줌
		//노트를 떨어뜨릴때 이 겟타임을 이용해서 분석하게 될거임
		if (player == null)
			return 0;
		return player.getPosition();
	}
	
	public void close()
	{
		isLoop = false;
		player.close();
		this.interrupt();
		//플레이어가 곡을 재생하다가 뒤로가기 버튼을 누르면
		//이 메소드를 실행시켜 해당 쓰레드를 중지상태로 만들거다.
	}
	
	@Override
	public void run()
	{
		try {
			//곡을 실행시키는 메소드
			do
			{
				player.play();
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis);
			}	
			while(isLoop);
			//isLoop의 값이 true라면 해당 곡은 무한반복으로 실행됨.
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			//오류가 발생한경우 해당 오류메세지 등장
		}
	}

}
