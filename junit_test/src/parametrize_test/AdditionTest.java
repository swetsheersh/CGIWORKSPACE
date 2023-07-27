package parametrize_test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

public class AdditionTest {

    public Addition add1;

    @BeforeEach
    public void setUp() {
        add1 = new Addition();
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
}

