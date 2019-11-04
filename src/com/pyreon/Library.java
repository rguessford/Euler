package com.pyreon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

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

    public static int sumDigits(String number){
        int accumulator = 0;
        for (int i = 0; i < number.length(); i++) {
            accumulator += Character.getNumericValue(number.charAt(i));
        }
        return accumulator;
    }

    public static String asWord(int num){
        HashMap<Integer,String> dictionary = new HashMap<>();
        dictionary.put(0,"");
        dictionary.put(1,"one");
        dictionary.put(2,"two");
        dictionary.put(3,"three");
        dictionary.put(4,"four");
        dictionary.put(5,"five");
        dictionary.put(6,"six");
        dictionary.put(7,"seven");
        dictionary.put(8,"eight");
        dictionary.put(9,"nine");
        dictionary.put(10,"ten");
        dictionary.put(11,"eleven");
        dictionary.put(12,"twelve");
        dictionary.put(13,"thirteen");
        dictionary.put(14,"fourteen");
        dictionary.put(15,"fifteen");
        dictionary.put(16,"sixteen");
        dictionary.put(17,"seventeen");
        dictionary.put(18,"eighteen");
        dictionary.put(19,"nineteen");
        dictionary.put(20,"twenty");
        dictionary.put(30,"thirty");
        dictionary.put(40,"forty");
        dictionary.put(50,"fifty");
        dictionary.put(60,"sixty");
        dictionary.put(70,"seventy");
        dictionary.put(80,"eighty");
        dictionary.put(90,"ninety");
        dictionary.put(100,"hundred");
        dictionary.put(1000,"thousand");
        StringBuilder res = new StringBuilder("");
        boolean noAnd = false;
        if(num%100 == 0) noAnd = true;
        if(num % 100 > 9 && num % 100 < 20){
            res.insert(0, dictionary.get(num % 100));
            num = num/100;
        } else{
            res.insert(0,dictionary.get(num%10));
            num = num/10;

            if (num % 10 != 0)
                res.insert(0,dictionary.get((num%10)*10)+" ");
            num = num/10;
        }
        if(num%10 != 0){
            if (noAnd) {
                res.insert(0, " hundred");
            } else res.insert(0, " hundred and ");
            res.insert(0,dictionary.get(num%10));
        }
        num = num / 10;
        if(num%10 != 0){
            res.insert(0, " thousand");
            res.insert(0,dictionary.get(num%10));
        }
        return res.toString();
    }

    public static HashSet<Long> findProperDivisors(long num) {
        ArrayList<Long> factorization = primeFactorization(num);
        HashSet<Long> divisors = new HashSet<>();
        divisors.add(1L);
        long combinations = Math.round(Math.pow(2, factorization.size()));
        for (int i = 1; i < combinations; i++) {
            int index=0;
            long divisor = 1;
            for(int j=i; j > 0; j = j>>1, index++){
                if((j & 1) == 1){
                    divisor *= factorization.get(index);
                }
            }
            divisors.add(divisor);
        }
        divisors.remove(num);
        return divisors;
    }

    public static void main(String[] args) {
        System.out.println(findProperDivisors(1000));
    }
}
