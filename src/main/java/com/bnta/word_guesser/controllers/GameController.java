package com.bnta.word_guesser.controllers;

import com.bnta.word_guesser.models.Game;
import com.bnta.word_guesser.models.Guess;
import com.bnta.word_guesser.models.Reply;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

// Adding the @RestController annotation gives the controller the configuration needed to process the requests and serialisation of JSON files
@RestController
@RequestMapping(value = "/games") // This annotation signifies a generic prefix
public class GameController {

    private Game game;
    private String currentWord; // currentWord will have the word return to the client
    private ArrayList<String> guessedLetters;

    //    Endpoint that will fire when the Post request is heard
    @PostMapping
    public ResponseEntity<Reply> newGame() { // Runs once per game
        game = new Game("hello"); // Creates game object
        currentWord = "*****";
        guessedLetters = new ArrayList<>();
        Reply reply = new Reply(currentWord, "New game started", false);
        return new ResponseEntity<>(reply, HttpStatus.OK); // When returning a ResponseEntity type requires an object and status code
    }

    //    Endpoint that returns the status of the game
    @GetMapping
    public ResponseEntity<Reply> getGameStatus() {
        Reply reply = new Reply(currentWord, "Game is in progress", false);
        return new ResponseEntity<>(reply, HttpStatus.OK);
    }

    //    Endpoint that updates the word
    @PatchMapping
    public ResponseEntity<Reply> handleGuess(@RequestBody Guess guess) { // Patch mappings require a parameter annotation
        Reply reply; // 3 possible outcomes so instantiating an empty reply variable

        /* Game Logic PSEUDO CODE
        check if game started
        check if the letter is already guessed
        check for incorrect guess
        process the correct guess

              flip *'s of the correct letters
              add letter to guessedLetters Arraylist
              check if we won the game
        */


//        check if game started
        if (game == null) {
            reply = new Reply(currentWord, "Game has not been started", false);
            return new ResponseEntity<>(reply, HttpStatus.BAD_REQUEST);
        }

//        check if the letter is already guessed
        if (guessedLetters.contains(guess.getLetter())) {
//            guess.getLetter() returns the letter stored in the guess object and it is checked if it exists in the array list guessedLetters
            reply = new Reply(currentWord, String.format("Already guessed the letter %s", guess.getLetter()), false);
//            String.format() takes in a given string and formats it given a specific guess
            return new ResponseEntity<>(reply, HttpStatus.OK);
        }

        guessedLetters.add(guess.getLetter()); // adds the guessed letter to the array as so far it has not been added to the array

//        check for incorrect guess
        if (!game.getWord().contains(guess.getLetter())) {
            // Checks the games original word and checks if the guess exists within the original word
            reply = new Reply(currentWord, String.format("%s is not in the word.", guess.getLetter()), false);
            return new ResponseEntity<>(reply, HttpStatus.OK);
        }

//        process the correct guess
        String runningSolution = game.getWord();


        for (Character letter : game.getWord().toCharArray()) { // Need to convert the String returned by games getWord to a character array
            if (!guessedLetters.contains(letter.toString())) { // if the letter in the original word is NOT in guessed letters
               runningSolution = runningSolution.replace(letter, '*'); // replaces the letter in runningSolution with a '*', generating the word backwards
            }
        }

        currentWord = runningSolution;
        reply = new Reply(currentWord, String.format("%s is in the word", guess.getLetter()), true);
        return new ResponseEntity<>(reply, HttpStatus.OK);

    }

}
