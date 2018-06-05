package StreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class OfficeStuff {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Map<String, Map<String, Integer>> companiesData = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split(" - ");
            String company = tokens[0].substring(1);
            int amount = Integer.parseInt(tokens[1]);
            String product = tokens[2].substring(0, tokens[2].length() - 1);

            companiesData.putIfAbsent(company, new LinkedHashMap<>());
            companiesData.get(company).putIfAbsent(product, 0);
            int currentAmount = companiesData.get(company).get(product);
            companiesData.get(company).put(product, currentAmount + amount);
        }
        StringBuilder sb = new StringBuilder();
        companiesData.forEach((key, value) -> {
            String products = value.entrySet().stream()
                    .map(pair -> pair.getKey() + "-" + pair.getValue())
                    .collect(Collectors.joining(", "));
            sb.append(key).append(": ").append(products).append(System.lineSeparator());
        });
        System.out.print(sb);
    }
}