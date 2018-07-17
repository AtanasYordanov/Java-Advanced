package t03_EnumsAndAnnotations.p05_CardCompareTo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String rank = reader.readLine();
        String suit = reader.readLine();
        Card firstCard = new Card(rank, suit);
        rank = reader.readLine();
        suit = reader.readLine();
        Card secondCard = new Card(rank, suit);
        Card greaterCard = firstCard.compareTo(secondCard) > 0 ? firstCard : secondCard;
        System.out.println(greaterCard);
    }
}
