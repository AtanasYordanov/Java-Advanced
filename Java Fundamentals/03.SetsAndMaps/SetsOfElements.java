package SetsAndMaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();
        String[] tokens = reader.readLine().split(" ");
        int n = Integer.parseInt(tokens[0]);
        int m = Integer.parseInt(tokens[1]);
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(reader.readLine());
            firstSet.add(number);
        }
        for (int i = 0; i < m; i++) {
            int number = Integer.parseInt(reader.readLine());
            secondSet.add(number);
        }
        StringBuilder sb = new StringBuilder();
        for (Integer number : firstSet) {
            if (secondSet.contains(number)) {
                sb.append(number).append(" ");
            }
        }
        System.out.println(sb);
    }
}
