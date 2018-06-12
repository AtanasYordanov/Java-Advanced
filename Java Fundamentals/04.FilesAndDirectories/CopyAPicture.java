package FilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyAPicture {

    private static final String PICTURE_PATH = "./src/FilesAndDirectories/resources/picture.jpg/";
    private static final String PICTURE_COPY_PATH = "./src/FilesAndDirectories/resources/picture-copy.jpg";

    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream(PICTURE_PATH);
             FileOutputStream fos = new FileOutputStream(PICTURE_COPY_PATH)) {
            for (int oneByte = fis.read(); oneByte != -1; oneByte = fis.read()) {
                fos.write(oneByte);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
