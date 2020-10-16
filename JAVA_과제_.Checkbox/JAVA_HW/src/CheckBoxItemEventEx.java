import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CheckBoxItemEventEx extends JFrame{

	private JCheckBox [] check = new JCheckBox[8]; // 각각 체크박스, 라벨, 텍스트 필드를 만들어 배열로 나열 해줍니다.
	private JLabel[] money = new JLabel[8];
	private JTextField[] tf = new JTextField[8];
	private String [] names = {"오만원","만원","천원","500원","100원","50원","10원","1원"}; // 라벨에 들어갈 이름들입니다.

	private JButton Cal = new JButton("계산"); // 요건 따로 메소드를 만들거기 때문에 버튼도 따로 만들었습니다.
	private	JLabel Input = new JLabel("금액"); // 이건 딱히 계산에 쓰일일도 없어서 그냥 만들었습니다.
	private	JTextField Text = new JTextField(10); // 입력값 받을 텍스트필드입니다.
	private int tempnumber, tempnumber_2; // 계산시에 쓰일 변수입니다.
	
	public CheckBoxItemEventEx() {
		setTitle("체크박스 만들기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null); // 별도의 레이아웃을 쓰지않을거라고 한겁니다. 제가 좌표로 지정해서 만들거기 때문입니다.

		
		add(Cal);
		Cal.setLocation(280, 15);
		Cal.setSize(80,30);
		
		c.add(Input);
		Input.setLocation(100,15);
		Input.setSize(80,30);
		
		c.add(Text);
		Text.setLocation(150,10);
		Text.setSize(80,30);
		
		for(int i = 0; i<check.length;i++)
		{
			money[i] = new JLabel(names[i]);
			c.add(money[i]);
			money[i].setLocation(100,50+(20*i));
			money[i].setSize(200,20);
			tf[i] = new JTextField(10);
			c.add(tf[i]);
			tf[i].setLocation(150,50+(20*i));
			tf[i].setSize(80,20);
			check[i] = new JCheckBox();
			check[i].setLocation(250,50+(20*i));
			check[i].setSize(20,20);
			check[i].setBorderPainted(true);
			c.add(check[i]);
			//각각의 박스들을 전부 다 좌표로 지정해서 박아주었습니다.
		}
		setSize(600,600); // 프레임 크기 지정
		setVisible(true); 
		
		Cal.addActionListener(new ActionListener(){ // 버튼을 눌럿을때 일어날 이벤트 메소드입니다.
		@Override
		
		public void actionPerformed(ActionEvent e)
		{
			String number = Text.getText(); // number변수에 아까 값을 입력받을 TextField 에 적혀잇는 값을 가져옵니다.
			if(number.length() == 0) // 입력 창에 아무것도 안적혀있음 아무것도 하지말란 소립니다.
				return;
			
			int money = Integer.parseInt(Text.getText()); // number변수에는 현재 12345 라는 숫자가 들어가있지만 이는 String형입니다. 그래서 그걸 INT형으로 바꿔주는 코드입니다.
			tempnumber_2 = money; // 입력값을 그대로 보존하기 위해 새로운 변수에다 입력값을 넣었습니다.
			//*********************************************************************			
			if(check[0].isSelected()) // 체크박스 0번이 선택된다면
			{
				tempnumber = tempnumber_2 / 50000; // 체크박스 0번 값은 5만 이므로 입력값(tempnumber_2) 를 5만으로 나눠줍니다.
				tf[0].setText(""+tempnumber); // 결과값을 첫번째 TextField에 넣구요
				tempnumber_2 = tempnumber_2 - (tempnumber*50000); // 입력값에서 나눈만큼 빼줍니다. ( 나머지 구하는것과 같습니다 )
			}
			else
			tf[0].setText("0"); // 체크가 안되어있다면 0을 출력합니다.
			//*********************************************************************		
			if(check[1].isSelected())
			{
				tempnumber = tempnumber_2 / 10000;
				tf[1].setText(""+tempnumber);
				tempnumber_2 = tempnumber_2 - (tempnumber*10000);
			}
			else
				tf[1].setText("0");
			//*********************************************************************			
			if(check[2].isSelected())
			{
				tempnumber = tempnumber_2 / 1000;
				tf[2].setText(""+tempnumber);
				tempnumber_2 = tempnumber_2 - (tempnumber*1000);
			}
			else
				tf[2].setText("0");
			//*********************************************************************				
			if(check[3].isSelected())
			{
				tempnumber = tempnumber_2 / 500;
				tf[3].setText(""+tempnumber);
				tempnumber_2 = tempnumber_2 - (tempnumber*500);
			}
			else
				tf[3].setText("0");
			//*********************************************************************			
			if(check[4].isSelected())
			{
				tempnumber = tempnumber_2 / 100;
				tf[4].setText(""+tempnumber);
				tempnumber_2 = tempnumber_2 - (tempnumber*100);
			}
			else
				tf[4].setText("0");
			//*********************************************************************			
			if(check[5].isSelected())
			{
				tempnumber = tempnumber_2 / 50;
				tf[5].setText(""+tempnumber);
				tempnumber_2 = tempnumber_2 - (tempnumber*50);
			}
			else
				tf[5].setText("0");
			//*********************************************************************			
			if(check[6].isSelected())
			{
				tempnumber = tempnumber_2 / 10;
				tf[6].setText(""+tempnumber);
				tempnumber_2 = tempnumber_2 - (tempnumber*10);
			}
			else
				tf[6].setText("0");
			//*********************************************************************		
			if(check[7].isSelected())
			{
				tempnumber = tempnumber_2 / 1;
				tf[7].setText(""+tempnumber);
				tempnumber_2 = tempnumber_2 - (tempnumber*1);
			}
			else
				tf[7].setText("0");
			//*********************************************************************		
			
			
		}
		
		});
		
	}


		
	public static void main(String [] args)
	{
		new CheckBoxItemEventEx();
		
	}
//	Integerparse.Int(JTextField.getText()); 
	//JTextField.getText()
}
