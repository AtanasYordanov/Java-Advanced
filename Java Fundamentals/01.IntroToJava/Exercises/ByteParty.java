package IntroToJava.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ByteParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] numbers = new int[n];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(reader.readLine());
        }
        for (String line = reader.readLine(); !line.equals("party over"); line = reader.readLine()) {
            String[] tokens = line.split("\\s+");
            int command = Integer.parseInt(tokens[0]);
            int position = Integer.parseInt(tokens[1]);
            for (int i = 0; i < numbers.length; i++) {
                if (command == 0) {
                    numbers[i] = changeToZero(numbers[i], position);
                } else if (command == 1) {
                    numbers[i] = changeToOne(numbers[i], position);
                } else {
                    numbers[i] = flipBit(numbers[i], position);
                }
            }
        }
        for (int number : numbers) {
            System.out.println(number);
        }
    }

    private static int flipBit(int number, int position) {
        int mask = 1 << position;
        return number ^ mask;
    }

    private static int changeToOne(int number, int position) {
        int mask = 1 << position;
        return number | mask;
    }

    private static int changeToZero(int number, int position) {
        int mask = ~(1 << position);
        return number & mask;
    }
}
