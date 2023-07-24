package lab2_2;

public class Savings extends AccountMethod {
	
	private final int minimumBalance=500;

	@Override
	public int withdraw(int amount, int balance) {
		// TODO Auto-generated method stub
		
		if (amount > 0 && balance - amount >= minimumBalance) {
            balance -= amount;
            return balance;
        }
        return balance;
	}
	
	
}
