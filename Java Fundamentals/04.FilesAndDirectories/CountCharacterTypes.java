package FilesAndDirectories;

import java.io.*;
import java.util.Set;

public class CountCharacterTypes {

    private static final String INPUT_PATH = "./src/FilesAndDirectories/resources/input.txt";
    private static final String OUTPUT_PATH = "./src/FilesAndDirectories/resources/output.txt";

    public static void main(String[] args) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        Set<Character> punctuationMarks = Set.of('!', ',', '.', '?');
        int vowelsCount = 0;
        int consonantsCount = 0;
        int punctuationMarksCount = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_PATH));
             PrintWriter writer = new PrintWriter(new FileWriter(OUTPUT_PATH, false))) {
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                for (char ch : line.toCharArray()) {
                    if (punctuationMarks.contains(ch)) {
                        punctuationMarksCount++;
                    } else if (vowels.contains(ch)) {
                        vowelsCount++;
                    } else if (ch != ' ') {
                        consonantsCount++;
                    }
                }
            }
            writer.println("Vowels: " + vowelsCount);
            writer.println("Consonants: " + consonantsCount);
            writer.println("Punctuation: " + punctuationMarksCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
