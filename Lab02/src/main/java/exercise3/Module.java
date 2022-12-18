/**
 * 
 */
package exercise3;


/**
 * @author LENOVO
 *
 */
public class Module {

	/**
	 * 
	 */
	public Module() {
		// TODO Auto-generated constructor stub
	}

	private Assessment assessment1;
	
	private Assessment assessment2;
	
	public double calculateAverage() {
		return (assessment1.getMark()*.2 + assessment2.getMark()*.8);
	}

	public Module(Assessment assessment1, Assessment assessment2) {
		super();
		this.assessment1 = assessment1;
		this.assessment2 = assessment2;
	}

	@Override
	public String toString() {
		return "COM1027 Average = " + this.calculateAverage() +"%"
                           + " ["+ assessment1.getName()+ "(20%) = "+ assessment1.getMark()+ "%" + " ," 
				           + assessment2.getName()+"(80%) = " + + assessment2.getMark() +"% ]";

	}

}


