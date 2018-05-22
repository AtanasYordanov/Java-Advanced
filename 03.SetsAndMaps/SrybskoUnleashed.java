package SetsAndMaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SrybskoUnleashed {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Map<String, Long>> venues = new LinkedHashMap<>();
        String regex = "^(?<singer>[\\w ]+)\\b @(?<venue>[\\w ]+)\\b (?<price>[\\d]+) (?<tickets>[\\d]+)";
        Pattern pattern = Pattern.compile(regex);
        for (String input = reader.readLine(); !input.equals("End"); input = reader.readLine()) {
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                String singer = matcher.group("singer");
                String venue = matcher.group("venue");
                long price = Integer.parseInt(matcher.group("price"));
                long tickets = Integer.parseInt(matcher.group("tickets"));
                long sum = price * tickets;
                venues.putIfAbsent(venue, new LinkedHashMap<>());
                venues.get(venue).putIfAbsent(singer, 0L);
                venues.get(venue).put(singer, venues.get(venue).get(singer) + sum);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Map<String, Long>> pair : venues.entrySet()) {
            sb.append(pair.getKey()).append(System.lineSeparator());
            pair.getValue().entrySet().stream()
                    .sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()))
                    .forEach(kvp -> {
                        sb.append("#  ").append(kvp.getKey()).append(" -> ")
                                .append(kvp.getValue()).append(System.lineSeparator());
                    });
        }
        System.out.print(sb);
    }
}
