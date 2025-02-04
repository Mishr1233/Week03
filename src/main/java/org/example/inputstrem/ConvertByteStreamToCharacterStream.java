package org.example.inputstrem;

import java.io.*;

public class ConvertByteStreamToCharacterStream {

    public static void printFile() throws IOException {

        FileInputStream file =new FileInputStream("sample.txt");
        InputStreamReader in =new InputStreamReader(file);

        BufferedReader br=new BufferedReader(in);

        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        // Close the BufferedReader
        br.close();
    }


    public static void main(String[] args) throws IOException {
        //printLine of file
        printFile();
    }
}
