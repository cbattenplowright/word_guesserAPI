package com.bnta.word_guesser.models;

// DTO
public class Reply {

    private String wordState; // the state of completion of the word "*****" / "h****"
    private String message;
    private boolean correct; // Refactoring improving the efficiency of the app

    public Reply(String wordState, String message, boolean correct) {
        this.wordState = wordState;
        this.message = message;
        this.correct = correct;
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

    public boolean getCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }
}
