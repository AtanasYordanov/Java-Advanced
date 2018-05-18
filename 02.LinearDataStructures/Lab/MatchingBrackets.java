package LinearDataStructures.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class MatchingBrackets {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        Deque<Integer> indices = new ArrayDeque<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                indices.push(i);
            } else if (input.charAt(i) == ')') {
                int startIndex = indices.pop();
                System.out.println(input.substring(startIndex, i + 1));
            }
        }
    }
}
