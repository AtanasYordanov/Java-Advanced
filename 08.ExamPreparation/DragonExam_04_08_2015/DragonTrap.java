package ExamPreparation.DragonExam_04_08_2015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DragonTrap {

    private static char[][] originalMatrix;
    private static char[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int rows = Integer.parseInt(reader.readLine());
        initializeMatrices(reader, rows);
        for (String input = reader.readLine(); !input.equals("End"); input = reader.readLine()) {
            String[] tokens = input.split(" ");
            int dragonRow = Integer.parseInt(tokens[0].substring(1));
            int dragonCol = Integer.parseInt(tokens[1].substring(0, tokens[1].length() - 1));
            int radius = Integer.parseInt(tokens[2]);
            int rotations = Integer.parseInt(tokens[3]);
            rotateMatrix(dragonRow, dragonCol, radius, rotations);
        }
        printOutput(rows);
    }

    private static void printOutput(int rows) {
        StringBuilder sb = new StringBuilder();
        int changedCount = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                sb.append(matrix[row][col]);
                if (matrix[row][col] != originalMatrix[row][col]) {
                    changedCount++;
                }
            }
            sb.append(System.lineSeparator());
        }
        sb.append("Symbols changed: ").append(changedCount);
        System.out.println(sb);
    }

    private static void initializeMatrices(BufferedReader reader, int rows) throws IOException {
        matrix = new char[rows][rows];
        originalMatrix = new char[rows][rows];
        for (int row = 0; row < rows; row++) {
            String input = reader.readLine();
            originalMatrix[row] = input.toCharArray();
            matrix[row] = input.toCharArray();
        }
    }

    private static void rotateMatrix(int dragonRow, int dragonCol, int radius, int rotations) {
        List<int[]> cellsQueue = fillCellsQueue(dragonRow, dragonCol, radius);
        if (cellsQueue.isEmpty()) {
            return;
        }
        if (rotations > 0) {
            rotateRight(cellsQueue, rotations);
        } else {
            rotateLeft(cellsQueue, -rotations);
        }
    }

    private static List<int[]> fillCellsQueue(int dragonRow, int dragonCol, int radius) {
        List<int[]> cellsQueue = new ArrayList<>();
        // Add the cells from the upper row
        int currentRow = dragonRow - radius;
        if (currentRow >= 0 && currentRow < matrix.length) {
            int start = Math.max(0, dragonCol - radius);
            int end = Math.min(matrix[0].length - 1, dragonCol + radius);
            for (int col = start; col <= end; col++) {
                cellsQueue.add(new int[]{currentRow, col});
            }
        }
        // Add the cells from the right column
        int currentCol = dragonCol + radius;
        if (currentCol >= 0 && currentCol < matrix[0].length) {
            int start = Math.max(0, dragonRow - radius + 1);
            int end = Math.min(matrix.length - 1, dragonRow + radius);
            for (int row = start; row <= end; row++) {
                cellsQueue.add(new int[]{row, currentCol});
            }
        }
        // Add the cells from the bottom row
        currentRow = dragonRow + radius;
        if (currentRow >= 0 && currentRow < matrix.length) {
            int start = Math.min(matrix[0].length - 1, dragonCol + radius - 1);
            int end = Math.max(0, dragonCol - radius);
            for (int col = start; col >= end; col--) {
                cellsQueue.add(new int[]{currentRow, col});
            }
        }
        // Add the cells from the left column
        currentCol = dragonCol - radius;
        if (currentCol >= 0 && currentCol < matrix[0].length) {
            int start = Math.min(matrix.length - 1, dragonRow + radius - 1);
            int end = Math.max(0, dragonRow - radius);
            for (int row = start; row >= end; row--) {
                cellsQueue.add(new int[]{row, currentCol});
            }
        }
        // Remove the first cell if added twice
        if (cellsQueue.size() > 1) {
            int[] first = cellsQueue.get(0);
            int[] last = cellsQueue.get(cellsQueue.size() - 1);
            if (first[0] == last[0] && first[1] == last[1]) {
                cellsQueue.remove(cellsQueue.size() - 1);
            }
        }
        return cellsQueue;
    }

    private static void rotateRight(List<int[]> cellsQueue, int rotations) {
        char[] replacements = new char[cellsQueue.size()];
        for (int j = 0; j < cellsQueue.size(); j++) {
            int rotationDiff = j - rotations % cellsQueue.size();
            int nextIndex = rotationDiff >= 0 ? rotationDiff : cellsQueue.size() + rotationDiff;
            int[] next = cellsQueue.get(nextIndex);
            replacements[j] = matrix[next[0]][next[1]];
        }
        for (int i = 0; i < replacements.length; i++) {
            int[] current = cellsQueue.get(i);
            matrix[current[0]][current[1]] = replacements[i];
        }
    }

    private static void rotateLeft(List<int[]> cellsQueue, int rotations) {
        char[] replacements = new char[cellsQueue.size()];
        for (int j = 0; j < cellsQueue.size(); j++) {
            int rotationDiff = (j + rotations % cellsQueue.size()) % cellsQueue.size();
            int nextIndex = rotationDiff >= 0 ? rotationDiff : cellsQueue.size() - rotationDiff;
            int[] next = cellsQueue.get(nextIndex);
            replacements[j] = matrix[next[0]][next[1]];
        }
        for (int i = 0; i < replacements.length; i++) {
            int[] current = cellsQueue.get(i);
            matrix[current[0]][current[1]] = replacements[i];
        }
    }
}