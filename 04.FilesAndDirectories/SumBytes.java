package FilesAndDirectories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SumBytes {

    private static final String PATH = "./src/FilesAndDirectories/resources/input.txt";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(PATH))) {
            int sum = 0;
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                for (char ch : line.toCharArray()) {
                    sum += ch;
                }
            }
            System.out.println(sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
