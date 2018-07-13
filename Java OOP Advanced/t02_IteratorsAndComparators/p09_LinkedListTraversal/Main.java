package t02_IteratorsAndComparators.p09_LinkedListTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        int n = Integer.parseInt(reader.readLine());

        while (n-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");
            String command = tokens[0];
            int element = Integer.parseInt(tokens[1]);
            switch (command) {
                case "Add":
                    list.addLast(element);
                    break;
                case "Remove":
                    list.remove(element);
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append(System.lineSeparator());
        list.forEach(num -> sb.append(num).append(" "));
        System.out.println(sb);
    }
}
