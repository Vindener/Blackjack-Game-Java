package strategy;

import game.GameEngine;

public class DealerStrategy implements PlayStrategy {
    @Override
    public void play(GameEngine engine) {
        engine.dealerTurn();
    }
}
