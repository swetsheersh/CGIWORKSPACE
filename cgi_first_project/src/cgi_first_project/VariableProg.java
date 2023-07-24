package cgi_first_project;

public class VariableProg {
	private double height;
	private double width;
	private double length;
	private static int boxId;
	public double volume() {
		return height*width*length;
	}
	
	public static void main(String[] args) {
		VariableProg obj= new VariableProg();
		obj.height=2.5;
		obj.width=5.5;
		obj.length=6.5;
		boxId= 525;
		System.out.println(obj.volume());
		System.out.println("box id is: "+boxId);
		
	}
}
