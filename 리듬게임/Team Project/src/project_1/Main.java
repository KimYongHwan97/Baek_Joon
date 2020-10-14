package project_1;

public class Main {
	
	public static final int SCREEN_WIDTH = 1280; //JFrame의 너비
	public static final int SCREEN_HEIHT = 720; //JFrame의 높이

	public static void main(String[] args) {
		
		new DynamicBeat(); 
		// 만들은 DynamicBeat라는 클래스를 이용한 인스턴스 객체 생성
		
	}
}

//public static 이라는것은 모든 프로젝트 내에서 공유할수 있는 하나의 변수를 의미
//final은 한번 선언되면 절대 바뀌지 않는 숫자를 얘기함
/*자바에서 제공하는 단순 이미지를 화면에 띄우는 방식을 사용시에 버퍼링 현상이 심하게 일어남
 *그래서 더블 버퍼링이라는 프로그래밍 기법을 이용할건데 이건 현재 프로그램의 전체화면의
 *크기에 맞는 이미지를 매 순간 생성해서 원하는 이미지만 화면에 출력하는 방식
 *버퍼에 이미지를 담아서 매 순간 이미지를 갱신해주기 때문에 게임에서는 빠질수 없는 기술  */
