package com.bnta.word_guesser.controllers;

import com.bnta.word_guesser.models.Game;
import com.bnta.word_guesser.models.Reply;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Adding the @RestController annotation gives the controller the configuration needed to process the requests and serialisation of JSON files
@RestController
public class GameController {

    // This is the method that will fire when the Get request is heard
    @GetMapping("/games") // "/games" is the route that will trigger the GET request
    public Reply newGame() {
        Game game = new Game("hello"); // Creates game object
        return new Reply("*****", "New game started"); // Spring will serialise the return object and send to the client
    }

}
