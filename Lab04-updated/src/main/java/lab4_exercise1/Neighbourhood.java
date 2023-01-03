package lab4_exercise1;

//import java.util.ArrayList;
public class Neighbourhood {
	
//	private ArrayList<House> houses= new ArrayList<House>(3);
	private House[] houses;

	
	public Neighbourhood() {
		houses = new House[3];
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
	
	public static void main(String[] args) {
		Neighbourhood guildford = new Neighbourhood();
		guildford.setHouses(0, 1, 3);
		String testHouse = new House(1,3).toString();
		System.out.println(testHouse+ " -- "+guildford.getHouses(0).toString());
	}
}
