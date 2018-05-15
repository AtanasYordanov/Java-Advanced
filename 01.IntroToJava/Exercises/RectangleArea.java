package IntroToJava.Exercises;

import java.io.IOException;
import java.util.Scanner;

public class RectangleArea {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        double a = scan.nextDouble();
        double b = scan.nextDouble();
        double area = a * b;
        System.out.printf("%.2f%n", area);
    }
}
