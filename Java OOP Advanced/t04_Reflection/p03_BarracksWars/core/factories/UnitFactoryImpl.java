package t04_Reflection.p03_BarracksWars.core.factories;

import t04_Reflection.p03_BarracksWars.contracts.Unit;
import t04_Reflection.p03_BarracksWars.contracts.UnitFactory;

import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"pr0304Barracks.models.units.";

	@Override
	public Unit createUnit(String unitType){
        try {
            Class<?> clazz = Class.forName("t04_Reflection.p03_BarracksWars.models.units." + unitType);
            return (Unit) clazz.getConstructor().newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException
                | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
	}
}
