package com.topzoft;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        // create player
        Player hero = new Player("hero", 100, 20, 0.8f);
        Monster dragon = new Monster("dragon", 100, 10, 5);
        Monster goblin = new Monster("goblin", 100, 20, 3);
        Monster [] monsters = { dragon,goblin };
        Game battleArena = new Game(hero, monsters);

        battleArena.startGame();
    }
}