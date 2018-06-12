package ExamPreparation.Exam_22_10_2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExtensions {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder text = new StringBuilder(reader.readLine());

        for (String line = reader.readLine(); !line.equals("Print"); line = reader.readLine()) {
            if (!line.contains("%")) {
                int start = text.indexOf(line);
                while (start >= 0) {
                    String replacement = new StringBuilder(line).reverse().toString();
                    text = text.replace(start, start + replacement.length(), replacement);
                    start = text.indexOf(line, start + line.length());
                }
            } else {
                String regex = line.replace("%", "\\S*");
                regex = regex.replaceAll("\\.", "\\\\.");
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(text);
                while (matcher.find()) {
                    String match = matcher.group(0);
                    int start = text.indexOf(match);
                    String replacement = new StringBuilder(match).reverse().toString();
                    text.replace(start, start + match.length(), replacement);
                }
            }
        }

        System.out.println(text);
    }
}