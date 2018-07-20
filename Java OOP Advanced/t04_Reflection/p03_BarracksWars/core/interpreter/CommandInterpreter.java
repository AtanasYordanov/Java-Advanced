package t04_Reflection.p03_BarracksWars.core.interpreter;

import t04_Reflection.p03_BarracksWars.annotations.Inject;
import t04_Reflection.p03_BarracksWars.contracts.Executable;
import t04_Reflection.p03_BarracksWars.contracts.Repository;
import t04_Reflection.p03_BarracksWars.contracts.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpreter {

    private Repository repository;
    private UnitFactory unitFactory;

    public CommandInterpreter(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    public String interpretCommand(String[] data, String commandName) {
        try {
            commandName = Character.toUpperCase(commandName.charAt(0)) + commandName.substring(1);
            Class<?> clazz = Class.forName("t04_Reflection.p03_BarracksWars.core.commands." + commandName);
            Constructor<?> constructor = clazz.getDeclaredConstructor(String[].class);
            constructor.setAccessible(true);
            Executable command = (Executable) constructor.newInstance((Object) data);
            Field[] dependencies = this.getClass().getDeclaredFields();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.isAnnotationPresent(Inject.class)) {
                    Class<?> type = field.getType();
                    for (Field dependency : dependencies) {
                        dependency.setAccessible(true);
                        if (dependency.getType().equals(type)) {
                            field.set(command, dependency.get(this));
                        }
                    }
                }
            }
            return command.execute();
        } catch (ClassNotFoundException | IllegalAccessException | InvocationTargetException | InstantiationException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }
}
