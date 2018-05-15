package IntroToJava.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TransportPrice {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int kilometers = Integer.parseInt(reader.readLine());
        String timeOfDay = reader.readLine();
        double total = 0D;
        if (kilometers < 20) {
            total += 0.7;
            if (timeOfDay.equals("day")) {
                total += kilometers * 0.79;
            } else {
                total += kilometers * 0.90;
            }
        } else if (kilometers < 100) {
            total += kilometers * 0.09;
        } else {
            total += kilometers * 0.06;
        }
        System.out.printf("%.2f%n", total);
    }
}
