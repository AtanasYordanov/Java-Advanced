package FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;

public class CustomMinFunction {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        int[] numbers = parseInput(input);
        Function<int[], Integer> getMinNumber = defineFunction();
        int minNumber = getMinNumber.apply(numbers);
        System.out.println(minNumber);
    }

    private static int[] parseInput(String[] input) {
        int[] numbers = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }
        return numbers;
    }

    private static Function<int[], Integer> defineFunction() {
        return arr -> {
            int min = Integer.MAX_VALUE;
            for (int num : arr) {
                if (num < min) {
                    min = num;
                }
            }
            return min;
        };
    }
}
