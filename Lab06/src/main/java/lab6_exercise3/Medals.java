/**
 * 
 */
package lab6_exercise3;

/**
 * @author LENOVO
 *
 */
public enum Medals {
    BRONZE(0),
    SILVER(1),
    GOLD(2);

  private final int value;

  Medals(final int newValue) {
      value = newValue;
  }

  public String getName() {
	  return this.name();
  }

  public int getIndex() {
	  return this.value;
  }
  
  
  /**
  * Method to return the medals in the correct order for the table.
  *
  * @return an array of the medals in the correct order.
   */
  public static Medals[] orderedMedals() {
  // Use the index as an array index.
	  Medals[] medals = new Medals[Medals.values().length];
	  for (Medals medal : Medals.values()) {
	  medals[medal.getIndex()] = medal;
	  }
	  return medals;
  }
}
