import java.util.ArrayList;

public class CustomerCurrentAccount extends CustomerAccount {
	
	ATMCard card;
	

	//Blank Constructor
	public CustomerCurrentAccount() {
	
	}


	//Constructor with Details
	public CustomerCurrentAccount(ATMCard card, String number, double balance, ArrayList<AccountTransaction> transactionList) {
	super(number, balance, transactionList);	
	this.card = card;
	}


	public ATMCard getCard() {
		return card;
	}
	
}