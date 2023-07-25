package lab1_1_6;

public class PersonMain {

	public static void main(String[] args) throws MyException {
		Person obj=new Person("","Bharathi",'F');
		try {
			if(obj.getFirstName()=="" || obj.getLastName()=="") {
				throw new MyException();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("Person Details:");
		System.out.println("-----------------");
		System.out.println("First Name: "+obj.getFirstName());
		System.out.println("Last Name: "+obj.getLastName());
		System.out.println("Gender: "+obj.getGender());

	}

}
