package com.abubakirkarimov.calculator;

import com.abubakirkarimov.calculator.calculator.Calculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @Test
    void additionReturnsCorrectResult() {
        assertEquals(8, calculator.add(5, 3));
    }
    @Test
    void subtractionReturnsCorrectResult() {
        assertEquals(2, calculator.subtract(5, 3));
    }
    @Test

    void multiplicationReturnsCorrectResult() {
        assertEquals(15, calculator.multiply(5, 3));
    }
    @Test
    void divisionReturnsCorrectResult() {
        assertEquals(2, calculator.divide(6, 3));
    }
    @Test
    void divisionByZeroThrowsException() {
        assertThrows(ArithmeticException.class,
                () -> calculator.divide(10, 0)
        );
    }
}
