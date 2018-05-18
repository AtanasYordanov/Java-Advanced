package LinearDataStructures.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaximumSumOf2x2Submatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = reader.readLine().split(", ");
        int rows = Integer.parseInt(tokens[0]);
        int cols = Integer.parseInt(tokens[1]);
        int[][] matrix = new int[rows][cols];
        fillMatrix(reader, rows, cols, matrix);
        int bestSum = 0;
        int startRow = -1;
        int startCol = -1;
        for (int row = 0; row < rows - 1; row++) {
            for (int col = 0; col < cols - 1; col++) {
                int sum = matrix[row][col];
                sum += matrix[row + 1][col];
                sum += matrix[row][col + 1];
                sum += matrix[row + 1][col + 1];
                if (sum > bestSum) {
                    bestSum = sum;
                    startRow = row;
                    startCol = col;
                }
            }
        }
        printOutput(matrix, bestSum, startRow, startCol);
    }

    private static void printOutput(int[][] matrix, int bestSum, int startRow, int startCol) {
        for (int row = startRow; row < startRow + 2; row++) {
            for (int col = startCol; col < startCol + 2; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println(bestSum);
    }

    private static void fillMatrix(BufferedReader reader, int rows, int cols, int[][] matrix) throws IOException {
        String[] tokens;
        for (int row = 0; row < rows; row++) {
            tokens = reader.readLine().split(", ");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Integer.parseInt(tokens[col]);
            }
        }
    }
}
