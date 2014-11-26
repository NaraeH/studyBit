package java14_date;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MyDate {
	public static void main(String[] args) {
		Date date = new Date();
		String[] dates = date.toString().split(" ");
		
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar.getWeekYear());
		System.out.println(calendar.getTime());
		System.out.println(calendar.get(Calendar.YEAR));
		System.out.println(calendar.get(Calendar.MONTH)+1);
		System.out.println(calendar.get(Calendar.DATE));
		
		String test = "[hello]";
		
		System.out.println(test.replace("[", "").replace("]", ""));
		
		ArrayList<String> testList = new ArrayList<String>();
		testList.add("1");
		testList.add("2");
		System.out.println(testList);
		
	}

}
