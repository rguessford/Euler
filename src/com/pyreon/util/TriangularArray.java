package com.pyreon.util;

public class TriangularArray {
    public int rows;

    private int [] array;

    public TriangularArray(int rows){
        this.rows = rows;
        array = new int[rows * (rows+1) / 2];
    }

    public int get(int rowIndex, int colIndex){
        return array[((rowIndex * (rowIndex+1)) / 2) + colIndex];
    }

    public void set(int rowIndex, int colIndex, int value){
        array[(rowIndex * (rowIndex+1)) / 2 + colIndex] = value;
    }

    public void fillWithSpaceDelimitedString(String numbers){
        String[] sNumbers = numbers.split(" ");
        if(sNumbers.length != array.length){
            System.err.println("incorrect number of values to fill triangular array");
        }
        for (int i = 0; i < sNumbers.length; i++) {
            array[i] = Integer.valueOf(sNumbers[i]);
        }
    }
}
