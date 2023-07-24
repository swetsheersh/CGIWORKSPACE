package tcinterface;

public class TC_InterImpl implements TC_Interface {

	@Override
	public void show() {
		// TODO Auto-generated method stub
		System.out.println("show method");
		
	}
	
	@Override
	public void hi() {
		// TODO Auto-generated method stub
		TC_Interface.super.hi();
		System.out.println("hi i am from implemented class");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TC_InterImpl obj=new TC_InterImpl();
		obj.hi();
		obj.show();
		TC_Interface.print();
		

	}


}
