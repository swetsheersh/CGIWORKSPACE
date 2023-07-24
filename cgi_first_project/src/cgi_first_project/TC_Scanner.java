package cgi_first_project;

import java.util.Scanner;

public class TC_Scanner {
	//Main method
	public static void main(String[] args) {
		String name;
		Scanner scanner= new Scanner(System.in);
		System.out.println("Enter your name: ");
		name=scanner.nextLine();
		System.out.println("Your name is :"+name);
		System.out.println("Squre root of 49 is :"+ Math.sqrt(49));
	}
}
