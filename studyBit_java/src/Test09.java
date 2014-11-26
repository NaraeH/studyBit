import java.util.ArrayList;


public class Test09 {

	public static void main(String[] args) {
		ArrayList arr = new ArrayList();
		
		String str = new String("z");
		
		arr.add("0000000");
		
		//arr.add(1, "11111111");
		arr.add(2, "222222");
		//arr.set(2, "222222");
		
		for(int i = 0; i<arr.size(); i++){
			System.out.println(i + " => " + arr.get(i));
		}
		
		
		System.out.println("---------------------");
		arr.remove(1);
		
		for(int i = 0; i<arr.size(); i++){
			System.out.println(i + " => " + arr.get(i));
		}
		
		
		System.out.println(arr.get(2));

	}

}
