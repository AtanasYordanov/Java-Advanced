package ExamPreparation.Exam_03_01_2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TheDharmaInitiative {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Map<Integer, String>> stationRecruits = new HashMap<>();
        initializeStations(stationRecruits);
        addRecruits(reader, stationRecruits);
        String command = reader.readLine();
        printOutput(stationRecruits, command);
    }

    private static void printOutput(Map<String, Map<Integer, String>> stationRecruits, String command) {
        if (command.equals("Exam_03_01_2018 Initiative")) {
            stationRecruits.entrySet().stream()
                    .sorted((a, b) -> {
                        int comp = b.getValue().size() - a.getValue().size();
                        if (comp == 0) {
                            comp = a.getKey().compareTo(b.getKey());
                        }
                        return comp;
                    })
                    .forEach(pair -> {
                        System.out.printf("The %s has %d Exam_03_01_2018 recruits in it.%n"
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
                stationRecruits.get(command).entrySet().stream()
                        .sorted(Comparator.comparing(Map.Entry::getKey, Comparator.reverseOrder()))
                        .forEach(pair -> {
                            System.out.printf("###%s - %s%n", pair.getValue(), pair.getKey());
                        });
            } else {
                System.out.println("No recruits.");
            }
        } else {
            System.out.println("Exam_03_01_2018 Initiative does not have such a station!");
        }
    }

    private static void addRecruits(BufferedReader reader, Map<String, Map<Integer, String>> stationRecruits) throws IOException {
        for (String input = reader.readLine(); !input.equals("Recruit"); input = reader.readLine()) {
            String[] data = input.split(":");
            String name = data[0];
            int number = Integer.parseInt(data[1]);
            String station = data[2];
            if (stationRecruits.containsKey(station)) {
                stationRecruits.get(station).put(number, name);
            }
        }
    }

    private static void initializeStations(Map<String, Map<Integer, String>> stationRecruits) {
        stationRecruits.put("Arrow", new HashMap<>());
        stationRecruits.put("Flame", new HashMap<>());
        stationRecruits.put("Hydra", new HashMap<>());
        stationRecruits.put("Orchid", new HashMap<>());
        stationRecruits.put("Pearl", new HashMap<>());
    }
}
