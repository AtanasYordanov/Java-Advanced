package t04_Reflection.p01_HarvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Main {
    public static void main(String[] args) throws IOException {
        Class clazz = RichSoilLand.class;
        Field[] fields = clazz.getDeclaredFields();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (String line = reader.readLine(); !line.equals("HARVEST"); line = reader.readLine()) {
            switch (line) {
                case "private":
                    for (Field field : fields) {
                        int modifiers = field.getModifiers();
                        if (Modifier.isPrivate(modifiers)) {
                            System.out.printf("private %s %s%n", field.getType().getSimpleName(), field.getName());
                        }
                    }
                    break;
                case "public":
                    for (Field field : fields) {
                        int modifiers = field.getModifiers();
                        if (Modifier.isPublic(modifiers)) {
                            System.out.printf("public %s %s%n", field.getType().getSimpleName(), field.getName());
                        }
                    }
                    break;
                case "protected":
                    for (Field field : fields) {
                        int modifiers = field.getModifiers();
                        if (Modifier.isProtected(modifiers)) {
                            System.out.printf("protected %s %s%n", field.getType().getSimpleName(), field.getName());
                        }
                    }
                    break;
                case "all":
                    for (Field field : fields) {
                        int modifiers = field.getModifiers();
                        String accessModifier = Modifier.toString(modifiers).split("\\s+")[0];
                        System.out.printf("%s %s %s%n", accessModifier, field.getType().getSimpleName(), field.getName());
                    }
                    break;
            }
        }
    }
}
