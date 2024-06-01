package entities;

import entities.piece.Piece;

public class Player {

    private String name;
    private Piece piece;

    public Player(String name, Piece piece) {
        this.piece = piece;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Piece getPiece() {
        return piece;
    }
}
