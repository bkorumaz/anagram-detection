package com.bkorumaz;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        try {
            File file = new File("strings.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));

            List<String>[] stringsAr = new List[2];

            for(int i=0; i<2; i++){
                String line = br.readLine();
                stringsAr[i] = Stream.of(line.split(","))
                        .collect(Collectors.toList());
            }

            br.close();

            System.out.println("first group of items " + stringsAr[0].toString());
            System.out.println("second group of items " + stringsAr[1].toString());

            int lengthOfFirstArray=stringsAr[0].size();
            int lengthOfSecondArray=stringsAr[1].size();

            if(lengthOfFirstArray!=lengthOfSecondArray){
                System.out.println("different number of items. check the file!");
            } else {
                String result = compareItems(stringsAr[0], stringsAr[1]).toString();
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

        //finding the difference string with removing chars from the longer string
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
