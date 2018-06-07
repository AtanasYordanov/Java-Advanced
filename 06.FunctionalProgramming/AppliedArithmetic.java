package FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.function.Consumer;

public class AppliedArithmetic {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        int[] numbers = parseInput(input);
        Consumer<int[]> add = defineAdd();
        Consumer<int[]> subtract = defineSubtract();
        Consumer<int[]> multiply = defineMultiply();
        Consumer<int[]> print = definePrint();
        Map<String, Consumer<int[]>> consumers = Map.of(
                "add", add,
                "subtract", subtract,
                "multiply", multiply,
                "print", print);
        for (String line = reader.readLine(); !line.equals("end"); line = reader.readLine()) {
            consumers.get(line).accept(numbers);
        }
    }

    private static Consumer<int[]> definePrint() {
        return arr -> {
            StringBuilder sb = new StringBuilder();
            for (int number : arr) {
                sb.append(number).append(" ");
            }
            System.out.println(sb);
        };
    }

    private static Consumer<int[]> defineMultiply() {
        return arr -> {
            for (int i = 0; i < arr.length; i++) {
                arr[i] *= 2;
            }
        };
    }

    private static Consumer<int[]> defineSubtract() {
        return arr -> {
            for (int i = 0; i < arr.length; i++) {
                arr[i]--;
            }
        };
    }

    private static Consumer<int[]> defineAdd() {
        return arr -> {
            for (int i = 0; i < arr.length; i++) {
                arr[i]++;
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
