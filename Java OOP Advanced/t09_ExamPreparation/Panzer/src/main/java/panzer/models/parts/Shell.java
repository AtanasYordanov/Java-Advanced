package panzer.models.parts;

import panzer.contracts.DefenseModifyingPart;

import java.math.BigDecimal;

public class Shell extends BasePart implements DefenseModifyingPart {

    private int defenseModifier;

    public Shell(String model, double weight, BigDecimal price, int defenseModifier) {
        super(model, weight, price);
        this.defenseModifier = defenseModifier;
    }

    @Override
    public int getDefenseModifier() {
        return this.defenseModifier;
    }

    @Override
    public String toString() {
        return String.format("%s+%d %s", super.toString(), this.defenseModifier, "Defense");
    }
}
