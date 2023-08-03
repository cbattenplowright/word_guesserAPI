package com.bnta.word_guesser.controllers;

import com.bnta.word_guesser.models.Game;
import com.bnta.word_guesser.models.Reply;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Adding the @RestController annotation gives the controller the configuration needed to process the requests and serialisation of JSON files
@RestController
@RequestMapping(value = "/games") // This annotation signifies a generic prefix
public class GameController {

    // This is the method that will fire when the Post request is heard
    @PostMapping
    public ResponseEntity<Reply> newGame() {
        Game game = new Game("hello"); // Creates game object
        Reply reply = new Reply("*****", "New game started");
        return new ResponseEntity<>(reply, HttpStatus.OK); // When returning a ResponseEntity type requires an object and status code
    }

}
