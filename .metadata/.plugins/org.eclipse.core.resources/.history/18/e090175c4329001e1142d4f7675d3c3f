package junit_test.sampletest;



import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class JunitRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Result result=JUnitCore.runClasses(TestJunit.class);
		for(Failure fail: result.getFailures()) {
			System.out.println(fail.toString());
		}
		System.out.println("Result="+result.wasSuccessful());
	}

}
