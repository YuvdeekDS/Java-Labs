package lab6_exercise3;

public class MedalTable {

   private int[][] medals;
   private Countries custom;
   public MedalTable() {
	super();
	this.medals = new int[Countries.values().length+1][Medals.values().length+1];
   }
   
   public void addMedal(Countries country, Medals medal) {   
	 this.medals[country.getIndex()][medal.getIndex()] =  getMedals(country, medal) +1;
   }
   
   public int getMedals(Countries country, Medals medal) {
	   return this.medals[country.getIndex()][medal.getIndex()];
   }
   public int getEUMedalCount() {
	  
	   int count =0;

	  for(Countries country: Countries.orderedCountries()) {
		  if(country.isEU())
		  {
			  for(Medals medal: Medals.values()) {
				  count += getMedals(country, medal);
			  }
		  }
	  }
	   return count;
   }
}
