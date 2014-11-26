//깊은 복사 테스트
package java10;

public class Main {

	public static void main(String[] args) {
		
		Person p1 = new Person("홍길동");
		Person p2 = new Person("임꺽정");
		
		p2 = p1;
		
		p2.setName("신사임당");
		
		System.out.println("p1의 이름: " + p1.getName());
		System.out.println("p2의 이름: " + p2.getName());
	}
}
