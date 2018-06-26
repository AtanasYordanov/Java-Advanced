package t05_InterfacesAndAbstraction.p03_Ferrari;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String driverName = reader.readLine();
        Car car = new Ferrari(driverName);

        System.out.printf("%s/%s/%s/%s%n"
                , car.getModel()
                , car.useBrakes()
                , car.pushGas()
                , car.getDriver());
    }
}
