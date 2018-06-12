package LinearDataStructures.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EncryptSortAndPrintArray {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] sums = new int[n];
        for (int i = 0; i < n; i++) {
            String input = reader.readLine();
            int sum = 0;
            int length = input.length();
            for (int j = 0; j < length; j++) {
                char ch = input.charAt(j);
                sum += isVowel(ch) ? ch * length : ch / length;
            }
            sums[i] = sum;
        }
        Arrays.sort(sums);
        for (int sum : sums) {
            System.out.println(sum);
        }
    }

    private static boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
