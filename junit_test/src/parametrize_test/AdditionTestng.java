package parametrize_test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

public class AdditionTestng {
  @BeforeMethod
  public void beforeMethod() {
  }


  @Test
  public void addTest() {
    throw new RuntimeException("Test not implemented");
  }
  
  @Test(enabled=false)
  public void TestWithException()
  {  
  	System.out.println("Method should be ignored as it's not ready yet");
  }
}
