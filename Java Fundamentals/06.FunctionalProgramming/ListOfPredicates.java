package FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Predicate;

public class ListOfPredicates {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int upperBound = Integer.parseInt(reader.readLine());
        String[] input = reader.readLine().split(" ");
        int[] divisors = parseInput(input);
        Predicate<Integer> isDivisible = a -> {
            for (int divisor : divisors) {
                if (a % divisor != 0) {
                    return false;
                }
            }
            return true;
        };
        printResult(upperBound, isDivisible);
    }

    private static void printResult(int upperBound, Predicate<Integer> isDivisible) {
        StringBuilder sb = new StringBuilder();
        for (int number = 1; number <= upperBound; number++) {
            if (isDivisible.test(number)) {
                sb.append(number).append(" ");
            }
        }
        System.out.println(sb);
    }

    private static int[] parseInput(String[] input) {
        int[] numbers = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }
        return numbers;
    }
}
