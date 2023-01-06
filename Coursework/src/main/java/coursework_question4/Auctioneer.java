package coursework_question4;

import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;

public class Auctioneer extends Dealership{

	private Map<Seller,Integer> sales;
	private Seller topSeller;
	public Auctioneer(String name) {
		super(name);
		this.sales = new HashMap<Seller,Integer>();
	}
	public boolean checkExistence(Car car) {
		for(Map.Entry<Advert, Seller> entry: super.carsForSale.entrySet()) {
			if(entry.getKey().getCar().equals(car))
				return true;
		}
		return false;
	}
	public String displayUnsoldCars() {
		StringBuilder builder = new StringBuilder();
		builder.append("UNSOLD CARS:\n");
		if(!this.unsoldCars.isEmpty())
		for(Map.Entry<Advert, Seller> entry : super.unsoldCars.entrySet()) {
			Car car = entry.getKey().getCar();
			builder.append("Ad: "+car.displayCarSpecification()+"\n");
		}
		return builder.toString();
	}
	public String displaySoldCars() {
		StringBuilder builder  = new StringBuilder();
		builder.append("SOLD CARS:\n");
		for (Map.Entry<Advert, Buyer> entry : super.soldCars.entrySet()) {
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
		builder.append("** Auctioneer - "+super.name+"**\n");
		BufferedReader buffReader = null;
			String line="";
			try {
			buffReader = new BufferedReader(new FileReader("auction_statistics.txt"));
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
	
	private void saveInFile(int noOfSales,double percentageOfAutomatic,double percentageOfManual) {
		StringBuilder builder = new StringBuilder();
		builder.append("Total Auction Sales: "+noOfSales+"\n");
		builder.append("Automatic Cars: "+percentageOfAutomatic+"%\n");
		builder.append("Manual Cars: "+percentageOfManual+"%\n");
		builder.append("Top Seller: "+ topSeller.toString());
		try {
		      FileWriter filewrite=new FileWriter("auction_statistics.txt"); 
		       filewrite.write(builder.toString());
		       filewrite.close();
		      
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	

	private void updateStatistics(Seller seller) {
		int newValue =  sales.containsKey(seller) ? sales.get(seller) + 1 : 1;
		sales.put(seller, newValue);
		seller.setSales(newValue);
		Map.Entry<Seller, Integer> highSeller = null;
		for(Map.Entry<Seller, Integer> sale: sales.entrySet()) {
			if(highSeller == null || sale.getValue().compareTo(highSeller.getValue()) > 0)
				highSeller = sale;
		}
		this.topSeller = highSeller.getKey();
		double percentageOfAutomatic = 0; 
		double percentageOfManual = 0 ;
		for(Advert adv: super.soldCars.keySet()) {
			if(adv.getCar().getGearbox().equals(CarType.MANUAL)) {
				percentageOfManual++;
			}else {
				percentageOfAutomatic++;
			}
		}
		
		percentageOfAutomatic = (percentageOfAutomatic / soldCars.size() ) * 100;
		percentageOfManual = (percentageOfManual / soldCars.size() ) * 100;
		saveInFile(sales.get(seller),percentageOfAutomatic,percentageOfManual);
	}
	
	public void endSale(Advert adv) {
		if(adv==null) {
			throw new IllegalArgumentException();
		}else {	
			if(adv.getHighestOffer().getValue() >= adv.getCar().getPrice() && checkExistence(adv.getCar()))
			{ //confirm the bid by picking the highest offer amount which is also higher than or equal to reserved price of car
				super.soldCars.put(adv,adv.getHighestOffer().getBuyer());
				super.unsoldCars.remove(adv);
				
				updateStatistics((Seller) super.carsForSale.get(adv)); // user is converted to seller for update statistics
				
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
				super.carsForSale.put(adv, (Seller)user);
				super.unsoldCars.put(adv,(Seller) user);
			}
		}
		
	}
}
