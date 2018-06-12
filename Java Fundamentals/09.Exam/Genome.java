package Exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Genome {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String regex = "^([a-z!@#$?]+)=(\\d+)--(\\d+)<<([a-z]+)$";
        Pattern pattern = Pattern.compile(regex);
        Map<String, Integer> genomes = new LinkedHashMap<>();
        for (String line = reader.readLine(); !line.equals("Stop!"); line = reader.readLine()) {
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                String name = matcher.group(1).replaceAll("[!@#$?]+", "");
                int length = Integer.parseInt(matcher.group(2));
                if (name.length() == length) {
                    int count = Integer.parseInt(matcher.group(3));
                    String type = matcher.group(4);
                    genomes.putIfAbsent(type, 0);
                    genomes.put(type, genomes.get(type) + count);
                }
            }
        }
        genomes.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()))
                .forEach(kvp -> System.out.printf("%s has genome size of %d%n", kvp.getKey(), kvp.getValue()));
    }
}
