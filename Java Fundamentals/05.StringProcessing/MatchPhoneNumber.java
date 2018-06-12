package StringProcessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MatchPhoneNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String regex = "^\\+359( |-)2(\\1)\\d{3}(\\1)\\d{4}$";
        StringBuilder sb = new StringBuilder();
        for (String line = reader.readLine(); !line.equals("end"); line = reader.readLine()) {
            if (line.matches(regex)) {
                sb.append(line).append(System.lineSeparator());
            }
        }
        System.out.print(sb);
    }
}
