package LinearDataStructures.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Collectors;

public class HotPotato {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Deque<String> queue = Arrays.stream(reader.readLine().split(" "))
                .collect(Collectors.toCollection(ArrayDeque::new));
        int n = Integer.parseInt(reader.readLine());
        int cycle = 1;
        while (queue.size() > 1) {
            for (int i = 1; i < n; i++) {
                queue.offer(queue.poll());
            }
            if (isPrime(cycle++)) {
                System.out.println("Prime " + queue.peek());
            } else {
                System.out.println("Removed " + queue.poll());
            }
        }
        System.out.println("Last is " + queue.poll());
    }

    private static boolean isPrime(long number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
