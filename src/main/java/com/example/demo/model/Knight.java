package com.example.demo.model;

public class Knight extends Piece {
    public Knight(Color color) {
        super(color);
    }

    @Override
    public boolean isValidMove(Board board, Position from, Position to) {
        int dr = Math.abs(from.getRow() - to.getRow());
        int dc = Math.abs(from.getCol() - to.getCol());
        if ((dr == 1 && dc == 2) || (dr == 2 && dc == 1)) {
            Cell dest = board.getCell(to);
            return dest.isEmpty() || dest.getPiece().getColor() != this.color;
        }
        return false;
    }
}
