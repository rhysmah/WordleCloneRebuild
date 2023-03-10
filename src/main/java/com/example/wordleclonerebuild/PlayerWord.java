package com.example.wordleclonerebuild;

import java.util.Arrays;

public class PlayerWord extends Word implements Updatable {

    private static final String VALID_CHARACTERS = "^[a-zA-Z]*$";
    private static final int    LETTERS_PER_WORD = 5;

    private final String[] playerWordLetters;

    public PlayerWord() {
        super();
        this.playerWordLetters = new String[LETTERS_PER_WORD];
    }

    /**
     * Replaces the character (String) at a specific index position.
     *
     * @param indexPosition the index (int) position of the character to be changed.
     * @param character the character (String) to be added to the specified index position.
     */
    @Override
    public void updateLetterAtIndexPosition(final String character, final int indexPosition) {
        playerWordLetters[indexPosition] = character.toUpperCase();
    }

    /**
     * Returns the player word as an array letters.
     *
     * @return the player words as an array (String[]).
     */
    public String[] getLetters() {
        return playerWordLetters;
    }

    /**
     * Checks if the player word is valid.
     *
     * @return true if the player word is a five-letter word in the list of words, else false.
     */
    public boolean notValidWord() {
        String word = String.join("", playerWordLetters);
        return !containsValidCharacters(word) || !isValidLength(word) || !isInWordList(word);
    }

    /*
     * Checks that the player word contains valid characters.
     */
    private boolean containsValidCharacters(final String word) {
        return word.matches(VALID_CHARACTERS);
    }

    /*
     * Checks that the player word is the correct length.
     */
    private boolean isValidLength(final String word) {
        return word.length() == LETTERS_PER_WORD;
    }

    /*
     * Checks that the player word is in the word list.
     */
    private boolean isInWordList(final String word) {
        return Arrays.asList(WordList.WORDS).contains(word);
    }
}
