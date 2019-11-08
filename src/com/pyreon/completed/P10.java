package com.pyreon.completed;

import com.pyreon.util.Eratosthenes;

/**
 * Summation of primes
 *
 * Problem 10
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 *
 * Find the sum of all the primes below two million.
 */
public class P10 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long accumulator = 0;
        Eratosthenes e = Eratosthenes.getInstance(2000000);
        for (int i = 0; i < 2000000; i++) {
            if(e.isPrime(i)) accumulator+=i;
        }
        long end = System.currentTimeMillis();
        System.out.println(accumulator + " " + (end - start));
    }
}
