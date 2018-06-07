/*
 * Driver for GuessingGameEngine
 * created at 4:37pm June 7th, 2018 by Josh Patton
 */
package net.joshpatton.examples.guess;

import java.util.Scanner;

public class GuessingGameApplication {
    Scanner scanner;
    public static void main(String[] args) {
        System.out.println("Guessing Game by Josh Patton");
        System.out.println("Created to demonstrate basic Java skills");
        System.out.println();
        playOneGame();
    }

    public static void playOneGame() {
        System.out.println("Guess a number 1 - 10");
        System.out.println("Input 'quit' to exit game");
        Scanner scanner = new Scanner(System.in);
        GuessingGameEngine engine = new GuessingGameEngine();

        while(!engine.isGameOver()) {
            System.out.print("1 - 10: ");
            String input = scanner.nextLine().trim();
            try {
                int guess = Integer.parseInt(input);
                if(!engine.inputAndGuess(guess)) {
                    System.out.println("Incorrect guess");
                }
            } catch (NumberFormatException e) {
                System.out.println("That is not a number. Ending game");
                userQuitGame();
            }
        }
        if(engine.isGameWon()) {
            System.out.println("Congratulations on winning the game!");
        } else {
            System.out.println("You have lost the game.");
            System.out.println("The number was " + engine.getTargetNumber());
        }
        System.out.println("You made " + engine.getGuessesMade() + " guesses");
        
    }

    public static void userQuitGame() {
        //TODO: show stats
        System.out.println("Goodbye");
        System.exit(0);
    }

}