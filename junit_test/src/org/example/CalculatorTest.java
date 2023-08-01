package org.example;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeClass
    public void setUp() {
        calculator = new Calculator();
        System.out.println("Setting up Calculator instance...");
    }

    @AfterClass
    public void tearDown() {
        System.out.println("Cleaning up...");
    }

    @Test
    public void testAddition() {
        int result = calculator.add(5, 3);
        Assert.assertEquals(result, 8, "Addition is incorrect!");
    }

    @Test
    public void testSubtraction() {
        int result = calculator.subtract(5, 3);
        Assert.assertEquals(result, 2, "Subtraction is incorrect!");
    }

    @Test
    public void testMultiplication() {
        int result = calculator.multiply(5, 3);
        Assert.assertEquals(result, 15, "Multiplication is incorrect!");
    }

    @Test
    public void testDivision() {
        int result = calculator.divide(6, 3);
        Assert.assertEquals(result, 2, "Division is incorrect!");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testDivisionByZero() {
        calculator.divide(10, 0);
    }
    
    
}
