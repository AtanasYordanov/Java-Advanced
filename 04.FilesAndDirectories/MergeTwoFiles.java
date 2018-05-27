package FilesAndDirectories;

import java.io.*;

public class MergeTwoFiles {

    private static final String FIRST_FILE_INPUT_PATH = "./src/FilesAndDirectories/resources/inputOne.txt";
    private static final String SECOND_FILE_INPUT_PATH = "./src/FilesAndDirectories/resources/inputTwo.txt";
    private static final String OUTPUT_PATH = "./src/FilesAndDirectories/resources/output.txt";

    public static void main(String[] args) {
        try (BufferedReader firstReader = new BufferedReader(new FileReader(FIRST_FILE_INPUT_PATH));
             BufferedReader secondReader = new BufferedReader(new FileReader(SECOND_FILE_INPUT_PATH));
             PrintWriter writer = new PrintWriter(new FileWriter(OUTPUT_PATH, false))) {

            for (String line = firstReader.readLine(); line != null; line = firstReader.readLine()) {
                writer.println(line);
            }
            for (String line = secondReader.readLine(); line != null; line = secondReader.readLine()) {
                writer.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
