/**
 * 
 */
package lab10_exercise2;

/**
 * @author LENOVO
 *
 */
public interface IGuest {
	
	public void addCharge(Service service,double charge);
	
	public double calculateTotalChargeWithoutVAT();
	
	public double calculateVATChargeAtRate(VATRate rate);
	
	public String toString();
}
