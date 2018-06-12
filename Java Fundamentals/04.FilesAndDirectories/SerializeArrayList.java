package FilesAndDirectories;

import java.io.*;
import java.util.List;

public class SerializeArrayList {

    private static final String PATH = "./src/FilesAndDirectories/resources/list.ser";

    public static void main(String[] args) {
        List<Double> list = List.of(1.2, 2.3, 6.4, 8.8);
        try (FileOutputStream fos = new FileOutputStream(PATH);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileInputStream fis = new FileInputStream(PATH);
             ObjectInputStream oos = new ObjectInputStream(fis)) {
            List<Double> deserializedList = (List<Double>) oos.readObject();
            for (Double num : deserializedList) {
                System.out.println(num);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
