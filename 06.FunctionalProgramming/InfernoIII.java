package FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.BiConsumer;

public class InfernoIII {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> gems = getGems(reader);
        Map<String, Set<Integer>> filters = getFilters(reader);
        BiConsumer<List<Integer>, Map<String, Set<Integer>>> filter = defineConsumer();
        filter.accept(gems, filters);
        printOutput(gems);
    }

    private static BiConsumer<List<Integer>, Map<String, Set<Integer>>> defineConsumer() {
        return (gems, filters) -> {
            Set<Integer> indicesToRemove = new TreeSet<>(Comparator.reverseOrder());
            for (int i = 0; i < gems.size(); i++) {
                for (Map.Entry<String, Set<Integer>> pair : filters.entrySet()) {
                    for (Integer sum : pair.getValue()) {
                        switch (pair.getKey()) {
                            case "Sum Left":
                                int leftSum = i > 0 ? gems.get(i) + gems.get(i - 1) : gems.get(i);
                                if (leftSum == sum) {
                                    indicesToRemove.add(i);
                                }
                                break;
                            case "Sum Right":
                                int rightSum = i < gems.size() - 1 ? gems.get(i) + gems.get(i + 1) : gems.get(i);
                                if (rightSum == sum) {
                                    indicesToRemove.add(i);
                                }
                                break;
                            case "Sum Left Right":
                                int leftRightSum = i < gems.size() - 1 ? gems.get(i) + gems.get(i + 1) : gems.get(i);
                                leftRightSum = i > 0 ? leftRightSum + gems.get(i - 1) : leftRightSum;
                                if (leftRightSum == sum) {
                                    indicesToRemove.add(i);
                                }
                                break;
                        }
                    }
                }
            }
            for (int integer : indicesToRemove) {
                gems.remove(integer);
            }
        };
    }

    private static void printOutput(List<Integer> gems) {
        StringBuilder sb = new StringBuilder();
        for (Integer gem : gems) {
            sb.append(gem).append(" ");
        }
        System.out.println(sb);
    }

    private static Map<String, Set<Integer>> getFilters(BufferedReader reader) throws IOException {
        Map<String, Set<Integer>> filters = new HashMap<>();
        for (String input = reader.readLine(); !input.equals("Forge"); input = reader.readLine()) {
            String[] tokens = input.split(";");
            String command = tokens[0];
            String type = tokens[1];
            int parameter = Integer.parseInt(tokens[2]);
            if (command.endsWith("Exclude")) {
                filters.putIfAbsent(type, new HashSet<>());
                filters.get(type).add(parameter);
            } else {
                filters.get(type).remove(parameter);
            }
        }
        return filters;
    }

    private static List<Integer> getGems(BufferedReader reader) throws IOException {
        List<Integer> gems = new ArrayList<>();
        String[] input = reader.readLine().split(" ");
        for (String str : input) {
            gems.add(Integer.parseInt(str));
        }
        return gems;
    }
}