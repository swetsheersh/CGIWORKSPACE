package com.cg.eis.exception;

public class EmployeeException extends Exception {

	@Override
	public String toString() {
		return "Invalid sallary input!! Below 3000 Not Allowed";
	}
	
}
