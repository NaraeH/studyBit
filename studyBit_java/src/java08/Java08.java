package java08;

public class Java08 {

	public static void main(String[] args) {
		
		double myHeight = 189.0;
		hiEveryone(12, 12.5);
		hiEveryone(12, myHeight);
		byeEveryone();
	}
		
		public static void hiEveryone(int age, double height){
			System.out.println("제 나이는 " + age + "입니다.");
			System.out.println("제 키는 " + height + "입니다.");
		}
		
		public static void byeEveryone(){
			System.out.println("안녕히 가십시오");
		}
	
}
