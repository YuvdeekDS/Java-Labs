package coursework_question3;

public abstract class User {

	private String fullname;
	
	private String capitalizeFirstLetters(String fullname){
		String result = "";
		for(String word: fullname.split(" "))
			result += word.substring(0,1).toUpperCase()+word.substring(1) + " ";
		return result;
	}
	
	public User(String fullname) {
		if(fullname.split(" ").length < 2 || fullname ==null || fullname == capitalizeFirstLetters(fullname) )
			throw new IllegalArgumentException();
			else
			this.fullname = fullname;
	}
	
	public String getName() {
		return this.fullname.split(" ")[0];
	};
	

	@Override
	public String toString() {
		return this.fullname;
	};

}
