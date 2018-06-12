package FilesAndDirectories;

import java.io.*;
import java.util.*;

public class WordCount {

    private static final String WORDS_INPUT_PATH = "./src/FilesAndDirectories/resources/words.txt";
    private static final String TEXT_INPUT_PATH = "./src/FilesAndDirectories/resources/text.txt";
    private static final String OUTPUT_PATH = "./src/FilesAndDirectories/resources/results.txt";

    public static void main(String[] args) {
        try (BufferedReader wordsReader = new BufferedReader(new FileReader(WORDS_INPUT_PATH));
             BufferedReader textReader = new BufferedReader(new FileReader(TEXT_INPUT_PATH));
             PrintWriter writer = new PrintWriter(new FileWriter(OUTPUT_PATH, false))) {

            String[] words = wordsReader.readLine().split(" ");
            Map<String, Integer> wordOccurrences = new LinkedHashMap<>();
            for (String word : words) {
                wordOccurrences.put(word, 0);
            }
            String[] text = textReader.readLine().split(" ");
            for (String word : text) {
                if (wordOccurrences.containsKey(word)) {
                    wordOccurrences.put(word, wordOccurrences.get(word) + 1);
                }
            }
            for (Map.Entry<String, Integer> pair : wordOccurrences.entrySet()) {
                writer.printf("%s - %d%n", pair.getKey(), pair.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
