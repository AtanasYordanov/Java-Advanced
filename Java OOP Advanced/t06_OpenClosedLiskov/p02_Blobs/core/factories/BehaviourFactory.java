package t06_OpenClosedLiskov.p02_Blobs.core.factories;

import t06_OpenClosedLiskov.p02_Blobs.interfaces.Behaviour;
import t06_OpenClosedLiskov.p02_Blobs.interfaces.Factory;

import java.lang.reflect.InvocationTargetException;

public class BehaviourFactory implements Factory<Behaviour> {

    @Override
    public Behaviour getInstance(String name) {
        try {
            Class<?> clazz = Class.forName("t06_OpenClosedLiskov.p02_Blobs.models.behaviours." + name);
            return (Behaviour) clazz.getConstructor().newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException
                | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }
}
