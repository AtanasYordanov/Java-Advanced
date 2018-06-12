package IntroToJava.Exercises;


import java.util.Scanner;

public class FormattingNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        double b = scan.nextDouble();
        double c = scan.nextDouble();
        String aAsHex = addPaddingAfter(String.format("%X", a));
        String aAsBinary = String.format("%010d", Integer.valueOf(Integer.toBinaryString(a)));
        String bFormatted = addPaddingBefore(String.format("%.2f", b));
        String cFormatted = addPaddingAfter(String.format("%.3f", c));
        System.out.printf("|%s|%s|%s|%s|%n", aAsHex, aAsBinary, bFormatted, cFormatted);
    }

    private static String addPaddingBefore(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(str);
        for (int i = length; i < 10; i++) {
            sb.insert(0, " ");
        }
        return sb.toString();
    }

    private static String addPaddingAfter(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(str);
        for (int i = length; i < 10; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }
}
