package lab2_5;

public class Current extends AccountMethod {
	
	private int overdraftLimit;
	
	private final int MIN_BALANCE=500;

	public int getOverdraftLimit() {
		return overdraftLimit;
	}



	public void setOverdraftLimit(int overdraftLimit) {
		this.overdraftLimit = overdraftLimit;
	}



	@Override
	public int withdraw(int amount, int balance) {
		// TODO Auto-generated method stub
		if (amount > 0 && balance - amount >= MIN_BALANCE  && overdraftLimit>10) {
            balance -= amount;
            return balance;
        }
        return balance;
	}
	
		
}
