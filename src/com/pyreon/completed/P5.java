package com.pyreon.completed;

/**
 * Smallest multiple
 *
 * Problem 5
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 *
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */
public class P5 {
    public static void main(String[] args) {
        long ans = 0;
        for (int i = 0; ans == 0; i++) {
            for (int j = 1; j < 21 ; j++) {
                if(i%j==0){
                    if(j==20) ans = i;
                    continue;
                }
                break;
            }
        }
        System.out.println(ans);
    }
}
