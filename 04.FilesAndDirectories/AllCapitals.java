package FilesAndDirectories;

import java.io.*;

public class AllCapitals {

    private static final String INPUT_PATH = "./src/FilesAndDirectories/resources/input.txt";
    private static final String OUTPUT_PATH = "./src/FilesAndDirectories/resources/output.txt";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_PATH));
             PrintWriter writer = new PrintWriter(new FileWriter(OUTPUT_PATH, false))) {
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                writer.println(line.toUpperCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
