import java.util.ArrayList;

public class CustomerDepositAccount extends CustomerAccount {
	
   double interestRate;


   //Blank Customer
   public CustomerDepositAccount() {
	
   }


   //Constructor with Details
   public CustomerDepositAccount(double interestRate, String number, double balance, ArrayList<AccountTransaction> transactionList) {
	super(number, balance, transactionList);	
	this.interestRate = interestRate;
   }
   
   public double getInterestRate() {
	return interestRate;
   }

}