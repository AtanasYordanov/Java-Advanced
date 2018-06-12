package LinearDataStructures.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DiagonalDifference {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(reader.readLine());
        int[][] matrix = new int[size][size];
        fillMatrix(reader, size, matrix);
        int firstDiagonal = 0;
        int secondDiagonal = 0;
        for (int index = 0; index < size; index++) {
            firstDiagonal += matrix[index][index];
            secondDiagonal += matrix[index][size - index - 1];
        }
        int diff = Math.abs(firstDiagonal - secondDiagonal);
        System.out.println(diff);
    }

    private static void fillMatrix(BufferedReader reader, int size, int[][] matrix) throws IOException {
        for (int row = 0; row < size; row++) {
            String[] line = reader.readLine().split(" ");
            for (int col = 0; col < size; col++) {
                matrix[row][col] = Integer.parseInt(line[col]);
            }
        }
    }
}
