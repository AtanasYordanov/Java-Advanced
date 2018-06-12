package t01_DefiningClasses.p11_CatLady;

public class StreetCat extends Cat {
    private double meowDecibels;

    public StreetCat(String name, double meowDecibels) {
        super(name);
        this.meowDecibels = meowDecibels;
    }

    @Override
    public String toString() {
        return String.format("StreetExtraordinaire %s %.2f", super.getName(), this.meowDecibels);
    }
}
