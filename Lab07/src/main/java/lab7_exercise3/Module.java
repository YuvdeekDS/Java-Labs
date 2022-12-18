package lab7_exercise3;

import java.util.regex.Pattern;

public class Module {

	private String name;
	
	public Module(String name) {
		super();
		this.name = name;
	}
	/*
	 * Returns the Modulename if it matches with Format  
	 * The name filed should only hold the module's code, for example COM1027 which consists of three capital letters followed by
	 *	4 numbers.
	 */
	
	public String getName() {
	    return Pattern.matches("[A-Z]{3}[0-9]{4}", this.name) ? this.name : "Error";
	   
	}
   
	
}
