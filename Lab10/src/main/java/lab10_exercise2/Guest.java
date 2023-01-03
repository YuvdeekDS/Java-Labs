package lab10_exercise2;

import static org.junit.Assert.assertEquals;

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
		return "Guest [" + (forename != null ? "forename=" + forename + ", " : "")
				+ (surname != null ? "surname=" + surname + ", " : "")
				+ (address != null ? "address=" + address + ", " : "")
				+ (telephone != null ? "telephoneNumber=" + telephone : "") + "]";
	}

	@Override
	public double calculateTotalChargeWithoutVAT() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double calculateVATChargeAtRate(VATRate rate) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public void addCharge(Service service, double charge) {
		// TODO Auto-generated method stub
		this.charges.add(new Charge(service, charge));
	}
	
	public static void main(String[] args) {
		Guest guest = new Guest("Sid", "James", "12 North Lane, Guildford, Surrey", "01483 654321");

		Service service1 = new Service("ROOM1234", "Room", VATRate.STANDARD, 100);
		guest.addCharge(service1, 200);

		Service service2 = new Service("DRIN1234", "Drink", VATRate.LOW, 5);
		guest.addCharge(service2, 10);

		Service service3 = new Service("NEWS1234", "Newspaper", VATRate.ZERO, 1);
		guest.addCharge(service3, 1);

		assertEquals(3, guest.getCharges().size());
	}
}
