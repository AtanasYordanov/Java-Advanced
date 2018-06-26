package t05_InterfacesAndAbstraction.p03_Ferrari;

public class Ferrari implements Car {
    private String driver;
    private String model;

    public Ferrari(String driver) {
        this.driver = driver;
        this.model = "488-Spider";
    }

    public String getModel() {
        return this.model;
    }

    @Override
    public String useBrakes() {
        return "Brakes!";
    }

    @Override
    public String pushGas() {
        return "Zadu6avam sA!";
    }

    @Override
    public String getDriver() {
        return this.driver;
    }
}
