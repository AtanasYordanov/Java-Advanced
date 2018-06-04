package ExamPreparation.DHARMA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DharmaSonarFence {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (String input = reader.readLine(); !input.equals("Reprogram"); input = reader.readLine()) {
            int num = Integer.parseInt(input);
            for (int i = 31; i >= 1; i--) {
                if (getBit(num, i) == getBit(num, i - 1)) {
                    num = flipBit(num, i);
                    num = flipBit(num, i - 1);
                    i--;
                }
            }
            System.out.println(Integer.toUnsignedString(num));
        }
    }

    private static int flipBit(int number, int position) {
        int mask = 1 << position;
        return number ^ mask;
    }

    private static int getBit(int number, int position) {
        int mask = number >> position;
        return mask & 1;
    }
}
