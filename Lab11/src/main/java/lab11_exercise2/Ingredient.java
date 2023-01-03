package lab11_exercise2;

public class Ingredient {
	private String dishName;
	private IngredientType dishType;
	private Supplier supplier;
	private int rawWeight;
	private int calories;
	private double fat;
	private double sodium;
	
	public Ingredient(String dishName,IngredientType enumVal,Supplier suppl, int rawWeight,int calories,double fat,double sodium) {
		// TODO Auto-generated constructor stub
		this.dishName = dishName;
		this.dishType = enumVal;
		this.supplier = suppl;
		this.rawWeight = rawWeight;
		this.calories = calories;
		this.fat = fat;
		this.sodium =sodium;
	}

	public String getName() {
		return dishName;
	}
	
	public IngredientType getType() {
		return dishType;
	}
	
	public int getRawWeight() {
		return rawWeight;
	}
	
	public int getCalories() {
		return calories;
	}
	
	public double getFat() {
		return fat;
	}
	
	public double getSodium() {
		return sodium;
	}
	
	public Supplier getSupplier() {
		return supplier;
	}
	
	public double getCookedWeight() {
		return rawWeight*(80/100.0);
	}
}
