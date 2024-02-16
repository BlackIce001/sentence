import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        // Add words to the list
        words.add("The");
        words.add("quick");
        words.add("brown");
        words.add("fox");
        words.add("jumps");
        words.add("over");
        words.add("the");
        words.add("lazy");
        words.add("dog");
        words.add(".");

        // Create a StringBuilder to store the sentence
        StringBuilder sentence = new StringBuilder();
        Random random = new Random();

        // Generate a random sentence with some words duplicated and a maximum of 15 words
        int sentenceLength = random.nextInt(15) + 1; // Generate a random sentence length between 1 and 15
        for (int i = 0; i < sentenceLength; i++) {
            int wordIndex = random.nextInt(words.size());
            String word = words.get(wordIndex);
            // Add the word to the sentence with a chance of duplication
            if (random.nextBoolean()) {
                sentence.append(word).append(" ");
            }
        }

        // Write the sentence to a file
        String filename = "sentence.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(sentence.toString().trim());
            System.out.println("Sentence has been written to " + filename);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
