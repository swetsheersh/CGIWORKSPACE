package com.example.springBootProj2.exception;

public class MyException extends Exception {

	@Override
	public String toString() {
		return "Player Already Exists";
	}
	
}
