package t02_IteratorsAndComparators.p08_PetClinics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Pet> pets = new HashMap<>();
        Map<String, Clinic> clinics = new HashMap<>();

        int n = Integer.parseInt(reader.readLine());

        while (n-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");
            String command = tokens[0];
            try {
                switch (command) {
                    case "Create":
                        String type = tokens[1];
                        switch (type) {
                            case "Pet":
                                String petName = tokens[2];
                                int age = Integer.parseInt(tokens[3]);
                                String kind = tokens[4];
                                Pet pet = new Pet(petName, age, kind);
                                pets.put(petName, pet);
                                break;
                            case "Clinic":
                                String clinicName = tokens[2];
                                int rooms = Integer.parseInt(tokens[3]);
                                Clinic clinic = new Clinic(clinicName, rooms);
                                clinics.put(clinicName, clinic);
                                break;
                        }
                        break;
                    case "Add":
                        String petName = tokens[1];
                        String clinicName = tokens[2];
                        Clinic clinic = clinics.get(clinicName);
                        Pet pet = pets.get(petName);
                        if (pet == null || clinic == null) {
                            System.out.println("Invalid Operation");
                            continue;
                        }
                        System.out.println(clinic.addPet(pet));
                        break;
                    case "HasEmptyRooms":
                        clinicName = tokens[1];
                        clinic = clinics.get(clinicName);
                        if (clinic == null) {
                            System.out.println("Invalid Operation");
                            continue;
                        }
                        System.out.println(clinics.get(clinicName).hasEmptyRooms());
                        break;
                    case "Release":
                        clinicName = tokens[1];
                        clinic = clinics.get(clinicName);
                        if (clinic == null) {
                            System.out.println("Invalid Operation");
                            continue;
                        }
                        System.out.println(clinic.releasePet());
                        break;
                    case "Print":
                        clinicName = tokens[1];
                        clinic = clinics.get(clinicName);
                        if (clinic == null) {
                            System.out.println("Invalid Operation");
                            continue;
                        }
                        switch (tokens.length) {
                            case 2:
                                System.out.println(clinics.get(clinicName));
                                break;
                            case 3:
                                int petIndex = Integer.parseInt(tokens[2]);
                                System.out.println(clinics.get(clinicName).getPet(petIndex));
                                break;
                        }
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
