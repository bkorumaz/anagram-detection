package com.bkorumaz;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        try {
            File file = new File("anagrams.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));

            String line1 = br.readLine();
            List<String> strings1 = Stream.of(line1.split(","))
                    .map (elem -> new String(elem))
                    .collect(Collectors.toList());

            String line2 = br.readLine();
            List<String> strings2 = Stream.of(line2.split(","))
                    .map (elem -> new String(elem))
                    .collect(Collectors.toList());
            br.close();

            System.out.println("first group of items " + strings1.toString());
            System.out.println("second group of items " + strings2.toString());

            int lengthOfFirstArray=strings1.size();
            int lengthOfSecondArray=strings2.size();

            if(lengthOfFirstArray!=lengthOfSecondArray){
                System.out.println("different number of items. check the file!");
            } else {
                String result = compareItems(strings1, strings2).toString();
                System.out.println(result);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static List<String> compareItems(List<String> ar1, List<String> ar2){
        List<String> results = new ArrayList<>();
        for(int i=0; i<ar1.size(); i++){
            if(checkAnagram(ar1.get(i),ar2.get(i))){
                results.add("Evet");
            } else {
                results.add("Hayir");
            }
        }
        return results;
    }

    private static boolean checkAnagram(String first, String second) {
        int lengthDifference = Math.abs(first.length() - second.length());
        if ( lengthDifference > 1 ) return false;

        String longer, shorter, difference;
        if(first.length() >= second.length()){
            longer = first;
            shorter = second;
        } else {
            shorter = first;
            longer= second;
        }
        difference=longer;
        for (int i = 0; i < shorter.length(); i++) {
            difference=difference.replaceFirst("["+ shorter.charAt(i) +"]", "");
        }

        if(difference.length()>1) {
            return false;
        }

        return true;
    }
}
