package Exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Snake {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] commands = reader.readLine().split(",\\s+");
        char[][] matrix = new char[n][n];
        int snakeRow = -1, snakeCol = -1, foodCount = 0, length = 1;
        for (int row = 0; row < n; row++) {
            String[] tokens = reader.readLine().split("\\s+");
            for (int col = 0; col < n; col++) {
                char current = tokens[col].charAt(0);
                matrix[row][col] = current;
                if (current == 's') {
                    snakeRow = row;
                    snakeCol = col;
                } else if (current == 'f') {
                    foodCount++;
                }
            }
        }
        for (String command : commands) {
            switch (command) {
                case "up":
                    snakeRow = snakeRow > 0 ? snakeRow - 1 : n - 1;
                    break;
                case "down":
                    snakeRow = snakeRow < n - 1 ? snakeRow + 1 : 0;
                    break;
                case "left":
                    snakeCol = snakeCol > 0 ? snakeCol - 1 : n - 1;
                    break;
                case "right":
                    snakeCol = snakeCol < n - 1 ? snakeCol + 1 : 0;
                    break;
            }
            if (matrix[snakeRow][snakeCol] == 'e') {
                System.out.println("You lose! Killed by an enemy!");
                return;
            } else if (matrix[snakeRow][snakeCol] == 'f') {
                length++;
                if (--foodCount == 0) {
                    System.out.printf("You win! Final snake length is %d%n", length);
                    return;
                }
                matrix[snakeRow][snakeCol] = '*';
            }
        }
        System.out.printf("You lose! There is still %d food to be eaten.%n", foodCount);
    }
}
