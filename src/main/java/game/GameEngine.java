package game;

import model.Deck;
import model.Player;

public class GameEngine {
    private final Deck deck;
    private final Player player;
    private final Player dealer;

    public GameEngine() {
        this.deck = factory.DeckFactory.createStandardDeck();
        this.player = new Player();
        this.dealer = new Player();
        startRound();
    }

    private void startRound() {
        player.receiveCard(deck.drawCard());
        player.receiveCard(deck.drawCard());
        dealer.receiveCard(deck.drawCard());
        dealer.receiveCard(deck.drawCard());
    }

    public void playerHit() {
        player.receiveCard(deck.drawCard());
    }

    public void dealerTurn() {
        while (dealer.getScore() < 17) {
            dealer.receiveCard(deck.drawCard());
        }
    }

    public String determineWinner() {
        if (player.isBusted()) return "Dealer wins (player lose)";
        if (dealer.isBusted()) return "Player wins (dealer lose)";
        return Integer.compare(player.getScore(), dealer.getScore()) > 0 ? "Player wins" : "Dealer wins";
    }

    public Player getPlayer() { return player; }
    public Player getDealer() { return dealer; }
}