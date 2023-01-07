package coursework_question1;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
public class Advert {
	
	private Car car;
	private List<Offer> offers;

	public Advert(Car car) {
		//accepts only objects of Car class
		if(car == null) {
		throw new IllegalArgumentException();	
		}else {
		this.car = car;
		this.offers = new ArrayList<Offer>();
		}
	}
	
	public boolean placeOffer(User buyer,double value) {
		//accepts only objects of User class and adds the offer to list 
		if(buyer == null) {
		throw new IllegalArgumentException();
		}else {			
			Offer newOffer = new Offer(buyer,value);
			return this.offers.add(newOffer);
		}
	}
	
	public Car getCar() {
		//returns the car of the Advert object
		return this.car;
	}
	
	public List<Offer> getOffers(){
		//returns list of offers
		return offers;
	}
	
	public Offer getHighestOffer() {
		//returns highest offer among the offers placed to the Advert.
		Offer highestOffer = offers.stream().max(Comparator.comparingDouble(Offer::getValue)).get();
		return highestOffer;
	}
}
