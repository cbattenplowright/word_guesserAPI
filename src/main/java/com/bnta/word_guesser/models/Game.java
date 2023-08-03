package com.bnta.word_guesser.models;

// POJO class
public class Game {

    private String word;
    private int guesses;
    private boolean complete;

//    Constructor for developer, we will make game objects with this
    public Game(String word) {
        this.word = word;
        this.guesses = 0;
        this.complete = false;
    }

//    When Spring constructs the object it uses an empty/default constructor it will serialise and de-serialise from JSON accessing them from the getters and setters
    public Game(){
    }

//    Getters and Setters
    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getGuesses() {
        return guesses;
    }

    public void setGuesses(int guesses) {
        this.guesses = guesses;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}
