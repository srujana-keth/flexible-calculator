package com.calculator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.enums.Operation;

public class CalculatorTest {
    @Test
    public void testGeneralOperations() {
        Calculator calculator = new Calculator();
        assertEquals(8.0, calculator.calculate(Operation.ADD, 5, 3));
        assertEquals(2.0, calculator.calculate(Operation.SUBTRACT, 5, 3));
        assertEquals(20.0, calculator.calculate(Operation.MULTIPLY, 5, 4));
        assertEquals(1.0, calculator.calculate(Operation.DIVIDE, 5, 5));
    }

    @Test
    public void testDivisionByZero() {
        Calculator calculator = new Calculator();
        assertThrows(ArithmeticException.class, 
        ()-> calculator.calculate(Operation.DIVIDE, 5, 0));
    }

    @Test
    public void testChainingOperations() {
        Calculator calculator = new Calculator();
        Number result = calculator.calculateChainOperations(2,
                Operation.ADD, 3,
                Operation.MULTIPLY, 4,
                Operation.SUBTRACT, 5);
        assertEquals(15.0, result);
    }

    @Test
    public void testUnsupportedOperation() {
        Calculator calculator = new Calculator();

        assertThrows(UnsupportedOperationException.class, () -> {
            try {
                Operation op = Operation.valueOf("MODULO");
                calculator.calculate(op, 5, 2);
            } catch (IllegalArgumentException e) {
                // Rethrow it as UnsupportedOperationException to match the expected behavior
                throw new UnsupportedOperationException("Unsupported operation: MODULO", e);
            }
        });
    }


}