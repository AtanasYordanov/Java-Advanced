package t08_ObjectCommunicationAndEvents.p04_WorkForce.factories;

import t08_ObjectCommunicationAndEvents.p04_WorkForce.model.employees.BaseEmployee;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class EmployeeFactory {

    public BaseEmployee getEmployee(String type, String name) {
        try {
            Class<?> clazz = Class.forName("t08_ObjectCommunicationAndEvents.p04_WorkForce.model.employees." + type);
            Constructor<?> constructor = clazz.getDeclaredConstructor(String.class);
            constructor.setAccessible(true);
            return (BaseEmployee) constructor.newInstance(name);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException | ClassNotFoundException e) {
            throw new IllegalArgumentException();
        }
    }
}
