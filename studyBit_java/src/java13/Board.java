package java13;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Board {
	
	private String title;
	private ArrayList<String> contents;
	private String pwd;
	private MyCalendar calendar;

	public Board() {}
	
	public Board(String title, ArrayList<String> contents, String pwd) {
		this.title = title;
		this.contents = contents;
		this.pwd = pwd;
		this.calendar = new MyCalendar();
	}
	
	public Board(String title, String date, ArrayList<String> contents, String pwd){
		this.title = title;
		this.contents = contents;
	}
	
	public Board(String csv){
		String[] token = csv.split("  ");
		
		this.title = token[0];
		
		this.contents = new ArrayList<String>();
		String[] content = token[1].replace("[", "").replace("]", "").split(", ");
		
		for(String c:content){
			this.contents.add(c);
		}

		this.pwd = token[2];
		
		String[] calendarList = token[3].split("-");
		this.calendar = new MyCalendar(Integer.parseInt(calendarList[0]),
				Integer.parseInt(calendarList[1]),
				Integer.parseInt(calendarList[2]));
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ArrayList<String> getContents() {
		return contents;
	}

	public void setContents(ArrayList<String> content) {
		this.contents = content;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPasswd(String passwd) {
		this.pwd = passwd;
	}

	public String getCalendar() {
		return calendar.getYear() + "-" + calendar.getMonth() + "-" + calendar.getDate();
	}

	public void setDate(MyCalendar calendar) {
		this.calendar = calendar;
	}

}
