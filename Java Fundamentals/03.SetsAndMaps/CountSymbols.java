package SetsAndMaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();
        Map<Character, Integer> occurrences = new TreeMap<>();
        for (char ch : text.toCharArray()) {
            occurrences.putIfAbsent(ch, 0);
            occurrences.put(ch, occurrences.get(ch) + 1);
        }
        for (Map.Entry<Character, Integer> pair : occurrences.entrySet()) {
            System.out.printf("%c: %d time/s%n", pair.getKey(), pair.getValue());
        }
    }
}
