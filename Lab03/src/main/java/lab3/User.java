package lab3;

public class User {
	private String name=null;
	private Email email=null;
	
	public User(String fullName,Email emailAddress) {
			this.name = fullName;
			this.email  = emailAddress;
	}
	
	public String toString() {
//		return "User [name="+this.name+", email="+this.email+"]";
		return this.name + " <" + this .email.getEmailAddress() + ">";
	}
}
