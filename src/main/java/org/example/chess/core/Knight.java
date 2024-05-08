package org.example.chess.core;

import lombok.val;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class Knight extends Piece {

    public Knight(COLOR color, Point position) {
        super(color, position);
    }

    @Override
    public Set<Point> getTargetFields(Point minPoint, Point maxPoint) {
        val moveSet = new HashSet<Point>();

        val targetField1 = new Point(getCoordinates().x + 2, getCoordinates().y + 1);
        if (targetField1.x <= maxPoint.x && targetField1.y <= maxPoint.y) {
            moveSet.add(targetField1);
        }
        val targetField2 = new Point(getCoordinates().x + 1, getCoordinates().y + 2);
        if (targetField2.x <= maxPoint.x && targetField2.y <= maxPoint.y) {
            moveSet.add(targetField2);
        }
        val targetField3 = new Point(getCoordinates().x - 2, getCoordinates().y - 1);
        if (targetField3.x >= minPoint.x && targetField3.y >= minPoint.y) {
            moveSet.add(targetField3);
        }
        val targetField4 = new Point(getCoordinates().x - 1, getCoordinates().y - 2);
        if (targetField4.x >= minPoint.x && targetField4.y >= minPoint.y) {
            moveSet.add(targetField4);
        }
        val targetField5 = new Point(getCoordinates().x + 2, getCoordinates().y - 1);
        if (targetField5.x <= maxPoint.x && targetField5.y >= minPoint.y) {
            moveSet.add(targetField5);
        }
        val targetField6 = new Point(getCoordinates().x + 1, getCoordinates().y - 2);
        if (targetField6.x <= maxPoint.x && targetField6.y >= minPoint.y) {
            moveSet.add(targetField6);
        }
        val targetField7 = new Point(getCoordinates().x - 2, getCoordinates().y + 1);
        if (targetField7.x >= minPoint.x && targetField7.y <= maxPoint.y) {
            moveSet.add(targetField7);
        }
        val targetField8 = new Point(getCoordinates().x - 1, getCoordinates().y + 2);
        if (targetField8.x >= minPoint.x && targetField8.y <= maxPoint.y) {
            moveSet.add(targetField8);
        }

        return moveSet;
    }
}
