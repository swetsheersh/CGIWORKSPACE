package lab2_5;

import java.util.Random;

public abstract class  AccountMethod {
	private final int MIN_BALANCE=500;
	public int deposit(int amount,int balance) {
        if (amount >= 0) {
            balance += amount;
            return balance;
        }
        return balance;
    }

    public int withdraw(int amount,int balance) {
        if (amount > 0 && balance - amount >= MIN_BALANCE) {
            balance -= amount;
            return balance;
        }
        return balance;
    }
  //account number 
  	public String generateAccNum() {
          Random random = new Random();
          return String.format("%09d", random.nextInt(1000000000));
     }
}
