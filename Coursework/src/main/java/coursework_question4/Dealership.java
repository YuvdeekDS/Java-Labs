package coursework_question4;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public abstract class Dealership {

	protected String name;
	protected Map<Advert,Seller> carsForSale,unsoldCars;
	protected Map<Advert,Buyer> soldCars;
	DecimalFormat df = new DecimalFormat("#.00");

	public Dealership(String name) {
		this.name = name;
		this.carsForSale = new HashMap<Advert,Seller>();
		this.soldCars = new HashMap<Advert,Buyer>();
		this.unsoldCars = new HashMap<Advert,Seller>();
	}

	public abstract String displaySoldCars();
	
	public abstract String displayStatistics();
	
	public abstract String displayUnsoldCars();
	
	public abstract boolean placeOffer(Advert adv,User user,double value);

	
	public abstract void registerCar(Advert adv,User user,String colour,CarType type,CarBody body,int noOfSeats);

}