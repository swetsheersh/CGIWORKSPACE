package lab1_1_6;

public class PersonMain {

	public static void main(String[] args) {
		Person obj=new Person("Divya","Bharathi",'F');
		System.out.println("Person Details:");
		System.out.println("-----------------");
		System.out.println("First Name: "+obj.getFirstName());
		System.out.println("Last Name: "+obj.getLastName());
		System.out.println("Gender: "+obj.getGender());

	}

}
