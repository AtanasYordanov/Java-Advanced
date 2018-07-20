package t04_Reflection.p03_BarracksWars;

import t04_Reflection.p03_BarracksWars.contracts.Repository;
import t04_Reflection.p03_BarracksWars.contracts.UnitFactory;
import t04_Reflection.p03_BarracksWars.core.Engine;
import t04_Reflection.p03_BarracksWars.core.factories.UnitFactoryImpl;
import t04_Reflection.p03_BarracksWars.data.UnitRepository;

public class Main {

	public static void main(String[] args) {
		Repository repository = new UnitRepository();
		UnitFactory unitFactory = new UnitFactoryImpl();
		Runnable engine = new Engine(repository, unitFactory);
		engine.run();
	}
}
