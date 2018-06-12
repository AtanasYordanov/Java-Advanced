package LinearDataStructures.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaximalSum {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = reader.readLine().split(" ");
        int rows = Integer.parseInt(tokens[0]);
        int cols = Integer.parseInt(tokens[1]);
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] line = reader.readLine().split(" ");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Integer.parseInt(line[col]);
            }
        }
        int maxSum = Integer.MIN_VALUE;
        int startRow = -1;
        int startCol = -1;
        for (int row = 0; row < rows - 2; row++) {
            for (int col = 0; col < cols - 2; col++) {
                int sum = 0;
                for (int i = row; i < row + 3; i++) {
                    for (int j = col; j < col + 3; j++) {
                        sum += matrix[i][j];
                    }
                }
                if (sum > maxSum) {
                    maxSum = sum;
                    startRow = row;
                    startCol = col;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Sum = ").append(maxSum).append(System.lineSeparator());
        for (int row = startRow; row < startRow + 3; row++) {
            for (int col = startCol; col < startCol + 3; col++) {
                sb.append(matrix[row][col]).append(" ");
            }
            sb.append(System.lineSeparator());
        }
        System.out.print(sb);
    }
}
