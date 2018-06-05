package StreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SortStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> names = new ArrayList<>();
        for (String input = reader.readLine(); !input.equals("END"); input = reader.readLine()) {
            names.add(input);
        }
        names.stream()
                .sorted((a, b) -> {
                    String[] names1 = a.split(" ");
                    String[] names2 = b.split(" ");

                    int comp = names1[1].compareTo(names2[1]);
                    if (comp == 0) {
                        comp = names2[0].compareTo(names1[0]);
                    }
                    return comp;
                })
                .forEach(System.out::println);
    }
}
