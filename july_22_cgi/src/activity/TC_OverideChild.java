package activity;

public class TC_OverideChild extends TC_Overide{

	@Override
	public void print() {
		// TODO Auto-generated method stub
		super.print();
		System.out.println("child class");
	}
	
	public static void main(String[] args) {
		TC_OverideChild obj= new TC_OverideChild();
		obj.print();
	}
	
}
