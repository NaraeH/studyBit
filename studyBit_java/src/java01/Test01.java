package java01;

public class Test01 {

	   public static void main(String[] args){
		   
		      byte b1 = 3;
		      byte b2 = 4;
		      short sh = 2;
		      float  f = 30.0f;
		      double d = 40;
		      char ch = 'A';
		      String st = "자바63기";

		      System.out.println("1번: " +  (b1 + sh) );   // 1)번
		      System.out.println("2번: " +  b1 + sh);   // 2)번
		      System.out.println("3번: " +  (b1 + b2) );   // 3)번
		      System.out.println("4번: " +  b1 + b2 );   // 4)번
		      //System.out.println("5번: " + st - ch ) ;   // 5)번
		      //System.out.println("6번: " +  (st - ch) );   // 6)번
		      System.out.println("7번: " +  d + f );   // 7)번
		      
		      
		   }
		

}
