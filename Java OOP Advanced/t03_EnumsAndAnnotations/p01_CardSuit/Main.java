package t03_EnumsAndAnnotations.p01_CardSuit;

public class Main {
    public static void main(String[] args) {
        CardSuit[] suits = CardSuit.values();
        System.out.println("Card Suits:");
        for (CardSuit suit : suits) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", suit.ordinal(), suit.name());
        }
    }
}
