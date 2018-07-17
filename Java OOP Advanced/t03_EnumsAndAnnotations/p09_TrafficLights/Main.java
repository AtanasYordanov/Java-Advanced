package t03_EnumsAndAnnotations.p09_TrafficLights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<TrafficLight> trafficLights = new ArrayList<>();
        String[] tokens = reader.readLine().split("\\s+");
        for (String token : tokens) {
            trafficLights.add(new TrafficLight(token));
        }
        int rotations = Integer.parseInt(reader.readLine());

        StringBuilder sb = new StringBuilder();
        while (rotations-- > 0) {
            for (TrafficLight trafficLight : trafficLights) {
                trafficLight.changeSignal();
                sb.append(trafficLight).append(" ");
            }
            sb.append(System.lineSeparator());
        }
        System.out.print(sb);
    }
}
