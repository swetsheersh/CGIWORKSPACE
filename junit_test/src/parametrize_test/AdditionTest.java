package parametrize_test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

public class AdditionTest {

    public Addition add1;
    @Before
    @BeforeEach
    public void setUp() {
        add1 = new Addition();
    }
    @Test()
    public void checkString() {
    	assertEquals("ggv",this.add1.add(10,Integer.parseInt("10") ));
    }
    @ParameterizedTest
    @MethodSource("input")
    public void addTest(int a, int b, int expected) {
        assertEquals(expected, add1.add(a, b));
    }

    private static Collection<Arguments> input() {
        return Arrays.asList(
            Arguments.of(1, 2, 3),
            Arguments.of(11, 22, 33),
            Arguments.of(12, 13, 25),
            Arguments.of(25, 10, 35)
        );
    }
    @Test(timeout = 1000)
    public void checkstr() throws InterruptedException {
    	Thread.sleep(5000);
    	assertEquals("25",this.add1.add(5, Integer.parseInt("25")));
    }
    @Test(expected = NumberFormatException.class)
    public void checkstr1() {
    	assertEquals("abc",this.add1.add(5,Integer.parseInt("ab")));
    }
    
}

