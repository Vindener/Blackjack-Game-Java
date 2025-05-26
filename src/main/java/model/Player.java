package model;

import java.util.*;

public class Player {
    private final List<Card> hand = new ArrayList<>();

    public void receiveCard(Card card) {
        hand.add(card);
    }

    public int getScore() {
        int score = 0;
        int aceCount = 0;
        for (Card c : hand) {
            score += c.getValue();
            if (c.getRank() == Card.Rank.ACE) aceCount++;
        }
        while (score > 21 && aceCount > 0) {
            score -= 10; // adjust ace from 11 to 1
            aceCount--;
        }
        return score;
    }

    public List<Card> getHand() {
        return hand;
    }

    public boolean isBusted() {
        return getScore() > 21;
    }
}
