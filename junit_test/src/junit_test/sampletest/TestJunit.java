package junit_test.sampletest;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class TestJunit {
	private Convert obj;
	@Before
	public void setUp() {
		obj=new Convert();
		System.out.println("inside");
	}
	@Test
	public void con() {
		Scanner scanner=new Scanner(System.in);
		String str="hello56";//scanner.nextLine();
		assertEquals("hello56",str);
	}
	
	@Test
	public void conv() {
		//Arrange
		//Convert obj=new Convert();
		//Act
		String res=obj.upd("Hello", "World");
		//Assert
		assertEquals("HELLOWORLD",res );
	}
	@Test
	public void givenTwoStringShouldNotReturnNull() {
		//Arrange
		//Convert obj=new Convert();
		//Act
		String res=obj.upd("Hello", "World");
		//Assert
		assertNotNull(res);
	}
}
