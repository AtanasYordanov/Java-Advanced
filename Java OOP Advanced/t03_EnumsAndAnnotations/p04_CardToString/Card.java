package t03_EnumsAndAnnotations.p04_CardToString;

public class Card {
    private CardRank cardRank;
    private CardSuit cardSuit;

    public Card(String cardRank, String cardSuit) {
        this.cardRank = CardRank.valueOf(cardRank);
        this.cardSuit = CardSuit.valueOf(cardSuit);
    }

    public int getPower() {
        return this.cardRank.getPower() + this.cardSuit.getPower();
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d"
                , this.cardRank.name(), this.cardSuit.name(), this.getPower());
    }
}
