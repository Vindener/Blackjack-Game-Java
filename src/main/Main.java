package main;

import game.GameEngine;

public class Main {
    public static void main(String[] args) {
        GameEngine game = new GameEngine();

        System.out.println("Player hand: " + game.getPlayer().getHand());
        System.out.println("Dealer hand: " + game.getDealer().getHand());

        game.playerHit();
        game.dealerTurn();

        System.out.println("Final Player hand: " + game.getPlayer().getHand());
        System.out.println("Final Dealer hand: " + game.getDealer().getHand());
        System.out.println(game.determineWinner());
    }
}
