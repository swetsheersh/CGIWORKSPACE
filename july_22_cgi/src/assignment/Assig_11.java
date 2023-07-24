package assignment;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

public class Assig_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate date=LocalDate.of(1947,Month.AUGUST, 15);
		LocalDate currdate=LocalDate.now();
		LocalDate d1= currdate.minusDays(date.getDayOfMonth());
		LocalDate d2= d1.minusMonths(date.getMonthValue());
		LocalDate d3= d2.minusYears(date.getYear());
		
		System.out.println("Duration in years, months and days : "+d3);
	}

}
