package com.bnta.word_guesser.models;

// DTO
public class Reply {

    private String wordState; // the state of completion of the word "*****" / "h****"
    private String message;

    public Reply(String wordState, String message) {
        this.wordState = wordState;
        this.message = message;
    }

//    default constructor for Spring
    public Reply() {

    }

//    Getters and Setters
    public String getWordState() {
        return wordState;
    }

    public void setWordState(String wordState) {
        this.wordState = wordState;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
