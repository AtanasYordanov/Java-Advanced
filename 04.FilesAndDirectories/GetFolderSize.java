package FilesAndDirectories;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GetFolderSize {

    private static final String DIR_PATH = "./src/FilesAndDirectories/resources/Exercises Resources/";
    private static final String OUTPUT_PATH = "./src/FilesAndDirectories/resources/output.txt";

    public static void main(String[] args) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(OUTPUT_PATH, false))) {
            File folder = new File(DIR_PATH);
            int size = 0;
            File[] files = folder.listFiles();
            for (File file : files) {
                size += file.length();
            }
            writer.println("Folder size: " + size);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
