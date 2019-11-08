package com.pyreon;

import com.pyreon.util.Library;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Digit fifth powers
 *
 * Problem 30
 * Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:
 *
 * 1634 = 14 + 64 + 34 + 44
 * 8208 = 84 + 24 + 04 + 84
 * 9474 = 94 + 44 + 74 + 44
 * As 1 = 14 is not a sum it is not included.
 *
 * The sum of these numbers is 1634 + 8208 + 9474 = 19316.
 *
 * Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
 */
public class P30 {
    public static void main(String[] args) {
        //9^5 = 59049
        //5*9^5 = 295245
        //295245 + 2^5 + 1 = 295278
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 2; i < 295278; i++) {
            if(i == Arrays.stream(Library.splitDigits(i)).reduce(0,(subtotal, x) -> Integer.sum(subtotal,(int) Math.pow(x,5)))){
                nums.add(i);
            }
        }
        System.out.println(nums.stream().reduce(0, Integer::sum));
    }
}
