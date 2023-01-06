package coursework_question3;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public abstract class Dealership {

	protected String name;
	protected Map<Advert,User> carsForSale,soldCars,unsoldCars;
	DecimalFormat df = new DecimalFormat("#.00");

	public Dealership(String name) {
		this.name = name;
		this.carsForSale = new HashMap<Advert,User>();
		this.soldCars = new HashMap<Advert,User>();
		this.unsoldCars = new HashMap<Advert,User>();
	}

	public abstract String displaySoldCars();
	
	public abstract String displayStatistics();
	
	public abstract String displayUnsoldCars();
	
	public abstract boolean placeOffer(Advert adv,User user,double value);

	
	public abstract void registerCar(Advert adv,User user,String colour,CarType type,CarBody body,int noOfSeats);

}