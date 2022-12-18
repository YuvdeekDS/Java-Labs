package lab5_exercise3;
import java.util.List;
import java.util.ArrayList;
public class Order {

	private List<Pizza> pizzas= new ArrayList<Pizza>();
	private Customer customer;
	
	public Order(Customer cust) {
		this.customer = cust;

	}
	public void addPizza(Pizza pizza) {
	pizzas.add(pizza);
	}
		
	public double calculateTotal(){
		double totalCost=0;
		for(Pizza pizza:pizzas) {
			totalCost+=pizza.calculateCost();
		}
		
		return totalCost;
	}
	
	public String printReceipt() {
		return "Customer: "+customer.toString()+"\n"+"Number of Pizzas: "+pizzas.size()+"\n"+"Total Cost: "+calculateTotal();
	}
}
