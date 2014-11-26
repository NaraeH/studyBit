package java01;

import java.util.Scanner;

public class Test02 {

	public static void main(String[] args) {
		
		int max = 0, mid = 0, min = 0;
		
		Scanner nums = new Scanner(System.in);
		
		System.out.println("비교할 숫자 3개를 입력하시오");	
		int num1 = nums.nextInt();
		int num2 = nums.nextInt();
		int num3 = nums.nextInt();
		
		nums.close();
		
		if((num1 > num2)&&(num1 > num3)){
			max = num1;
			if(num2> num3){
				mid = num2;
				min = num3;
			}else{
				mid = num3;
				min = num2;
			}
			
		}else if((num2 > num1) && (num2 > num3)){
			max = num2;
			if(num1> num3){
				mid = num1;
				min = num3;
			}else{
				mid = num3;
				min = num1;
			}
		}else if((num3 > num1)&&(num3 > num2)){
			max = num3;
			if(num1 > num2){
				mid = num1;
				min = num2;
			}else{
				mid = num2;
				min = num1;
			}
		}
		
		System.out.println("가장큰수: " + max);
		System.out.println("가장큰수: " + mid);
		System.out.println("가장큰수: " + min);
		
	}
}
