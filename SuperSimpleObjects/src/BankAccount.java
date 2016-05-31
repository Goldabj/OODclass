/**
 * 
 * 
 *
 * @author goldacbj.
 *         Created Dec 9, 2014.
 */
public class BankAccount {
	private double balance;
	
	/**
	 * 
	 * initialize the balance of the account
	 *
	 */
	public BankAccount() {
		this.balance = 0.0;
	}
	
	/**
	 * 
	 * initialized the balance of the account to be the initalBalance
	 *
	 * @param initialBalance
	 */
	public BankAccount(double initialBalance) {
		this.balance = initialBalance;
	}
	
	/**
	 * 
	 * returns the value of the balance
	 *
	 * @return
	 */
	public double getBalance() {
		return this.balance;
	}
	
	/**
	 * 
	 * adds amount of money to balance
	 *
	 * @param amount
	 */
	public void deposit(double amount) {
		this.balance += amount;
	}
	
	/**
	 * 
	 * subtracts amount of money from the balance
	 *
	 * @param amount
	 */
	public void withdraw(double amount) {
		this.balance -= amount;
	}
	
}
