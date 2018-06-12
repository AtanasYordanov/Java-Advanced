package ExamPreparation.Exam_19_02_2017;

import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Highscore {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, List<Pair<String, Integer>>> playerStatistics = new LinkedHashMap<>();
        for (String line = reader.readLine(); !line.equals("osu!"); line = reader.readLine()) {
            String[] tokens = line.split(" |<->");
            int firstPlayerScore = Integer.parseInt(tokens[0]);
            String firstPlayerName = tokens[1];
            String secondPlayerName = tokens[2];
            int secondPlayerScore = Integer.parseInt(tokens[3]);
            int difference = Math.abs(firstPlayerScore - secondPlayerScore);
            playerStatistics.putIfAbsent(firstPlayerName, new ArrayList<>());
            playerStatistics.putIfAbsent(secondPlayerName, new ArrayList<>());
            if (firstPlayerScore > secondPlayerScore) {
                playerStatistics.get(firstPlayerName).add(new Pair<>(secondPlayerName, difference));
                playerStatistics.get(secondPlayerName).add(new Pair<>(firstPlayerName, -difference));
            } else {
                playerStatistics.get(firstPlayerName).add(new Pair<>(secondPlayerName, -difference));
                playerStatistics.get(secondPlayerName).add(new Pair<>(firstPlayerName, difference));
            }
        }
        playerStatistics.entrySet().stream()
                .sorted(Comparator.comparing(kvp -> kvp.getValue().stream()
                        .mapToLong(Pair::getValue).sum(), Comparator.reverseOrder()))
                .forEach(kvp -> {
                    System.out.printf("%s - (%d)%n", kvp.getKey()
                            , kvp.getValue().stream().mapToLong(Pair::getValue).sum());
                    for (Pair<String, Integer> pair : kvp.getValue()) {
                        System.out.printf("*   %s <-> %d%n", pair.getKey(), pair.getValue());
                    }
                });
    }
}