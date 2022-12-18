/**
 * 
 */
package exercise2;



/**
 * @author LENOVO
 *
 */
public class Meal {

	private Food mainCourse;
	private Food dessert;
	
	@Override
	public String toString() {
		return "Meal [mainCourse = " + mainCourse + ", dessert = " + dessert + "]";
	}

	public Meal(Food mainCourse, Food dessert) {
		super();
		this.mainCourse = mainCourse;
		this.dessert = dessert;
	}

	/**
	 * 
	 */
	public Meal() {
		// TODO Auto-generated constructor stub
	}
	
	public double calculateTotalSugarLevel() {
		return mainCourse.getSugarLevel() + dessert.getSugarLevel();
		
	}
	public static void main(String[] args) {
		
		Meal meal = new Meal(new Food("Fish and Chips", 0.2), new Food("Apple Pie", 17));
		System.out.println("Meal [mainCourse = Fish and Chips, dessert = Apple Pie]");
		System.out.println(meal.toString());
	}
}
