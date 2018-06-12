package ExamPreparation.Exam_19_02_2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ascent {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> memo = new LinkedHashMap<>();
        String regex = "[,_]([a-zA-Z]+)(\\d)";
        Pattern pattern = Pattern.compile(regex);
        for (String line = reader.readLine(); !line.equals("Ascend"); line = reader.readLine()) {
            for (Map.Entry<String, String> pair : memo.entrySet()) {
                line = line.replaceAll(pair.getKey(), pair.getValue());
            }
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                String match = matcher.group(0);
                int digit = Integer.parseInt(matcher.group(2));
                StringBuilder sb = new StringBuilder();
                String body = matcher.group(1);
                if (match.charAt(0) == ',') {
                    for (int i = 0; i < body.length(); i++) {
                        sb.append((char) (body.charAt(i) + digit));
                    }
                } else {
                    for (int i = 0; i < body.length(); i++) {
                        sb.append((char) (body.charAt(i) - digit));
                    }
                }
                String decodedString = sb.toString();
                line = line.replaceAll(match, decodedString);
                memo.put(match, decodedString);
            }
            System.out.println(line);
        }
    }
}