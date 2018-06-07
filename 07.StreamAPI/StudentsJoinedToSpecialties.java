package StreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class StudentsJoinedToSpecialties {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<StudentSpecialty> specialties = new ArrayList<>();
        Map<Integer, String> students = new HashMap<>();
        for (String line = reader.readLine(); !line.equals("Students:"); line = reader.readLine()) {
            int index = line.lastIndexOf(" ");
            String name = line.substring(0, index);
            int facultyNumber = Integer.parseInt(line.substring(index + 1));
            specialties.add(new StudentSpecialty(name, facultyNumber));
        }
        for (String line = reader.readLine(); !line.equals("END"); line = reader.readLine()) {
            int index = line.indexOf(" ");
            int facultyNumber = Integer.parseInt(line.substring(0, index));
            String name = line.substring(index + 1);
            students.put(facultyNumber, name);
        }
        specialties.stream()
                .sorted(Comparator.comparing(s -> students.get(s.getFacultyNumber())))
                .forEach(s -> {
                    System.out.printf("%s %d %s%n"
                            , students.get(s.getFacultyNumber())
                            , s.getFacultyNumber()
                            , s.getName());
                });
    }

    private static class StudentSpecialty {
        private String name;
        private int facultyNumber;

        StudentSpecialty(String name, int facultyNumber) {
            this.name = name;
            this.facultyNumber = facultyNumber;
        }

        String getName() {
            return name;
        }

        int getFacultyNumber() {
            return facultyNumber;
        }
    }
}
