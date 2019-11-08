package com.pyreon.completed;

import com.pyreon.util.Library;

import java.util.HashSet;

/**
 * Amicable numbers
 *
 * Problem 21
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
 * If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.
 *
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
 *
 * Evaluate the sum of all the amicable numbers under 10000.
 */
public class P21 {
    public static void main(String[] args) {
        HashSet<Long> amicables = new HashSet<>();
        for (long a = 2; a < 10000; a++) {
            Long b = Library.findProperDivisors(a).stream().reduce(0L,Long::sum);
            if(a != b && a == Library.findProperDivisors(b).stream().reduce(0L,Long::sum)){
                amicables.add(a);
                amicables.add(b);
            }
        }
        System.out.println(amicables.stream().reduce(Long::sum));
    }

}
