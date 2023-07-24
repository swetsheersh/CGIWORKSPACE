//package parametrize_test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.Collections;
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.MethodSource;
//import org.junit.runner.RunWith;
//import org.junit.runners.Parameterized;
//import org.junit.runners.Parameterized.Parameter;
//import org.junit.runners.Parameterized.Parameters;
////@RunWith(Parameterized.class)
//public class AdditionTest {
//	public int a;
//	public int b;
//	public int expected;
//	public Addition add1;
//	
//	
//	public AdditionTest(int a, int b, int expected) {
//		super();
//		this.a = a;
//		this.b = b;
//		this.expected = expected;
//	}
//	
//	@BeforeEach
//	public void setUp() {
//		add1=new Addition();
//	}
//
//	@Parameterized.Parameters
//	public static Collection input() {
//		return Arrays.asList(new Object[][] {{1,2,3},{11,22,33},
//			{12,13,25},{25,10,40}});
//	}
//	@ParameterizedTest
//	@MethodSource("input")
//	public void addTest() {
//	    assertEquals(expected, add1.add(a, b));
//	}


//}
package parametrize_test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

public class AdditionTest {
	@Parameter(0)
    public int a;
	@Parameter(1)
    public int b;
	@Parameter(2)
    public int expected;
    public Addition add1;

    public AdditionTest(int a, int b, int expected) {
        this.a = a;
        this.b = b;
        this.expected = expected;
    }
    
   

	@BeforeEach
	public void setUp() {
		add1=new Addition();
	}

    @ParameterizedTest
    @MethodSource(value="input")
    public void addTest() {
        add1 = new Addition(); // Move this line inside the test method.
        assertEquals(expected, add1.add(a, b));
    }

    private static Collection<Object[]> input() {
        return Arrays.asList(new Object[][] {
                {1, 2, 3},
                {11, 22, 33},
                {12, 13, 25},
                {25, 10, 35}
        });
    }
}


