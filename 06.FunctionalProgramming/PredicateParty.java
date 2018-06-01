package FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> names = Arrays.stream(reader.readLine().split(" ")).collect(Collectors.toList());
        for (String input = reader.readLine(); !input.equals("Party!"); input = reader.readLine()) {
            String[] tokens = input.split(" ");
            String command = tokens[0];
            String type = tokens[1];
            String param = tokens[2];
            Predicate<String> filter = getPredicate(type, param);
            executeCommand(names, command, filter);
        }
        printResult(names);
    }

    private static void executeCommand(List<String> names, String command, Predicate<String> filter) {
        if (command.equals("Remove")) {
            names.removeIf(filter);
        } else {
            Set<String> namesToDouble = new HashSet<>();
            for (String name : names) {
                if (filter.test(name)) {
                    namesToDouble.add(name);
                }
            }
            for (int i = 0; i < names.size(); i++) {
                String name = names.get(i);
                if (namesToDouble.contains(name)) {
                    names.add(i++, name);
                }
            }
        }
    }

    private static Predicate<String> getPredicate(String type, String param) {
        Predicate<String> predicate;
        switch (type) {
            case "StartsWith":
                predicate = a -> a.startsWith(param);
                break;
            case "EndsWith":
                predicate = a -> a.endsWith(param);
                break;
            default:
                predicate = a -> a.length() == Integer.parseInt(param);
                break;
        }
        return predicate;
    }

    private static void printResult(List<String> names) {
        StringBuilder sb = new StringBuilder();
        if (names.isEmpty()) {
            sb.append("Nobody is going to the party!");
        } else {
            sb.append(String.join(", ", names));
            sb.append(" are going to the party!");
        }
        System.out.println(sb);
    }
}
