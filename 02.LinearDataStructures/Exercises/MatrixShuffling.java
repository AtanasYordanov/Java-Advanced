package LinearDataStructures.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MatrixShuffling {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = reader.readLine().split(" ");
        int rows = Integer.parseInt(tokens[0]);
        int cols = Integer.parseInt(tokens[1]);
        String[][] matrix = new String[rows][cols];
        fillMatrix(reader, rows, cols, matrix);
        StringBuilder sb = new StringBuilder();
        for (String line = reader.readLine(); !line.equals("END"); line = reader.readLine()) {
            tokens = line.split(" ");
            try {
                int row1 = Integer.parseInt(tokens[1]);
                int col1 = Integer.parseInt(tokens[2]);
                int row2 = Integer.parseInt(tokens[3]);
                int col2 = Integer.parseInt(tokens[4]);
                if (isValid(row1, col1, row2, col2, rows, cols)) {
                    String temp = matrix[row1][col1];
                    matrix[row1][col1] = matrix[row2][col2];
                    matrix[row2][col2] = temp;
                    appendMatrix(sb, matrix);
                } else {
                    sb.append("Invalid input!").append(System.lineSeparator());
                }
            } catch (Exception e) {
                sb.append("Invalid input!").append(System.lineSeparator());
            }
        }
        System.out.println(sb);

    }

    private static void fillMatrix(BufferedReader reader, int rows, int cols, String[][] matrix) throws IOException {
        for (int row = 0; row < rows; row++) {
            String[] line = reader.readLine().split(" ");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = line[col];
            }
        }
    }

    private static void appendMatrix(StringBuilder sb, String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                sb.append(matrix[row][col]).append(" ");
            }
            sb.append(System.lineSeparator());
        }
    }

    private static boolean isValid(int row1, int col1, int row2, int col2, int rows, int cols) {
        return row1 >= 0 && row2 >= 0 && col1 >= 0 && col2 >= 0
                && row1 < rows && row2 < rows && col1 < cols && col2 < cols;
    }
}
