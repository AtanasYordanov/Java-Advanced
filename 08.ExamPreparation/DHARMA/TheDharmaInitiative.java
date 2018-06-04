package ExamPreparation.DHARMA;

import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TheDharmaInitiative {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, List<Pair<String, Integer>>> stationRecruits = new HashMap<>();
        initializeStations(stationRecruits);
        addRecruits(reader, stationRecruits);
        String command = reader.readLine();
        printOutput(stationRecruits, command);
    }

    private static void printOutput(Map<String, List<Pair<String, Integer>>> stationRecruits, String command) {
        if (command.equals("DHARMA Initiative")) {
            stationRecruits.entrySet().stream()
                    .sorted((a, b) -> {
                        int comp = b.getValue().size() - a.getValue().size();
                        if (comp == 0) {
                            comp = a.getKey().compareTo(b.getKey());
                        }
                        return comp;
                    })
                    .forEach(pair -> {
                        System.out.printf("The %s has %d DHARMA recruits in it.%n"
                                , pair.getKey(), pair.getValue().size());
                    });
        } else if (stationRecruits.containsKey(command)) {
            Map<String, String> stations = Map.of(
                    "Arrow", "The Arrow station: Development of defensive strategies, and Intelligence gathering.",
                    "Flame", "The Flame station: Communication.",
                    "Hydra", "The Hydra station: Zoological Research.",
                    "Orchid", "The Orchid station: Space-time manipulation research, disguised as a Botanical station.",
                    "Pearl", "The Pearl station: Psychological Research and/or Observation."
            );
            System.out.println(stations.get(command));
            if (stationRecruits.get(command).size() > 0) {
                stationRecruits.get(command).stream()
                        .sorted(Comparator.comparing(Pair::getValue, Comparator.reverseOrder()))
                        .forEach(pair -> {
                            System.out.printf("###%s - %s%n", pair.getKey(), pair.getValue());
                        });
            } else {
                System.out.println("No recruits.");
            }
        } else {
            System.out.println("DHARMA Initiative does not have such a station!");
        }
    }

    private static void addRecruits(BufferedReader reader, Map<String, List<Pair<String, Integer>>> stationRecruits) throws IOException {
        for (String input = reader.readLine(); !input.equals("Recruit"); input = reader.readLine()) {
            String[] data = input.split(":");
            String name = data[0];
            int number = Integer.parseInt(data[1]);
            String station = data[2];
            if (stationRecruits.containsKey(station)) {
                stationRecruits.get(station).add(new Pair<>(name, number));
            }
        }
    }

    private static void initializeStations(Map<String, List<Pair<String, Integer>>> stationRecruits) {
        stationRecruits.put("Arrow", new ArrayList<>());
        stationRecruits.put("Flame", new ArrayList<>());
        stationRecruits.put("Hydra", new ArrayList<>());
        stationRecruits.put("Orchid", new ArrayList<>());
        stationRecruits.put("Pearl", new ArrayList<>());
    }
}
