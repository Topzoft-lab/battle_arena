# Battle Arena Game

**Battle Arena** is an engaging, turn-based combat game where players face off against various monsters. Players can choose their actions (attack, defend, heal) strategically while attempting to defeat the monster before their own health is depleted. The game provides a simple but fun way to practice Java fundamentals like **Object-Oriented Programming (OOP)**, **collections**, and **game loop mechanics**.

## Features:
- **Character Creation**: Players and monsters are represented by characters with customizable attributes like health, attack power, and defense.
- **Turn-Based Combat**: Players and monsters take turns selecting actions such as **attacking**, **defending**, or **healing**.
- **Randomized Target Selection**: In case of multiple opponents, players can select their target randomly or based on strategy.
- **Health System**: Characters have health points that decrease when they take damage. Players must manage their health wisely.
- **Strategic Combat**: Players need to decide when to attack, defend, or heal to outlast their opponents.
- **Multiple Opponents**: The game can be expanded to feature multiple types of monsters with different attack and defense abilities.

## Technologies Used:
- **Java**: The game is developed using Java, focusing on **Object-Oriented Programming (OOP)** principles.
- **Collections**: The game utilizes **Maps**, **Lists**, and **Arrays** to manage the game state, opponents, and actions.
- **Random Selection**: The game uses randomization for actions like selecting an opponent or determining the outcome of some attacks.
- **Scanner for Input**: User input is handled through the **Scanner** class, allowing players to choose actions during the game.

## Getting Started:
1. Clone the repository to your local machine.
2. Compile and run the project using your preferred Java IDE or the command line.
3. Start the game by following the in-game prompts to select your actions and attack opponents.
4. Enjoy strategizing and defeating monsters in the arena!

## Project Structure:
- **`Character.java`**: The base class representing both the player and the monsters.
- **`Player.java`**: A subclass of `Character` with player-specific logic and actions.
- **`Monster.java`**: A subclass of `Character` with monster-specific behaviors.
- **`Game.java`**: The main class that handles the game flow, including turns and combat logic.
- **`Main.java`**: The entry point that starts the game and handles user interactions.

## Future Enhancements:
- Implement more diverse **monster types** with different behaviors (e.g., healers, tanks).
- Add **special abilities** for characters, such as critical hits or area damage.
- Allow for **multiplayer** support, where players can battle each other.
- Introduce **levels** or **waves** of monsters with increasing difficulty.
