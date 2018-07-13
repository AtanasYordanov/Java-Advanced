package t02_IteratorsAndComparators.p04_Froggy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split("[,\\s]+"))
                .mapToInt(Integer::parseInt).toArray();

        Lake lake = new Lake(numbers);
        String ignore = reader.readLine();

        StringBuilder sb = new StringBuilder();
        for (Integer num : lake) {
            sb.append(num).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        System.out.println(sb);
    }
}
