import java.util.ArrayList; 

public class CustomerAccount  {
   
	String accountNumber;
	double balance;
	
	ArrayList<AccountTransaction> transactionList = new ArrayList<AccountTransaction>();

	//Blank Constructor
	public CustomerAccount() {
		
	}

	//Constructor with Details
	public CustomerAccount(String accountNumber, double balance, ArrayList<AccountTransaction> transactionList) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.transactionList = transactionList;
	}
	

	//Getter and Setter Methods
	public String getAccountNumber() {
		return accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public ArrayList<AccountTransaction> getTransactionList() {
		return transactionList;
	}

	
}