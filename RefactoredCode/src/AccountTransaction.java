public class AccountTransaction {

	String date;
	String type;
	double amount;
	
	//Blank Constructor
	public AccountTransaction(){
		
	}
	
	//Constructor with Details
	public AccountTransaction(String date, String type, double amount){
		this.date = date;
		this.type = type;
		this.amount = amount;
	}
	
	
	//Getter Methods
	public String getDate() {
		return date;
	}


	public String getType() {
		return type;
	}


	public double getAmount() {
		return amount;
	}


	@Override
	public String toString() {
		return "AccountTransaction [date=" + date + 
				                 ", type=" + type + 
				                 ", amount=" + amount + "]";
	}
	
}
