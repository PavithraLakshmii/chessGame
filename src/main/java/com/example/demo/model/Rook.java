package com.example.demo.model;

public class Rook extends Piece {
    public Rook(Color color) {
        super(color);
    }

    @Override
    public boolean isValidMove(Board board, Position from, Position to) {
        int dr = to.getRow() - from.getRow();
        int dc = to.getCol() - from.getCol();
        if (dr == 0 && dc == 0) return false;
        if (dr == 0 || dc == 0) {
            if (board.isPathClear(from, to)) {
                Cell dest = board.getCell(to);
                return dest.isEmpty() || dest.getPiece().getColor() != this.color;
            }
        }
        return false;
    }
}
