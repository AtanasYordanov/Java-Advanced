package t01_Generics.p10_Tuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String [] tokens = reader.readLine().split("\\s+");
        String firstName = tokens[0];
        String lastName = tokens[1];
        String address = tokens[2];
        Tuple<Tuple<String, String>, String> nameAndAddress =
                new Tuple<>(new Tuple<>(firstName, lastName), address);

        tokens = reader.readLine().split("\\s+");
        String name = tokens[0];
        int liters = Integer.parseInt(tokens[1]);
        Tuple<String, Integer> nameAndLiters = new Tuple<>(name, liters);

        tokens = reader.readLine().split("\\s+");
        int number = Integer.parseInt(tokens[0]);
        double floatingNumber = Double.parseDouble(tokens[1]);
        Tuple<Integer, Double> numbers = new Tuple<>(number, floatingNumber);

        System.out.printf("%s %s -> %s%n"
                , nameAndAddress.getFirstItem().getFirstItem()
                , nameAndAddress.getFirstItem().getSecondItem()
                , nameAndAddress.getSecondItem());

        System.out.printf("%s -> %d%n"
                , nameAndLiters.getFirstItem()
                , nameAndLiters.getSecondItem());

        System.out.printf("%d -> %s%n"
                , numbers.getFirstItem()
                , numbers.getSecondItem());

    }
}
