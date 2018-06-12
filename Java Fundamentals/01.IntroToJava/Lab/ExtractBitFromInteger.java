package IntroToJava.Lab;

import java.io.IOException;
import java.util.Scanner;

public class ExtractBitFromInteger {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        int position = scan.nextInt();
        int mask = number >> position;
        int bit = mask & 1;
        System.out.println(bit);
    }
}
