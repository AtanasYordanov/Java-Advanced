package LinearDataStructures.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumElement {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Integer> trackStack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split(" ");
            String command = tokens[0];
            switch (command) {
                case "1":
                    int element = Integer.parseInt(tokens[1]);
                    stack.push(element);
                    int maxElement = trackStack.isEmpty() ? element : trackStack.peek();
                    if (element >= maxElement) {
                        trackStack.push(element);
                    } else {
                        trackStack.push(maxElement);
                    }
                    break;
                case "2":
                    stack.pop();
                    trackStack.pop();
                    break;
                case "3":
                    sb.append(trackStack.peek()).append(System.lineSeparator());
                    break;
            }
        }
        System.out.print(sb);
    }
}