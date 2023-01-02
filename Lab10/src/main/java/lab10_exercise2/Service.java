package lab10_exercise2;
import java.util.regex.Pattern;
public class Service {

	private String code;
	private String name;
	private VATRate rate;
	private double standardCharge;
	
	public Service(String code,String name,VATRate vat, double stdchrg) {
		
		if(code == null || name  == null)
			throw new NullPointerException();
		
		if(stdchrg < 0)
			throw new IllegalArgumentException();
		
		if(!Pattern.matches("[a-zA-z]{4}\\d+",code))
			throw new IllegalArgumentException();
		
		this.code = code;
		this.name= name;
		this.rate = vat;
		this.standardCharge = stdchrg;
		
	}
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the rate
	 */
	public VATRate getRate() {
		return rate;
	}

	/**
	 * @return the standardCharge
	 */
	public double getStandardCharge() {
		return standardCharge;
	}


}
