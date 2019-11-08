package com.pyreon.completed;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class P22 {
    public static void main(String[] args) {
        BufferedReader nameReader;
        try{
            nameReader = new BufferedReader( new FileReader(new File("src/res/p022_names.txt")));
            String[] names = nameReader.readLine().split(",");
            ArrayList <String> namelist = Arrays.stream(names).sorted().map(x -> x.replace("\"", "")).collect(Collectors.toCollection(ArrayList::new));
            long accumulatorTotal = 0;
            for (int i = 0; i < namelist.size(); i++) {
                long accumulatorNameScore = 0;
                String name = namelist.get(i);
                for (int j = 0; j < name.length(); j++) {
                    accumulatorNameScore += name.charAt(j) - '@';
                }
                accumulatorTotal += accumulatorNameScore * (i+1);
            }
            System.out.println(accumulatorTotal);
            nameReader.close();
        }catch (IOException e){
            System.err.println("oops");
        }

    }
}
