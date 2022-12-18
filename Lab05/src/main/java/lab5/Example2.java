package lab5;

/**
 * A simple class used to demonstrate deficiencies in arrays.
 * 
 * @author Stella Kazamia
 * 
 */
public class Example2 {

	public static final int NUMBER_OF_LINES = 6;
	
	public static void main(String[] args) {
		// Add your code here
		for(int i=1;i<=NUMBER_OF_LINES;i++) {
		
		System.out.println(i+" "+ (i+2) +" "+(i+4)+" "+(i+6));
		}
	}
}
