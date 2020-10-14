package project_1;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter{
	
	@Override
	public void keyPressed(KeyEvent e) // Ű�� �������� ��� Ű�� �������� ������ �޼ҵ� (KeyEvent �� �޾Ƽ� ���)
	{
		if(DynamicBeat.game == null)
		{
			return;
			//���� �����̶�� ������ ���������� ���� ���¶�� �ٷ� ���������ν� �Ʒ� if������ �����Ű�� �ʰԲ� ��
		}
		if(e.getKeyCode() == KeyEvent.VK_S)//���� ���� Ű�� S��� / Game�� �ִ� �Լ� ����ؼ� �������.
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
			//���� �����̶�� ������ ���������� ���� ���¶�� �ٷ� ���������ν� �Ʒ� if������ �����Ű�� �ʰԲ� ��
		}
		if(e.getKeyCode() == KeyEvent.VK_S)//���� ���� Ű�� S���
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
