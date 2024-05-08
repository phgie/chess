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

    public void printPosition(Position position) {
        val output = new StringBuilder();

        val board = new Piece[rows][cols];
        for (Piece piece : position.getPieces()) {
            board[piece.getCoordinates().x][piece.getCoordinates().y] = piece;
        }

        for (int row = rows - 1; row >= 0; row--) {
            for (int col = 0; col < cols; col++) {
                val pieceString = board[row][col] == null ? "*"
                        : board[row][col].getColor() == Piece.COLOR.BLACK ? "B" : "W";
                output.append(pieceString).append(" ");
            }
            output.append("\n");
        }

        System.out.println(output);
    }
}
