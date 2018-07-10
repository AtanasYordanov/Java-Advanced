package t01_Generics.p02_GenericBoxOfInteger;

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
        System.out.println(box);
    }
}
