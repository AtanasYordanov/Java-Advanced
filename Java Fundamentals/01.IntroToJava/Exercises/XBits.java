package IntroToJava.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class XBits {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = new int[8];
        for (int i = 0; i < 8; i++) {
            numbers[i] = Integer.parseInt(reader.readLine());
        }
        int count = 0;
        for (int i = 1; i < 7; i++) {
            for (int j = 1; j < 31; j++) {
                if (isValid(numbers, i, j)) {
                    count++;
                    j++;
                }
            }
        }
        System.out.println(count);
    }

    private static boolean isValid(int[] numbers, int i, int j) {
        return getBit(numbers[i], j) == 1
                && getBit(numbers[i - 1], j - 1) == 1
                && getBit(numbers[i - 1], j + 1) == 1
                && getBit(numbers[i + 1], j - 1) == 1
                && getBit(numbers[i + 1], j + 1) == 1
                && getBit(numbers[i - 1], j) == 0
                && getBit(numbers[i + 1], j) == 0
                && getBit(numbers[i], j - 1) == 0
                && getBit(numbers[i], j + 1) == 0;
    }

    private static int getBit(int number, int position) {
        int mask = number >> position;
        return mask & 1;
    }
}