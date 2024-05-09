package org.example.chess;

import lombok.val;
import org.example.chess.core.Board;
import org.example.chess.core.Knight;
import org.example.chess.core.Piece;
import org.example.chess.core.Position;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ThreadPositionApplication {
    public static void main(String[] args) {
        val board = new Board(8, 8);
        val threadPositions = getThreadPositionsForKnights(board);

        System.out.println("Found " + threadPositions.size() + " thread positions!");

        System.out.println("\nTextual representation:");
        threadPositions.forEach(position -> System.out.println(board.getTextualOutput(position)));
        System.out.println("\nGraphical representation:");
        threadPositions.forEach(position -> System.out.println(board.getGraphicalOutput(position)));
    }

    private static List<Position> getThreadPositionsForKnights(Board board) {

        val threadPositions = new ArrayList<Position>();

        val minPoint = board.getMinPoint();
        val maxPoint = board.getMaxPoint();

        for (int row = minPoint.x; row <= maxPoint.x; row++) {
            for (int col = minPoint.y; col <= maxPoint.y; col++) {
                val knightWhite = new Knight(Piece.COLOR.WHITE, new Point(row, col));
                for (Point targetField : knightWhite.getReachableFields(minPoint, maxPoint)) {
                    val knightBlack = new Knight(Piece.COLOR.BLACK, targetField);
                    threadPositions.add(new Position(knightWhite, knightBlack));
                }
            }
        }

        return threadPositions;
    }
}