package ExamPreparation.DragonExam_04_08_2015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class DragonArmy {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Map<String, Dragon>> dragons = new LinkedHashMap<>();
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split(" ");
            String type = tokens[0];
            String name = tokens[1];
            int damage = !tokens[2].equals("null") ? Integer.parseInt(tokens[2]) : 45;
            int health = !tokens[3].equals("null") ? Integer.parseInt(tokens[3]) : 250;
            int armor = !tokens[4].equals("null") ? Integer.parseInt(tokens[4]) : 10;

            dragons.putIfAbsent(type, new TreeMap<>());
            if (dragons.get(type).containsKey(name)) {
                dragons.get(type).get(name).setDamage(damage);
                dragons.get(type).get(name).setHealth(health);
                dragons.get(type).get(name).setArmor(armor);
            } else {
                Dragon dragon = new Dragon(name, damage, health, armor);
                dragons.get(type).put(name, dragon);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Map<String, Dragon>> pair : dragons.entrySet()) {

            double averageDamage = pair.getValue().values()
                    .stream()
                    .mapToDouble(Dragon::getDamage)
                    .average()
                    .getAsDouble();

            double averageHealth = pair.getValue().values()
                    .stream()
                    .mapToDouble(Dragon::getHealth)
                    .average()
                    .getAsDouble();

            double averageArmor = pair.getValue().values()
                    .stream()
                    .mapToDouble(Dragon::getArmor)
                    .average()
                    .getAsDouble();

            sb.append(String.format("%s::(%.2f/%.2f/%.2f)%n", pair.getKey(), averageDamage, averageHealth, averageArmor));
            pair.getValue().values()
                    .forEach(dragon -> {
                        sb.append(String.format("-%s -> damage: %d, health: %d, armor: %d%n", dragon.getName()
                                , dragon.getDamage(), dragon.getHealth(), dragon.getArmor()));
                    });
        }
        System.out.print(sb);
    }

    private static class Dragon implements Comparable<Dragon> {
        private String name;
        private int damage;
        private int health;
        private int armor;

        Dragon(String name, int damage, int health, int armor) {
            this.name = name;
            this.damage = damage;
            this.health = health;
            this.armor = armor;
        }

        String getName() {
            return name;
        }

        int getDamage() {
            return damage;
        }

        int getHealth() {
            return health;
        }

        int getArmor() {
            return armor;
        }

        void setDamage(int damage) {
            this.damage = damage;
        }

        void setHealth(int health) {
            this.health = health;
        }

        void setArmor(int armor) {
            this.armor = armor;
        }

        @Override
        public int compareTo(Dragon o) {
            return this.name.compareTo(o.name);
        }
    }
}