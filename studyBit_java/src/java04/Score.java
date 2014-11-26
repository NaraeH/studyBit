package java04;

public class Score {
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int sum;
	private double avg;
	private String grade;
	
	public Score(String name, int kor, int eng, int math){
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;		
	}
	
	public String getName(){ return this.name; }
	public String getGrade(){ return this.grade; }
	
	public void sum(){
		this.sum = this.kor + this.eng + this.math;
	}
	
	public void avg(){
		avg = this.sum / 3;
	}
	
	public String grade(){
		
		if(avg >= 90){
			grade = "A";
		}else if(avg >= 80){
			grade = "B";
		}else{
			grade = "F";
		}
		return grade;
	}
}
