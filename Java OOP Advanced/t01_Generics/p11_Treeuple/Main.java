package t01_Generics.p11_Treeuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = reader.readLine().split("\\s+");
        String firstName = tokens[0];
        String lastName = tokens[1];
        String address = tokens[2];
        String town = tokens[3];
        Treeuple<Tuple<String, String>, String, String> nameAndAddress =
                new Treeuple<>(new Tuple<>(firstName, lastName), address, town);

        tokens = reader.readLine().split("\\s+");
        String name = tokens[0];
        int liters = Integer.parseInt(tokens[1]);
        boolean isDrunk = tokens[2].equals("drunk");
        Treeuple<String, Integer, Boolean> nameLitersDrunk = new Treeuple<>(name, liters, isDrunk);

        tokens = reader.readLine().split("\\s+");
        name = tokens[0];
        double balance = Double.parseDouble(tokens[1]);
        String bankName = tokens[2];
        Treeuple<String, Double, String> nameBalanceBank = new Treeuple<>(name, balance, bankName);

        System.out.printf("%s %s -> %s -> %s%n"
                , nameAndAddress.getFirstItem().getFirstItem()
                , nameAndAddress.getFirstItem().getSecondItem()
                , nameAndAddress.getSecondItem()
                , nameAndAddress.getThirdItem());

        System.out.printf("%s -> %d -> %s%n"
                , nameLitersDrunk.getFirstItem()
                , nameLitersDrunk.getSecondItem()
                , nameLitersDrunk.getThirdItem());

        System.out.printf("%s -> %s -> %s%n"
                , nameBalanceBank.getFirstItem()
                , nameBalanceBank.getSecondItem()
                , nameBalanceBank.getThirdItem());
    }
}
