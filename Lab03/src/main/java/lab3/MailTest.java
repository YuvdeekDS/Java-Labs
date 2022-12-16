package lab3;

public class MailTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		MailSimple ms = new MailSimple("sender@surrey.ac.uk","recipient.surrey.ac.uk","Hello");
//		ms.print();
//		Email email = new Email("email@surrey.ac.uk");
//		System.out.println(email.getEmailAddress());
//	
//		System.out.println(email.setEmailAddress("test@surrey.ac.uk"));
//		User user = new User("Bugs Bunny",email);
//		System.out.println(user.toString());
		
		System.out.println();
		Email senderEmail = new Email("s.kazamia@surrey.ac.uk"); 
		User sender = new User("Stella Kazamia", senderEmail);
		Email recipientEmail = new Email("unknown@surrey.ac.uk"); User 
		recipient = new User("Unknown Unknown", recipientEmail);
		String message = "Hello, This is an example of complex objects.";
		Mail emptyEmail = new Mail(sender, recipient, ""); emptyEmail.print();
		System.out.println();
		Mail finalEmail = new Mail(sender, recipient, message); finalEmail.print();
	}

}
