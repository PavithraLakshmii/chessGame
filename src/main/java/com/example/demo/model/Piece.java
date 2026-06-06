package com.example.demo.model;

import com.example.demo.utils.Board;

public abstract class Piece {
    protected final Color color;

    protected Piece(Color color) { this.color = color; }

    public Color getColor() { return color; }

    public abstract boolean isValidMove(Board board, Position from, Position to);

    protected boolean isOpponentPiece(Board board, Position pos) {
        Cell c = board.getCell(pos);
        return c != null && !c.isEmpty() && c.getPiece().getColor() != this.color;
    }
}
