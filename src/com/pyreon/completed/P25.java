package com.pyreon.completed;

import java.math.BigInteger;

/**
 * 1000-digit Fibonacci number
 *
 * Problem 25
 * The Fibonacci sequence is defined by the recurrence relation:
 *
 * Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.
 * Hence the first 12 terms will be:
 *
 * F1 = 1
 * F2 = 1
 * F3 = 2
 * F4 = 3
 * F5 = 5
 * F6 = 8
 * F7 = 13
 * F8 = 21
 * F9 = 34
 * F10 = 55
 * F11 = 89
 * F12 = 144
 * The 12th term, F12, is the first term to contain three digits.
 *
 * What is the index of the first term in the Fibonacci sequence to contain 1000 digits?
 */
public class P25 {
    public static void main(String[] args) {
        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ONE;
        float count = 2;
        while (a.toString().length() != 1000 || b.toString().length() != 1000){
            a = a.add(b);
            count++;
            b = b.add(a);
            count++;
            System.out.println(a);
            System.out.println(b);
        }
        if (a.toString().length() == 1000){
            System.out.println(count -1);
        } else {
            System.out.println(count);
        }
    }
}
