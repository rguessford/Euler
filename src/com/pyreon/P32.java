package com.pyreon;

import com.pyreon.util.Library;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Pandigital products
 *
 * Problem 32
 * We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once; for example, the 5-digit number, 15234, is 1 through 5 pandigital.
 *
 * The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing multiplicand, multiplier, and product is 1 through 9 pandigital.
 *
 * Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital.
 *
 * HINT: Some products can be obtained in more than one way so be sure to only include it once in your sum.
 */
public class P32 {
    public static void main(String[] args) {
        HashSet<Integer> products = new HashSet<>();
        for (int b = 1; b <= 9876; b++) {
            Integer[] allnums = new Integer[] {1,2,3,4,5,6,7,8,9};
            ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(allnums));
            boolean badnum = false;
            for(int num : Library.splitDigits(b)){
                if(nums.remove((Integer) num)) {
                    continue;
                } else {
                    badnum = true;
                    break;
                }
            }
            if(badnum) continue;

            for (int a = 1; a <= 987; a++) {
                ArrayList<Integer> remainingNums = new ArrayList<>(nums);
                badnum = false;
                for(int num : Library.splitDigits(a)){
                    if(remainingNums.remove((Integer) num)) {
                        continue;
                    } else {
                        badnum = true;
                        break;
                    }
                }
                if (badnum) continue;

                for(int num : Library.splitDigits(a * b)){
                    if(remainingNums.remove((Integer) num)) {
                        continue;
                    } else {
                        badnum = true;
                        break;
                    }
                }
                if (badnum) continue;
                if (remainingNums.size() > 0) continue;
                System.out.println(a + " * " + b + " = " + a*b);
                products.add(a*b);
            }
        }
        System.out.println(products.stream().reduce(0,Integer::sum));
    }
}
