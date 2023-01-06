package coursework_question3;

import java.util.HashMap;
import java.util.Map;

public class Auctioneer extends Dealership{

	private Map<Seller,Integer> sales;
	private Seller topSeller;
	public Auctioneer(String name) {
		super(name);
		this.sales = new HashMap<Seller,Integer>();
	}
	public boolean checkExistence(Car car) {
		for(Map.Entry<Advert, User> entry: super.carsForSale.entrySet()) {
			if(entry.getKey().getCar().equals(car))
				return true;
		}
		return false;
	}
	public String displayUnsoldCars() {
		StringBuilder builder = new StringBuilder();
		builder.append("UNSOLD CARS:\n");
		if(!this.unsoldCars.isEmpty())
		for(Map.Entry<Advert, User> entry : super.unsoldCars.entrySet()) {
			Car car = entry.getKey().getCar();
			builder.append("Ad: "+car.displayCarSpecification()+"\n");
		}
		return builder.toString();
	}
	public String displaySoldCars() {
		StringBuilder builder  = new StringBuilder();
		builder.append("SOLD CARS:\n");
		for (Map.Entry<Advert, User> entry : super.soldCars.entrySet()) {
			Advert adv = entry.getKey();
			Car car = adv.getCar();
		    builder.append(car.getID() + " - ");
		    Offer highestOffer = adv.getHighestOffer();
		    String buyerName = highestOffer.getBuyer().toString();
		    builder.append("Purchased by "+buyerName);
		    builder.append(" with a successful £"+df.format( highestOffer.getValue() ) );
		    builder.append(" bid.\n");
		}
		
		return builder.toString();
	}
	
	public String displayStatistics() {
		StringBuilder builder = new StringBuilder();
		builder.append("Statistics");
		
		return builder.toString();
	}
	
	public void endSale(Advert adv) {
		if(adv==null) {
			throw new IllegalArgumentException();
		}else {	
			if(adv.getHighestOffer().getValue() >= adv.getCar().getPrice() && checkExistence(adv.getCar()))
			{ //confirm the bid by picking the highest offer amount which is also higher than reserved price of car
				super.soldCars.put(adv, super.carsForSale.get(adv));
				super.unsoldCars.remove(adv);
			}
		}
	}
	
	public boolean placeOffer(Advert adv,User user,double value) {
		if(user == null ||  adv == null  || value < 0){
			throw new IllegalArgumentException();
		}else {
			if(checkExistence(adv.getCar())) {	// place offer only if the car is registered		
				return adv.placeOffer(user, value);
			}else {
				return false;
			}
		}
	}
	
public void registerCar(Advert adv,User user,String colour,CarType type,CarBody body,int noOfSeats) {
		
		if(adv == null || user == null) {
			throw new IllegalArgumentException();
		}else {			
			Car car  = adv.getCar();
			car.setColour(colour);
			car.setGearbox(type);
			car.setBody(body);
			car.setNumberOfSeats(noOfSeats);
			if(!checkExistence(car)) {	// register car if it is not already registered			
				super.carsForSale.put(adv, user);
				super.unsoldCars.put(adv, user);
			}
		}
		
	}

}
