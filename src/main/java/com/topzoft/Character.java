package com.topzoft;

/**
 * Character Class (Base Class)
 * The Character class serves as a blueprint for both the Player and the
 * Monster. It contains common properties and methods.
 * 
 * Attributes:
 * name: The name of the character (e.g., "Hero" for the player, "Dragon" for
 * the monster).
 * health: The current health of the character.
 * attackPower: The strength of the character's attack.
 * Methods:
 * attack(opponent): Executes an attack on the opponent and reduces their
 * health.
 * takeDamage(damage): Reduces the health of the character by the specified
 * damage.
 * isAlive(): Returns a boolean indicating whether the character's health is
 * above zero.
 */
public abstract class Character {

    protected String name;
    protected int health;
    protected int attackPower;

    public Character(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    public void takeDamage(int damage) {
        System.out.println(this.name + " takes " + damage + " damage");
        this.health = this.health - damage;
        if (this.health < 0) {
            this.health = 0;
        }
        System.out.println(this.name + " health: " + this.health);
    }

    public String getName() {
        return this.name;
    }

    public int getHealth() {
        return this.health;
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    public abstract void attack(Character character);
    public abstract void chooseAction(int turn, Character character);

}
