package app.factory;

import app.contracts.Action;
import app.contracts.ActionFactory;

import java.lang.reflect.InvocationTargetException;

public class ActionFactoryImpl implements ActionFactory {
    @Override
    public Action create(String actionName, String... participantNames) throws ClassNotFoundException
            , IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> clazz = Class.forName("app.models.actions." + actionName);
        return (Action) clazz.getConstructor().newInstance();
    }
}
