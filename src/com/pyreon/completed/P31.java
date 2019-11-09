package com.pyreon.completed;

/**
 *In England the currency is made up of pound, £, and pence, p, and there are eight coins in general circulation:
 *
 * 1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
 * It is possible to make £2 in the following way:
 *
 * 1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
 * How many different ways can £2 be made using any number of coins?
 */
public class P31 {
    public static void main(String[] args) {
        int[] coins = new int[] {1,2,5,10,20,50,100,200};
        int[][] matrix = new int[coins.length+1][201];
        //one way to make no change
        matrix[0][0] = 1;
        //no ways to make any change with no coins
        for (int i = 1; i < matrix[0].length; i++) {
            matrix[0][i] = 0;
        }

        for (int i = 1; i <= coins.length; i++) {
            //one way to make no change for this row
            matrix[i][0] = 1;
            for (int amount = 1; amount <= 200; amount++) {
                int value = coins[i-1];
                int waysWithoutCoin = matrix[i-1][amount];
                int waysWithCoin = value <= amount ? matrix[i][amount - value] : 0;

                matrix[i][amount] = waysWithCoin + waysWithoutCoin;
            }
        }
        System.out.println(matrix[8][200]);
    }
}
