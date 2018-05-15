package IntroToJava.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class EuroTrip {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double quantity = Double.parseDouble(reader.readLine());
        BigDecimal result = new BigDecimal(quantity * 1.2).multiply(new BigDecimal("4210500000000"));
        System.out.printf("%.2f marks%n", result);
    }
}
