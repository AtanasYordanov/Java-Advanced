package LinearDataStructures.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StringMatrixRotation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        int rotation = Integer.parseInt(input.substring(input.indexOf("(") + 1, input.indexOf(")")));
        rotation %= 360;
        List<String> lines = new ArrayList<>();
        for (String line = reader.readLine(); !line.equals("END"); line = reader.readLine()) {
            lines.add(line);
        }
        int maxLength = 0;
        for (String line : lines) {
            int length = line.length();
            if (length > maxLength){
                maxLength = length;
            }
        }
        char[][] matrix = fillMatrix(lines, maxLength);
        StringBuilder sb = new StringBuilder();
        switch (rotation){
            case 0:
                append0(matrix, sb);
                break;
            case 90:
                append90(matrix, sb);
                break;
            case 180:
                append180(matrix, sb);
                break;
            case 270:
                append270(matrix, sb);
                break;
        }
        System.out.println(sb);
    }

    private static char[][] fillMatrix(List<String> lines, int maxLength) {
        char[][] matrix = new char[lines.size()][maxLength];
        for (int row = 0; row < lines.size(); row++) {
            String line = lines.get(row);
            for (int col = 0; col < maxLength; col++) {
                if (col < line.length()){
                    matrix[row][col] = line.charAt(col);
                }else{
                    matrix[row][col] = ' ';
                }
            }
        }
        return matrix;
    }

    private static void append270(char[][] matrix, StringBuilder sb) {
        for (int col = 0; col < matrix[0].length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                sb.append(matrix[row][matrix[0].length- col - 1]);
            }
            sb.append(System.lineSeparator());
        }
    }

    private static void append180(char[][] matrix, StringBuilder sb) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                sb.append(matrix[matrix.length - row - 1][matrix[0].length -col-1]);
            }
            sb.append(System.lineSeparator());
        }
    }

    private static void append90(char[][] matrix, StringBuilder sb) {
        for (int col = 0; col < matrix[0].length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                sb.append(matrix[matrix.length - row - 1][col]);
            }
            sb.append(System.lineSeparator());
        }
    }

    private static void append0(char[][] matrix, StringBuilder sb) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                sb.append(matrix[row][col]);
            }
            sb.append(System.lineSeparator());
        }
    }
}
