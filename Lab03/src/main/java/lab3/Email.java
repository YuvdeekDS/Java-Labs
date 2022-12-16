package lab3;

public final class Email {
	private static final String  DEFAULT_ADDRESS = "unknown@unknown";
	private String emailAddress = DEFAULT_ADDRESS;
	
	public Email (String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public String getEmailAddress() {
		return this.emailAddress;
	}
	
	public String setEmailAddress(String newEmailAddress) {
		this.emailAddress = newEmailAddress;
		return this.emailAddress;
	}
}
