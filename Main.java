import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        // Path to the text file
        String filePath = "G:\\Java\\Project1\\WordCount\\src\\Text.txt";

        // Creates a HashMap to store word counts
        Map<String, Integer> wordCountMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Splits the line into words
                String[] words = line.split("\\W+");

                for (String word : words) {
                    // Converts word to lowercase to make the count case-insensitive
                    word = word.toLowerCase();

                    if (!word.isEmpty()) {
                        // Updates the word count in the map
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Sorts the wordCountMap by value in descending order and gets the top 10 entries
        List<Map.Entry<String, Integer>> top10Words = wordCountMap.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(10)
                .collect(Collectors.toList());

        // Prints the top 10 most frequent words
        System.out.println("Top 10 most frequent words:");
        for (Map.Entry<String, Integer> entry : top10Words) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}