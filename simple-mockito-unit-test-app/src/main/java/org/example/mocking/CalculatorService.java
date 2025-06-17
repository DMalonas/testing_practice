package org.example.mocking;


public class CalculatorService {

    private final MathHelper mathHelper;

    public CalculatorService(MathHelper mathHelper) {
        this.mathHelper = mathHelper;
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return mathHelper.multiply(a, b);
    }

    public double divide(int a, int b) {
        return mathHelper.divide(a, b);
    }
}