package lab1_1_7_1_8;

import java.util.Scanner;

public class PersonMain_1_8 {

	public static void main(String[] args) {
		String fName,lName;
		char gen;
		int pn;
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter First Name: ");
		fName=scanner.nextLine();
		System.out.println("Enter Last Name: ");
		lName=scanner.nextLine();
		do {
			System.out.println("Enter Gender Either M OR F:");
			gen=scanner.next().charAt(0);
			
			if(!((gen==Gen.M.toString().charAt(0)) || (gen==Gen.F.toString().charAt(0)))) {
				System.out.println("Invalid Input!! Try Again");
			}
		}while(!((gen==Gen.M.toString().charAt(0)) || (gen==Gen.F.toString().charAt(0))));
		System.out.println("Enter Pnone Number: ");
		pn=scanner.nextInt();
		
		Person obj=new Person(fName,lName,gen,pn);
		System.out.println("Person Details:");
		System.out.println("-----------------");
		System.out.println("First Name: "+obj.getFirstName());
		System.out.println("Last Name: "+obj.getLastName());
		System.out.println("Gender: "+obj.getGender());
		System.out.println("Phone Number: "+obj.getPhoneNumber());
		

	}

}
