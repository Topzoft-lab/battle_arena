package com.topzoft;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Player extends Character {

    private boolean isDefending = false;
    private float defensePower;

    public Player(String name, int health, int attackPower, float defensePower) {
        super(name, health, attackPower);
        // Clamp defensePower between 0.1 and 0.9
        this.defensePower = Math.max(0.1f, Math.min(0.9f, defensePower));
    }

    @Override
    public void takeDamage(int damage) {
        int reducedDamage = damage; // Default to full damage
        if (this.isDefending) {
            // Multiply damage by (1 - defensePower) to reduce it
            reducedDamage = (int) (damage * (1.0f - defensePower));
            System.out.println(this.name + " defends, reducing damage from " + damage + " to " + reducedDamage);
            this.isDefending = false; // Reset defending after one attack
        }
        super.takeDamage(reducedDamage); // Apply the reduced damage
    }

    @Override
    public void attack(Character character) {
        character.takeDamage(this.attackPower);
    }

    @Override
    public void chooseAction(int turn, Character target) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Turn " + turn + ": Choose an action for " + this.name + " (health: " + this.health + "):");
        System.out.println("1: Attack | 2: Defend | 3: Heal");
        int choice = scanner.nextInt();
        // scanner.close();

        switch (choice) {
            case 1:
                attack(target);
                break;
            case 2:
                defend(target);
                break;
            case 3:
                heal();
                break;
            default:
                System.out.println("Invalid choice! Skipping turn.");
        }
    }

    public Character selectTarget(Character[] opponents) {
        if (opponents.length == 0)
            return null;
        if (opponents.length == 1) {
            return opponents[0];
        }
        // Display the available targets to the player
        System.out.println("Select your target:");

        // Create a Map to store character names as the key and the Character object as
        // the value
        Map<Integer, Character> opponentsMap = new HashMap<>();
        int i = 1;

        // Populate the Map with character names and corresponding objects
        for (Character opponent : opponents) {
            opponentsMap.put(i, opponent);
            System.out.println(i + ". " + opponent.getName());
            i++;
        }

        // Get player input for selecting a target
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of the opponent you want to attack: ");
        int playerChoice = scanner.nextInt();
        // scanner.close();

        // Get the character name from the number chosen
        if (opponentsMap.containsKey(playerChoice)) {
            return opponentsMap.get(playerChoice); // Return the corresponding Character object
        } else {
            System.out.println("Invalid choice. Please select a valid opponent.");
            return null;
        }

    }

    public void defend(Character character) {
        this.isDefending = true;
    }

    public void heal() {
        this.health = this.health + 20;
        if (this.health > 100) {
            this.health = 100;
        }
    }

}
