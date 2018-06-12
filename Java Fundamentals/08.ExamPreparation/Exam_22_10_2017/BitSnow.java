package ExamPreparation.Exam_22_10_2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BitSnow {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = reader.readLine().split(", ");
        int[] numbers = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            numbers[i] = Integer.parseInt(tokens[i]);
        }
        for (int i = tokens.length - 2; i >= 0; i--) {
            for (int j = 0; j < 16; j++) {
                int index = i;
                if (getBit(numbers[index], j) == 1) {
                    while (index < tokens.length - 1 && getBit(numbers[index + 1], j) == 0) {
                        index++;
                    }
                }
                if (index > i) {
                    numbers[i] = flipBit(numbers[i], j);
                    numbers[index] = flipBit(numbers[index], j);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int number : numbers) {
            sb.append(number).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        System.out.println(sb);
    }

    private static int getBit(int number, int position) {
        int mask = number >> position;
        return mask & 1;
    }

    private static int flipBit(int number, int position) {
        int mask = 1 << position;
        return number ^ mask;
    }
}