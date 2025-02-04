package org.example.inputstrem;

import java.io.*;

public class PerformenceComparison {

    public static void main(String[] args) {
        //StringBuilder vs StringBuffer comparison
        String str = "hello";

        long startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000000; i++) {
            sb.append(str);
        }
        long endTime = System.nanoTime();
        System.out.println("Time taken by StringBuilder: " + (endTime - startTime) + " nanoseconds");

        startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < 1000000; i++) {
            sbf.append(str);
        }
        endTime = System.nanoTime();
        System.out.println("Time taken by StringBuffer: " + (endTime - startTime) + " nanoseconds");

        // FileReader vs InputStreamReader comparison
        String filePath = "sample.txt";

        try {
            // Using FileReader
            startTime = System.nanoTime();
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            int wordCountFileReader = countWords(bufferedReader);
            endTime = System.nanoTime();
            System.out.println("FileReader Word Count: " + wordCountFileReader);
            System.out.println("Time taken by FileReader: " + (endTime - startTime) + " nanoseconds");

            // Using InputStreamReader (new FileReader instance)
            startTime = System.nanoTime();
            FileInputStream fileInputStream = new FileInputStream(filePath);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            int wordCountInputStreamReader = countWords(bufferedReader);
            endTime = System.nanoTime();
            System.out.println("InputStreamReader Word Count: " + wordCountInputStreamReader);
            System.out.println("Time taken by InputStreamReader: " + (endTime - startTime) + " nanoseconds");

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }

    public static int countWords(BufferedReader reader) throws IOException {
        int wordCount = 0;
        String line;
        while ((line = reader.readLine()) != null) {
            String[] words = line.split("\\s+");
            wordCount += words.length;
        }
        reader.close();
        return wordCount;
    }
}
