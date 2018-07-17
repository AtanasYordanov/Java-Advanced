package t03_EnumsAndAnnotations.p08_CardGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstPlayer = reader.readLine();
        String secondPlayer = reader.readLine();
        Map<String, Card> handedCards = new HashMap<>();
        boolean firstPlayerWins = false;
        Card bestCard = null;
        while (handedCards.size() < 10) {
            String cardName = reader.readLine();
            try {
                String[] rankAndSuit = cardName.split("\\s+of\\s+");
                CardRank cardRank = CardRank.valueOf(rankAndSuit[0]);
                CardSuit cardSuit = CardSuit.valueOf(rankAndSuit[1]);
                if (!handedCards.containsKey(cardName)) {
                    Card card = new Card(cardRank, cardSuit);
                    int power = card.getPower();
                    if (bestCard == null || power > bestCard.getPower()) {
                        bestCard = card;
                        firstPlayerWins = handedCards.size() <= 5;
                    }
                    handedCards.put(card.toString(), card);
                } else {
                    System.out.println("Card is not in the deck.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("No such card exists.");
            }
        }
        String end = String.format(" wins with %s.", bestCard);
        String output = firstPlayerWins ? firstPlayer + end : secondPlayer + end;
        System.out.println(output);
    }
}
