package ExamPreparation.Exam_03_05_2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ChessKnight {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[][] board = new String[8][8];
        for (int i = 0; i < 8; i++) {
            String[] tokens = reader.readLine().split("\\|");
            System.arraycopy(tokens, 0, board[i], 0, 8);
        }
        String[] startingPosition = reader.readLine().split("");
        int knightRow = Integer.parseInt(startingPosition[0]);
        int knightCol = Integer.parseInt(startingPosition[1]);
        int invalidCount = 0, outOfBoundsCount = 0;
        List<String> piecesTaken = new ArrayList<>();
        for (String line = reader.readLine(); !line.equals("END"); line = reader.readLine()) {
            String[] tokens = line.split(" -> ");
            String[] currentPosition = tokens[0].split("");
            String[] targetPosition = tokens[1].split("");
            int currentRow = Integer.parseInt(currentPosition[0]);
            int currentCol = Integer.parseInt(currentPosition[1]);
            if (currentRow != knightRow || currentCol != knightCol) {
                continue;
            }
            int targetRow = Integer.parseInt(targetPosition[0]);
            int targetCol = Integer.parseInt(targetPosition[1]);
            if (!isValid(knightRow, knightCol, targetRow, targetCol)) {
                invalidCount++;
            } else if (!isInBounds(targetRow, targetCol)) {
                outOfBoundsCount++;
            } else {
                if (!board[targetRow][targetCol].equals(" ")) {
                    piecesTaken.add(board[targetRow][targetCol]);
                }
                board[targetRow][targetCol] = " ";
                knightRow = targetRow;
                knightCol = targetCol;
            }
        }
        System.out.printf("Pieces take: %s%n", String.join(", ", piecesTaken));
        System.out.printf("Invalid moves: %d%n", invalidCount);
        System.out.printf("Board out moves: %d%n", outOfBoundsCount);
    }

    private static boolean isInBounds(int row, int col) {
        return row >= 0 && row < 8 && col >= 0 && col < 8;
    }

    private static boolean isValid(int knightRow, int knightCol, int row, int col) {
        return (Math.abs(knightRow - row) == 1 && Math.abs(knightCol - col) == 2)
                || (Math.abs(knightRow - row) == 2 && Math.abs(knightCol - col) == 1);
    }
}
