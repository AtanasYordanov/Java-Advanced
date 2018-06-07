package ExamPreparation.Exam_03_01_2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DharmaSupplies {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Pattern pattern = Pattern.compile("\\[.*?]");
        int totalCrates = 0;
        int inputLines = 0;
        List<String> crates = new ArrayList<>();
        for (String line = reader.readLine(); !line.equals("Collect"); line = reader.readLine()) {
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                crates.add(matcher.group(0));
                totalCrates++;
            }
            inputLines++;
        }
        int n = totalCrates / inputLines;
        String regex = String.format("\\[#(\\d{%1$d}|[a-z]{%1$d})([A-Za-z0-9\\s]+)#\\1]", n);
        pattern = Pattern.compile(regex);
        int validCrates = 0;
        int foodAmount = 0;
        int drinkAmount = 0;
        for (String crate : crates) {
            Matcher matcher = pattern.matcher(crate);
            if (matcher.find()) {
                validCrates++;
                if (Character.isDigit(matcher.group(1).charAt(0))) {
                    int amount = getFoodAmount(matcher);
                    foodAmount += amount;
                } else {
                    int amount = getDrinkAmount(matcher);
                    drinkAmount += amount;
                }
            }
        }
        if (validCrates > 0) {
            System.out.println("Number of supply crates: " + validCrates);
            System.out.println("Amount of food collected: " + foodAmount);
            System.out.println("Amount of drinks collected: " + drinkAmount);
        } else {
            System.out.println("No supplies found!");
        }
    }

    private static int getDrinkAmount(Matcher matcher) {
        int bodySum = 0;
        int tagSum = 0;
        for (char ch : matcher.group(2).toCharArray()) {
            bodySum += ch;
        }
        for (char ch : matcher.group(1).toCharArray()) {
            tagSum += ch;
        }
        return bodySum * tagSum;
    }

    private static int getFoodAmount(Matcher matcher) {
        Set<Character> characters = new HashSet<>();
        String body = matcher.group(2);
        for (char ch : body.toCharArray()) {
            characters.add(ch);
        }
        int sum = 0;
        for (Character ch : characters) {
            sum += ch;
        }
        return sum * matcher.group(1).length();
    }
}