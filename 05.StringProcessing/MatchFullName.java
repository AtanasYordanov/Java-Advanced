package StringProcessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MatchFullName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String regex = "^[A-Z][a-z]+ [A-Z][a-z]+$";
        StringBuilder sb = new StringBuilder();
        for (String input = reader.readLine(); !input.equals("end"); input = reader.readLine()) {
            if (input.matches(regex)) {
                sb.append(input).append(System.lineSeparator());
            }
        }
        System.out.print(sb);
    }
}
