package factory;

import model.Card;

public class CardFactory {
    public static Card createCard(Card.Suit suit, Card.Rank rank) {
        return new Card(suit, rank);
    }
}
