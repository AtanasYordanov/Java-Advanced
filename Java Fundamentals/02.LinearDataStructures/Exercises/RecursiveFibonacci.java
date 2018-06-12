package LinearDataStructures.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RecursiveFibonacci {

    private static long[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        memo = new long[n + 2];
        System.out.println(fib(n + 1));
    }

    private static long fib(int n) {
        if (n <= 2) {
            return 1;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = fib(n - 1) + fib(n - 2);
        return memo[n];
    }
}
