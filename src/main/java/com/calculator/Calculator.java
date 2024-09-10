package com.calculator;

import java.util.HashMap;
import java.util.Map;

import com.calculator.operations.*;
import com.enums.Operation;

class Calculator {
    Map<Operation, GeneralOperations> operations= new HashMap<>();
    public Calculator() {
        operations.put(Operation.ADD, new Sum());
        operations.put(Operation.SUBTRACT, new Difference());
        operations.put(Operation.MULTIPLY, new Product());
        operations.put(Operation.DIVIDE, new Division());
    }

    public void addnewOperation(Operation op, GeneralOperations type) {
        operations.put(op, type);
    }
    public Number calculate(Operation op, Number a, Number b) {
        GeneralOperations type = operations.get(op);
        if (type == null) {
            throw new UnsupportedOperationException("Unsupported operation: " + op);
        }
        return type.calculateResult(a.doubleValue(), b.doubleValue());
    } 

    public Number calculateChainOperations(Number first, Object... chainOperationsNumbers) {
        Number result = first;
        for(int i=0;i<chainOperationsNumbers.length;i=i+2) {
            Operation op = (Operation) chainOperationsNumbers[i];
            Number value = (Number) chainOperationsNumbers[i+1];
            result = calculate(op, result, value);
        }
        return result;
    }

}