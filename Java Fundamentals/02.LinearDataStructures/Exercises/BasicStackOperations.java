package LinearDataStructures.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BasicStackOperations {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = reader.readLine().split(" ");
        int pushCount = Integer.parseInt(tokens[0]);
        int popCount = Integer.parseInt(tokens[1]);
        int element = Integer.parseInt(tokens[2]);
        String[] elements = reader.readLine().split(" ");
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < pushCount; i++) {
            stack.push(Integer.parseInt(elements[i]));
        }
        for (int i = 0; i < popCount; i++) {
            stack.pop();
        }
        if (stack.isEmpty()) {
            System.out.println("0");
        } else if (stack.contains(element)) {
            System.out.println("true");
        } else {
            int minElement = Integer.MAX_VALUE;
            while (!stack.isEmpty()) {
                int current = stack.pop();
                if (current < minElement) {
                    minElement = current;
                }
            }
            System.out.println(minElement);
        }
    }
}
