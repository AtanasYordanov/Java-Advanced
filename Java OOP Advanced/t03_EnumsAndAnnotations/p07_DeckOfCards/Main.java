package t03_EnumsAndAnnotations.p07_DeckOfCards;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();
        List<Card> deck = new ArrayList<>();
        CardSuit[] suits = CardSuit.values();
        CardRank[] ranks = CardRank.values();
        for (CardSuit suit : suits) {
            for (CardRank rank : ranks) {
                Card card = new Card(rank, suit);
                deck.add(card);
            }
        }
        for (Card card : deck) {
            System.out.println(card);
        }
    }
}
