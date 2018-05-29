package StringProcessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LettersChangeNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = reader.readLine().split("\\s+");
        double sum = performOperations(tokens);
        System.out.printf("%.2f", sum);
    }

    private static double performOperations(String[] tokens) {
        double sum = 0;

        for (String token : tokens) {
            double number = Double.parseDouble(token.substring(1, token.length() - 1));

            if (token.charAt(0) >= 'a' && token.charAt(0) <= 'z') {
                int position = token.charAt(0) - 'a' + 1;
                number *= position;
            } else if (token.charAt(0) >= 'A' && token.charAt(0) <= 'Z') {
                int position = token.charAt(0) - 'A' + 1;
                number /= 1.0 * position;
            }

            if (token.charAt(token.length() - 1) >= 'a' && token.charAt(token.length() - 1) <= 'z') {
                int position = token.charAt(token.length() - 1) - 'a' + 1;
                number += position;
            } else if (token.charAt(0) >= 'A' && token.charAt(token.length() - 1) <= 'Z') {
                int position = token.charAt(token.length() - 1) - 'A' + 1;
                number -= position;
            }

            sum += number;
        }
        return sum;
    }
}
