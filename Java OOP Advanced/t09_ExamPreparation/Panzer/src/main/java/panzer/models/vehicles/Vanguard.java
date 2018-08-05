package panzer.models.vehicles;

import java.math.BigDecimal;

public class Vanguard extends BaseVehicle {

    public Vanguard(String model, double weight, BigDecimal price, long attack, long defense, long hitPoints) {
        super(model, weight, price, attack, defense, hitPoints);
    }

    @Override
    public double getWeight() {
        return super.getWeight() * 2;
    }

    @Override
    public double getAttack() {
        return super.getAttack() * 0.75;
    }

    @Override
    public double getDefense() {
        return super.getDefense() * 1.5;
    }

    @Override
    public double getHitPoints() {
        return super.getHitPoints() * 1.75;
    }
}
