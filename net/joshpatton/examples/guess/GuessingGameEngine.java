/*
 * This is the first thing I create when learning a new language.
 * I repurpose it now for demonstrating my knowledge
 * created at 4:30pm June 7th, 2018 by Josh Patton
 */
package net.joshpatton.examples.guess;

import java.util.stream.IntStream;
import java.util.Random;

public class GuessingGameEngine {
    // constants
    final public int MINIMUM_NUMBER = 1;
    final public int DEFAULT_MAXIMUM_NUMBER = 10;
    final public int DEFAULT_MAXIMUM_GUESSES = 5;
    // properties for the number to guess
    private int targetNumber = 0; // Cannot be guessed (intitalization to 0 is redundant but clarifies)
    private int maximumNumber = DEFAULT_MAXIMUM_NUMBER;
    // game state
    private boolean gameWon = false;
    private boolean gameOver = false;
    private int guessesMade = 0;
    private int maximumGuesses = DEFAULT_MAXIMUM_GUESSES;
    

    public GuessingGameEngine() {
        generateAndSetTargetNumber();
    }

    public GuessingGameEngine(int targetNumber) {
        this.targetNumber = targetNumber;
    }
    
    private void generateAndSetTargetNumber() {
        // TODO: consider making randomIntStream static for performance
        // Stacking the Random object and the ints call is not pretty but it makes converting to static simpler
        IntStream randomIntStream = (new Random()).ints(MINIMUM_NUMBER, (maximumNumber + 1));

        this.targetNumber = randomIntStream.findFirst().getAsInt();
    }

    public boolean inputAndGuess(int guess) throws IllegalArgumentException {
        if(gameOver) return false;
        if(!isInputValid(guess)) {
            throw new IllegalArgumentException("Guess is invalid");
        }

        guessesMade++;
        
        if(guess == targetNumber) {
            gameWon = true;
            gameOver = true;
            return true;
        } else {
            if(guessesMade >= maximumGuesses) { // use greater than equal to instead of equal to as backup
                gameOver = true;
            }
            return false;
        }
    }

    private boolean isInputValid(int guess) {
        return guess >= MINIMUM_NUMBER && guess <= maximumNumber;
    }

    // GETTERS / SETTERS

    public boolean isGameOver() {
        return this.gameOver;
    }

    public boolean isGameWon() {
        return this.gameWon;
    }

    public int getGuessesMade() {
        return this.guessesMade;
    }

    public int getTargetNumber() {
        return this.targetNumber;
    }
}