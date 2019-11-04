package com.pyreon;

import java.math.BigInteger;

/**
 *Power digit sum
 *
 * Problem 16
 * 215 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 *
 * What is the sum of the digits of the number 2^1000?
 */
public class P16 {
    public static void main(String[] args) {
        BigInteger result = new BigInteger("2").pow(1000);
        System.out.println(Library.sumDigits(result.toString()));
    }
}
