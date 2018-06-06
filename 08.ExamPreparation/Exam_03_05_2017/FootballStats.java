package ExamPreparation.Exam_03_05_2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FootballStats {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Map<String, List<String>>> matches = new HashMap<>();
        for (String input = reader.readLine(); !input.equals("Season End"); input = reader.readLine()) {
            String[] tokens = input.split(" - | ");
            String firstTeam = tokens[0];
            String secondTeam = tokens[1];
            String score = tokens[3];
            String scoreReversed = reverseResult(score);
            matches.putIfAbsent(firstTeam, new TreeMap<>());
            matches.putIfAbsent(secondTeam, new TreeMap<>());
            matches.get(firstTeam).putIfAbsent(secondTeam, new ArrayList<>());
            matches.get(secondTeam).putIfAbsent(firstTeam, new ArrayList<>());
            matches.get(firstTeam).get(secondTeam).add(score);
            matches.get(secondTeam).get(firstTeam).add(scoreReversed);
        }
        String[] teams = reader.readLine().split(", ");
        StringBuilder sb = new StringBuilder();
        for (String team : teams) {
            matches.get(team)
                    .forEach((key, value) -> {
                        for (String score : value) {
                            sb.append(team).append(" - ").append(key).append(" -> ")
                                    .append(score).append(System.lineSeparator());
                        }
                    });
        }
        System.out.print(sb);
    }

    private static String reverseResult(String score) {
        String[] goals = score.split(":");
        return String.format("%s:%s", goals[1], goals[0]);
    }
}