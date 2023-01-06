package coursework_question3;

public class Seller extends User{

	public Seller(String name) {
		super(name);
	}


	@Override
	public String toString() {
		String sellername = super.toString();
		sellername = sellername.split(" ")[0]+" "+sellername.split(" ")[1].charAt(0) + ". ()";
		return sellername;
	}
}
