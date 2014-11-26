package java03;

public class Circle {
	
	private static final float PI = 3.14f; 
	private int r;
	
	public Circle(int r) {
		this.r = r;
	}

	public void showPerimeter(){
		System.out.println("둘레: " + (this.r * 2 * PI));
	}
	
	public void showArea(){
		System.out.println("넓이: " + (this.r * this.r * PI));
	}

}
