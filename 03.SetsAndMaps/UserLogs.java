package SetsAndMaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserLogs {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Map<String, Integer>> logs = new TreeMap<>();
        for (String input = reader.readLine(); !input.equals("end"); input = reader.readLine()) {
            String regex = "^IP=(?<ip>(\\d+\\.?)+|(.+:.+)\\b) .+ user=(?<username>\\w+)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                String username = matcher.group("username");
                String ip = matcher.group("ip");
                logs.putIfAbsent(username, new LinkedHashMap<>());
                logs.get(username).putIfAbsent(ip, 0);
                logs.get(username).put(ip, logs.get(username).get(ip) + 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Map<String, Integer>> pair : logs.entrySet()) {
            sb.append(pair.getKey()).append(":").append(System.lineSeparator());
            for (Map.Entry<String, Integer> entry : pair.getValue().entrySet()) {
                sb.append(String.format("%s => %d, ", entry.getKey(), entry.getValue()));
            }
            sb.delete(sb.length() - 2, sb.length());
            sb.append(".").append(System.lineSeparator());
        }
        System.out.print(sb);
    }
}
