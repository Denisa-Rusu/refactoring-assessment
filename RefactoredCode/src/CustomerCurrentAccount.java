import java.util.ArrayList;

public class CustomerCurrentAccount extends CustomerAccount {
	
	ATMCard atm;
	

	//Blank Constructor
	public CustomerCurrentAccount() {
	
	}


	//Constructor with Details
	public CustomerCurrentAccount(ATMCard atm, String number, double balance, ArrayList<AccountTransaction> transactionList) {
	super(number, balance, transactionList);	
	this.atm = atm;
	}


	public ATMCard getAtm() {
		return atm;
	}


	public void setAtm(ATMCard atm) {
		this.atm = atm;
	}
	
}