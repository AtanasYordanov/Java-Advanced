package FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Predicate;

public class PredicateForNames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maxLength = Integer.parseInt(reader.readLine());
        String[] names = reader.readLine().split(" ");
        Predicate<String> lengthIsValid = s -> s.length() <= maxLength;
        printResult(names, lengthIsValid);
    }

    private static void printResult(String[] names, Predicate<String> lengthIsValid) {
        StringBuilder sb = new StringBuilder();
        for (String name : names) {
            if (lengthIsValid.test(name)) {
                sb.append(name).append(System.lineSeparator());
            }
        }
        System.out.println(sb);
    }
}
