package com.pyreon;

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
        long largest = 0;
        long num = 600851475143L;
        for(long i = 2; i < num; i++){
            while( num % i == 0){
                System.out.println(num);
                num /= i;
            }
        }
        System.out.println(num);
    }
}
