public class ATMCard {
 
	int pin;
	boolean valid;

	public ATMCard() {
	
	}
	
	public ATMCard(int pin, boolean valid)
	{
		this.pin = pin;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	@Override
	public String toString() {
		return "ATMCard [pin=" + pin + 
				  ", valid=" + valid + "]";
	}


}