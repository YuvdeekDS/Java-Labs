package lab11_exercise2;

public class Supplier {

	private String name;
	private String phoneNumber;
	public Supplier(String name,String number) {
		// TODO Auto-generated constructor stub
		this.name= name;
		if((number.length() == 11 || number.length() == 8) && number.matches("[0-9]+"))
		this.phoneNumber = number;
		else
			throw new IllegalArgumentException("Phone Number should include code");
	}

	public String getName() {
		return name;
	}
	
	public String getPhone() {
		return phoneNumber;
	}
}

