package LinearDataStructures.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FillTheMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = reader.readLine().split(", ");
        int size = Integer.parseInt(tokens[0]);
        String type = tokens[1];
        int[][] matrix = new int[size][size];
        int counter = 1;
        fillMatrix(size, type, matrix, counter);
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                sb.append(matrix[row][col]).append(" ");
            }
            sb.append(System.lineSeparator());
        }
        System.out.print(sb);
    }

    private static void fillMatrix(int size, String type, int[][] matrix, int counter) {
        for (int col = 0; col < size; col++) {
            for (int row = 0; row < size; row++) {
                if (type.equals("A") || col % 2 == 0) {
                    matrix[row][col] = counter++;
                } else {
                    matrix[size - row - 1][col] = counter++;
                }
            }
        }
    }
}
