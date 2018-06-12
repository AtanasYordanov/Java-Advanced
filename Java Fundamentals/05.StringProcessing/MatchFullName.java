package StringProcessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MatchFullName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String regex = "^[A-Z][a-z]+ [A-Z][a-z]+$";
        StringBuilder sb = new StringBuilder();
        for (String line = reader.readLine(); !line.equals("end"); line = reader.readLine()) {
            if (line.matches(regex)) {
                sb.append(line).append(System.lineSeparator());
            }
        }
        System.out.print(sb);
    }
}
