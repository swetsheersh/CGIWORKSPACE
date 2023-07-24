package exception_cgi;

import java.util.Scanner;

public class Emp {
	private int age;
	private String name;
	
	public void getDetails() throws MyException{
		Scanner scanner= new Scanner(System.in);
		System.out.println("Enter your age");
		this.age=scanner.nextInt();
		System.out.println("Enter your Name");
		name=scanner.nextLine();
		if(age<18) {
			throw new MyException(age);
		}
	}
}
