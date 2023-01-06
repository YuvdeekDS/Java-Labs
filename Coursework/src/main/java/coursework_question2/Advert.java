package coursework_question2;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
public class Advert {
	
	private Car car;
	private List<Offer> offers;

	public Advert(Car car) {
		this.car = car;
		this.offers = new ArrayList<Offer>();
	}
	
	public boolean placeOffer(User buyer,double value) {
		Offer newOffer = new Offer(buyer, value);
		return this.offers.add(newOffer);
	}
	
	public Car getCar() {
		return this.car;
	}
	
	public List<Offer> getOffers(){
		return offers;
	}
	
	public Offer getHighestOffer() {
		Offer highestOffer = offers.stream().max(Comparator.comparingDouble(Offer::getValue)).get();
		return highestOffer;
	}
}
