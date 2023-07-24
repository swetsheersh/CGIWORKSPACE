package com.cgi.july_21;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TC_DateTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate date=LocalDate.now();
		System.out.println(date);
		LocalDate indep =LocalDate.of(1947,Month.AUGUST, 15);
		System.out.println(date.plusMonths(1));
		System.out.println(indep);
		System.out.println(date.minusWeeks(5));
		System.out.println(date.withDayOfMonth(25));
		
		ZonedDateTime zt=ZonedDateTime.now();
		System.out.println(zt);
		ZonedDateTime zt1=ZonedDateTime.now(ZoneId.of("Europe/Paris"));
		System.out.println(zt1);
	}

}
