package LinearDataStructures.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;

public class SimpleCalculator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = reader.readLine().split(" ");
        Deque<String> stack = new ArrayDeque<>();
        Collections.addAll(stack, tokens);
        while (stack.size() > 1) {
            int firstNumber = Integer.parseInt(stack.pop());
            String operand = stack.pop();
            int secondNumber = Integer.parseInt(stack.pop());
            if (operand.equals("+")) {
                stack.push(String.valueOf(firstNumber + secondNumber));
            } else {
                stack.push(String.valueOf(firstNumber - secondNumber));
            }
        }
        System.out.println(stack.pop());
    }
}
