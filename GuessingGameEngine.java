/*
 * This is the first thing I create when learning a new language.
 * I repurpose it now for demonstrating my knowledge
 * created at 4:30pm June 7th, 2018
 */

public class GuessingGameEngine {
    // constants
    final public int MINIMUM_NUMBER = 1;
    final public int DEFAULT_MAXIMUM_NUMBER = 10;
    // properites
    private int targetNumber = 0; // Can not be guessed (intitalization to 0 is redundant but clarifies)
    private int maximumNumber = DEFAULT_MAXIMUM_NUMBER;
    private boolean gameWon = false;

    public GuessingGameEngine() {
        generateAndSetTargetNumber();
    }

    public GuessingGameEngine(int targetNumber) {

    }
    
    private int generateAndSetTargetNumber() {
        return 5; // random number determined by dice roll
    }

    public boolean inputAndGuess(int guess) {
        if(guess == targetNumber) {
            gameWon = true;
            return true;
        } else { // else not necessary. kept for style
            return false;
        }
    }
}