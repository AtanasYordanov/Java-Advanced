package FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Predicate;

public class FindEvensOrOdds {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = reader.readLine().split(" ");
        int lowerBound = Integer.parseInt(tokens[0]);
        int upperBound = Integer.parseInt(tokens[1]);
        String type = reader.readLine();
        Predicate<Integer> isValid = definePredicate(type);
        printResult(lowerBound, upperBound, isValid);
    }

    private static void printResult(int lowerBound, int upperBound, Predicate<Integer> isValid) {
        StringBuilder sb = new StringBuilder();
        for (int number = lowerBound; number <= upperBound; number++) {
            if (isValid.test(number)) {
                sb.append(number).append(" ");
            }
        }
        System.out.println(sb);
    }

    private static Predicate<Integer> definePredicate(String type) {
        if (type.equals("odd")) {
            return a -> a % 2 != 0;
        } else {
            return a -> a % 2 == 0;
        }
    }
}
