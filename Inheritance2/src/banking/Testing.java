package banking;

public class Testing {
	public BankAccount saving1 = new SavingsAccount(20 , 10);
	public SavingsAccount saving2 = new SavingsAccount(30, 40);
	public double balance = saving1.getBalance();
	public double balance2 = saving2.getBalance();
}
