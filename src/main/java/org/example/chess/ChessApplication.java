package org.example.chess;

import lombok.val;
import org.example.chess.components.Game;
import org.example.chess.core.Board;

public class ChessApplication {
    public static void main(String[] args) {
        val board = new Board(3, 3);

        val game = new Game(board);
        val positions = game.getPositions();

        System.out.println("Found " + positions.size() + " positions:\n");

        positions.forEach(board::printPosition);
    }
}