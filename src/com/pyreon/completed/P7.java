package com.pyreon.completed;

import com.pyreon.util.Eratosthenes;

/**
 * 10001st prime
 *
 * Problem 7
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 *
 * What is the 10001st prime number?
 */
public class P7 {
    public static void main(String[] args) {
        Eratosthenes era = Eratosthenes.getInstance(5000000);
        long answer = 0;
        long current = 0;
        for (int i = 1; i < 10002; i++) {
            while(!era.isPrime(current))current++;
            System.out.printf("the %d prime is %d%n", i, current);
            if (i == 10001 && era.isPrime(current)) answer = current;
            current++;
        }
        System.out.println(answer);
    }
}
