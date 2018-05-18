package LinearDataStructures.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BasicQueueOperations {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = reader.readLine().split(" ");
        int pushCount = Integer.parseInt(tokens[0]);
        int popCount = Integer.parseInt(tokens[1]);
        int element = Integer.parseInt(tokens[2]);
        String[] elements = reader.readLine().split(" ");
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < pushCount; i++) {
            queue.offer(Integer.parseInt(elements[i]));
        }
        for (int i = 0; i < popCount; i++) {
            queue.poll();
        }
        if (queue.isEmpty()) {
            System.out.println("0");
        } else if (queue.contains(element)) {
            System.out.println("true");
        } else {
            int minElement = Integer.MAX_VALUE;
            while (!queue.isEmpty()) {
                int current = queue.pop();
                if (current < minElement) {
                    minElement = current;
                }
            }
            System.out.println(minElement);
        }
    }
}
