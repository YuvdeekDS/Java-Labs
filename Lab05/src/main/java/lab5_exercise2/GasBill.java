package lab5_exercise2;

public class GasBill {
	private String accountNumber;
	private double amount;
	private Customer customer;
	
	public GasBill(String acNo,double amt,Customer cust) {
		this.accountNumber = acNo.matches("([0-9]{4})-([0-9]{4})-([0-9]{4})") ? acNo : "Invalid Account";
		this.amount = amt;
		this.customer = cust;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public boolean checkAccountAccuracy() {
		return accountNumber.matches(".*\\d+.*");
	}
	
	public String getCustomer() {
		return customer.getName()+". "+customer.getSurname();
	}
	
	public String displayAccountDetails() {
		return "Gas Bill\n Account Number:"+accountNumber+"\n Customer:"+getCustomer()+"\n Amount due:"+displayAmountDue();
	}
	
	private String displayAmountDue() {
		return amount+"0";
	}
}
