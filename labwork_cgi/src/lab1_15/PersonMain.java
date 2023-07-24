package lab1_15;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class PersonMain  {
	
	//method
	public void calculateAge(LocalDate date) {
		LocalDate d1=LocalDate.now();
		d1=d1.minusDays(date.getDayOfMonth());
		d1=d1.minusMonths(date.getMonthValue());
		d1=d1.minusYears(date.getYear());
		System.out.println("You are "+d1.getYear()+
				" year "+d1.getMonthValue()+ " month "+ 
				d1.getDayOfMonth()+" days old" );
		
	}
	public String getFullName(String firstName, String lastName) {
		return firstName.concat(" ").concat(lastName);
	}
	
	public static void main(String[] args) {
		Person obj=new Person("Divya","Bharathi",'F');
		System.out.println("Person Details:");
		System.out.println("-----------------");
		System.out.println("First Name: "+obj.getFirstName());
		System.out.println("Last Name: "+obj.getLastName());
		System.out.println("Gender: "+obj.getGender());
		
		//Age calculate 
		
		Scanner scanner=new Scanner(System.in);
		String d;
		System.out.println("Enter your D.O.B in (dd-MM-yyyy) format: ");
		d=scanner.nextLine();
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate date=LocalDate.parse(d,formatter);
		PersonMain obj1=new PersonMain();
		obj1.calculateAge(date);
		
		//Full Name
		System.out.println("Full Name: "+obj1.getFullName(obj.getFirstName(), obj.getLastName()));
	}

}
