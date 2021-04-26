package org.samples;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SampleTests {
    @Test
    public void testCellAge() {
        Cell cell = new Cell();
        assertEquals(cell.age, 0);
        cell.advanceAge();
        assertEquals(cell.age, 1);
        for (int i = 0; i < 100; i++) {

            assertEquals(cell.isVampire(), false);
            cell.advanceAge();
        }
        assertEquals(cell.isVampire(), true);

    }

    @Test
    public void testBecomesVampire() {
        Cell cell = new Cell();
        cell.setVampire();
        assertEquals(cell.isVampire(), true);
    }

    @Test
    public void testNeighborCounts() {
        Board board = new Board();
        int x =1 ;
        int y = 1;
        board.addCell(x-1,y-1,false);
        board.addCell(x+0,y-1,false);
        board.addCell(x+1,y-1,false);
        board.addCell(x-1,y,false);
        board.addCell(x+1,y,false);

        board.addCell(x-1,y+1,false);
        board.addCell(x+0,y+1,false);
        board.addCell(x+1,y+1,false);
        assertEquals(board.getNeighborCountAt(x,y), 8);

    }
    @Test
    public void testVampireNeighborCounts() {
        Board board = new Board();
        int x =1 ;
        int y = 1;
        board.addCell(x-1,y-1,true);
        board.addCell(x+0,y-1,false);
        board.addCell(x+1,y-1,false);
        board.addCell(x-1,y,false);
        board.addCell(x+1,y,false);

        board.addCell(x-1,y+1,false);
        board.addCell(x+0,y+1,false);
        board.addCell(x+1,y+1,false);
        assertEquals(board.getNeighborCountAt(x,y), 7);

    }
    @Test
    public void testVampireNeighborCountsForVampire() {
        Board board = new Board();
        int x =1 ;
        int y = 1;
        board.addCell(x,y,true);
        board.addCell(x-1,y-1,true);
        board.addCell(x+0,y-1,false);
        board.addCell(x+1,y-1,false);
        board.addCell(x-1,y,false);
        board.addCell(x+1,y,false);

        board.addCell(x-1,y+1,false);
        board.addCell(x+0,y+1,false);
        board.addCell(x+1,y+1,false);
        assertEquals(board.getNeighborCountAt(x,y), 1);

    }
}
