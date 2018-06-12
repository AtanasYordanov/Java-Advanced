package IntroToJava.Lab;

import java.util.Scanner;

public class ReadInput {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String first = scan.next("\\w+");
        String second = scan.next("\\w+");
        int num1 = scan.nextInt();
        int num2 = scan.nextInt();
        int num3 = scan.nextInt();
        scan.nextLine();
        String third = scan.nextLine();
        int sum = num1 + num2 + num3;
        System.out.printf("%s %s %s %d%n", first, second, third, sum);
    }
}
