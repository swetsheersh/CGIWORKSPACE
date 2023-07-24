package lab1_1_7_1_8;

public class Person {
	private String firstName;
	private String lastName;
	private char gender;
	private int phoneNumber;
	//geeter setter
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	//default constructor
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	//Parameterize  constructor
	public Person(String firstName, String lastName, char gender, int phoneNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
	}
	//tostring
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", phoneNumber="
				+ phoneNumber + "]";
	}
	
	

}
