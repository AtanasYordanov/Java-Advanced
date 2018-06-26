package t05_InterfacesAndAbstraction.p10_MooD3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = reader.readLine().split("\\s+\\|\\s+");
        String username = tokens[0];
        String type = tokens[1];
        double specialPoints = Double.parseDouble(tokens[2]);
        int level = Integer.parseInt(tokens[3]);
        Hero hero = type.equals("Demon")
                ? new Demon(username, level, specialPoints)
                : new Archangel(username, level, (int)specialPoints);
        System.out.println(hero);
    }
}
