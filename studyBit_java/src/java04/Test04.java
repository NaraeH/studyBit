package java04;

public class Test04 {

	public static void main(String[] args) {
		
		Score s = new Score("홍길동", 100, 90, 100);
		
		s.sum();
		s.avg();
		s.grade();
		
		System.out.println(s.getName() + "의 성적은" + s.getGrade() + "입니다");

	}

}
