import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.BadLocationException;

public class TextAreaEx extends JFrame{
	private JSlider slider = new JSlider(JSlider.HORIZONTAL,0,100,0); // Jslider ����
	private JTextArea ta = new JTextArea(7,10); // TextArea ����
	
	public TextAreaEx()
	{
		setTitle("TextArea ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		c.add(slider, BorderLayout.SOUTH);
		c.add(new JScrollPane(ta),BorderLayout.CENTER);
		
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setPaintTrack(true);
		slider.setMajorTickSpacing(20);
		
		slider.addChangeListener(new ChangeListener() 
		{
			@Override
			public void stateChanged(ChangeEvent e)
			{
				JSlider slider = (JSlider)e.getSource(); // �̺�Ʈ �ҽ� slider�� ����
				if(ta.getText().length() <= slider.getValue())// TextArea�� ���� �޾ƿͼ� �� ���̿� slider�� ���� ���ؼ� TextArea�� ���� �� �۰ų� ���ٸ�
				{
					slider.setValue(ta.getText().length()); // slider�� ���� TextArea�� ���� ���� ���� ������
				}
			
			else 
			{
				try {
					ta.setText(ta.getText(0,slider.getValue()));
					//TextArea�ȿ� �ִ� ���� �����Ѵ�. ���� TextArea�ȿ� �ִ� ���� �������� �ߴµ� �� �������� Slider�� ���� �� ��ŭ �� ���ڿ��� ��ȯ�Ѵ�.
				} 
				catch (BadLocationException e1)
				{
					
				}
					
			}
			}
		});
		
		ta.addKeyListener(new KeyAdapter() 
		{
		@Override
		public void keyTyped(KeyEvent e) 
		{
			JTextArea ta = (JTextArea)e.getSource(); // �̺�Ʈ �ҽ� ������
			int size = ta.getText().length(); // size ������ TextArea �� ���̰��� �������
			try
			{
				if(size >= 100) // ����� 100���� Ŀ���ٸ�
					ta.setText(ta.getText(0,100)); // 100���� ���ʹ� �׳� ���ڿ��� ����ϵ��� ��
			}
			catch(BadLocationException ex) {}
			slider.setValue(size); // �����̴��� ���� size�� �����ϰ� ���� ( TextArea ���� �����ϰ� )
		}
		});
		
		setSize(300,250);
		setVisible(true);
	}

public static void main(String[] args)
{
	new TextAreaEx();
}



}




