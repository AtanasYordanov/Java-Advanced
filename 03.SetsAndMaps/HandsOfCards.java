package SetsAndMaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Set<String>> hands = new LinkedHashMap<>();
        for (String line = reader.readLine(); !line.equals("JOKER"); line = reader.readLine()) {
            String[] tokens = line.split(": |, ");
            String playerName = tokens[0];
            hands.putIfAbsent(playerName, new HashSet<>());
            for (int i = 1; i < tokens.length; i++) {
                String card = tokens[i];
                hands.get(playerName).add(card);
            }
        }
        for (Map.Entry<String, Set<String>> pair : hands.entrySet()) {
            int playerScore = 0;
            for (String card : pair.getValue()) {
                int power;
                switch (card.charAt(0)) {
                    case '1':
                        power = 10;
                        break;
                    case 'J':
                        power = 11;
                        break;
                    case 'Q':
                        power = 12;
                        break;
                    case 'K':
                        power = 13;
                        break;
                    case 'A':
                        power = 14;
                        break;
                    default:
                        power = card.charAt(0) - '0';
                        break;
                }
                int multiplier = 0;
                switch (card.charAt(card.length() - 1)) {
                    case 'S':
                        multiplier = 4;
                        break;
                    case 'H':
                        multiplier = 3;
                        break;
                    case 'D':
                        multiplier = 2;
                        break;
                    case 'C':
                        multiplier = 1;
                        break;
                }
                playerScore += power * multiplier;
            }
            System.out.printf("%s: %d%n", pair.getKey(), playerScore);
        }
    }
}
