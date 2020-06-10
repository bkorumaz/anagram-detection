package com.bkorumaz;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        try {
            File file = new File("anagrams.txt");

            BufferedReader br = new BufferedReader(new FileReader(file));

            String line;
            line = br.readLine();
            List<String> items1 = Arrays.asList(line.split("\\s*,\\s*"));
            line = br.readLine();
            List<String> items2 = Arrays.asList(line.split("\\s*,\\s*"));

            System.out.println("first group of items" + items1.toString());
            System.out.println("second group of items" + items2.toString());
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }




    }
}
