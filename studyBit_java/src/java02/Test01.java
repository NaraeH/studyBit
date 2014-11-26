package java02;

public class Test01 {

	public static void main(String[] args) {
		
		Person p1 = new Person("홍길동", "m880101");
		Person p2 = new Person("성춘향");

		System.out.println("이름: " + p1.getName());
		System.out.println("군번호: " + p1.getmId());
		
		System.out.println("이름: " + p2.getName());
		System.out.println("군번호: " + p2.getmId());

	}

}
