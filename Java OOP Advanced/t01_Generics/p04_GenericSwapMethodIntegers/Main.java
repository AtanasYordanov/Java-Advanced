package t01_Generics.p04_GenericSwapMethodIntegers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        GenericBox<Integer> box = new GenericBox<>();
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            box.add(Integer.parseInt(reader.readLine()));
        }
        String[] tokens = reader.readLine().split(" ");
        int firstIndex = Integer.parseInt(tokens[0]);
        int secondIndex = Integer.parseInt(tokens[1]);
        box.swapElements(firstIndex, secondIndex);
        System.out.println(box);
    }
}
