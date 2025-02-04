package org.example.searching;


public class FindSpecificWord {

    public static String findSentenceWithWord(String[] sentences, String word) {
        for (String sentence : sentences) {

            if (sentence.contains(word)) {
                return sentence;
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        // Example array of sentences
        String[] sentences = {
                "The sky is blue.",
                "Java is a programming language.",
                "Linear search is simple to implement.",
                "I love coding!"
        };

        // The word to search for
        String word = "coding";

        // Call the method to find the sentence
        String result = findSentenceWithWord(sentences, word);

        // Print the result
        System.out.println(result);  // Output: I love coding!
    }
}

