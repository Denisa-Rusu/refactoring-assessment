import java.util.ArrayList; 

public class CustomerAccount  {
   
	String number;
	double balance;
	ArrayList<AccountTransaction> transactionList = new ArrayList<AccountTransaction>();

	//Blank Constructor
	public CustomerAccount() {
		
	}

	//Constructor with Details
	public CustomerAccount(String number, double balance, ArrayList<AccountTransaction> transactionList) {
		super();
		this.number = number;
		this.balance = balance;
		this.transactionList = transactionList;
	}
	

	//Getter and Setter Methods
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
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

	public void setTransactionList(ArrayList<AccountTransaction> transactionList) {
		this.transactionList = transactionList;
	}
	
}