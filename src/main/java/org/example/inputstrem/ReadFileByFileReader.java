package org.example.inputstrem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileByFileReader {

    //PrintLine function
    public static void printLine(){

        try {
            //BufferReader Object br
            BufferedReader br=new BufferedReader(new FileReader("sample.txt"));
            String line;

            //Print line by line file
            while((line=br.readLine())!=null){
                System.out.println(line);

            }
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
      //call printLine function
        printLine();
    }
}
