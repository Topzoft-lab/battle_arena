package com.topzoft;

public class Monster extends Character {

    private int specialAttackTurns;

    public Monster(String name, int health, int attackPower, int specialAttackTurns) {
        super(name, health, attackPower);
        this.specialAttackTurns = specialAttackTurns;
    }
    
    public void specialAttack(Character character) {
        character.takeDamage(attackPower * 2);
    }

    @Override
    public void attack(Character character) {
        character.takeDamage(attackPower);
    }

    @Override
    public void chooseAction(int turn, Character target) {
        if (turn % specialAttackTurns == 0 && turn > 0) {
            specialAttack(target);
        } else {
            attack(target);
        }
    }
}
    

