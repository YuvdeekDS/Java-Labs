/**
 * 
 */
package lab6_exercise3;

/**
 * @author LENOVO
 *
 */
public enum Countries {
  CANADA(1, false),
  CHINA(2,false),
  RUSSIA(3,true),
  BRITAIN(4,true),
  FRANCE(5, true);
  
  private int value;
  private boolean euStatus;

  Countries(int i, boolean b) {
	this.value = i;
	this.euStatus = b;
		// TODO Auto-generated constructor stub
	}

public String getName() {
	  return this.name();
  }

  public int getIndex() {
	  return this.value;
  }
  
  public int getArrayIndex() {
	  return this.value-1;
  }
  /**
   * Method to check whether the country belongs to EU or not.
   *
   * @return an array of the medals in the correct order.
    */
  public boolean isEU() {
	  return this.euStatus;
  }
  
  /**
  * Method to return the countries in the correct order.
  *
  * @return an array of the countries in the correct order.
   */
  public static Countries[] orderedCountries() {
	  // Use the index as an array index.
	  Countries[] output = new Countries[Countries.values().length];
	  for (Countries country : Countries.values()) {
	  output[country.getArrayIndex()] = country;
	  }
	  return output;
  }
}
