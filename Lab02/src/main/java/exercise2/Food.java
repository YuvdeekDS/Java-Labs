/**
 * 
 */
package exercise2;

/**
 * @author LENOVO
 *
 */
public class Food {

	private String name;
	private double amountOfSugar;
	
	/**
	 * 
	 */
	public Food() {
		// TODO Auto-generated constructor stub
	}
   public String getName() {
	   return this.getName();
   }
   public double getSugarLevel() {
	   return this.amountOfSugar;
   }
public Food(String name, double amountOfSugar) {
	super();
	this.name = name;
	this.amountOfSugar = amountOfSugar;
}
@Override
public String toString() {
	return name;
}
}
