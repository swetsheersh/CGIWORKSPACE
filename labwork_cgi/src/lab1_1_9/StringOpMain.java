package lab1_1_9;

import java.util.Scanner;

public class StringOpMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringOp str=new StringOp();
		StringOpMethod method=new StringOpMethod();
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter String: ");
		str.setStr(scanner.nextLine());
		System.out.println("Enter Your Choice as per following operation: ");
		System.out.println("Enter 1 : Add the String to itself");
		System.out.println("Enter 2 : Replace odd positions with #\r\n"+ "");
		System.out.println("Enter 3 : Remove duplicate characters in the String");
		System.out.println("Enter 4 : Change odd characters to upper case");
		System.out.println("Enter 5 :Exit");
		int choice;
		choice=scanner.nextInt();
		switch(choice) {
		case 1:
			System.out.println(method.addItself(str.getStr()));
			break;
		case 2:
			System.out.println(method.oddpos(str.getStr()));
			break;
		case 3:
			System.out.println(method.removedup(str.getStr()));
			break;
		case 4:
			System.out.println(method.oddUpper(str.getStr()));
			break;
		case 5:
			System.out.println("Thank You...");
			break;
		default: 
			System.out.println("Thank You...");
		}
	}

}
