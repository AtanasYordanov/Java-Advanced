package ExamPreparation.Exam_19_02_2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Earthquake {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Deque<Deque<Integer>> queue = new ArrayDeque<>();
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            Deque<Integer> wave = Arrays.stream(reader.readLine().split(" "))
                    .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
            queue.offer(wave);
        }
        List<Integer> output = new ArrayList<>();
        while (!queue.isEmpty()) {
            Deque<Integer> sequence = queue.poll();
            int wave = sequence.poll();
            while (!sequence.isEmpty() && wave >= sequence.peek()) {
                sequence.poll();
            }
            output.add(wave);
            if (!sequence.isEmpty()) {
                queue.offer(sequence);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(output.size()).append(System.lineSeparator());
        for (Integer seismicity : output) {
            sb.append(seismicity).append(" ");
        }
        System.out.println(sb);
    }
}
