package SetsAndMaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PopulationCounter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, LinkedHashMap<String, Long>> countriesMap = new LinkedHashMap<>();
        for (String input = reader.readLine(); !input.equals("report"); input = reader.readLine()) {
            String[] tokens = input.split("\\|");
            String city = tokens[0];
            String country = tokens[1];
            long population = Long.parseLong(tokens[2]);
            countriesMap.putIfAbsent(country, new LinkedHashMap<>());
            countriesMap.get(country).put(city, population);
        }
        StringBuilder sb = new StringBuilder();
        countriesMap.entrySet().stream()
                .sorted(Comparator.comparing(a -> a.getValue().values().stream()
                                .mapToLong(Long::valueOf)
                                .sum(),
                        Comparator.reverseOrder()))
                .forEach(kvp -> {
                    long totalPopulation = kvp.getValue().values().stream()
                            .mapToLong(Long::valueOf)
                            .sum();
                    sb.append(String.format("%s (total population: %d)%n", kvp.getKey(), totalPopulation));

                    kvp.getValue().entrySet().stream()
                            .sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()))
                            .forEach(nestedKvp -> {
                                sb.append(String.format("=>%s: %d%n", nestedKvp.getKey(), nestedKvp.getValue()));
                            });
                });
        System.out.print(sb);
    }
}
