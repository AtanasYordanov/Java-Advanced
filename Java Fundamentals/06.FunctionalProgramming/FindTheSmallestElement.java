package FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;

public class FindTheSmallestElement {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");
        int[] numbers = parseInput(input);
        Function<int[], Integer> getSmallestElementIndex = arr -> {
            int min = Integer.MAX_VALUE;
            int index = -1;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] <= min) {
                    min = arr[i];
                    index = i;
                }
            }
            return index;
        };
        int minElementIndex = getSmallestElementIndex.apply(numbers);
        System.out.println(minElementIndex);
    }

    private static int[] parseInput(String[] input) {
        int[] numbers = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }
        return numbers;
    }
}
