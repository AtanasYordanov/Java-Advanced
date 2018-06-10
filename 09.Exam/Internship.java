package Exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Internship {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());
        Deque<String> problemsStack = new ArrayDeque<>();
        Deque<String> candidatesQueue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            problemsStack.push(reader.readLine());
        }
        String regex = "[A-Z][a-z]+? [A-Z][a-z]+";
        for (int i = 0; i < m; i++) {
            String name = reader.readLine();
            if (name.matches(regex)) {
                candidatesQueue.offer(name);
            }
        }
        while (candidatesQueue.size() > 1 && !problemsStack.isEmpty()) {
            String problem = problemsStack.pop();
            String candidate = candidatesQueue.poll();
            if (problemIsSolved(problem, candidate)) {
                System.out.printf("%s solved %s.%n", candidate, problem);
                candidatesQueue.offer(candidate);
            } else {
                System.out.printf("%s failed %s.%n", candidate, problem);
                problemsStack.addLast(problem);
            }
        }
        if (candidatesQueue.size() == 1) {
            System.out.printf("%s gets the job!%n", candidatesQueue.poll());
        } else {
            System.out.println(String.join(",", candidatesQueue));
        }
    }

    private static boolean problemIsSolved(String problem, String candidate) {
        int problemAsciiSum = problem.chars().sum();
        int candidateAsciiSum = candidate.chars().sum();
        return candidateAsciiSum > problemAsciiSum;
    }
}
