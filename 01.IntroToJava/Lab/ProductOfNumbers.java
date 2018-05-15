package IntroToJava.Lab;

import java.math.BigInteger;
import java.util.Scanner;

public class ProductOfNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int from = scan.nextInt();
        int to = scan.nextInt();
        BigInteger product = BigInteger.ONE;
        for (int i = from; i <= to; i++) {
            product = product.multiply(BigInteger.valueOf(i));
        }
        System.out.printf("product[%d..%d] = %s%n", from, to, product);
    }
}
