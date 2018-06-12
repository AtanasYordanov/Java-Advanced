package StringProcessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SumOfAllValues {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String keysString = reader.readLine();
        String textString = reader.readLine();
        String regex = "^(?<start>[a-zA-Z_]+)((\\d.*\\d)|(\\d))(?<end>[a-zA-Z_]+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(keysString);
        if (!matcher.find()) {
            System.out.println("<p>A key is missing</p>");
            return;
        }
        String startKey = matcher.group("start");
        String endKey = matcher.group("end");
        regex = String.format("%s(\\d*(\\.\\d+)?)%s", startKey, endKey);
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(textString);
        double sum = 0D;
        while (matcher.find() && !matcher.group(1).isEmpty()) {
            sum += Double.parseDouble(matcher.group(1));
        }
        if (sum == 0D) {
            System.out.println("<p>The total value is: <em>nothing</em></p>");
        } else if (sum == (int) sum) {
            System.out.printf("<p>The total value is: <em>%.0f</em></p>%n", sum);
        } else {
            System.out.printf("<p>The total value is: <em>%.2f</em></p>%n", sum);
        }
    }
}