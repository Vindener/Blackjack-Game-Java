package main;

import game.GameEngine;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    private static final String SAVE_FILE = "data/stats.json";

    public static void main(String[] args) {
        GameEngine game = new GameEngine();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Blackjack!");

        String result = null;

        while (true) {
            System.out.println("Player hand: " + game.getPlayer().getHand() + " (score: " + game.getPlayer().getScore() + ")");
            System.out.print("Do you want to hit or stand? (h/s): ");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("h")) {
                game.playerHit();
                if (game.getPlayer().isBusted()) {
                    result = "Dealer wins (player lose)";
                    System.out.println(result);
                    break;
                }
            } else if (choice.equalsIgnoreCase("s")) {
                game.dealerTurn();
                System.out.println("Dealer hand: " + game.getDealer().getHand() + " (score: " + game.getDealer().getScore() + ")");
                result = game.determineWinner();
                System.out.println(result);
                break;
            }
        }

        saveResult(result);
        scanner.close();
    }

    private static void saveResult(String result) {
        JSONObject stats = new JSONObject();
        int playerWins = 0;
        int dealerWins = 0;

        try {
            String content = new String(Files.readAllBytes(Paths.get(SAVE_FILE)), StandardCharsets.UTF_8);
            JSONObject old = (JSONObject) new JSONParser().parse(content);
            playerWins = ((Long) old.getOrDefault("playerWins", 0L)).intValue();
            dealerWins = ((Long) old.getOrDefault("dealerWins", 0L)).intValue();
        } catch (IOException | ParseException ignored) {}

        if (result.contains("Player wins")) playerWins++;
        else dealerWins++;

        stats.put("playerWins", playerWins);
        stats.put("dealerWins", dealerWins);

        try (FileWriter file = new FileWriter(SAVE_FILE)) {
            file.write(stats.toJSONString());
            System.out.println("Game stats saved to " + SAVE_FILE);
        } catch (IOException e) {
            System.out.println("Failed to save stats: " + e.getMessage());
        }
    }
}
