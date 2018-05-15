package IntroToJava.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BlurFilter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int blurFilter = Integer.parseInt(reader.readLine());
        String[] tokens = reader.readLine().split(" ");
        int rows = Integer.parseInt(tokens[0]);
        int cols = Integer.parseInt(tokens[1]);
        long[][] matrix = new long[rows][cols];
        for (int row = 0; row < rows; row++) {
            tokens = reader.readLine().split(" ");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Integer.parseInt(tokens[col]);
            }
        }
        tokens = reader.readLine().split(" ");
        int targetRow = Integer.parseInt(tokens[0]);
        int targetCol = Integer.parseInt(tokens[1]);
        for (int row = targetRow - 1; row <= targetRow + 1; row++) {
            for (int col = targetCol - 1; col <= targetCol + 1; col++) {
                if (isInBounds(row, col, matrix)) {
                    matrix[row][col] += blurFilter;
                }
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

    private static boolean isInBounds(int row, int col, long[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length;
    }
}
