package com.pyreon.completed;

import java.util.Arrays;

/**
 * Lexicographic permutations
 *
 * Problem 24
 * A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4. If all of the permutations are listed numerically or alphabetically, we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:
 *
 * 012   021   102   120   201   210
 *
 * What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 */
public class P24 {
    public static void main(String[] args) {
        int [] permutation = new int[] {0,1,2,3,4,5,6,7,8,9};
        int count = 1;
        int target = 1000000;
        while(count < target){

            int i = permutation.length - 1;
            while (permutation[i-1] >= permutation[i]){
                i -= 1;
            }

            int j = permutation.length;
            while(permutation[j - 1] <= permutation[i-1]){
                j-=1;
            }
            //swap the largest digit with the next largest digit
            int temp = permutation[i-1];
            permutation[i-1] = permutation[j-1];
            permutation[j-1] = temp;

            i++;
            j = permutation.length;
            while(i < j){
                temp = permutation[i-1];
                permutation[i-1] = permutation[j-1];
                permutation[j-1] = temp;
                i++;
                j--;
            }
            count++;
        }
        System.out.println(Arrays.toString(permutation));
    }
}
