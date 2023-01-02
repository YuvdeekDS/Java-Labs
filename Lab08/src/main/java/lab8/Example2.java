package lab8;

/**
 * A simple class used to test out exceptions.
 * 
 * 
 * @author Stella Kazamia
 */
public class Example2 {

	/**
	 * Main entry point: this is the first method that is run.
	 * 
	 * @param args The command line arguments.
	 */
	public static void main(String[] args) {
		// Create a person object with an invalid age.
		try {
			Person person = new Person("joe", "bloggs", -1);
			System.out.println(person);	
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
	}
}
