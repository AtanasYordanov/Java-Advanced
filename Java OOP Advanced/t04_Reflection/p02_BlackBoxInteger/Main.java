package t04_Reflection.p02_BlackBoxInteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    @SuppressWarnings("unchecked")
	public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException
            , InvocationTargetException, InstantiationException, IOException, NoSuchFieldException {
		Class clazz = BlackBoxInt.class;
        Constructor constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt box = (BlackBoxInt) constructor.newInstance();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (String line = reader.readLine(); !line.equals("END"); line = reader.readLine()) {
            String[] tokens = line.split("_");
            String command = tokens[0];
            int value = Integer.parseInt(tokens[1]);
            Method method = clazz.getDeclaredMethod(command, int.class);
            method.setAccessible(true);
            method.invoke(box, value);
            Field field = clazz.getDeclaredField("innerValue");
            field.setAccessible(true);
            System.out.println(field.get(box));
        }
	}
}
