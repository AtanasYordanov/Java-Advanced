package FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ReverseAndExclude {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        int[] numbers = parseInput(input);
        int divisor = Integer.parseInt(reader.readLine());
        Consumer<int[]> reverse = defineReverse();
        Predicate<Integer> checkIfDivisible = n -> n % divisor != 0;
        Consumer<int[]> printValidElements = definePrint(checkIfDivisible);
        reverse.accept(numbers);
        printValidElements.accept(numbers);
    }

    private static Consumer<int[]> definePrint(Predicate<Integer> checkIfDivisible) {
        return arr -> {
            StringBuilder sb = new StringBuilder();
            for (int number : arr) {
                if (checkIfDivisible.test(number)) {
                    sb.append(number).append(" ");
                }
            }
            System.out.println(sb);
        };
    }

    private static Consumer<int[]> defineReverse() {
        return arr -> {

            for (int i = 0; i < arr.length / 2; i++) {
                int temp = arr[i];
                arr[i] = arr[arr.length - i - 1];
                arr[arr.length - i - 1] = temp;
            }
        };
    }

    private static int[] parseInput(String[] input) {
        int[] numbers = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }
        return numbers;
    }
}
