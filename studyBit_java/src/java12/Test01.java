package java12;

import java.util.ArrayList;
import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> contents = new ArrayList<String>();
		String text;
		
		System.out.println("입력> ");
		while(true){
			text = scanner.nextLine();
			if(!text.equals("")){
				System.out.println("===>" + text);
				contents.add(text);
			}else{
				break;
			}
		}
		System.out.println(contents);
		scanner.close();
	}

}
