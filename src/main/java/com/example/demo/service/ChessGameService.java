package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.*;
import com.example.demo.utils.ChessGame;

import javax.annotation.PostConstruct;

@Service
public class ChessGameService {

    private ChessGame chessGame;

    @PostConstruct
    public void init() {

        Player white =
                new Player("White",
                        Color.WHITE);

        Player black =
                new Player("Black",
                        Color.BLACK);

        chessGame =
                new ChessGame(white, black);
    }

    public MoveResponse makeMove(
            MoveRequest request) {

        Move move =
                new Move(
                        new Position(
                                request.getFromRow(),
                                request.getFromCol()),

                        new Position(
                                request.getToRow(),
                                request.getToCol()));

        boolean result =
                chessGame.makeMove(move);

        return new MoveResponse(
                result,
                result ? "Move Applied"
                        : "Invalid Move");
    }
}