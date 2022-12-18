package lab5_exercise3;

public class Customer {
	private String name;
	private String surName;
	
	public Customer(String name,String surname) {
		this.name= name;
		this.surName =surname;
	}
	
	public char getName() {
		return name.charAt(0);
	}
	
	public String getSurname() {
		return surName;
	}
	
	public String toString() {
		return getName()+". "+getSurname();
	}
}
