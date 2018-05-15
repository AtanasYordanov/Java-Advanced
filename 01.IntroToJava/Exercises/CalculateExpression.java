package IntroToJava.Exercises;

import java.util.Scanner;

public class CalculateExpression {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double a = scan.nextDouble();
        double b = scan.nextDouble();
        double c = scan.nextDouble();
        double f1 = calcF1(a, b, c);
        double f2 = calcF2(a, b, c);
        double diff = Math.abs((a + b + c) / 3 - (f1 + f2) / 2);
        System.out.printf("F1 result: %.2f; F2 result: %.2f; Diff: %.2f%n", f1, f2, diff);
    }

    private static double calcF1(double a, double b, double c) {
        double power = (a + b + c) / Math.sqrt(c);
        return Math.pow((a * a + b * b) / (a * a - b * b), power);
    }

    private static double calcF2(double a, double b, double c) {
        double power = (a - b);
        return Math.pow((a * a + b * b - c * c * c), power);
    }
}
