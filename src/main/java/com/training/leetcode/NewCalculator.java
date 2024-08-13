package com.training.leetcode;

/**
 * The Calculator class provides methods to perform basic arithmetic operations.
 */
public class NewCalculator {

    /**
     * Adds two integers.
     * 
     * @param a the first integer
     * @param b the second integer
     * @return the sum of a and b
     */
    public int add(int a, int b) {
        return a + b;
    }

    /**
     * Subtracts the second integer from the first integer.
     * 
     * @param a the first integer
     * @param b the second integer
     * @return the difference between a and b
     */
    public int subtract(int a, int b) {
        return a - b;
    }

    /**
     * Multiplies two integers.
     * 
     * @param a the first integer
     * @param b the second integer
     * @return the product of a and b
     */
    public int multiply(int a, int b) {
        return a * b;
    }

    /**
     * Divides the first integer by the second integer.
     * 
     * @param a the first integer
     * @param b the second integer
     * @return the quotient of a divided by b
     * @throws ArithmeticException if b is zero
     */
    public int divide(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return a / b;
    }
}

