package t06_OpenClosedLiskov.p02_Blobs.core.factories;

import t06_OpenClosedLiskov.p02_Blobs.interfaces.Behaviour;
import t06_OpenClosedLiskov.p02_Blobs.interfaces.Factory;

import java.lang.reflect.InvocationTargetException;

public class BehaviourFactory implements Factory<Behaviour> {

    private static final String PATH_TO_BEHAVIOURS = "t06_OpenClosedLiskov.p02_Blobs.models.behaviours.";

    @Override
    public Behaviour getInstance(String name) {
        try {
            Class<?> clazz = Class.forName(PATH_TO_BEHAVIOURS + name);
            return (Behaviour) clazz.getConstructor().newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException
                | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }
}
