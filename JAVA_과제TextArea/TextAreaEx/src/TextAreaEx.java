import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.BadLocationException;

public class TextAreaEx extends JFrame{
	private JSlider slider = new JSlider(JSlider.HORIZONTAL,0,100,0); // Jslider 생성
	private JTextArea ta = new JTextArea(7,10); // TextArea 생성
	
	public TextAreaEx()
	{
		setTitle("TextArea 예제");
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
				JSlider slider = (JSlider)e.getSource(); // 이벤트 소스 slider에 저장
				if(ta.getText().length() <= slider.getValue())// TextArea의 값을 받아와서 그 길이와 slider의 값을 비교해서 TextArea의 값이 더 작거나 같다면
				{
					slider.setValue(ta.getText().length()); // slider의 값을 TextArea의 길이 값과 같게 맞춰줌
				}
			
			else 
			{
				try {
					ta.setText(ta.getText(0,slider.getValue()));
					//TextArea안에 있는 값을 설정한다. 먼저 TextArea안에 있는 값을 가져오라 했는데 그 과정에서 Slider가 가진 값 만큼 빈 문자열로 반환한다.
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
			JTextArea ta = (JTextArea)e.getSource(); // 이벤트 소스 가져옴
			int size = ta.getText().length(); // size 변수에 TextArea 의 길이값을 집어넣음
			try
			{
				if(size >= 100) // 사이즈가 100보다 커진다면
					ta.setText(ta.getText(0,100)); // 100이후 부터는 그냥 빈문자열로 출력하도록 함
			}
			catch(BadLocationException ex) {}
			slider.setValue(size); // 슬라이더의 값을 size와 동일하게 맞춤 ( TextArea 값과 동일하게 )
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




