package com.example.demo.controller;

import com.example.demo.model.MoveRequest;
import com.example.demo.model.MoveResponse;
import com.example.demo.service.ChessGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/game")
public class GameController {

    private final ChessGameService gameService;

    @Autowired
    public GameController(ChessGameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/move")
    public MoveResponse move(@RequestBody MoveRequest request) {
        return gameService.makeMove(request);
    }
}
