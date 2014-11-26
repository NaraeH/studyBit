
public class Test08 {

	public static void main(String[] args) {
		
		int[] arr = new int[3];
		
		
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 2;
		
		arr[2] = arr[2-1];
		arr[1] = arr[1-1];
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		
	}

}
