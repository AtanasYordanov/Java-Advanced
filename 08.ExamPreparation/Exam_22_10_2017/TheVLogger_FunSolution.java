package ExamPreparation.Exam_22_10_2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TheVLogger_FunSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Set<String>> vloggerFollowers = new HashMap<>();

        for (String input = reader.readLine(); !input.equals("Statistics"); input = reader.readLine()) {
            String[] tokens = input.split(" ");
            String vlogger = tokens[0];
            String command = tokens[1];
            if (command.equals("joined")) {
                vloggerFollowers.putIfAbsent(vlogger, new HashSet<>());
            } else {
                String followedVlogger = tokens[2];
                if (vloggerFollowers.containsKey(vlogger) && vloggerFollowers.containsKey(followedVlogger)
                        && !vlogger.equals(followedVlogger)) {
                    vloggerFollowers.get(followedVlogger).add(vlogger);
                }
            }
        }
        System.out.printf("The V-Logger has a total of %d vloggers in its logs.%n", vloggerFollowers.size());

        final int[] counter = {1};
        vloggerFollowers.entrySet().stream()
                .sorted((a, b) -> {
                    int comp = b.getValue().size() - a.getValue().size();
                    if (comp == 0) {
                        comp = Long.compare(
                                vloggerFollowers.values().stream()
                                        .filter(f -> f.contains(a.getKey()))
                                        .count()
                                ,
                                vloggerFollowers.values().stream()
                                        .filter(f -> f.contains(b.getKey()))
                                        .count());
                    }
                    return comp;
                })
                .forEach(kvp -> {
                    System.out.printf("%d. %s : %d followers, %d following%n"
                            , counter[0]
                            , kvp.getKey()
                            , vloggerFollowers.get(kvp.getKey()).size()
                            , vloggerFollowers.values().stream()
                                    .filter(a -> a.contains(kvp.getKey()))
                                    .count());
                    if (counter[0]++ == 1) {
                        vloggerFollowers.get(kvp.getKey()).stream()
                                .sorted()
                                .forEach(f -> System.out.printf("*  %s%n", f));
                    }
                });
    }
}
