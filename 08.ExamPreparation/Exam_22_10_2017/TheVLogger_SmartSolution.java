package ExamPreparation.Exam_22_10_2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TheVLogger_SmartSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Set<String>> vloggerFollowers = new TreeMap<>();
        Map<String, Set<String>> vloggerFollowing = new HashMap<>();

        for (String input = reader.readLine(); !input.equals("Statistics"); input = reader.readLine()) {
            String[] tokens = input.split(" ");
            String vlogger = tokens[0];
            String command = tokens[1];
            if (command.equals("joined")) {
                vloggerFollowers.putIfAbsent(vlogger, new TreeSet<>());
                vloggerFollowing.putIfAbsent(vlogger, new HashSet<>());
            } else {
                String followedVlogger = tokens[2];
                if (vloggerFollowers.containsKey(vlogger) && vloggerFollowers.containsKey(followedVlogger)
                        && !vlogger.equals(followedVlogger)) {
                    vloggerFollowers.get(followedVlogger).add(vlogger);
                    vloggerFollowing.get(vlogger).add(followedVlogger);
                }
            }
        }

        System.out.printf("The V-Logger has a total of %d vloggers in its logs.%n", vloggerFollowers.size());

        final int[] counter = {1};
        vloggerFollowers.entrySet().stream()
                .sorted((a, b) -> {
                    int comp = b.getValue().size() - a.getValue().size();
                    if (comp == 0) {
                        comp = vloggerFollowing.get(a.getKey()).size() - vloggerFollowing.get(b.getKey()).size();
                    }
                    return comp;
                })
                .forEach(kvp -> {
                    System.out.printf("%d. %s : %d followers, %d following%n"
                            , counter[0]
                            , kvp.getKey()
                            , kvp.getValue().size()
                            , vloggerFollowing.get(kvp.getKey()).size());

                    if (counter[0]++ == 1) {
                        vloggerFollowers.get(kvp.getKey())
                                .forEach(f -> System.out.printf("*  %s%n", f));
                    }
                });
    }
}
