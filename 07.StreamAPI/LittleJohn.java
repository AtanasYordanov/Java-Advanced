package StreamAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LittleJohn {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int smallArrows = 0, mediumArrows = 0, largeArrows = 0;
        String regex = "(>-{5}>)|(>{2}-{5}>)|(>{3}-{5}>{2})";
        Pattern pattern = Pattern.compile(regex);
        for (int i = 0; i < 4; i++) {
            String line = reader.readLine();
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                if (matcher.group(3) != null) {
                    largeArrows++;
                } else if (matcher.group(2) != null) {
                    mediumArrows++;
                } else {
                    smallArrows++;
                }
            }
        }
        int number = smallArrows * 100 + mediumArrows * 10 + largeArrows;
        String binaryString = Integer.toBinaryString(number);
        String reversedBinaryString = new StringBuilder(binaryString).reverse().toString();
        String finalBinaryString = binaryString + reversedBinaryString;
        int result = Integer.parseInt(finalBinaryString, 2);
        System.out.println(result);
    }
}