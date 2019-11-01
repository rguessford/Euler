package com.pyreon;

import java.util.Arrays;

/**
 * Sum square difference
 *
 * Problem 6
 * The sum of the squares of the first ten natural numbers is,
 *
 * 12 + 22 + ... + 102 = 385
 * The square of the sum of the first ten natural numbers is,
 *
 * (1 + 2 + ... + 10)2 = 552 = 3025
 * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.
 *
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 */
public class P6 {
    public static void main(String[] args) {
        int[] firstHundred = new int[100];
        for (int i = 0; i < 100; i++) {
            firstHundred[i] = i+1;
        }
        int sumOfSquares = Arrays.stream(firstHundred).map(x -> (int)Math.round(Math.pow(x, 2))).reduce(0,Integer::sum);
        int squareOfSum = (int)Math.round(Math.pow(Arrays.stream(firstHundred).reduce(0, Integer::sum), 2));
        System.out.println(squareOfSum - sumOfSquares);
    }
}
