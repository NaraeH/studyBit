package java02;

public class Person {
	
	private String name;
	private String mId;
	
	public String getName() {
		return name;
	}

	public String getmId() {
		return mId;
	}

	public Person(String name){
		this.name = name;
		this.mId = "해당없음";
	}
	
	public Person(String name, String mId){
		this.name = name;
		this.mId = mId;
	}

}
