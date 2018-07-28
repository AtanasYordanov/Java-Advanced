package t06_OpenClosedLiskov.p02_Blobs.core.factories;

import t06_OpenClosedLiskov.p02_Blobs.interfaces.Attack;
import t06_OpenClosedLiskov.p02_Blobs.interfaces.Factory;

import java.lang.reflect.InvocationTargetException;

public class AttackFactory implements Factory<Attack> {

    @Override
    public Attack getInstance(String name){
        try {
            Class<?> clazz = Class.forName("t06_OpenClosedLiskov.p02_Blobs.models.attacks." + name);
            return  (Attack) clazz.getConstructor().newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException
                | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }
}
