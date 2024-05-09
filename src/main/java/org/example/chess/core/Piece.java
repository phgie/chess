package org.example.chess.core;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.awt.*;
import java.util.Set;

@RequiredArgsConstructor
@Getter
public abstract class Piece {

    public enum COLOR {
        WHITE,
        BLACK
    }

    private final COLOR color;
    private final Point coordinates;

    public abstract Set<Point> getReachableFields(Point minPoint, Point maxPoint);

    @Override
    public boolean equals(Object object) {
        return object instanceof Piece other
                && this.hashCode() == other.hashCode()
                && this.color.equals(other.color)
                && this.coordinates.equals(other.coordinates);
    }

    @Override
    public int hashCode() {
        return color.hashCode() + coordinates.x + coordinates.y;
    }

    @Override
    public String toString() {
        return "(" + color + "): " + coordinates.x + "|" + coordinates.y;
    }
}
