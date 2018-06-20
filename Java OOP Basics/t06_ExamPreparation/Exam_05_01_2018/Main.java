package t06_ExamPreparation.Exam_05_01_2018;

import t06_ExamPreparation.Exam_05_01_2018.model.Colonist;
import t06_ExamPreparation.Exam_05_01_2018.model.Colony;
import t06_ExamPreparation.Exam_05_01_2018.model.Family;
import t06_ExamPreparation.Exam_05_01_2018.model.colonists.*;
import t06_ExamPreparation.Exam_05_01_2018.model.constants.Classes;
import t06_ExamPreparation.Exam_05_01_2018.model.constants.Commands;
import t06_ExamPreparation.Exam_05_01_2018.model.constants.Messages;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final String SPLIT_DELIMITER = "\\s+";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = reader.readLine().split(SPLIT_DELIMITER);
        int maxFamilyCount = Integer.parseInt(tokens[0]);
        int maxFamilyCapacity = Integer.parseInt(tokens[1]);
        Colony colony = new Colony(maxFamilyCount, maxFamilyCapacity);

        for (String line = reader.readLine(); !line.equals(Commands.END); line = reader.readLine()) {
            tokens = line.split(SPLIT_DELIMITER);
            String command = tokens[0];
            switch (command) {
                case Commands.INSERT:
                    try {
                        insertColonist(colony, tokens);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case Commands.REMOVE:
                    remove(colony, tokens);
                    break;
                case Commands.GROW:
                    int years = Integer.parseInt(tokens[1]);
                    colony.grow(years);
                    break;
                case Commands.POTENTIAL:
                    System.out.printf("potential: %d%n", colony.getPotential());
                    break;
                case Commands.CAPACITY:
                    System.out.println(colony.getCapacity());
                    break;
                case Commands.FAMILY:
                    String familyId = tokens[1];
                    Family family = colony.getFamilyById(familyId);
                    if (family != null) {
                        System.out.println(family);
                    } else {
                        System.out.println(Messages.FAMILY_DOES_NOT_EXIST);
                    }
                    break;

            }
        }
    }

    private static void remove(Colony colony, String[] tokens) {
        String modificator = tokens[1];
        String familyId = tokens[2];
        switch (modificator) {
            case Commands.FAMILY:
                colony.removeFamily(familyId);
                return;
            case Commands.COLONIST:
                String colonistId = tokens[3];
                colony.removeColonist(familyId, colonistId);
        }
    }

    private static void insertColonist(Colony colony, String[] tokens) {
        String colonistClass = tokens[1];
        String colonistId = tokens[2];
        String familyId = tokens[3];
        int talent = Integer.parseInt(tokens[4]);
        int age = Integer.parseInt(tokens[5]);
        Colonist colonist;
        switch (colonistClass) {
            case Classes.SOLDIER:
                colonist = new Soldier(colonistId, familyId, talent, age);
                colony.addColonist(colonist);
                return;
            case Classes.SOFTWARE_ENGINEER:
                colonist = new SoftwareEngineer(colonistId, familyId, talent, age);
                colony.addColonist(colonist);
                return;
            case Classes.HARDWARE_ENGINEER:
                colonist = new HardwareEngineer(colonistId, familyId, talent, age);
                colony.addColonist(colonist);
                return;
            case Classes.SURGEON:
                String sign = tokens[6];
                colonist = new Surgeon(colonistId, familyId, talent, age, sign);
                colony.addColonist(colonist);
                return;
            case Classes.GENERAL_PRACTITIONER:
                String sign2 = tokens[6];
                colonist = new GeneralPractitioner(colonistId, familyId, talent, age, sign2);
                colony.addColonist(colonist);
        }
    }
}
