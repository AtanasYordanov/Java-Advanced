package SetsAndMaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LogsAggregator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Map<String, Integer>> logs = new TreeMap<>();
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split(" ");
            String ip = tokens[0];
            String user = tokens[1];
            int duration = Integer.parseInt(tokens[2]);
            logs.putIfAbsent(user, new TreeMap<>());
            logs.get(user).putIfAbsent(ip, 0);
            logs.get(user).put(ip, logs.get(user).get(ip) + duration);
        }
        for (Map.Entry<String, Map<String, Integer>> pair : logs.entrySet()) {
            int duration = pair.getValue().values().stream()
                    .mapToInt(Integer::valueOf)
                    .sum();
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("%s: %d [", pair.getKey(), duration));
            for (String ip : pair.getValue().keySet()) {
                sb.append(ip).append(", ");
            }
            sb.delete(sb.length() - 2, sb.length());
            sb.append("]");
            System.out.println(sb);
        }
    }
}
