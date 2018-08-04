package app.contracts;

import java.lang.reflect.InvocationTargetException;

public interface SpecialFactory {
    Special create(String className) throws
            ClassNotFoundException,
            IllegalAccessException,
            InstantiationException,
            NoSuchMethodException,
            InvocationTargetException;
}
