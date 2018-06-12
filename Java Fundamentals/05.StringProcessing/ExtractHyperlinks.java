package StringProcessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractHyperlinks {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (String line = reader.readLine(); !line.equals("END"); line = reader.readLine()) {
            sb.append(line);
        }
        String text = sb.toString();
        sb = new StringBuilder();
        int fromIndex = 0;
        for (int index = text.indexOf("<", fromIndex); index >= 0; index = text.indexOf("<", fromIndex)) {
            int endIndex = text.indexOf(">", index + 1);
            String subText = text.substring(index + 1, endIndex);
            if (subText.startsWith("!--")) {
                fromIndex = index + 1;
                continue;
            }
            if (subText.charAt(0) == 'a') {
                String regex = "href\\s*=\\s*(\"|')(.+?)(\\1)";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(subText);
                if (matcher.find()) {
                    sb.append(matcher.group(2)).append(System.lineSeparator());
                } else {
                    regex = "href\\s*=\\s*([^\\s]+)";
                    if (subText.matches(regex)) {
                        sb.append(matcher.group(1)).append(System.lineSeparator());
                    }
                }
            }
            fromIndex = endIndex + 1;
        }
        System.out.print(sb);
    }
}
