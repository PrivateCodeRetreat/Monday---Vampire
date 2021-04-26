package org.samples;

import org.lambda.query.Queryable;

import java.awt.*;
import java.util.HashMap;

public class Board {
    private HashMap<Point, Cell> board = new HashMap<>();

    public void addCell(int x, int y, boolean isVampire) {
        board.put(new Point(x, y), new Cell(isVampire));
    }

    public int getNeighborCountAt(int x, int y) {
        Cell cell = board.get(new Point(x, y));
        boolean isVampire = cell != null && cell.isVampire();

        return getNeighborsFor(x, y).where(p -> board.get(p) != null && isVampire == board.get(p).isVampire()).size();
    }

    private Queryable<Point> getNeighborsFor(int x, int y) {
        return Queryable.as(
                new Point(x - 1, y - 1),
                new Point(x + 0, y - 1),
                new Point(x + 1, y - 1),
                new Point(x - 1, y),
                new Point(x + 1, y),
                new Point(x - 1, y + 1),
                new Point(x + 0, y + 1),
                new Point(x + 1, y + 1)
        );
    }
}
