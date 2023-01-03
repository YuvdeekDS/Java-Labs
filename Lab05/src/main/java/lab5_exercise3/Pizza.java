package lab5_exercise3;

import java.util.Arrays;

public class Pizza {
	private String[] toppings;

	@Override
	public String toString() {
		String topString = String.join(",", toppings);
		return topString;
	}
	public Pizza(){

	}
	public void addToppings(String[] toppings) {
		this.toppings = toppings;
	}

	public String printToppings() {
		String topString = String.join(",", toppings);
		return topString;
	}

	public double calculateCost() {
		double price=0;
		if(toppings==null) { return 0; };
		switch(toppings.length) {
		case 1:
		case 2:
		case 3:
		case 4:
			price = 8.99;
			//Add code here
			break;
		case 5:
			price = 9.99;
			//Add code here
			break;
		case 6:
			price = 10.99;
			//Add code here
			break;
		case 7:
			price = 11.99;
			//Add code here
			break;
		case 8:
			price = 12.99;
			break; 
		case 9:
			price = 13.99;
			break; 
		case 10:
			price = 14.99;
			break;
		default:
			price=0;
		}

		return price;
	}
}
