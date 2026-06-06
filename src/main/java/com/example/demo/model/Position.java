package com.example.demo.model;

public class Position {
    private final int row;
    private final int col;

    public Position(int row, int col) { this.row = row; this.col = col; }
    public int getRow() { return row; }
    public int getCol() { return col; }
    public Position offset(int dRow, int dCol) { return new Position(row + dRow, col + dCol); }
    @Override public boolean equals(Object o) { if (this==o) return true; if (o==null||getClass()!=o.getClass()) return false; Position p=(Position)o; return row==p.row && col==p.col; }
    @Override public int hashCode() { return 31*row + col; }
}
