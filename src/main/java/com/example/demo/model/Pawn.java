package com.example.demo.model;
import com.example.demo.utils.Board;

public class Pawn extends Piece {
    public Pawn(Color color) {
        super(color);
    }

    @Override
    public boolean isValidMove(Board board, Position from, Position to) {
        int dir = (this.color == Color.WHITE) ? -1 : 1;
        int startRow = (this.color == Color.WHITE) ? 6 : 1;

        int dr = to.getRow() - from.getRow();
        int dc = to.getCol() - from.getCol();

        Cell dest = board.getCell(to);

        // Forward move
        if (dc == 0) {
            // one step
            if (dr == dir && dest.isEmpty()) return true;
            // two steps from starting position
            if (from.getRow() == startRow && dr == 2 * dir) {
                Position between = from.offset(dir, 0);
                if (board.getCell(between).isEmpty() && dest.isEmpty()) return true;
            }
        }

        // capture
        if (Math.abs(dc) == 1 && dr == dir && !dest.isEmpty() && dest.getPiece().getColor() != this.color) {
            return true;
        }

        return false;
    }
}
