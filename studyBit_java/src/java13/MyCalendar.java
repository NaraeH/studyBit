package java13;

import java.util.Calendar;

public class MyCalendar {
	private int year;
	private int month;
	private int date;
	private MyCalendar calendar;
	
	Calendar myCalendar = Calendar.getInstance();
	
	public MyCalendar(){
		this.year = myCalendar.get(Calendar.YEAR);
		this.month = myCalendar.get(Calendar.MONTH)+1;
		this.date = myCalendar.get(Calendar.DATE);
	}
	
	public MyCalendar(int year, int month, int date) {
		this.year = year;
		this.month = month;
		this.date = date;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}
	
	public String getMyCalendar() {
		return calendar.getYear() + "-" + calendar.getMonth() + "-" + calendar.getDate();
	}
}
