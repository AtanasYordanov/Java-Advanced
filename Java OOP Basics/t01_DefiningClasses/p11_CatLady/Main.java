package t01_DefiningClasses.p11_CatLady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Cat> catsByName = new HashMap<>();
        for (String line = reader.readLine(); !line.equals("End"); line = reader.readLine()) {
            String[] tokens = line.split(" ");
            Cat cat = getCat(tokens);
            catsByName.put(tokens[1], cat);
        }
        Cat targetCat = catsByName.get(reader.readLine());
        System.out.println(targetCat);
    }

    private static Cat getCat(String[] tokens) {
        String breed = tokens[0];
        switch (breed) {
            case "Siamese":
                return new SiameseCat(tokens[1], Double.parseDouble(tokens[2]));
            case "Cymric":
                return new CymricCat(tokens[1], Double.parseDouble(tokens[2]));
            default:
                return new StreetCat(tokens[1], Double.parseDouble(tokens[2]));
        }
    }
}
