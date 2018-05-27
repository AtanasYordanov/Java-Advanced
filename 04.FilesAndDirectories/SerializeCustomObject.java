package FilesAndDirectories;

import java.io.*;

public class SerializeCustomObject {

    private static final String PATH = "./src/FilesAndDirectories/resources/course.ser";

    public static void main(String[] args) {
        Course course = new Course("Java Advanced", 100);
        try (FileOutputStream fos = new FileOutputStream(PATH);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(course);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileInputStream fis = new FileInputStream(PATH);
             ObjectInputStream oos = new ObjectInputStream(fis)) {
            Course deserializedObject = (Course) oos.readObject();
            System.out.println(deserializedObject);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static class Course implements Serializable {
        private String name;
        private int studentsCount;

        Course(String name, int studentsCount) {
            this.name = name;
            this.studentsCount = studentsCount;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getStudentsCount() {
            return studentsCount;
        }

        public void setStudentsCount(int studentsCount) {
            this.studentsCount = studentsCount;
        }

        @Override
        public String toString() {
            return this.name + " -> " + this.studentsCount;
        }
    }
}
