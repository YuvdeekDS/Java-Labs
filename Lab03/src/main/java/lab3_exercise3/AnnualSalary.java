package lab3_exercise3;

public class AnnualSalary {
	private double salary = 0;
	static final double PERSONAL_ALLOWANCE= 12500;
	static final double BASIC_RATE = 0.20;
	static final double HIGHER_RATE = 0.40;
	private double taxDeducted = 0;
	private static final double THRESHOLD = 50000.00;
	public double getSalary() {
		return salary;
	}
	
	public void setSalary(double sal) {
		this.salary = sal;
	}
	
	public double calculateTax() {
		 if (salary <= PERSONAL_ALLOWANCE) {
			 taxDeducted = 0.0;
		 } else if (salary <= THRESHOLD) {
			 	taxDeducted = (salary - PERSONAL_ALLOWANCE) * BASIC_RATE;
		 } else {
			 taxDeducted = (THRESHOLD - PERSONAL_ALLOWANCE) * BASIC_RATE + (salary - THRESHOLD) * HIGHER_RATE;
		 }

		 return taxDeducted;
	}
	
}


