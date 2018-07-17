package t03_EnumsAndAnnotations.p10_Inferno;

import t03_EnumsAndAnnotations.p10_Inferno.annotations.ClassInfo;
import t03_EnumsAndAnnotations.p10_Inferno.model.Weapon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Weapon> weapons = new HashMap<>();
        for (String line = reader.readLine(); !line.equals("END"); line = reader.readLine()) {
            String[] tokens = line.split(";");
            String command = tokens[0];
            switch (command) {
                case "Create":
                    String type = tokens[1];
                    String name = tokens[2];
                    Weapon weapon = new Weapon(name, type);
                    weapons.put(name, weapon);
                    break;
                case "Add":
                    name = tokens[1];
                    int socketIndex = Integer.parseInt(tokens[2]);
                    String gemType = tokens[3];
                    weapon = weapons.get(name);
                    weapon.addGem(gemType, socketIndex);
                    break;
                case "Remove":
                    name = tokens[1];
                    socketIndex = Integer.parseInt(tokens[2]);
                    weapon = weapons.get(name);
                    weapon.removeGem(socketIndex);
                    break;
                case "Print":
                    name = tokens[1];
                    weapon = weapons.get(name);
                    System.out.println(weapon);
                    break;
                case "Compare":
                    String firstWeaponName = tokens[1];
                    String secondWeaponName = tokens[2];
                    Weapon firstWeapon = weapons.get(firstWeaponName);
                    Weapon secondWeapon = weapons.get(secondWeaponName);
                    Weapon greaterWeapon = firstWeapon.compareTo(secondWeapon) > 0 ? firstWeapon : secondWeapon;
                    System.out.printf("%s (Item Level: %.1f)%n", greaterWeapon, greaterWeapon.getItemLevel());
                    break;
                case "Author":
                    ClassInfo classInfo = Weapon.class.getAnnotation(ClassInfo.class);
                    System.out.printf("Author: %s%n", classInfo.author());
                    break;
                case "Revision":
                    classInfo = Weapon.class.getAnnotation(ClassInfo.class);
                    System.out.printf("Revision: %d%n", classInfo.revision());
                    break;
                case "Description":
                    classInfo = Weapon.class.getAnnotation(ClassInfo.class);
                    System.out.printf("Class description: %s%n", classInfo.description());
                    break;
                case "Reviewers":
                    classInfo = Weapon.class.getAnnotation(ClassInfo.class);
                    System.out.printf("Reviewers: %s%n", String.join(", ", classInfo.reviewers()));
                    break;
            }
        }
    }
}
