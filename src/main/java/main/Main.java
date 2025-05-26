package main;

import game.GameEngine;
import java.util.Scanner;
import strategy.DealerStrategy;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== Blackjack Menu");
            System.out.println("1. Start new game");
            System.out.println("2. Show statistics");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");
            String input = scanner.nextLine();

            if (input.equals("1")) {
                playGame(scanner);
            } else if (input.equals("2")) {
                StatsManager.getInstance().showStats();
            } else if (input.equals("3")) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }

    private static void playGame(Scanner scanner) {
        GameEngine game = new GameEngine();
        game.setDealerStrategy(new DealerStrategy());  // застосування патерну Strategy
        String result = null;

        while (true) {
            System.out.println("\nPlayer hand: " + game.getPlayer().getHand() + " (score: " + game.getPlayer().getScore() + ")");
            System.out.print("Do you want to hit or stand? (h/s): ");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("h")) {
                game.playerHit();
                if (game.getPlayer().isBusted()) {
                    System.out.println("\nPlayer busted!");
                    System.out.println("Final Player hand: " + game.getPlayer().getHand() + " (score: " + game.getPlayer().getScore() + ")");
                    System.out.println("Final Dealer hand: " + game.getDealer().getHand() + " (score: " + game.getDealer().getScore() + ")");
                    result = "Dealer wins (player busted)";
                    System.out.println(result);
                    break;
                }
            } else if (choice.equalsIgnoreCase("s")) {
                game.dealerPlay();  // <- виклик стратегії
                System.out.println("\nFinal Player hand: " + game.getPlayer().getHand() + " (score: " + game.getPlayer().getScore() + ")");
                System.out.println("Final Dealer hand: " + game.getDealer().getHand() + " (score: " + game.getDealer().getScore() + ")");
                result = game.determineWinner();
                System.out.println(result);
                break;
            } else {
                System.out.println("Invalid input. Type 'h' or 's'.");
            }
        }

        StatsManager.getInstance().saveResult(result);
    }
}
