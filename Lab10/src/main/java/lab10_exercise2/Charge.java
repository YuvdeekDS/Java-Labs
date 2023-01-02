package lab10_exercise2;

public class Charge {
	
	private Service service;
	private double Charge;
	public Charge(Service service,double charge) {
		// TODO Auto-generated constructor stub
		this.service = service;
		this.Charge =charge;
	}
	/**
	 * @return the service
	 */
	public Service getService() {
		return service;
	}

	/**
	 * @return the charge
	 */
	public double getCharge() {
		return Charge;
	}
	

	public double calculateVAT() {
		return (this.service.getRate().getNumVal() / 100) * this.Charge;
	}
}
