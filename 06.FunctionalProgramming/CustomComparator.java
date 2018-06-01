package FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class CustomComparator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        Integer[] numbers = parseInput(input);

        Comparator<Integer> comp = (a, b) -> {
            if (Math.abs(a % 2) == Math.abs(b % 2)) {
                return a - b;
            } else if (a % 2 == 0) {
                return -1;
            } else {
                return 1;
            }
        };

        Arrays.sort(numbers, comp);
        printResult(numbers);
    }

    private static void printResult(Integer[] numbers) {
        StringBuilder sb = new StringBuilder();
        for (Integer number : numbers) {
            sb.append(number).append(" ");
        }
        System.out.println(sb);
    }

    private static Integer[] parseInput(String[] input) {
        Integer[] output = new Integer[input.length];
        for (int i = 0; i < input.length; i++) {
            output[i] = Integer.parseInt(input[i]);
        }
        return output;
    }
}
