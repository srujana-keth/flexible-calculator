package com.calculator.operations;

public class Division implements GeneralOperations {
    @Override
    public Number calculateResult(Number a, Number b) {
        if (b.doubleValue() == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        } 
        return a.doubleValue() / b.doubleValue();
    }
}
