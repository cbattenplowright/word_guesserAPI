package com.bnta.word_guesser.models;

public class Guess { // Needs to be a POJO class as the client will be sending through the users guess

    private String letter;

    public Guess(String letter) {
        this.letter = letter;
    }

    public Guess() {

    }

    public String getLetter() {
        return this.letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

}
