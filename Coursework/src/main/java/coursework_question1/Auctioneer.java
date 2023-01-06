package coursework_question1;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Auctioneer {

	protected String name;
	protected Map<Advert,User> carsForSale,soldCars,unsoldCars;
	DecimalFormat df = new DecimalFormat("#.00");

	public Auctioneer(String name) {
		this.name = name;
		this.carsForSale = new HashMap<Advert,User>();
		this.soldCars = new HashMap<Advert,User>();
		this.unsoldCars = new HashMap<Advert,User>();
	}
	
	public boolean checkExistence(Car car) {
		for(Map.Entry<Advert, User> entry: carsForSale.entrySet()) {
			if(entry.getKey().getCar().equals(car))
				return true;
		}
		return false;
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
			if(!checkExistence(car)) {				
				carsForSale.put(adv, user);
				unsoldCars.put(adv, user);
			}
		}
		
	}
	
	public boolean placeOffer(Advert adv,User user,double value) {
		if(user == null ||  adv == null  || value < 0){
			throw new IllegalArgumentException();
		}else {
			if(checkExistence(adv.getCar())) {				
				return adv.placeOffer(user, value);
			}else {
				return false;
			}
		}
	}
	
	public void endSale(Advert adv) {
		if(adv==null) {
			throw new IllegalArgumentException();
		}else {	
			if(adv.getHighestOffer().getValue() >= adv.getCar().getPrice())
			{
				soldCars.put(adv, carsForSale.get(adv));
				unsoldCars.remove(adv);
			}
		}
	}
	
	public String displaySoldCars() {
		StringBuilder builder  = new StringBuilder();
		builder.append("SOLD CARS:\n");
		for (Map.Entry<Advert, User> entry : soldCars.entrySet()) {
			Advert adv = entry.getKey();
			Car car = adv.getCar();
		    builder.append(car.getId() + " - ");
		    Offer highestOffer = adv.getHighestOffer();
		    String buyerName = highestOffer.getBuyer().getName();
		    builder.append("Purchased by "+buyerName);
		    builder.append(" with a successful £"+df.format( car.getPrice() ) );
		    builder.append(" bid.\n");
		}
		
		return builder.toString();
	}
	
	public String displayStatistics() {
		StringBuilder builder = new StringBuilder();
		builder.append("Statistics");
		
		return builder.toString();
	}
	
	public String displayUnsoldCars() {
		StringBuilder builder = new StringBuilder();
		builder.append("UNSOLD CARS:\n");
		if(!unsoldCars.isEmpty())
		for(Map.Entry<Advert, User> entry : unsoldCars.entrySet()) {
			Car car = entry.getKey().getCar();
			builder.append("Ad: "+car.displayCarSpecification()+"\n");
		}
		return builder.toString();
	}
}
