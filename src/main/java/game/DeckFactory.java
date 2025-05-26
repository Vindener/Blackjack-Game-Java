package factory;

import model.Card;
import model.Deck;

public class DeckFactory {
    public static Deck createStandardDeck() {
        Deck deck = new Deck();
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                deck.addCard(new Card(suit, rank));
            }
        }
        deck.shuffle();
        return deck;
    }
}
