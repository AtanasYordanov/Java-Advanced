package t06_ExamPreparation.Exam_08_05_2017;

import t06_ExamPreparation.Exam_08_05_2017.constants.AvatarCommands;
import t06_ExamPreparation.Exam_08_05_2017.constants.Nations;
import t06_ExamPreparation.Exam_08_05_2017.model.Nation;
import t06_ExamPreparation.Exam_08_05_2017.model.benders.*;
import t06_ExamPreparation.Exam_08_05_2017.model.monuments.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Nation> nations = Map.of(
                Nations.AIR, new Nation(Nations.AIR),
                Nations.FIRE, new Nation(Nations.FIRE),
                Nations.WATER, new Nation(Nations.WATER),
                Nations.EARTH, new Nation(Nations.EARTH)
        );
        List<String> wars = new ArrayList<>();

        for (String line = reader.readLine(); !line.equals(AvatarCommands.END); line = reader.readLine()) {
            String[] tokens = line.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case AvatarCommands.CREATE_BENDER:
                    String type = tokens[1];
                    Bender bender = getBender(tokens);
                    nations.get(type).addBender(bender);
                    break;
                case AvatarCommands.CREATE_MONUMENT:
                    type = tokens[1];
                    Monument monument = getMonument(tokens);
                    nations.get(type).addMonument(monument);
                    break;
                case AvatarCommands.STATUS:
                    String nationType = tokens[1];
                    System.out.println(nations.get(nationType));
                    break;
                case AvatarCommands.WAR:
                    nationType = tokens[1];
                    wars.add(nationType);
                    String winner = "";
                    double maxPower = Double.MIN_VALUE;
                    for (Nation nation : nations.values()) {
                        double totalPower = nation.getTotalPower();
                        if (totalPower > maxPower) {
                            maxPower = totalPower;
                            winner = nation.getElement();
                        }
                    }
                    String finalWinner = winner;
                    nations.values().stream()
                            .filter(n -> !n.getElement().equals(finalWinner))
                            .forEach(n -> {
                                n.destroyBenders();
                                n.destroyMonuments();
                            });
                    break;

            }
        }
        for (int i = 0; i < wars.size(); i++) {
            System.out.printf("War %d issued by %s%n", i + 1, wars.get(i));
        }
    }

    private static Monument getMonument(String[] tokens) {
        String type = tokens[1];
        String name = tokens[2];
        int affinity = Integer.parseInt(tokens[3]);
        switch (type) {
            case Nations.AIR:
                return new AirMonument(name, affinity);
            case Nations.FIRE:
                return new FireMonument(name, affinity);
            case Nations.WATER:
                return new WaterMonument(name, affinity);
            case Nations.EARTH:
                return new EarthMonument(name, affinity);
        }
        return null;
    }

    private static Bender getBender(String[] tokens) {
        String type = tokens[1];
        String name = tokens[2];
        int power = Integer.parseInt(tokens[3]);
        double secondaryParameter = Double.parseDouble(tokens[4]);
        switch (type) {
            case Nations.AIR:
                return new AirBender(name, power, secondaryParameter);
            case Nations.FIRE:
                return new FireBender(name, power, secondaryParameter);
            case Nations.WATER:
                return new WaterBender(name, power, secondaryParameter);
            case Nations.EARTH:
                return new EarthBender(name, power, secondaryParameter);
        }
        return null;
    }
}
