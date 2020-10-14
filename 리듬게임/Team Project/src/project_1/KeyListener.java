package project_1;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter{
	
	@Override
	public void keyPressed(KeyEvent e) // 키를 눌럿을대 어떠한 키를 눌렀는지 감지할 메소드 (KeyEvent 를 받아서 사용)
	{
		if(DynamicBeat.game == null)
		{
			return;
			//현재 게임이라는 변수가 진행중이지 않은 상태라면 바로 리턴함으로써 아래 if문들을 실행시키지 않게끔 함
		}
		if(e.getKeyCode() == KeyEvent.VK_S)//현재 누른 키가 S라면 / Game에 있는 함수 사용해서 만든거임.
		{
			DynamicBeat.game.pressS();
		}
		else if(e.getKeyCode() == KeyEvent.VK_D)
		{
			DynamicBeat.game.pressD();
		}
		else if(e.getKeyCode() == KeyEvent.VK_F)
		{
			DynamicBeat.game.pressF();
		}
		else if(e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			DynamicBeat.game.pressSpace();
		}
		else if(e.getKeyCode() == KeyEvent.VK_J)
		{
			DynamicBeat.game.pressJ();
		}
		else if(e.getKeyCode() == KeyEvent.VK_K)
		{
			DynamicBeat.game.pressK();
		}
		else if(e.getKeyCode() == KeyEvent.VK_L)
		{
			DynamicBeat.game.pressL();
		}

	}
	
	@Override
	public void keyReleased(KeyEvent e)
	{
		if(DynamicBeat.game == null)
		{
			return;
			//현재 게임이라는 변수가 진행중이지 않은 상태라면 바로 리턴함으로써 아래 if문들을 실행시키지 않게끔 함
		}
		if(e.getKeyCode() == KeyEvent.VK_S)//현재 누른 키가 S라면
		{
			DynamicBeat.game.relaseS();
		}
		else if(e.getKeyCode() == KeyEvent.VK_D)
		{
			DynamicBeat.game.relaseD();
		}
		else if(e.getKeyCode() == KeyEvent.VK_F)
		{
			DynamicBeat.game.relaseF();
		}
		else if(e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			DynamicBeat.game.relaseSpace();
		}
		else if(e.getKeyCode() == KeyEvent.VK_J)
		{
			DynamicBeat.game.relaseJ();
		}
		else if(e.getKeyCode() == KeyEvent.VK_K)
		{
			DynamicBeat.game.relaseK();
		}
		else if(e.getKeyCode() == KeyEvent.VK_L)
		{
			DynamicBeat.game.relaseL();
		}
	}

}
