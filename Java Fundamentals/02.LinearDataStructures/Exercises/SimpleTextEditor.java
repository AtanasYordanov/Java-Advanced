package LinearDataStructures.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class SimpleTextEditor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Deque<String> stack = new ArrayDeque<>();
        stack.push("");
        StringBuilder output = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split(" ");
            String command = tokens[0];
            switch (command) {
                case "1":
                    String text = tokens[1];
                    sb.append(text);
                    stack.push(sb.toString());
                    break;
                case "2":
                    int count = Integer.parseInt(tokens[1]);
                    sb.delete(sb.length() - count, sb.length());
                    stack.push(sb.toString());
                    break;
                case "3":
                    int index = Integer.parseInt(tokens[1]) - 1;
                    output.append(sb.charAt(index)).append(System.lineSeparator());
                    break;
                case "4":
                    sb.delete(0, sb.length());
                    stack.pop();
                    sb.append(stack.peek());
                    break;
            }
        }
        System.out.print(output);
    }
}
