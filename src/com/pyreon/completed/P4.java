package com.pyreon.completed;

import static com.pyreon.util.Library.isPalindrome;

/**
 * Largest palindrome product
 *
 * Problem 4
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 *
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */
public class P4 {
    public static void main(String[] args) {
        long largest = 0;
        for (long i = 100; i < 999; i++) {
            for (long j = 100; j < 999 ; j++) {
                if(isPalindrome(i*j)) {
                    largest = Math.max(largest, i*j);
                    System.out.println(i*j);
                }
            }
        }
        System.out.printf("largest palindrome product : %d", largest);
    }

}
