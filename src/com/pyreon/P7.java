package com.pyreon;

/**
 * 10001st prime
 *
 * Problem 7
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 *
 * What is the 10 001st prime number?
 */
public class P7 {
    public static void main(String[] args) {
        long answer = 0;
        long current = 0;
        for (int i = 1; i < 10002; i++) {
            while(!isPrime(current))current++;
            System.out.printf("the %d prime is %d%n", i, current);
            if (i == 10001 && isPrime(current)) answer = current;
            current++;
        }
        System.out.println(answer);
    }

    public static boolean isPrime(long prime){
        if(prime == 0 || prime == 1) return false;
        if(prime == 2) return true;
        for (long i = 0; i <= Math.ceil(Math.sqrt(prime)); i++) {
            if(i != 0 && i != 1 && prime % i == 0) return false;
        }
        return true;
    }
}
