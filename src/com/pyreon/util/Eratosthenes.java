package com.pyreon.util;

import java.util.BitSet;

/**
 * Implementation of Eratosthene's sieve.
 *
 * Problem 10 originally took ~ 15 seconds to complete while brute forcing primes.
 * Implementing Eratosthenes' sieve brought execution time down to < 300 ms
 */
public class Eratosthenes{
    static Eratosthenes instance;
    int limit;
    BitSet sieve;

    public static Eratosthenes getInstance(int limit){
        if(instance == null){
            instance = new Eratosthenes(limit);
        } else if (limit > instance.limit){
            instance = new Eratosthenes(limit);
        }
        return instance;
    }

    //generate a lookup table for primes under Integer.MAX_VALUE*2
    private Eratosthenes(int limit){
        this.limit = limit;
        sieve = new BitSet(limit);
        sieve.set(1, limit);
        for (long i = 3; i < Math.round(Math.sqrt((long) limit *2)) ; i+=2) {
            if (sieve.get((int)(i-1)/2)){
                for (long j = i * i; j < (long) limit *2; j += i) {
                    if (j%2 == 0) continue;
                    sieve.clear((int) (j-1)/2);
                }
            }
        }
    }

    public boolean isPrime(long prime){
        if(prime == 2) return true;
        if(prime %2 == 0) return false;
        return sieve.get((int)(prime-1)/2);
    }
}