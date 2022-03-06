import java.util.ArrayList;

public class CustomerCurrentAccount extends CustomerAccount {
	
	ATMCard card;
	

	//Blank Constructor
	public CustomerCurrentAccount() {
	
	}


	//Constructor with Details
	public CustomerCurrentAccount(ATMCard card, String accountNumber, double balance, ArrayList<AccountTransaction> transactionList) {
	super(accountNumber, balance, transactionList);	
	this.card = card;
	}


	public ATMCard getCard() {
		return card;
	}
	
}