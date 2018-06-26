package t05_InterfacesAndAbstraction.p08_MilitaryElite;

import t05_InterfacesAndAbstraction.p08_MilitaryElite.constants.Corps;
import t05_InterfacesAndAbstraction.p08_MilitaryElite.constants.Missions;
import t05_InterfacesAndAbstraction.p08_MilitaryElite.constants.Soldiers;
import t05_InterfacesAndAbstraction.p08_MilitaryElite.model.Impl.Mission;
import t05_InterfacesAndAbstraction.p08_MilitaryElite.model.Impl.Repair;
import t05_InterfacesAndAbstraction.p08_MilitaryElite.model.api.Soldier;
import t05_InterfacesAndAbstraction.p08_MilitaryElite.model.Impl.soldiers.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Soldier> soldiers = new ArrayList<>();
        Map<String, Soldier> privates = new HashMap<>();
        for (String line = reader.readLine(); !line.equals("End"); line = reader.readLine()) {
            String[] tokens = line.split(" ");
            Soldier soldier = getSoldier(tokens, privates);
            if (soldier != null) {
                soldiers.add(soldier);
            }
        }
        soldiers.forEach(System.out::println);
    }

    private static Soldier getSoldier(String[] tokens, Map<String, Soldier> privates) {
        String type = tokens[0];
        String id = tokens[1];
        String firstName = tokens[2];
        String lastName = tokens[3];
        switch (type) {
            case Soldiers.PRIVATE:
                double salary = Double.parseDouble(tokens[4]);
                Private priv = new Private(id, firstName, lastName, salary);
                privates.put(id, priv);
                return priv;
            case Soldiers.SPY:
                String codeNumber = tokens[4];
                return new Spy(id, firstName, lastName, codeNumber);
            case Soldiers.LEUTENANT_GENERAL:
                salary = Double.parseDouble(tokens[4]);
                LeutenantGeneral general = new LeutenantGeneral(id, firstName, lastName, salary);
                for (int i = 5; i < tokens.length; i++) {
                    String privateId = tokens[i];
                    general.addPrivate(privates.get(privateId));
                }
                return general;
            case Soldiers.ENGINEER:
                salary = Double.parseDouble(tokens[4]);
                String corps = tokens[5];
                if (!corpsIsValid(corps)) {
                    return null;
                }
                Engineer engineer = new Engineer(id, firstName, lastName, salary, corps);
                for (int i = 6; i < tokens.length; i += 2) {
                    String part = tokens[i];
                    int repairHours = Integer.parseInt(tokens[i + 1]);
                    Repair repair = new Repair(part, repairHours);
                    engineer.addRepair(repair);
                }
                return engineer;
            case Soldiers.COMMANDO:
                salary = Double.parseDouble(tokens[4]);
                corps = tokens[5];
                if (!corpsIsValid(corps)) {
                    return null;
                }
                Commando commando = new Commando(id, firstName, lastName, salary, corps);
                for (int i = 6; i < tokens.length; i += 2) {
                    String missionName = tokens[i];
                    String state = tokens[i + 1];
                    if (!stateIsValid(state)) {
                        continue;
                    }
                    Mission mission = new Mission(missionName, state);
                    commando.addMission(mission);
                }
                return commando;
            default:
                return null;
        }
    }

    private static boolean corpsIsValid(String corps) {
        return corps.equals(Corps.AIRFORCES) || corps.equals(Corps.MARINES);
    }

    private static boolean stateIsValid(String state) {
        return state.equals(Missions.FINISHED_STATE) || state.equals(Missions.IN_PROGRESS_STATE);
    }
}
