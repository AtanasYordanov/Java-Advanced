package LinearDataStructures.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MatrixOfPalindromes {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = reader.readLine().split(" ");
        int rows = Integer.parseInt(tokens[0]);
        int cols = Integer.parseInt(tokens[1]);
        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            char ch = (char) ('a' + row);
            for (int col = 0; col < cols; col++) {
                char middleLetter = (char) (ch + col);
                String cell = String.valueOf(ch) + String.valueOf(middleLetter) + String.valueOf(ch);
                matrix[row][col] = cell;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                sb.append(matrix[row][col]).append(" ");
            }
            sb.append(System.lineSeparator());
        }
        System.out.print(sb);
    }
}
