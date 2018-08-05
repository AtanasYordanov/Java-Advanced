package panzer.models.parts;

import panzer.contracts.HitPointsModifyingPart;

import java.math.BigDecimal;

public class Endurance extends BasePart implements HitPointsModifyingPart {

    private int hitPointsModifier;

    public Endurance(String model, double weight, BigDecimal price, int hitPointsModifier) {
        super(model, weight, price);
        this.hitPointsModifier = hitPointsModifier;
    }

    @Override
    public int getHitPointsModifier() {
        return this.hitPointsModifier;
    }

    @Override
    public String toString() {
        return String.format("%s+%d %s", super.toString(), this.hitPointsModifier, "HitPoints");
    }
}
