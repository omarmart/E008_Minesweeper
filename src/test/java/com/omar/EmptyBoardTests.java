package com.omar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Collections;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class EmptyBoardTests {
 
    private Board board;

    @Before
    public void initializeEmptyBoard() {
        Set<Coordinates> mines = Collections.emptySet();
        board = new Board(14, 10, mines);
    }

    @Test
    public void shouldCreateBoardWithSpecifiedDimensions() {
        assertEquals(14, board.getWidth());
        assertEquals(10, board.getHeight());
    }

    @Test
    public void shouldCreateBoardWithAllCellsCovered() {
        for (int x = 0; x < board.getWidth(); x++) {
            for (int y = 0; y < board.getHeight(); y++) {
                assertEquals(Status.COVERED, board.getCell(x, y).getState());
            }
        }
    }

    @Test
    public void shouldCreateBoardWithoutAnyMines() {
        for (int x = 0; x < board.getWidth(); x++) {
            for (int y = 0; y < board.getHeight(); y++) {
                assertFalse(board.getCell(x, y).isMined());
            }
        }
    }


}
