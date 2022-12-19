package lab11_exercise2;

import java.util.ArrayList;

interface Iitem{
	void addIngredient(Ingredient ingrd);
	double getTotalCalories();
	double getTotalFat(IngredientType ingType);
	double getTotalSodium(IngredientType ingrd);
	double getTotalWeight();
}

public class Item implements Iitem{
	private ArrayList<Ingredient> itemIngredients = new ArrayList<Ingredient>();
	public Item() {
		// TODO Auto-generated constructor stub
	}
	
	public void addIngredient(Ingredient ingrd) {
		itemIngredients.add(ingrd);
	}
	
	
	public double getTotalCalories() {
		return itemIngredients.stream().reduce(0.0d,(acc,ob)->acc+ob.getCalories(),Double::sum);
	}
	
	public double getTotalFat(IngredientType ingType) {
		return itemIngredients.stream().reduce(0.0d,(acc,ob)->{
			if(ob.getType()==ingType) {
				return acc+ob.getFat();
				}else {
					return acc;
				}
			
		},Double::sum);
	}
	
	public  double getTotalSodium(IngredientType ingType) {
		return itemIngredients.stream().reduce(0.0d,(acc,ob)->{
			if(ob.getType()==ingType) {
				return acc+ob.getSodium();
				}else {
					return acc;
				}
		},Double::sum);
	}
	
	public double getTotalWeight() {
		return itemIngredients.stream().reduce(0.0d,(acc,ob)->acc+ob.getCookedWeight(),Double::sum);
	}
}
