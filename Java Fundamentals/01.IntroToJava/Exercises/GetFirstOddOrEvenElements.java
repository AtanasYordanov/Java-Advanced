package IntroToJava.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GetFirstOddOrEvenElements {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        String[] tokens = reader.readLine().split("\\s+");
        int targetCount = Integer.parseInt(tokens[1]);
        String type = tokens[2];
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int number : numbers) {
            if ((type.equals("odd") && number % 2 != 0)
                    || (type.equals("even") && number % 2 == 0)) {
                sb.append(number).append(" ");
                if (++count == targetCount) {
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}
