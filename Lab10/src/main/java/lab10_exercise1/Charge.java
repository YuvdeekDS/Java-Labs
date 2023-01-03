package lab10_exercise1;

public class Charge {
	
	private Service service;
	private double charge;
	public Charge(Service service,double charge) {
		// TODO Auto-generated constructor stub
		this.service = service;
		this.charge =charge;
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
		return charge;
	}
	

	public double calculateVAT() {
		return (this.service.getRate().getNumVal() / 100) * this.charge;
	}
}
