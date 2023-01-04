package com.example.wordleclonerebuild;

import java.util.Arrays;

/**
 * Represents the win condition array for a Wordle game.
 * @author Mahannah
 * @version 4 January 2023
 */
public class winCondition implements Comparable {

    private final Boolean[] solution;

    /**
     * Creates an object of type winCondition.
     *
     * @param lettersPerWord the length of the array to be created.
     */
    public winCondition(final int lettersPerWord) {
        this.solution = new Boolean[lettersPerWord];
    }

    /**
     * Updates the solution array with a specified Boolean value at the specified index.
     *
     * @param index the index position that's updated.
     * @param value the value to be added to the specified index position.
     */
    public void updateSolution(final int index, final boolean value) {
        solution[index] = value;
    }

    /**
     * Checks if the two specified letters are equivalent.
     *
     * @param firstLetter the first letter to be compared.
     * @param secondLetter the second letter to be compared.
     * @return true if the letters are equivalent, else false.
     */
    @Override
    public boolean lettersAreEqual(final String firstLetter, final String secondLetter) {
        return (firstLetter.equals(secondLetter));
    }

    /**
     * Checks if the specified letter is in the specified word.
     *
     * @param letter the letter (String) to be looked for in the word.
     * @param word the word to be evaluated.
     * @return true if the letter is in the word, else false.
     */
    @Override
    public boolean letterIsInWord(final String letter, final Updatable[] word) {
        /*
         * The compiler doesn't know if an object of type Updatable contains Strings. So here,
         * we're looping through each of the objects in "word", whatever they may be, converting
         * each of those objects to a String, then comparing that String to "letter", itself a
         * String, to see if they match. We're explicitly asking to look for a String comparison.
         */
        for (Updatable letterInWord : word) {
            if (letterInWord.toString().equals(letter)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the win condition is met -- i.e., the array contains only "true" values.
     *
     * @return true if the array contains all "true" values, else false.
     */
    public Boolean checkIfWinConditionMet() {
        return Arrays.stream(solution).anyMatch(booleanValue -> !booleanValue);
    }
}