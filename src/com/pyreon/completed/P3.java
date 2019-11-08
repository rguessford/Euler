package com.pyreon.completed;

import com.pyreon.util.Library;

import java.util.ArrayList;

/**
 * Largest prime factor
 *
 * Problem 3
 * The prime factors of 13195 are 5, 7, 13 and 29.
 *
 * What is the largest prime factor of the number 600851475143 ?
 */
public class P3 {
    public static void main(String[] args) {
        long num = 600851475143L;
        ArrayList<Long> factorization = Library.primeFactorization(num);
        System.out.println(factorization.get(factorization.size()-1));
    }
}
