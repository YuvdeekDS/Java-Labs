package lab10_exercise3;


import java.util.ArrayList;
import java.util.List;

public class Guest implements IGuest{
	
	private String forename;
	/**
	 * @return the forename
	 */
	public String getForename() {
		return forename;
	}



	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}



	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}



	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}



	/**
	 * @return the charges
	 */
	public List<Charge> getCharges() {
		return charges;
	}



	private String surname;
	private String address;
	private String telephone;
	private List<Charge> charges;
	
	public Guest(String fname,String sname,String add,String phNo) {
		// TODO Auto-generated constructor stub
		this.forename = fname;
		this.surname = sname;
		this.address = add;
		this.telephone = phNo;
		this.charges = new ArrayList<Charge>();
		
	}
	


	@Override
	public String toString() {
		return  (forename != null ? forename + " " : "")
				+ (surname != null ? surname + ", " : "")
				+ (address != null ? address + ", " : "")
				+ (telephone != null ? telephone : "");
	}

	@Override
	public double calculateTotalChargeWithoutVAT() {
		// TODO Auto-generated method stub
		double total =0;
		for (Charge charge : this.charges) {
		     total+=charge.getCharge(); 
		    }
		return total;
	}

	@Override
	public double calculateVATChargeAtRate(VATRate rate) {
		// TODO Auto-generated method stub
		double total =0;
		for (Charge charge : this.charges) {  
			total+= (charge.getCharge() * rate.getNumVal())/100;
		    }
		return total;
	}



	@Override
	public void addCharge(Service service, double charge) {
		// TODO Auto-generated method stub
		this.charges.add(new Charge(service, charge));
	}
}
