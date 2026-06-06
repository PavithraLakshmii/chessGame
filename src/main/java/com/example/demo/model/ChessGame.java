package com.example.demo.model;

public class ChessGame {
    private final Player white;
    private final Player black;
    private final Board board;
    private Color turn = Color.WHITE;

    public ChessGame(Player white, Player black) {
        this.white = white;
        this.black = black;
        this.board = new Board();
    }

    public Board getBoard() {
        return board;
    }

    public boolean makeMove(Move move) {
        Position from = move.getFrom();
        Position to = move.getTo();

        if (!inBounds(from) || !inBounds(to)) return false;
        if (from.equals(to)) return false;

        Cell s = board.getCell(from);
        if (s == null || s.isEmpty()) return false;
        Piece p = s.getPiece();
        if (p.getColor() != turn) return false; // wrong player's turn

        boolean ok = board.move(from, to);
        if (ok) {
            // flip turn
            turn = (turn == Color.WHITE) ? Color.BLACK : Color.WHITE;
        }
        return ok;
    }

    private boolean inBounds(Position p) {
        return p != null && p.getRow() >= 0 && p.getRow() < 8 && p.getCol() >= 0 && p.getCol() < 8;
    }
}
