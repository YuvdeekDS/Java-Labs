package lab6_exercise3;

import static org.junit.Assert.assertEquals;

public class Check {

	public Check() {
		// TODO Auto-generated constructor stub
	}
  public static void main(String[] args) {
	
	  
	  MedalTable table = new MedalTable();
	  table.addMedal(Countries.BRITAIN, Medals.GOLD);
		table.addMedal(Countries.CHINA, Medals.GOLD);
		table.addMedal(Countries.FRANCE, Medals.SILVER);
		for(Countries country: Countries.orderedCountries()) {
		System.out.println(country.getName()+"--"+country.getIndex());
		}
		
}
}
