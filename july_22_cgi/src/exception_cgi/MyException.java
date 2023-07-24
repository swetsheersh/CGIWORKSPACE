package exception_cgi;

public class MyException extends Exception {
	private int age;

	public MyException(int age) {
		super();
		this.age = age;
	}

	@Override
	public String toString() {
		return "sorry!! you are below 18";
	}
	
}
