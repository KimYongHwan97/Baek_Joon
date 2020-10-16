import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CheckBoxItemEventEx extends JFrame{

	private JCheckBox [] check = new JCheckBox[8]; // ���� üũ�ڽ�, ��, �ؽ�Ʈ �ʵ带 ����� �迭�� ���� ���ݴϴ�.
	private JLabel[] money = new JLabel[8];
	private JTextField[] tf = new JTextField[8];
	private String [] names = {"������","����","õ��","500��","100��","50��","10��","1��"}; // �󺧿� �� �̸����Դϴ�.

	private JButton Cal = new JButton("���"); // ��� ���� �޼ҵ带 ����ű� ������ ��ư�� ���� ��������ϴ�.
	private	JLabel Input = new JLabel("�ݾ�"); // �̰� ���� ��꿡 �����ϵ� ��� �׳� ��������ϴ�.
	private	JTextField Text = new JTextField(10); // �Է°� ���� �ؽ�Ʈ�ʵ��Դϴ�.
	private int tempnumber, tempnumber_2; // ���ÿ� ���� �����Դϴ�.
	
	public CheckBoxItemEventEx() {
		setTitle("üũ�ڽ� ����� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null); // ������ ���̾ƿ��� ���������Ŷ�� �Ѱ̴ϴ�. ���� ��ǥ�� �����ؼ� ����ű� �����Դϴ�.

		
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
			//������ �ڽ����� ���� �� ��ǥ�� �����ؼ� �ھ��־����ϴ�.
		}
		setSize(600,600); // ������ ũ�� ����
		setVisible(true); 
		
		Cal.addActionListener(new ActionListener(){ // ��ư�� �������� �Ͼ �̺�Ʈ �޼ҵ��Դϴ�.
		@Override
		
		public void actionPerformed(ActionEvent e)
		{
			String number = Text.getText(); // number������ �Ʊ� ���� �Է¹��� TextField �� �����մ� ���� �����ɴϴ�.
			if(number.length() == 0) // �Է� â�� �ƹ��͵� ���������� �ƹ��͵� �������� �Ҹ��ϴ�.
				return;
			
			int money = Integer.parseInt(Text.getText()); // number�������� ���� 12345 ��� ���ڰ� �������� �̴� String���Դϴ�. �׷��� �װ� INT������ �ٲ��ִ� �ڵ��Դϴ�.
			tempnumber_2 = money; // �Է°��� �״�� �����ϱ� ���� ���ο� �������� �Է°��� �־����ϴ�.
			//*********************************************************************			
			if(check[0].isSelected()) // üũ�ڽ� 0���� ���õȴٸ�
			{
				tempnumber = tempnumber_2 / 50000; // üũ�ڽ� 0�� ���� 5�� �̹Ƿ� �Է°�(tempnumber_2) �� 5������ �����ݴϴ�.
				tf[0].setText(""+tempnumber); // ������� ù��° TextField�� �ֱ���
				tempnumber_2 = tempnumber_2 - (tempnumber*50000); // �Է°����� ������ŭ ���ݴϴ�. ( ������ ���ϴ°Ͱ� �����ϴ� )
			}
			else
			tf[0].setText("0"); // üũ�� �ȵǾ��ִٸ� 0�� ����մϴ�.
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
