package com.pyreon;

import java.lang.reflect.Array;
import java.time.chrono.Era;
import java.util.ArrayList;
import java.util.HashMap;

public class Library {

    public static boolean isPalindrome (long palindromeToCheck){
        return isPalindrome(String.valueOf(palindromeToCheck));
    }

    public static boolean isPalindrome (String palindromeToCheck){
        for (int i = 0; i < palindromeToCheck.length(); i++) {
            if(palindromeToCheck.charAt(i) != palindromeToCheck.charAt(palindromeToCheck.length()-(i+1))) return false;
        }
        return true;
    }


    /**
     * @deprecated
     * use eratosthenes sieve instead.
     */
    @Deprecated
    public static boolean isPrime(long prime){
        if(prime == 0 || prime == 1) return false;
        if(prime == 2) return true;
        if(prime % 2 == 0) return false;
        for (long i = 0; i <= Math.ceil(Math.sqrt(prime)); i++) {
            if(i != 0 && i != 1 && prime % i == 0) return false;
        }
        return true;
    }

    public static ArrayList<Long> primeFactorization (long num){
        ArrayList<Long> factorization = new ArrayList<>();
        for(long i = 2; i <= num; i++){
            while( num % i == 0){
                factorization.add(i);
                num /= i;
            }
        }
        return factorization;
    }

    public static long countDivisors(long num){
        ArrayList<Long> primeFactorization = primeFactorization(num);
        HashMap<Long, Long> map = new HashMap<>();

        for(Long _num : primeFactorization){
            Long count = map.getOrDefault(_num, 0L);
            map.put(_num, count+1);
        }
        return map.values().stream().map(x -> x+1).reduce(1L, (acc, x) -> acc*x);
    }

    public static void main(String[] args) {
        System.out.println(countDivisors(76564125L));
    }
}
