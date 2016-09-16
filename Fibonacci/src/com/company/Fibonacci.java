package com.company;

/**
 * Created by rgadbois on 9/15/16.
 * Fibonacci number is sum of previous two Fibonacci numbers fn= fn-1+ fn-2 * first 10 Fibonacci numbers are 1, 1, 2, 3, 5, 8, 13, 21, 34, 55
 */
public class Fibonacci {

    public int recursion(int number) {

        if ((number == 1) || (number == 2)) {
            return 1;
        }
        return recursion(number - 1) + recursion(number-2); // tail recursion
    }

    public int interation(int number) {
        if ((number == 1) || (number == 2)) {
            return 1;
        }
        int value1=1, value2=1, fib=1;
        for (int i = 3; i <= number; i++) {
            fib = value1 + value2;
            value1 = value2;
            value2 = fib;
        }
        return fib;
    }

}
