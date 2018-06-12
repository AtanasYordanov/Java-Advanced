package SetsAndMaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LegendaryFarming {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> materials = new HashMap<>();
        Map<String, Integer> junk = new TreeMap<>();
        materials.put("motes", 0);
        materials.put("fragments", 0);
        materials.put("shards", 0);
        StringBuilder sb = new StringBuilder();
        loop:
        while (true) {
            String[] input = reader.readLine().split(" ");
            for (int i = 0; i < input.length - 1; i += 2) {
                int quantity = Integer.parseInt(input[i]);
                String material = input[i + 1].toLowerCase();
                switch (material) {
                    case "motes":
                        materials.putIfAbsent(material, 0);
                        materials.put(material, materials.get(material) + quantity);
                        if (materials.get("motes") >= 250) {
                            sb.append("Dragonwrath obtained!").append(System.lineSeparator());
                            materials.put("motes", materials.get("motes") - 250);
                            break loop;
                        }
                        break;
                    case "fragments":
                        materials.putIfAbsent(material, 0);
                        materials.put(material, materials.get(material) + quantity);
                        if (materials.get("fragments") >= 250) {
                            sb.append("Valanyr obtained!").append(System.lineSeparator());
                            materials.put("fragments", materials.get("fragments") - 250);
                            break loop;
                        }
                        break;
                    case "shards":
                        materials.putIfAbsent(material, 0);
                        materials.put(material, materials.get(material) + quantity);
                        if (materials.get("shards") >= 250) {
                            sb.append("Shadowmourne obtained!").append(System.lineSeparator());
                            materials.put("shards", materials.get("shards") - 250);
                            break loop;
                        }
                        break;
                    default:
                        junk.putIfAbsent(material, 0);
                        junk.put(material, junk.get(material) + quantity);
                        break;
                }
            }
        }
        Comparator<Map.Entry<String, Integer>> compareByQuantity = Comparator.comparing(Map.Entry::getValue
                , Comparator.reverseOrder());
        Comparator<Map.Entry<String, Integer>> compareByName = Comparator.comparing(Map.Entry::getKey);
        materials.entrySet().stream()
                .sorted(compareByQuantity.thenComparing(compareByName))
                .forEach(kvp -> {
                    sb.append(kvp.getKey()).append(": ").append(kvp.getValue()).append(System.lineSeparator());
                });
        junk.forEach((key, value) -> sb.append(key).append(": ").append(value).append(System.lineSeparator()));
        System.out.print(sb);
    }
}
