package t05_InterfacesAndAbstraction.p04_Telephony;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Smartphone phone = new Smartphone();
        String[] numbers = reader.readLine().split(" ");
        String[] URLs = reader.readLine().split(" ");

        for (String number : numbers) {
            try {
                phone.callPhone(number);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        for (String url : URLs) {
            try {
                phone.browseWeb(url);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
