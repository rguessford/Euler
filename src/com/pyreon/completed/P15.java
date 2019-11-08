package com.pyreon.completed;

/**
 * Lattice paths
 *
 * Problem 15
 * Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.
 *
 *
 * How many such routes are there through a 20×20 grid?
 */
public class P15 {
    public static void main(String[] args) {
        long [][] grid = new long[21][21];
        for (int i = 0; i < 21; i++) {
            grid[20][i] = 1;
            grid[i][20] = 1;
        }

        for (int i = 19; i >= 0; i--) {
            for (int j = 19; j >= 0; j--) {
                grid[i][j] = grid[i+1][j] + grid[i][j+1];
            }
        }

        System.out.println(grid[0][0]);
    }
}
