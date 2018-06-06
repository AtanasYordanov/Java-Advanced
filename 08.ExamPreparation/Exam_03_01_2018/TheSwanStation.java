package ExamPreparation.Exam_03_01_2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class TheSwanStation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> divisors = Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
        Deque<Integer> numbers = Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        String[] output = new String[6];
        int index = 0;
        while (index < 6) {
            int divisor = divisors.peek();
            int number = numbers.poll();
            if (number % divisor == 0) {
                output[index++] = Integer.toString(number);
                divisors.poll();
            } else {
                numbers.offer(number + 1);
            }
        }

        System.out.println(String.join(", ", output));
    }
}
