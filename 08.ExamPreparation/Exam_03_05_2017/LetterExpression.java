package ExamPreparation.Exam_03_05_2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LetterExpression {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        String regex = "(.*?)(-?\\d+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        int sum = 0;
        while (matcher.find()) {
            String symbols = matcher.group(1);
            int number = Integer.parseInt(matcher.group(2));
            sum += symbols.length() % 2 == 0 ? number : -number;
        }
        System.out.println(sum);
    }
}
