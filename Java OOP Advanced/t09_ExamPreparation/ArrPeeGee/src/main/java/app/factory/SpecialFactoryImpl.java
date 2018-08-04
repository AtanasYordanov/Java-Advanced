package app.factory;

import app.contracts.Special;
import app.contracts.SpecialFactory;

import java.lang.reflect.InvocationTargetException;

public class SpecialFactoryImpl implements SpecialFactory {
    @Override
    public Special create(String className) throws ClassNotFoundException, IllegalAccessException
            , InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> clazz = Class.forName("app.models.specials." + className);
        return (Special) clazz.getConstructor().newInstance();
    }
}
