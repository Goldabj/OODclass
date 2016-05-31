package simpleExample;

public class BankAccount implements Measurable{
	
	private double balance;
	
	public BankAccount() {
		this.balance = 0;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public double getMeasure() {
		return this.balance;
	}
}
