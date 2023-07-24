package lab2_5;

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

	@Override
	public int deposit(int amount, int balance) {
		// TODO Auto-generated method stub
		return super.deposit(amount, balance);
	}

	@Override
	public String generateAccNum() {
		// TODO Auto-generated method stub
		return super.generateAccNum();
	}
	
	
}
