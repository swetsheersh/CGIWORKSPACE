package abstruct;

public class TC_AbsImpl extends TC_Abstruct {

	@Override
	public void show() {
		System.out.println("impleted method");
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TC_AbsImpl obj= new TC_AbsImpl();
		obj.show();
		obj.print();

	}

	

}
