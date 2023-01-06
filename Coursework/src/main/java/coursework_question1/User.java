package coursework_question1;


public class User {
	private String fullname; 
	
	private String capitalizeFirstLetters(String fullname){
		String result = "";
		for(String word: fullname.split(" "))
			result += word.substring(0,1).toUpperCase()+word.substring(1) + " ";
		return result;
	}
	
	public User(String username) {
		if(username.split(" ").length < 2 || username ==null || username == capitalizeFirstLetters(username) )
		throw new IllegalArgumentException();
		else
		this.fullname = username;
	}

	public String getName() {
		return fullname.split(" ")[0];
	}
	
	public String toString() {
		return fullname;
	}
}
