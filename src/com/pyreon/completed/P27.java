package com.pyreon.completed;

import com.pyreon.util.Eratosthenes;

/**
 * Quadratic primes
 *
 * Problem 27
 * Euler discovered the remarkable quadratic formula:
 *
 * n2+n+41
 * It turns out that the formula will produce 40 primes for the consecutive integer values 0≤n≤39. However, when n=40,402+40+41=40(40+1)+41 is divisible by 41, and certainly when n=41,412+41+41 is clearly divisible by 41.
 *
 * The incredible formula n2−79n+1601 was discovered, which produces 80 primes for the consecutive values 0≤n≤79. The product of the coefficients, −79 and 1601, is −126479.
 *
 * Considering quadratics of the form:
 *
 * n2+an+b, where |a|<1000 and |b|≤1000
 *
 * where |n| is the modulus/absolute value of n
 * e.g. |11|=11 and |−4|=4
 * Find the product of the coefficients, a and b, for the quadratic expression that produces the maximum number of primes for consecutive values of n, starting with n=0.
 */
public class P27 {
    public static void main(String[] args) {
        int longest = 0;
        int answer = 0;
        Eratosthenes era = Eratosthenes.getInstance(2100000);
        for (int a = -1000; a < 1001; a++) {
            for (int b = 0; b < 1001; b++) {
                if(!era.isPrime(b)){
                    continue;
                }
                int n = 0;
                while(true){
                    int numToTest = (n*n) + (a * n) + b;
                    if(numToTest < 0){
                        break;
                    }
                    if(era.isPrime(numToTest)){
                        n++;
                    } else break;

                }
                if (n > longest) {
                    longest = n;
                    answer = a * b;
                }
            }
        }
        System.out.println(answer);
    }
}
