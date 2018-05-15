package IntroToJava.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class OddAndEvenPairs {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        if (numbers.length % 2 == 1) {
            System.out.println("invalid length");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.length; i += 2) {
            if (numbers[i] % 2 == 0 && numbers[i + 1] % 2 == 0) {
                sb.append(String.format("%d, %d -> both are even", numbers[i], numbers[i + 1]));
            } else if (numbers[i] % 2 == 1 && numbers[i + 1] % 2 == 1) {
                sb.append(String.format("%d, %d -> both are odd", numbers[i], numbers[i + 1]));
            } else {
                sb.append(String.format("%d, %d -> different", numbers[i], numbers[i + 1]));
            }
            sb.append(System.lineSeparator());
        }
        System.out.print(sb);
    }
}
