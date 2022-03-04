import java.util.ArrayList; 

public class Customer {

	String pps;
	String surname;
	String firstName;
	String dob;
	String customerID;
	String password;
	
	ArrayList<CustomerAccount> accounts = new ArrayList<CustomerAccount>();
	
	
	
	//Blank Constructor
	public Customer() {
		
	}
	

	//Constructor with Details
	public Customer(String pps, String surname, String firstName, String dob, String customerID, String password,
			ArrayList<CustomerAccount> accounts) {
		super();
		this.pps = pps;
		this.surname = surname;
		this.firstName = firstName;
		this.dob = dob;
		this.customerID = customerID;
		this.password = password;
		this.accounts = accounts;
	}



	//Getter Methods
	public String getPps() {
		return pps;
	}


	public String getSurname() {
		return surname;
	}


	public String getFirstName() {
		return firstName;
	}


	public String getDob() {
		return dob;
	}


	public String getCustomerID() {
		return customerID;
	}


	public String getPassword() {
		return password;
	}

	
	public ArrayList<CustomerAccount> getAccounts() {
		return accounts;
	}


	@Override
	public String toString() {
		return "Customer [pps=" + pps + 
			   ", surname=" + surname + 
			   ", firstName=" + firstName + 
			   ", dob=" + dob + 
			   ", customerID=" + customerID + 
			   ", password=" + password +
			   ", accounts=" + accounts + "]";
	}

}