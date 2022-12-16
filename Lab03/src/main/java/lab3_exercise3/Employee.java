package lab3_exercise3;

public class Employee {
	private int id=0;
	private String forename = null;
	private String surname = null;
	private AnnualSalary salary = new AnnualSalary();
	private Position companyPosition = new Position();
	
	public String displayEmployeeName() {
		return forename+" "+surname;
	}
	
	private boolean eligibleForBonus()  {
		return false;
	}
	
	public int getId() {
		return id;
	}
	public String getForename() {
		return forename;
	}
	public String getSurname() {
		return surname;
	}
	public double getSalary() {
		return salary.getSalary();
	}
	public String getPositionName() {
		return companyPosition.getRoleName();
	}
	public String getEligibility() {
		return salary.getSalary() > 40000 ? " eligible " : " not eligible ";
	}
	public String toString() {
		return surname+", "+forename +" ("+id+"): "+companyPosition.getRoleName()+ " at £"+salary.getSalary()+" (£"+salary.calculateTax()+" tax)"+" and is" + getEligibility() + "for bonus.";
	}
	public Employee(int id,String fname,String surname,AnnualSalary salary,Position companyPosition) {
		this.id= id;
		this.forename = fname;
		this.surname = surname;
		this.salary = salary;
		this.companyPosition = companyPosition;
	}
}
