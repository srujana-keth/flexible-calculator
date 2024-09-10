package com.calculator.operations;

public class Difference implements GeneralOperations {
    @Override
    public Number calculateResult(Number a, Number b) {
        return a.doubleValue() - b.doubleValue();
    }
}
