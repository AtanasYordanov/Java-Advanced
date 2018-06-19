package t03_Inheritance.p04_MordorsCrueltyPlan;

import t03_Inheritance.p04_MordorsCrueltyPlan.constants.FoodConstants;
import t03_Inheritance.p04_MordorsCrueltyPlan.model.foods.*;
import t03_Inheritance.p04_MordorsCrueltyPlan.model.Foods;
import t03_Inheritance.p04_MordorsCrueltyPlan.model.Gandalf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final String SPLIT_DELIMITER = "\\s+";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Gandalf gandalf = new Gandalf();
        String[] tokens = reader.readLine().split(SPLIT_DELIMITER);
        for (String token : tokens) {
            Foods food = createFood(token);
            gandalf.eat(food);
        }
        System.out.println(gandalf.getHappinooessPoints());
        System.out.println(gandalf.getMood());
    }

    private static Foods createFood(String food) {
        food = food.toLowerCase();
        switch (food) {
            case FoodConstants.CRAM:
                return new Cram();
            case FoodConstants.LEMBAS:
                return new Lembas();
            case FoodConstants.APPLE:
                return new Apple();
            case FoodConstants.MELON:
                return new Melon();
            case FoodConstants.HONEY_CAKE:
                return new HoneyCake();
            case FoodConstants.MUSHROOMS:
                return new Mushrooms();
            default:
                return new Foods();
        }
    }
}
