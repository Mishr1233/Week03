package org.example.inputstrem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CountOccurrenceOfWord {

    public static int countOccurrence(String target){
        int count=0;

        try {
            BufferedReader br=new BufferedReader(new FileReader("sample.txt"));
            String line;

            while((line=br.readLine())!=null){
                String[] word=line.split("\\W+");

             for(int i=0;i<word.length;i++){
                 if(word[i].equals(target)){
                     count++;
                 }
             }

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return count;
    }

    public static void main(String[] args) {
      String str="you";
        System.out.println("Occurrence of '" + str + "': " + countOccurrence(str));
    }
}
