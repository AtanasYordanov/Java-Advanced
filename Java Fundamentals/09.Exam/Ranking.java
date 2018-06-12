package Exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Ranking {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> contests = new HashMap<>();
        Map<String, Map<String, Integer>> userContests = new TreeMap<>();
        for (String line = reader.readLine(); !line.equals("end of contests"); line = reader.readLine()) {
            String[] tokens = line.split(":");
            String contest = tokens[0];
            String password = tokens[1];
            contests.put(contest, password);
        }
        for (String line = reader.readLine(); !line.equals("end of submissions"); line = reader.readLine()) {
            String[] tokens = line.split("=>");
            String contest = tokens[0];
            String password = tokens[1];
            String user = tokens[2];
            int points = Integer.parseInt(tokens[3]);
            if (contests.containsKey(contest) && contests.get(contest).equals(password)) {
                userContests.putIfAbsent(user, new LinkedHashMap<>());
                if (!userContests.get(user).containsKey(contest) || userContests.get(user).get(contest) < points) {
                    userContests.get(user).put(contest, points);
                }
            }
        }
        userContests.entrySet().stream()
                .sorted(Comparator.comparing(kvp -> kvp.getValue().values().stream().mapToInt(Integer::valueOf).sum()
                        , Comparator.reverseOrder()))
                .limit(1)
                .forEach(kvp -> {
                    int totalPoints = kvp.getValue().values().stream().mapToInt(Integer::valueOf).sum();
                    System.out.printf("Best candidate is %s with total %d points.%n", kvp.getKey(), totalPoints);
                });
        System.out.println("Ranking:");
        userContests.forEach((key, value) -> {
            System.out.println(key);
            value.entrySet().stream()
                    .sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()))
                    .forEach(kvp -> System.out.printf("#  %s -> %d%n", kvp.getKey(), kvp.getValue()));
        });
    }
}
