package IntroToJava.Lab;

import java.util.Scanner;

public class AverageOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double num1 = scan.nextDouble();
        double num2 = scan.nextDouble();
        double num3 = scan.nextDouble();
        double average = (num1 + num2 + num3) / 3;
        System.out.printf("%.2f", average);
    }
}
