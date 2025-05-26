package model;

import java.util.*;

public class Deck {
    private final Stack<Card> cards = new Stack<>();

    public Deck() {
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                cards.push(new Card(suit, rank));
            }
        }
        shuffle();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        if (cards.isEmpty()) throw new IllegalStateException("Deck is empty");
        return cards.pop();
    }
}
