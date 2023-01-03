package lab11_exercise3;

import java.util.Date;
import java.util.ArrayList;
public class ReadyMeal {
	
	private String name;
	private ProductType type;
	private Factory factory;
	private Date productionDate=null;
	private ArrayList<Iitem> items = new ArrayList<Iitem>();
	
	public ReadyMeal(String name,ProductType type,Factory factory) {
		this.productionDate= new Date();
		this.name = name;
		this.type = type;
		this.factory = factory;
	}

	public void addItem(Iitem biscuit) {
		items.add(biscuit);
	}
	
	public String printContent() {
		StringBuffer content = new StringBuffer();
		content.append(enumToTitleString(this.type));
		content.append(" ");
		content.append(this.name);
		content.append(" Ready Meal ");
		//double totalCookedWeight = items.stream().reduce(0.0d,(acc,ob)->ob.getTotalWeight(),Double::sum);
		double totalCookedWeight = 0.0;
		
		for(Iitem item: items) {
			totalCookedWeight += item.getTotalWeight();
		}
		content.append(totalCookedWeight+ " g\n");
		
		content.append("\n");
		content.append("Contents\n");
		//double totalCalories = items.stream().reduce(0.0d,(acc,ob)->ob.getTotalCalories(),Double::sum);
		
		double totalCalories = 0.0;
		
		for(Iitem item: items) {
			totalCalories += item.getTotalCalories();
		}
		content.append("Calories: "+totalCalories+"kcal\n");
		
		content.append("Meat (fat): ");
		
		//double totalFat = items.stream().reduce(0.0d,(acc,ob)->ob.getTotalFat(IngredientType.MEAT),Double::sum);
		
		double totalFat = 0.0;
		
		for (Iitem item: items) {
			totalFat += item.getTotalFat(IngredientType.MEAT);
		}
		content.append(totalFat+"g\n");
		
		content.append("Vegetable (sodium): ");
		//double totalSodium = items.stream().reduce(0.0d,(acc,ob)->ob.getTotalSodium(IngredientType.VEGETABLE),Double::sum);
		double totalSodium = 0.0;
		
		for(Iitem item: items) {
			totalSodium += item.getTotalSodium(IngredientType.VEGETABLE);
		}
		
		content.append(totalSodium+"g\n");
		
		content.append("\n");
		
		content.append(factory.getAddress());
		return content.toString();
	}
	
	public String getName() {
		return name;
	}
	
	public Factory getFactory() {
		return factory;
	}
	
	public ProductType getType() {
		return type;
	}
	
	private String enumToTitleString(ProductType type) {
		String enumString = type.toString();
		return enumString.substring(0,1) + enumString.substring(1).toLowerCase();
	}
}

