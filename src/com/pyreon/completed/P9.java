package com.pyreon.completed;

/**
 * Special Pythagorean triplet
 *
 * Problem 9
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 *
 * a2 + b2 = c2
 * For example, 32 + 42 = 9 + 16 = 25 = 52.
 *
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 */
public class P9 {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = 997;
        while(Math.round(Math.pow(a, 2) + Math.pow(b, 2)) != Math.round(Math.pow(c, 2))){
            if(c > b){
                c--;
                b++;
            } else {
                a++;
                b = a + 1;
                c = 1000 - a - b;
            }
        }
        System.out.println(a*b*c);
    }
}
