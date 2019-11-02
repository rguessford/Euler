package com.pyreon;

import java.time.chrono.Era;

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

    @Deprecated
    /**
     * @deprecated
     * use eratosthenes sieve instead.
     */
    public static boolean isPrime(long prime){
        if(prime == 0 || prime == 1) return false;
        if(prime == 2) return true;
        if(prime % 2 == 0) return false;
        for (long i = 0; i <= Math.ceil(Math.sqrt(prime)); i++) {
            if(i != 0 && i != 1 && prime % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
