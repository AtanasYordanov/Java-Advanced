package IntroToJava.Lab;

import java.util.Scanner;

public class ModifyABit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        int position = scan.nextInt();
        int bit = scan.nextInt();
        int result;
        if (bit == 0) {
            int mask = ~(1 << position);
            result = number & mask;
        } else {
            int mask = 1 << position;
            result = number | mask;
        }
        System.out.println(result);
    }
}
