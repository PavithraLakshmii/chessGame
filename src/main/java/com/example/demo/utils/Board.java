package com.example.demo.utils;

import com.example.demo.model.Bishop;
import com.example.demo.model.Cell;
import com.example.demo.model.Color;
import com.example.demo.model.King;
import com.example.demo.model.Knight;
import com.example.demo.model.Pawn;
import com.example.demo.model.Piece;
import com.example.demo.model.Position;
import com.example.demo.model.Queen;
import com.example.demo.model.Rook;

public class Board {
    private final int size = 8;
    private final Cell[][] cells = new Cell[size][size];

    public Board() {
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                cells[r][c] = new Cell(new Position(r, c));
            }
        }
        setupStandard();
    }

    public Cell getCell(Position pos) {
        if (pos.getRow() < 0 || pos.getRow() >= size || pos.getCol() < 0 || pos.getCol() >= size) {
            return null;
        }
        return cells[pos.getRow()][pos.getCol()];
    }

    public boolean isPathClear(Position from, Position to) {
        int dr = Integer.compare(to.getRow(), from.getRow());
        int dc = Integer.compare(to.getCol(), from.getCol());

        int r = from.getRow() + dr;
        int c = from.getCol() + dc;
        while (r != to.getRow() || c != to.getCol()) {
            Cell cell = cells[r][c];
            if (!cell.isEmpty()) return false;
            r += dr;
            c += dc;
        }
        return true;
    }

    public boolean move(Position from, Position to) {
        Cell s = getCell(from);
        Cell d = getCell(to);
        if (s == null || d == null) return false;
        if (s.isEmpty()) return false;
        Piece p = s.getPiece();
        if (!p.isValidMove(this, from, to)) return false;
        if (!d.isEmpty() && d.getPiece().getColor() == p.getColor()) return false;

        d.setPiece(p);
        s.setPiece(null);
        return true;
    }

    private void setupStandard() {
        // Black major pieces row 0
        cells[0][0].setPiece(new Rook(Color.BLACK));
        cells[0][1].setPiece(new Knight(Color.BLACK));
        cells[0][2].setPiece(new Bishop(Color.BLACK));
        cells[0][3].setPiece(new Queen(Color.BLACK));
        cells[0][4].setPiece(new King(Color.BLACK));
        cells[0][5].setPiece(new Bishop(Color.BLACK));
        cells[0][6].setPiece(new Knight(Color.BLACK));
        cells[0][7].setPiece(new Rook(Color.BLACK));
        // Black pawns row 1
        for (int c = 0; c < size; c++) cells[1][c].setPiece(new Pawn(Color.BLACK));

        // White pawns row 6
        for (int c = 0; c < size; c++) cells[6][c].setPiece(new Pawn(Color.WHITE));
        // White major pieces row 7
        cells[7][0].setPiece(new Rook(Color.WHITE));
        cells[7][1].setPiece(new Knight(Color.WHITE));
        cells[7][2].setPiece(new Bishop(Color.WHITE));
        cells[7][3].setPiece(new Queen(Color.WHITE));
        cells[7][4].setPiece(new King(Color.WHITE));
        cells[7][5].setPiece(new Bishop(Color.WHITE));
        cells[7][6].setPiece(new Knight(Color.WHITE));
        cells[7][7].setPiece(new Rook(Color.WHITE));
    }
}
