package com.pyreon.completed;

import com.pyreon.util.Library;

import java.util.ArrayList;
import java.util.LinkedHashSet;

/**
 * Non-abundant sums
 *
 * Problem 23
 * A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
 *
 * A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.
 *
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum of two abundant numbers is 24. By mathematical analysis, it can be shown that all integers greater than 28123 can be written as the sum of two abundant numbers. However, this upper limit cannot be reduced any further by analysis even though it is known that the greatest number that cannot be expressed as the sum of two abundant numbers is less than this limit.
 *
 * Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
 */
public class P23 {
    public static void main(String[] args) {
        LinkedHashSet<Integer> abundants = new LinkedHashSet<>();
        for (int i = 1; i < 28124; i++) {
            if (Library.findProperDivisors(i).stream().reduce(0L,Long::sum) > i){
                abundants.add(i);
            }
        }
        ArrayList<Integer> abundantsums = new ArrayList<>();
        for (int i = 1; i < 28124; i++) {
            for (Integer abundant : abundants) {
                if(abundant>i){
                    break;
                } else {
                    if (abundants.contains(i-abundant)){
                        abundantsums.add(i);
                        break;
                    }
                }
            }

        }
        long accumulator = 0;
        for (int i = 1; i < 28124; i++) {
            if(!abundantsums.contains(i)){
                accumulator += i;
            }
        }
        System.out.println(accumulator);
    }
}
