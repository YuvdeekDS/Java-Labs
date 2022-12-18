package lab4;
/**
 * A simple class to introduce ArrayLists
 * 
 * @author Stella Kazamia
 * 
 */

 import java.util.ArrayList;

public class Example4 {

	// Add a field

	// Add a default constructor
	public ArrayList<String> namesList = new ArrayList<String>();
	
	public Example4() {

	}
	public void addNames() {
		// Initialise the array list
		namesList.add("Helen");
		namesList.add("Stella");
	}

	public String displayNames() {
		// Loop through the array list
		String names="";
		for (String name: namesList) {
			names += name ;
		
		}
		return names;
	}
}
