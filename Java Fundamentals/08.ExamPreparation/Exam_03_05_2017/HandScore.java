package ExamPreparation.Exam_03_05_2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HandScore {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] cards = reader.readLine().split(" ");
        int sum = 0;
        int currentSum = 0;
        int sequenceLength = 1;
        String previousSuit = "";
        for (String card : cards) {
            String suit = card.substring(card.length() - 1);
            String face = card.substring(0, card.length() - 1);
            int value = getFaceValue(face);
            if (suit.equals(previousSuit)) {
                currentSum += value;
                sequenceLength++;
            } else {
                sum += currentSum * sequenceLength;
                currentSum = value;
                sequenceLength = 1;
                previousSuit = suit;
            }
        }
        sum += currentSum * sequenceLength;
        System.out.println(sum);
    }

    private static int getFaceValue(String face) {
        switch (face) {
            case "J":
                return 12;
            case "Q":
                return 13;
            case "K":
                return 14;
            case "A":
                return 15;
            default:
                return Integer.parseInt(face);
        }
    }
}
