package org.example.chess.core;

import lombok.RequiredArgsConstructor;
import lombok.val;

import java.awt.*;

@RequiredArgsConstructor
public class Board {

    private final int rows;
    private final int cols;

    public Point getMinPoint() {
        return new Point(0, 0);
    }

    public Point getMaxPoint() {
        return new Point(rows - 1, cols - 1);
    }

    public String getTextualOutput(Position position) {
        val output = new StringBuilder();
        position.getPieces().forEach(piece -> output.append(piece.toString()).append(" "));
        return output.toString();
    }

    public String getGraphicalOutput(Position position) {
        val piecesOnBoard = getBoardForPosition(position);
        return getOutputForBoard(piecesOnBoard);
    }

    private String getOutputForBoard(Piece[][] piecesOnBoard) {
        val output = new StringBuilder();
        for (int row = rows - 1; row >= 0; row--) { // start with the last row, because the graphical representation is printed from top to bottom
            for (int col = 0; col < cols; col++) {
                val fieldOutput = getOutputForField(piecesOnBoard, row, col);
                output.append(fieldOutput).append(" ");
            }
            output.append("\n");
        }

        return output.toString();
    }

    private static String getOutputForField(Piece[][] piecesOnBoard, int row, int col) {
        return piecesOnBoard[row][col] == null ? "*" : piecesOnBoard[row][col].getColor() == Piece.COLOR.BLACK ? "B" : "W";
    }

    private Piece[][] getBoardForPosition(Position position) {
        val piecesOnBoard = new Piece[rows][cols];
        position.getPieces().forEach(piece -> piecesOnBoard[piece.getCoordinates().x][piece.getCoordinates().y] = piece);
        return piecesOnBoard;
    }
}
