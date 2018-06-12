package IntroToJava.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CharacterMultiplier {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = reader.readLine().split(" ");
        String first = tokens[0];
        String second = tokens[1];
        int sum = 0;
        for (int i = 0; i < Math.max(first.length(), second.length()); i++) {
            int value1 = first.length() > i ? first.charAt(i) : 1;
            int value2 = second.length() > i ? second.charAt(i) : 1;
            sum += value1 * value2;
        }
        System.out.println(sum);
    }
}
