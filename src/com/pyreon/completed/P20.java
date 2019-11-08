package com.pyreon.completed;

import com.pyreon.util.Library;

import java.math.BigInteger;

/**
 * Factorial digit sum
 *
 * Problem 20
 * n! means n × (n − 1) × ... × 3 × 2 × 1
 *
 * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
 * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 *
 * Find the sum of the digits in the number 100!
 */
public class P20 {
    public static void main(String[] args) {
        BigInteger accumulator = BigInteger.ONE;
        for (int i = 1; i <= 100 ; i++) {
            accumulator = accumulator.multiply(BigInteger.valueOf(i));
        }
        System.out.println(Library.sumDigits(accumulator.toString()));
    }
}
