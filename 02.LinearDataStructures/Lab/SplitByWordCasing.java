package LinearDataStructures.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SplitByWordCasing {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] words = reader.readLine().split("[.!,/()'\\\\\";:\\[\\] ]");
        List<String> lower = new ArrayList<>();
        List<String> upper = new ArrayList<>();
        List<String> mixed = new ArrayList<>();
        for (String word : words) {
            if (word.equals("")) {
                continue;
            }
            if (isLowerCase(word)) {
                lower.add(word);
            } else if (isUpperCase(word)) {
                upper.add(word);
            } else {
                mixed.add(word);
            }
        }
        System.out.println("Lower-case: " + String.join(", ", lower));
        System.out.println("Mixed-case: " + String.join(", ", mixed));
        System.out.println("Upper-case: " + String.join(", ", upper));
    }

    private static boolean isUpperCase(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (!Character.isUpperCase(word.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean isLowerCase(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (!Character.isLowerCase(word.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
