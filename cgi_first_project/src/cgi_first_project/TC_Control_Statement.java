package cgi_first_project;

public class TC_Control_Statement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char grade='B';
		switch(grade) {
		case 'A': 
			System.out.println("Your grade is A , selected");
			break;
		case 'B':
			System.out.println("Your grade is B , Invited for next round");
			break;
		case 'C':
			System.out.println("your grade is c ,sorry not selected");
			break;
		default:
			System.out.println("Thanks");
		}
	}
}
		
	


