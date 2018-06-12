package LinearDataStructures.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BalancedParentheses {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        Deque<Character> stack = new ArrayDeque<>();
        boolean isValid = true;
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (isOpeningParenthesis(currentChar)) {
                stack.push(currentChar);
            } else {
                if (stack.isEmpty() || !isValid(stack, currentChar)) {
                    isValid = false;
                    break;
                } else {
                    stack.pop();
                }
            }
        }
        System.out.println(isValid ? "YES" : "NO");
    }

    private static boolean isOpeningParenthesis(char currentChar) {
        return currentChar == '(' || currentChar == '[' || currentChar == '{';
    }

    private static boolean isValid(Deque<Character> stack, char currentChar) {
        return (currentChar == ')' && stack.peek() == '(')
                || (currentChar == ']' && stack.peek() == '[')
                || (currentChar == '}' && stack.peek() == '{');
    }
}
