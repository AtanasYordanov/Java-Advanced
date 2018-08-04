package app.factory;

import app.contracts.Targetable;
import app.contracts.TargetableFactory;

import java.lang.reflect.InvocationTargetException;

public class TargetableFactoryImpl implements TargetableFactory {
    @Override
    public Targetable create(String name, String className) throws ClassNotFoundException, IllegalAccessException
            , InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> clazz = Class.forName("app.models.participants." + className);
        return (Targetable) clazz.getConstructor(String.class).newInstance(name);
    }
}
