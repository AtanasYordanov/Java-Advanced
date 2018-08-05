package panzer.models.vehicles;

import panzer.contracts.Part;
import panzer.contracts.Vehicle;
import panzer.models.miscellaneous.VehicleAssembler;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

public abstract class BaseVehicle implements Vehicle {

    private String model;
    private double weight;
    private BigDecimal price;
    private long attack;
    private long defense;
    private long hitPoints;
    private VehicleAssembler assembler;
    private Set<String> parts;

    protected BaseVehicle(String model, double weight, BigDecimal price, long attack, long defense, long hitPoints) {
        this.model = model;
        this.weight = weight;
        this.price = price;
        this.attack = attack;
        this.defense = defense;
        this.hitPoints = hitPoints;
        this.parts = new LinkedHashSet<>();
        this.assembler = new VehicleAssembler();
    }

    @Override
    public Iterable<String> getParts() {
        return this.parts;
    }

    @Override
    public double getTotalWeight() {
        return this.getWeight() + this.assembler.getTotalWeight();
    }

    @Override
    public BigDecimal getTotalPrice() {
        return this.getPrice().add(this.assembler.getTotalPrice());
    }

    @Override
    public long getTotalAttack() {
        return (long) this.getAttack() + this.assembler.getTotalAttackModification();
    }

    @Override
    public long getTotalDefense() {
        return (long) this.getDefense() + this.assembler.getTotalDefenseModification();
    }

    @Override
    public long getTotalHitPoints() {
        return (long) this.getHitPoints() + this.assembler.getTotalHitPointModification();
    }

    @Override
    public void addArsenalPart(Part arsenalPart) {
        this.assembler.addArsenalPart(arsenalPart);
        this.parts.add(arsenalPart.getModel());
    }

    @Override
    public void addShellPart(Part shellPart) {
        this.assembler.addShellPart(shellPart);
        this.parts.add(shellPart.getModel());
    }

    @Override
    public void addEndurancePart(Part endurancePart) {
        this.assembler.addEndurancePart(endurancePart);
        this.parts.add(endurancePart.getModel());
    }

    @Override
    public String getModel() {
        return this.model;
    }

    protected double getWeight() {
        return this.weight;
    }

    protected BigDecimal getPrice() {
        return this.price;
    }

    protected double getAttack() {
        return this.attack;
    }

    protected double getDefense() {
        return this.defense;
    }

    protected double getHitPoints() {
        return this.hitPoints;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s - %s", this.getClass().getSimpleName(), this.model))
                .append(System.lineSeparator())
                .append(String.format("Total Weight: %.3f", this.getTotalWeight()))
                .append(System.lineSeparator())
                .append(String.format("Total Price: %.3f", this.getTotalPrice()))
                .append(System.lineSeparator())
                .append(String.format("Attack: %d", this.getTotalAttack()))
                .append(System.lineSeparator())
                .append(String.format("Defense: %d", this.getTotalDefense()))
                .append(System.lineSeparator())
                .append(String.format("HitPoints: %d", this.getTotalHitPoints()))
                .append(System.lineSeparator())
                .append("Parts: ");

        sb.append(this.parts.size() > 0 ? String.join(", ", this.parts) : "None");
        return sb.toString();
    }
}
