package panzer.models.vehicles;

import java.math.BigDecimal;

public class Revenger extends BaseVehicle {

    public Revenger(String model, double weight, BigDecimal price, long attack, long defense, long hitPoints) {
        super(model, weight, price, attack, defense, hitPoints);
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice().multiply(BigDecimal.valueOf(1.5));
    }

    @Override
    public double getAttack() {
        return super.getAttack() * 2.5;
    }

    @Override
    public double getDefense() {
        return super.getDefense() * 0.5;
    }

    @Override
    public double getHitPoints() {
        return super.getHitPoints() * 0.5;
    }
}
