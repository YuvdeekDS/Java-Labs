package lab11_exercise3;

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
		itemIngredients = new ArrayList<Ingredient>();
	}
	
	public void addIngredient(Ingredient ingrd) {
		itemIngredients.add(ingrd);
	}
	
	
	public double getTotalCalories() {
		
		double totalCalories = 0.0;
			
		for(Ingredient ingrd: itemIngredients ) {
			totalCalories += ingrd.getCalories();
		}
		return totalCalories;
	}
	
	public double getTotalFat(IngredientType ingType) {
		double totalFat=0.0;
		for (Ingredient ingrd: itemIngredients) {
			if(ingrd.getType() == ingType) {
				totalFat += ingrd.getFat();
			}
		}
		return totalFat;
	}
	
	public  double getTotalSodium(IngredientType ingType) {
		
		double totalSodium=0.0;
		for (Ingredient ingrd: itemIngredients) {
			if(ingrd.getType() == ingType) {
				totalSodium += ingrd.getSodium();
			}
		}
		return totalSodium;

	}
	
	public double getTotalWeight() {
		double cookedWeight=0.0;
		
		for (Ingredient ingrd: itemIngredients) {
				cookedWeight += ingrd.getCookedWeight();
		}
		return cookedWeight;
	}
}
