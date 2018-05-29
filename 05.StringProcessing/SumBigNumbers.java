package StringProcessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumBigNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String num1 = reader.readLine();
        String num2 = reader.readLine();
        String sum = sumNumbers(num1, num2);
        System.out.println(sum);
    }

    private static String sumNumbers(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int remainder = 0;
        for (int i = 0; i <= Math.max(num1.length(), num2.length()) - 1; i++) {
            int digit1 = num1.length() - 1 - i >= 0 ? num1.charAt(num1.length() - 1 - i) - '0' : 0;
            int digit2 = num2.length() - 1 - i >= 0 ? num2.charAt(num2.length() - 1 - i) - '0' : 0;
            int sum = digit1 + digit2 + remainder;
            if (sum > 9) {
                sb.append(sum % 10);
                remainder = 1;
            } else {
                sb.append(sum);
                remainder = 0;
            }
        }
        if (remainder > 0) {
            sb.append(remainder);
        }
        sb.reverse();
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '0') {
                sb.deleteCharAt(i);
                i--;
            } else {
                break;
            }
        }
        return sb.toString();
    }
}
