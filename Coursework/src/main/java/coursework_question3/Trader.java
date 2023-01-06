package coursework_question3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Trader extends Dealership {

	private List<Seller> sellers;

	public Trader(String name) {
		super(name);
		this.sellers = new ArrayList<Seller>();
	}

	public boolean checkExistence(Car car) {
		for (Map.Entry<Advert, User> entry : super.carsForSale.entrySet()) {
			if (entry.getKey().getCar().equals(car))
				return true;
		}
		return false;
	}

	public String displaySoldCars() {
		StringBuilder builder = new StringBuilder();
		builder.append("SOLD CARS:\n");
		for (Map.Entry<Advert, User> entry : super.soldCars.entrySet()) {
			Advert adv = entry.getKey();
			Car car = adv.getCar();
			builder.append(car.getID() + " - ");
			Offer highestOffer = adv.getHighestOffer();
			String buyerName = highestOffer.getBuyer().toString();
			builder.append("Purchased by " + buyerName);
			builder.append(" with a successful £" + df.format(highestOffer.getValue()));
			builder.append(" bid.\n");
		}

		return builder.toString();
	}

	public String displayStatistics() {
		StringBuilder builder = new StringBuilder();
		builder.append("Statistics");

		return builder.toString();
	}

public boolean placeOffer(Advert adv, User user, double value) {
	if (user == null || adv == null || value < 0) {
		throw new IllegalArgumentException();
	} else {
		if (checkExistence(adv.getCar())) { // place offer only if the car is available for sale
			if (adv.placeOffer(user, value)) {
				
				if (value >= adv.getCar().getPrice()) { // If a successful offer is made on the car, then
					endSale(adv); // the car gets removed from the list of available cars by calling endSale method
					return true;
				}
				return false;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}

	public void endSale(Advert adv) {
		if (adv == null) {
			throw new IllegalArgumentException();
		} else {
			if (adv.getHighestOffer().getValue() >= adv.getCar().getPrice()) { // confirm the bid by picking the highest
																				// offer amount which is also higher
																				// than reserved price of car
				super.soldCars.put(adv, super.carsForSale.get(adv));
				super.unsoldCars.remove(adv);
			}
		}
	}

	public String displayUnsoldCars() {
		StringBuilder builder = new StringBuilder();
		builder.append("UNSOLD CARS:\n");
		if (!super.unsoldCars.isEmpty())
			for (Map.Entry<Advert, User> entry : super.unsoldCars.entrySet()) {
				Car car = entry.getKey().getCar();
				builder.append("Ad: " + car.displayCarSpecification() + "\n");
			}
		return builder.toString();
	}

	public void registerCar(Advert adv, User user, String colour, CarType type, CarBody body, int noOfSeats) {

		if (adv == null || user == null) {
			throw new IllegalArgumentException();
		} else {
			Car car = adv.getCar();
			car.setColour(colour);
			car.setGearbox(type);
			car.setBody(body);
			car.setNumberOfSeats(noOfSeats);
			if (!checkExistence(car)) { // register car if it is not already registered
				super.carsForSale.put(adv, user);
				super.unsoldCars.put(adv, user);
			}
		}

	}

}
