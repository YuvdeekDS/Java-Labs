package lab4_exercise1;
//import java.util.ArrayList;
public class Neighbourhood {
	
//	private ArrayList<House> houses= new ArrayList<House>(3);
	private House[] houses = new House[3];

	
	public Neighbourhood() {
		setHouses(0,3,4);
		setHouses(1,5,1);
		setHouses(2,7,2);
	}
	
	public int calculatetotal() {
		return 0;
	}
	
	
	public House getHouses(int index) {
		return houses[index];
	}
	
	public void setHouses(int index,int numberOfHouse,int numberOfBottles) {
		House hs = new House(numberOfHouse,numberOfBottles);
		houses[index]= hs;
	}
	
	public int calculateTotal() {
		int total=0;
		for(House house: houses) {
			total += house.getNumberBottles();
		}
		return total;
	}
	
	public String displayArray() {
		String dispString="";
		int total=0;
		for (House house: houses) {
			dispString+="Number of bottles in House number "+house.getNumberOfHouse()+" is "+house.getNumberBottles()+"\n";
			total+=house.getNumberBottles();
		}
		dispString+="Total number of bottles to be delivered: "+total;
		return dispString;
	}
}
