package SetsAndMaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AMinerTask {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> resources = new LinkedHashMap<>();
        for (String resource = reader.readLine(); !resource.equals("stop"); resource = reader.readLine()) {
            int quantity = Integer.parseInt(reader.readLine());
            if (resources.containsKey(resource)) {
                resources.put(resource, resources.get(resource) + quantity);
            } else {
                resources.put(resource, quantity);
            }
        }
        for (Map.Entry<String, Integer> pair : resources.entrySet()) {
            System.out.printf("%s -> %s%n", pair.getKey(), pair.getValue());
        }
    }
}
