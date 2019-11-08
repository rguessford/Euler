package com.pyreon.completed;

/**
 * Number spiral diagonals
 *
 * Problem 28
 * Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:
 *
 * 21 22 23 24 25
 * 20  7  8  9 10
 * 19  6  1  2 11
 * 18  5  4  3 12
 * 17 16 15 14 13
 *
 * It can be verified that the sum of the numbers on the diagonals is 101.
 *
 * What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?
 */
public class P28 {
    public static void main(String[] args) {
        int[][] arr = new int[1001][1001];
        int maxHbound = 1000;
        int minHbound = 0;
        int maxVbound = 999;
        int minVbound = 0;
        int vDirection = 0;
        int hDirection = -1;
        int x = 1000;
        int y = 1000;
        for (int i = 1002001; i > 0; i--) {
            arr[x][y] = i;
            x += hDirection;
            y += vDirection;
            if(hDirection == -1 && x == minHbound){
                    minHbound++;
                    hDirection = 0;
                    vDirection = -1;
            }
            if(hDirection == 1 && x == maxHbound){
                    maxHbound--;
                    hDirection = 0;
                    vDirection = 1;
            }
            if(vDirection == -1 && y == minVbound){
                minVbound++;
                hDirection = 1;
                vDirection = 0;
            }
            if(vDirection == 1 && y == maxVbound){
                maxVbound--;
                hDirection = -1;
                vDirection = 0;
            }
        }
        int accumulator = 0;
        for (int i = 0; i <= 1000; i++) {
            accumulator += arr[i][i];
        }
        for (int i = 1000; i >= 0; i--) {
            if(i==500) continue;
            accumulator += arr[1000-i][i];
        }

        System.out.println(accumulator);
    }
}
