package FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class ThePartyReservationFilterModule {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] names = reader.readLine().split(" ");
        Map<String, Set<String>> filters = getFilters(reader);
        List<Predicate<String>> tests = getTests(filters);
        BiFunction<List<String>, Predicate<String>, List<String>> filter = defineFunction();
        List<String> filteredNames = filterNames(names, tests, filter);
        System.out.println(String.join(" ", filteredNames));
    }

    private static BiFunction<List<String>, Predicate<String>, List<String>> defineFunction() {
        return (arr, test) -> {
            List<String> result = new ArrayList<>();
            for (String str : arr) {
                if (test.test(str)) {
                    result.add(str);
                }
            }
            return result;
        };
    }

    private static List<String> filterNames(String[] names, List<Predicate<String>> tests
            , BiFunction<List<String>, Predicate<String>, List<String>> filter) {
        List<String> filteredNames = Arrays.asList(names);
        for (Predicate<String> test : tests) {
            filteredNames = filter.apply(filteredNames, test);
        }
        return filteredNames;
    }

    private static List<Predicate<String>> getTests(Map<String, Set<String>> filters) {
        List<Predicate<String>> tests = new ArrayList<>();
        for (Map.Entry<String, Set<String>> pair : filters.entrySet()) {
            for (String param : pair.getValue()) {
                switch (pair.getKey()) {
                    case "Starts with":
                        tests.add(a -> !a.startsWith(param));
                        break;
                    case "Ends with":
                        tests.add(a -> !a.endsWith(param));
                        break;
                    case "Length":
                        tests.add(a -> a.length() != Integer.parseInt(param));
                        break;
                    case "Contains":
                        tests.add(a -> !a.contains(param));
                        break;
                }
            }
        }
        return tests;
    }

    private static Map<String, Set<String>> getFilters(BufferedReader reader) throws IOException {
        Map<String, Set<String>> filters = new HashMap<>();
        for (String input = reader.readLine(); !input.equals("Print"); input = reader.readLine()) {
            String[] tokens = input.split(";");
            String command = tokens[0];
            String type = tokens[1];
            String parameter = tokens[2];
            if (command.endsWith("Add filter")) {
                filters.putIfAbsent(type, new HashSet<>());
                filters.get(type).add(parameter);
            } else {
                filters.get(type).remove(parameter);
            }
        }
        return filters;
    }
}