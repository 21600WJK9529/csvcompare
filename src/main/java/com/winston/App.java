package com.winston;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App 
{
    public static void main(String[] args) {
        String fileName = "TestData.csv";//csv 1 in program file so it works without directory
        File file = new File(fileName);
        String fileName2 = "TestData2.csv";//csv 2 in program file so it works without directory
        File file2 = new File(fileName2);
        // this gives you a 2-dimensional array of strings
        List<List<String>> csv1 = new ArrayList<>();
        List<List<String>> csv2 = new ArrayList<>();
        Scanner inputStream;
        Scanner inputStream2;
        try {
            inputStream = new Scanner(file);
            inputStream2 = new Scanner(file2);
            int lineNo=1;
            while (inputStream.hasNext()) {
                String line = inputStream.next();
                String line2= inputStream2.next();
                if(line.equals(line2)==true){
                    System.out.println("Match for line "+lineNo);
                }else{
                    System.out.println("No match for line "+lineNo
                                        +"\nCompared: "+line+" with: "+line2);
                }
                String[] values = line.split(",");
                String[] values2 = line2.split(",");
                // this adds the currently parsed line to the 2-dimensional string array
                csv1.add(Arrays.asList(values));
                csv2.add(Arrays.asList(values2));
                lineNo++;
            }

            inputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
