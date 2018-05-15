package IntroToJava.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameOfNames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String bestPlayer = "";
        int bestScore = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            String playerName = reader.readLine();
            int score = Integer.parseInt(reader.readLine());
            for (int j = 0; j < playerName.length(); j++) {
                int asciiValue = playerName.charAt(j);
                if (asciiValue % 2 == 0) {
                    score += asciiValue;
                } else {
                    score -= asciiValue;
                }
            }
            if (score > bestScore) {
                bestScore = score;
                bestPlayer = playerName;
            }
        }
        System.out.printf("The winner is %s - %d points%n", bestPlayer, bestScore);
    }
}
