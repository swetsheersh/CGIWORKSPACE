package lab1_1_4_1_5;

import java.util.Scanner;

public class Assignment_1_5 {
	//main method
	public static void main(String[] args) {
		int num;
		//taking input
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter a Number: ");
		num=scanner.nextInt();
		if(num>0) {
			System.out.println(num+ " is positive");
		}else {
			System.out.println(num+ " is negative");
		}
	}
}
