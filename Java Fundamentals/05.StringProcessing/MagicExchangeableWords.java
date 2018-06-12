package StringProcessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MagicExchangeableWords {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");
        boolean areExchangeable = areExchangeable(input[0], input[1]);
        System.out.println(areExchangeable);
    }

    private static boolean areExchangeable(String firstWord, String secondWord) {
        Map<Character, Character> charMap = new LinkedHashMap<>();
        boolean areExchangeable = true;
        if (firstWord.length() == secondWord.length()) {
            for (int i = 0; i < firstWord.length(); i++) {
                if (charMap.containsKey(firstWord.charAt(i))) {
                    areExchangeable = charMap.get(firstWord.charAt(i)) == secondWord.charAt(i);
                } else {
                    charMap.put(firstWord.charAt(i), secondWord.charAt(i));
                }
            }
        } else {
            areExchangeable = checkUniqueCharacters(firstWord) == checkUniqueCharacters(secondWord);
        }
        return areExchangeable;
    }

    private static int checkUniqueCharacters(String word) {
        Set<Character> chars = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            chars.add(word.charAt(i));
        }
        return chars.size();
    }
}
