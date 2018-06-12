package t01_DefiningClasses.p11_CatLady;

public class CymricCat extends Cat {
    private double furLength;

    public CymricCat(String name, double furLength) {
        super(name);
        this.furLength = furLength;
    }

    @Override
    public String toString() {
        return String.format("Cymric %s %.2f", super.getName(), this.furLength);
    }
}
