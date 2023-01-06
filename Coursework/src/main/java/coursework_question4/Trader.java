package coursework_question4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
		for (Map.Entry<Advert, Seller> entry : super.carsForSale.entrySet()) {
			if (entry.getKey().getCar().equals(car))
				return true;
		}
		return false;
	}

	public String displaySoldCars() {
		StringBuilder builder = new StringBuilder();
		builder.append("SOLD CARS:\n");
		for (Map.Entry<Advert, Buyer> entry : super.soldCars.entrySet()) {
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

	public static void main(String[] args) {
		Dealership dealership = new Trader("AutoTrader");

	    Car car = new Car(1234, "Mazda 3", 20000, Condition.NEW, SaleType.FORSALE);
	    Car car2 = new Car(2345, "Toyota Corolla", 15000, Condition.NEW, SaleType.FORSALE);

	    Advert ad = new Advert(car);
	    Advert ad2 = new Advert(car2);

	    User user2 = new Buyer("Alice Wonderland", 50);
	    User seller = new Seller("Stella Kazamia");
	    User seller2 = new Seller("Adam Hills");

	    dealership.registerCar(ad, seller, "Blue", CarType.AUTOMATIC, CarBody.HATCHBACK, 5);
	    dealership.registerCar(ad2, seller2, "Red", CarType.MANUAL, CarBody.MICRO, 4);
	    System.out.println(dealership.placeOffer(ad2, user2, 250));
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

public String displayStatistics() {
	StringBuilder builder = new StringBuilder();
	builder.append("** Trader - "+super.name+"**\n");
	BufferedReader buffReader = null;
		String line="";
		try {
		buffReader = new BufferedReader(new FileReader("trade_statistics.txt"));
			line = buffReader.readLine();
			while (line != null) { //buffer reads the line until EOF reached
				builder.append(line); 
				
				line = buffReader.readLine();
				if(line!= null) {
					builder.append("\n");
				}
			}
		} catch (FileNotFoundException e) {
			//handle I/O Exception if File Not Found Exception arises
			e.printStackTrace();
		} catch (IOException e2) {
			// handle I/O exception while buffer reading the file
			e2.printStackTrace();
		}finally {
			// close the file buffer if exists
			if(buffReader != null) {
				try {
					buffReader.close();
				} catch (IOException e) {
					//handle if any exception arises while closing the buffer
					e.printStackTrace();
				}
			}
		}
	return builder.toString();
}


private void saveInFile(int noOfSale) {
	StringBuilder builder = new StringBuilder();
	builder.append("Total Sales: "+noOfSale+"\n");
	builder.append("All Sellers:\n");
	for(Seller seller:sellers) {
		builder.append("\t"+seller.toString());
		builder.append("\n");
	}
	
	try {
	      FileWriter filewrite=new FileWriter("trade_statistics.txt"); 
	       filewrite.write(builder.toString());
	       filewrite.close();
	      
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
}

private void updateStatistics(Seller currentSeller) {
	int salesCount=0;
	if(!sellers.contains(currentSeller))
	sellers.add(currentSeller);
	
	currentSeller.setSales(currentSeller.getSales()+1);
	for(Seller seller:sellers) {
		salesCount+= seller.getSales();
	}
	saveInFile(salesCount);
}

	public void endSale(Advert adv) {
		if (adv == null) {
			throw new IllegalArgumentException();
		} else {
			if (adv.getHighestOffer().getValue() >= adv.getCar().getPrice()) { // confirm the bid by picking the highest
																				// offer amount which is also higher
																				// than reserved price of car
				super.soldCars.put(adv,adv.getHighestOffer().getBuyer());
				updateStatistics((Seller) super.carsForSale.get(adv));
				super.unsoldCars.remove(adv);
			}
		}
	}

	public String displayUnsoldCars() {
		StringBuilder builder = new StringBuilder();
		builder.append("UNSOLD CARS:\n");
		if (!super.unsoldCars.isEmpty())
			for (Map.Entry<Advert, Seller> entry : super.unsoldCars.entrySet()) {
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
				super.carsForSale.put(adv,(Seller) user);
				super.unsoldCars.put(adv,(Seller) user);
			}
		}

	}
}
