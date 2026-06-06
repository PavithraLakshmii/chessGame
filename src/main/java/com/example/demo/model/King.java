package com.example.demo.model;

import com.example.demo.utils.Board;

public class King extends Piece {
    public King(Color color) {
        super(color);
    }

    @Override
    public boolean isValidMove(Board board, Position from, Position to) {
        int dr = Math.abs(from.getRow() - to.getRow());
        int dc = Math.abs(from.getCol() - to.getCol());
        if (dr <= 1 && dc <= 1 && !(dr == 0 && dc == 0)) {
            Cell dest = board.getCell(to);
            return dest.isEmpty() || dest.getPiece().getColor() != this.color;
        }
        return false;
    }
}
