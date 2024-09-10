package com.calculator;

import com.enums.Operation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        // User input
        System.out.println("Enter the first number: ");
        double num1 = getNumberInput(scanner);

        System.out.println("Enter the operation (ADD, SUBTRACT, MULTIPLY, DIVIDE): ");
        Operation operation = getOperationInput(scanner);

        System.out.println("Enter the second number: ");
        double num2 = getNumberInput(scanner);

        // Perform the calculation and display the result
        try {
            Number result = calculator.calculate(operation, num1, num2);
            System.out.println("The result is: " + result);
        } catch (UnsupportedOperationException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static double getNumberInput(Scanner scanner) {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please enter a valid number: ");
            }
        }
    }

    private static Operation getOperationInput(Scanner scanner) {
        while (true) {
            try {
                return Operation.valueOf(scanner.nextLine().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid operation. Please enter one of the following operations (ADD, SUBTRACT, MULTIPLY, DIVIDE): ");
            }
        }
    }
}