package lab2_5;

import java.util.Random;

public class AccountDetail {
	
	//parameters
	private String accNum;
    private Person accHolder;
    private int balance;
    //getters and setters
	public String getAccNum() {
		return accNum;
	}
	public void setAccNum(String accNum) {
		this.accNum = accNum;
	}
	public Person getAccHolder() {
		return accHolder;
	}
	public void setAccHolder(Person accHolder) {
		this.accHolder = accHolder;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	//default constructor
	public AccountDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	//Parameterized constructor
	public AccountDetail(String accNum ,Person accHolder, int balance) {
		super();
		this.accNum = accNum;
		this.accHolder = accHolder;
		this.balance = balance;
	}
	//tostring
	@Override
	public String toString() {
		return "AccountDetail [accNum=" + accNum + ", accHolder=" + accHolder + ", balance=" + balance + "]";
	}
    
   
}
