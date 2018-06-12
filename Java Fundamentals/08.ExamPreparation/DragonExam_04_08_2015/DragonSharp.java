package ExamPreparation.DragonExam_04_08_2015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DragonSharp {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String regex = "^((?<if>if \\((?<first>\\d+)(?<condition>==|>|<)(?<second>\\d+)\\))|(?<else>else))(?<loop> loop (?<loopCount>\\d+))? out \"(?<output>.+)\";$";
        Pattern pattern = Pattern.compile(regex);
        boolean prevWasFalse = false;
        StringBuilder sb = new StringBuilder();
        for (int line = 1; line <= n; line++) {
            String input = reader.readLine();
            Matcher matcher = pattern.matcher(input);
            if (!matcher.matches()) {
                System.out.printf("Compile time error @ line %d%n", line);
                return;
            }
            if (matcher.group("if") != null) {
                if (statementIsTrue(matcher)) {
                    sb.append(getOutput(matcher));
                    prevWasFalse = false;
                } else {
                    prevWasFalse = true;
                }
            } else if (prevWasFalse) {
                sb.append(getOutput(matcher));
            }
        }
        System.out.print(sb);
    }

    private static String getOutput(Matcher matcher) {
        StringBuilder sb = new StringBuilder();
        String output = matcher.group("output");
        if (matcher.group("loop") == null) {
            sb.append(output).append(System.lineSeparator());
        } else {
            int count = Integer.parseInt(matcher.group("loopCount"));
            for (int i = 0; i < count; i++) {
                sb.append(output).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    private static boolean statementIsTrue(Matcher matcher) {
        int firstNum = Integer.parseInt(matcher.group("first"));
        int secondNum = Integer.parseInt(matcher.group("second"));
        switch (matcher.group("condition")) {
            case "<":
                return firstNum < secondNum;
            case ">":
                return firstNum > secondNum;
            default:
                return firstNum == secondNum;
        }
    }
}
