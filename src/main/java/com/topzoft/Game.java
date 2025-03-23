package com.topzoft;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private Player player;
    private Monster[] monsters;
    private int turn = 0;

    public Game(Player player, Monster[] monsters) {
        this.player = player;
        this.monsters = monsters;
    }

    // Initializes and starts the game
    public void startGame() {
        System.out.println("Game starting...");
        System.out.println("Player: " + player.getName() + " vs " + monsters.length + " monster(s)");
        gameLoop(); // Begin the main game loop
    }

    // Runs the core game loop, alternating between player and monster turns
    private void gameLoop() {
        while (true) { // Loop until game ends
            turn++;
            System.out.println("\nTurn " + turn + ":");

            // Player's turn
            if(!player.isAlive()){
                endGame(false);
                break;
            }
            System.out.println(player.getName() + "'s turn (Health: " + player.getHealth() + ")");
            Character target = this.player.selectTarget(monsters);
            this.player.chooseAction(turn, target);

            // Monsters' turn
            Character attackingMonster = selectAttackingMonster(monsters);
            if(attackingMonster == null){
               endGame(true);
               break;
            }
            System.out.println(attackingMonster.getName() + "'s turn (Health: " + attackingMonster.getHealth() + ")");
            attackingMonster.chooseAction(turn, player);
        }
    }

    public Character selectAttackingMonster(Character[] opponents) {
        // List to store alive monsters
        List<Character> aliveMonsters = new ArrayList<>();

        // Filter out the monsters that are alive
        for (Character opponent : opponents) {
            if (opponent.isAlive()) {
                aliveMonsters.add(opponent);
            }
        }

        // If no monsters are alive, return null
        if (aliveMonsters.isEmpty()) {
            System.out.println("No monsters are alive to attack.");
            return null;
        }
        
        // Randomly select a monster from the alive monsters
        Random random = new Random();
        int randomIndex = random.nextInt(aliveMonsters.size()); // Get a random index
        return aliveMonsters.get(randomIndex); // Return the randomly selected monster
    }

    // Ends the game and displays the result
    private void endGame(boolean playerWon) {
        if (playerWon) {
            System.out.println("\nVictory! " + player.getName() + " defeated all monsters!");
        } else {
            System.out.println("\nDefeat! " + player.getName() + " was slain by the monsters.");
        }
        System.out.println("Game over after " + turn + " turns.");
    }
}