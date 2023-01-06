package coursework_question4;

public class Buyer extends User{

	private int age=0;
	public Buyer(String name,int age) {
		super(name);
		if(age < 18)
			throw new IllegalArgumentException();
		else
		this.age = age;
	}
	
	public int getAge() {
		return this.age;
	}
	
	@Override
	public String toString() {
		String firstname = this.getName();
		//firstname = firstname.replaceAll("(?<=.).(?=.)", "*");
		firstname = firstname.charAt(0)+"***"+firstname.charAt(firstname.length()-1);
		return firstname;
	}
}
