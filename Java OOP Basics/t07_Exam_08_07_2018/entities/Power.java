package entities;

import interfaces.SuperPower;

public class Power implements SuperPower {
    private String name;
    private double powerPoints;

    public Power(String name, double powerPoints) {
        this.setName(name);
        this.setPowerPoints(powerPoints);
    }

    private void setName(String name) {
        String regex = "\\@[A-Za-z_]{3,}\\@";
        if (!name.matches(regex)){
            throw new IllegalArgumentException("Super power name not in the correct format!");
        }
        this.name = name;
    }

    private void setPowerPoints(double powerPoints) {
        if (powerPoints < 0){
            throw new IllegalArgumentException("Power points should be a possitive number!");
        }
        this.powerPoints = powerPoints;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getPowerPoints() {
        return this.powerPoints + this.name.length() / 2;
    }
}
