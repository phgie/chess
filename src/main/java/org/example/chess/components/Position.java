package org.example.chess.components;

import lombok.Getter;
import org.example.chess.core.Piece;

import java.util.Set;

@Getter
public class Position {

    private final Set<Piece> pieces;

    public Position(Piece... pieces) {
        this.pieces = Set.of(pieces);
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof Position other && this.hashCode() == other.hashCode() && this.pieces.equals(other.pieces);
    }

    @Override
    public int hashCode() {
        var hashCode = 0;
        for (Piece piece : pieces) {
            hashCode += piece.hashCode();
        }
        return hashCode;
    }
}
