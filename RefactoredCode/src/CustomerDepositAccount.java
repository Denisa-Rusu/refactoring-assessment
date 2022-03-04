import java.util.ArrayList;

public class CustomerDepositAccount extends CustomerAccount {
	
   double interestRate;


   public CustomerDepositAccount() {
	
   }


   public CustomerDepositAccount(double interestRate, String number, double balance, ArrayList<AccountTransaction> transactionList) {
	super(number, balance, transactionList);	
	this.interestRate = interestRate;
   }


   public double getInterestRate() {
	return interestRate;
   }


   public void setInterestRate(double interestRate) {
	this.interestRate = interestRate;
   }

}