package org.example.inputstrem;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileUpdation {

    public static void fileUpdation() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             FileWriter writer = new FileWriter("java.txt", true)) {

            System.out.println("Enter line (type 'exit' to close file):");

            String line;
            while ((line = br.readLine()) != null) {

                if (line.equalsIgnoreCase("exit")) {
                    break;
                }

                writer.write(line + System.lineSeparator());
            }

            System.out.println("File updated successfully.");

        } catch (IOException e) {
            System.err.println("An error occurred while updating the file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        fileUpdation();
    }
}
