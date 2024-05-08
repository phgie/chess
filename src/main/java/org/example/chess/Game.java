package org.example.chess;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.example.chess.core.Board;
import org.example.chess.core.Knight;
import org.example.chess.core.Piece;
import org.example.chess.core.Position;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class Game {

    private final Board board;

    public List<Position> getPositions() {

        val positions = new ArrayList<Position>();

        val minPoint = board.getMinPoint();
        val maxPoint = board.getMaxPoint();

        for (int row = minPoint.x; row <= maxPoint.x; row++) {
            for (int col = minPoint.y; col <= maxPoint.y; col++) {
                val knightWhite = new Knight(Piece.COLOR.WHITE, new Point(row, col));
                for (Point targetField : knightWhite.getTargetFields(minPoint, maxPoint)) {
                    val knightBlack = new Knight(Piece.COLOR.BLACK, targetField);
                    positions.add(new Position(knightWhite, knightBlack));
                }
            }
        }

        return positions;
    }
}
