package ExamPreparation.Exam_19_02_2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Shockwave {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] dimensions = reader.readLine().split(" ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);
        int[][] matrix = new int[rows][cols];
        for (String input = reader.readLine(); !input.equals("Here We Go"); input = reader.readLine()) {
            String[] tokens = input.split(" ");
            int x1 = Integer.parseInt(tokens[0]);
            int y1 = Integer.parseInt(tokens[1]);
            int x2 = Integer.parseInt(tokens[2]);
            int y2 = Integer.parseInt(tokens[3]);
            for (int row = x1; row <= x2; row++) {
                for (int col = y1; col <= y2; col++) {
                    matrix[row][col]++;
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
}
