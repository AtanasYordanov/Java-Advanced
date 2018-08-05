package panzer.core;

import java.math.BigDecimal;
import java.util.*;

import panzer.contracts.BattleOperator;
import panzer.contracts.Manager;
import panzer.contracts.Part;
import panzer.contracts.Vehicle;
import panzer.models.parts.Arsenal;
import panzer.models.parts.Endurance;
import panzer.models.parts.Shell;
import panzer.models.vehicles.Revenger;
import panzer.models.vehicles.Vanguard;

public class ManagerImpl implements Manager {

    private Map<String, Part> parts;
    private Map<String, Vehicle> vehicles;
    private Set<String> defeatedVehicles;
    private BattleOperator battleOperator;

    public ManagerImpl(BattleOperator battleOperator) {
        this.battleOperator = battleOperator;
        this.parts = new LinkedHashMap<>();
        this.vehicles = new LinkedHashMap<>();
        this.defeatedVehicles = new LinkedHashSet<>();
    }

    @Override
    public String addVehicle(List<String> arguments) {
        String type = arguments.get(1);
        String model = arguments.get(2);
        double weight = Double.parseDouble(arguments.get(3));
        BigDecimal price = new BigDecimal(arguments.get(4));
        long attack = Long.parseLong(arguments.get(5));
        long defense = Long.parseLong(arguments.get(6));
        long hitpoints = Long.parseLong(arguments.get(7));

        Vehicle vehicle = null;
        switch (type) {
            case "Vanguard":
                vehicle = new Vanguard(model, weight, price, attack, defense, hitpoints);
                break;
            case "Revenger":
                vehicle = new Revenger(model, weight, price, attack, defense, hitpoints);
                break;
        }
        this.vehicles.put(model, vehicle);
        return String.format("Created %s Vehicle - %s", type, model);
    }

    @Override
    public String addPart(List<String> arguments) {
        String vehicleModel = arguments.get(1);
        String type = arguments.get(2);
        String partModel = arguments.get(3);
        double weight = Double.parseDouble(arguments.get(4));
        BigDecimal price = new BigDecimal(arguments.get(5));
        int additionalParameter = Integer.parseInt(arguments.get(6));

        Vehicle vehicle = this.vehicles.get(vehicleModel);
        Part part = null;
        switch (type) {
            case "Arsenal":
                part = new Arsenal(partModel, weight, price, additionalParameter);
                vehicle.addArsenalPart(part);
                break;
            case "Shell":
                part = new Shell(partModel, weight, price, additionalParameter);
                vehicle.addShellPart(part);
                break;
            case "Endurance":
                part = new Endurance(partModel, weight, price, additionalParameter);
                vehicle.addEndurancePart(part);
                break;
        }
        this.parts.put(partModel, part);
        return String.format("Added %s - %s to Vehicle - %s", type, partModel, vehicleModel);
    }

    @Override
    public String inspect(List<String> arguments) {
        String model = arguments.get(1);

        Part part = this.parts.get(model);
        if (part == null) {
            return this.vehicles.get(model).toString();
        }
        return part.toString();
    }

    @Override
    public String battle(List<String> arguments) {
        Vehicle attacker = this.vehicles.get(arguments.get(1));
        Vehicle target = this.vehicles.get(arguments.get(2));
        String winnerName = this.battleOperator.battle(attacker, target);
        String loserName = attacker.getModel().endsWith(winnerName) ? target.getModel() : attacker.getModel();
        this.vehicles.remove(loserName);
        this.defeatedVehicles.add(loserName);
        return String.format("%s versus %s -> %s Wins! Flawless Victory!", attacker.getModel(), target.getModel(), winnerName);
    }

    @Override
    public String terminate(List<String> arguments) {
        StringBuilder sb = new StringBuilder();
        sb.append("Remaining Vehicles: ");

        if (this.vehicles.size() > 0) {
            sb.append(String.join(", ", this.vehicles.keySet()));
        } else {
            sb.append("None");
        }
        sb.append(System.lineSeparator())
                .append("Defeated Vehicles: ");
        if (this.defeatedVehicles.size() > 0) {
            sb.append(String.join(", ", this.defeatedVehicles));
        } else {
            sb.append("None");
        }
        sb.append(System.lineSeparator())
                .append("Currently Used Parts: ")
                .append(this.vehicles.values().stream()
                        .mapToInt(v -> ((Set<String>) v.getParts()).size()).sum());
        return sb.toString();
    }
}
