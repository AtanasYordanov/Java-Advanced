package panzer.models.parts;

import panzer.contracts.AttackModifyingPart;

import java.math.BigDecimal;

public class Arsenal extends BasePart implements AttackModifyingPart {

    private int attackModifier;

    public Arsenal(String model, double weight, BigDecimal price, int attackModifier) {
        super(model, weight, price);
        this.attackModifier = attackModifier;
    }

    @Override
    public int getAttackModifier() {
        return this.attackModifier;
    }

    @Override
    public String toString() {
        return String.format("%s+%d %s", super.toString(), this.attackModifier, "Attack");
    }
}
